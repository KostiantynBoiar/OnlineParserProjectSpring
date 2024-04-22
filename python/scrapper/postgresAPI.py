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

def update_product(products_list):
    """Update products if they already exist in the database"""
    sql = """UPDATE products_scrapper
             SET price = %s,
                 brand = %s,
                 category = %s,
                 description = %s,
                 image = %s,
                 name = %s
             WHERE id = %s"""

    config = load_config()
    try:
        with psycopg2.connect(**config) as conn:
            with conn.cursor() as cur:
                # execute the UPDATE statement for each product
                for product in products_list:
                    cur.execute(sql, (product[1], product[2], product[3], product[4], product[5], product[6], product[0]))

                    # check if any row was affected (i.e., if the product with the same ID existed)
                    affected_rows = cur.rowcount
                    if affected_rows == 0:
                        print("Product with ID {} does not exist. Inserting new product...".format(product[0]))
                        # Call insert_product method to insert the product if it doesn't exist
                        insert_product([product])
                    else:
                        print("Product with ID {} updated successfully.".format(product[0]))

                # commit the changes to the database
                conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)