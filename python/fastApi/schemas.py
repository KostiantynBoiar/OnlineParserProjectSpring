from typing import List
from pydantic import BaseModel

class ItemBaseSchema(BaseModel):
    id: str | None = None
    brand: str | None = None
    category: str | None = None
    price: float | None = None
    image: str | None = None
    description: str | None = None
    url: str | None = None
    timestamp: str | None = None

    class Config:
        orm_mode = True
        allow_population_by_field_name = True
        arbitrary_types_allowed = True


class ListItem(BaseModel):
    status: str | None = None
    result: str | None = None
    notes: List[ItemBaseSchema]