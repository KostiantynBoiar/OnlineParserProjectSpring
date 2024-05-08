"""
TODO:
    Create an api using fastapi package and sqlachemy ORM that will boot scrappers' scripts and insert data into database
    from the other websites
"""

import models
import items
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from database import engine, Base

models.Base.metadata.create_all(bind=engine)

app = FastAPI()

origins = [
    "http://localhost:3000",
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


app.include_router(items.router, tags=['Products'], prefix='/api/v1/products')


@app.get("/api/healthchecker")
def root():
    return {"message": "Welcome to FastAPI with SQLAlchemy"}