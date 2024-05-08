"""
TODO:
    Create an api using fastapi package and sqlachemy ORM that will boot scrappers' scripts and insert data into database
    from the other websites
"""

from fastapi import FastAPI, APIRouter, status

app = FastAPI()

router = APIRouter()

@router.get("/api/v1/products/", status_code=status.HTTP_200_OK)
def root():
    return {"message": "Welcome to FastAPI with SQLAlchemy"}

@router.post("/api/v1/products/post/{shop_name}", status_code=status.HTTP_200_OK)
def post_products(shop_name: str):
    return {"message": "Welcome to FastAPI with SQLAlchemy"}