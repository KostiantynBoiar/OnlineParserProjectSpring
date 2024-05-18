from fastapi import FastAPI, APIRouter, Depends
from sqlalchemy.orm import Session
import models
from database import get_db
from scrappers import rozetka_scrapper
from scrappers.rozetka_scrapper import scrapper
from models import Products


app = FastAPI()
router = APIRouter()

scrapper_map = {"rozetka_scrapper": rozetka_scrapper.scrapper(),
                "comfy_scrapper": "comfy_scrapper",}

@router.get('/')
def get_notes(db: Session = Depends(get_db), limit: int = 100, page: int = 1, search: str = ''):
    skip = (page - 1) * limit

    products = db.query(models.Products).filter(
        models.Products.name.contains(search)).limit(limit).offset(skip).all()
    print(products)
    return {'status': 'success', 'results': len(products), 'products': products}


@router.post('/post/{shop_name}')
def scrapper_query(shop_name: str, db: Session = Depends(get_db)):


    if f'{shop_name}_scrapper' in scrapper_map:

        print(scrapper_map[f'{shop_name}_scrapper'])
        _scrapper = rozetka_scrapper.scrapper()

    else:
        return {'status': 'error', 'message': 'Shop name not found'}

    for row in _scrapper:
        # Check if a product with the same ID already exists
        existing_product = db.query(Products).filter_by(id=row[0]).first()

        # If a product with the same ID exists, update its attributes
        if existing_product:
            existing_product.brand = row[2]
            existing_product.category = row[3]
            existing_product.price = row[1]
            existing_product.image = row[5]
            existing_product.description = row[4]
            existing_product.name = row[6]
            existing_product.timestamp = row[7]
        else:
            # If the product doesn't exist, create a new one
            product = Products(
                id=row[0],
                brand=row[2],
                category=row[3],
                price=row[1],
                image=row[5],
                description=row[4],
                name=row[6],
                timestamp=row[7]
            )
            db.add(product)  # Add the product to the session

    db.commit()  # Commit the changes to the database

    return {"message": "Data added to the database successfully"}