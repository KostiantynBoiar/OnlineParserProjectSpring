from .database import Base
from sqlalchemy import TIMESTAMP, Column, String, Boolean
from sqlalchemy.sql import func
from fastapi_utils.guid_type import GUID, GUID_DEFAULT_SQLITE

class Products(Base):
    __tablename__ = 'products_scrapper'
    id = Column(String, primary_key=True)
    brand = Column(String)
    category = Column(String)
    price = Column(String)
    image = Column(String)
    description = Column(String)
    name = Column(String)
