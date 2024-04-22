import psycopg2
from configuration.config import load_config

def insert_product(products_list):

    """Insert multiple product rows into the table"""

    sql = """INSERT INTO products_scrapper(id, price,
         brand, category, description, image, name) 
         VALUES (%s, %s, %s, %s, %s, %s, %s)
         RETURNING *"""
    
    config = load_config()
    rows = []
    try:
        with psycopg2.connect(**config) as conn:
            with conn.cursor() as cur:
                # execute the INSERT statement
                cur.executemany(sql, products_list)

                # check the number of affected rows
                affected_rows = cur.rowcount
                print(f"{affected_rows} rows inserted.")

                # commit the changes to the database
                conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)    
    finally:
        print("Insertion has been done")


def update_product(product):
    pass