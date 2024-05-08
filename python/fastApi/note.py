from fastapi import FastAPI, APIRouter, Depends
from sqlalchemy.orm import Session

import models
from database import get_db

app = FastAPI()
router = APIRouter()


@router.get('/')
def get_notes(db: Session = Depends(get_db), limit: int = 100, page: int = 1, search: str = ''):
    skip = (page - 1) * limit

    notes = db.query(models.Products).filter(
        models.Products.title.contains(search)).limit(limit).offset(skip).all()
    return {'status': 'success', 'results': len(notes), 'notes': notes}