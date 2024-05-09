from database import Base
from sqlalchemy import TIMESTAMP, Column, String, Boolean
from sqlalchemy.sql import func
from fastapi_utils.guid_type import GUID, GUID_SERVER_DEFAULT_POSTGRESQL


class Products(Base):

    __tablename__ = 'products_scrapper'
    id = Column(GUID, primary_key=True,
            server_default=GUID_SERVER_DEFAULT_POSTGRESQL)
    brand = Column(String)
    category = Column(String)
    price = Column(String)
    image = Column(String)
    description = Column(String)
    name = Column(String)
