from fastapi import FastAPI, APIRouter, Depends
from sqlalchemy.orm import Session
import models
from database import get_db
from scrappers.rozetka_scrapper import scrapper
app = FastAPI()
router = APIRouter()


@router.get('/')
def get_notes(db: Session = Depends(get_db), limit: int = 100, page: int = 1, search: str = ''):
    skip = (page - 1) * limit

    products = db.query(models.Products).filter(
        models.Products.name.contains(search)).limit(limit).offset(skip).all()
    return {'status': 'success', 'results': len(products), 'notes': products}


@router.get('/rozetka/{shop_name}')
def scrapper_query(shop_name: str, db: Session = Depends(get_db)):

    _scrapper = scrapper(db)
    return "ok"