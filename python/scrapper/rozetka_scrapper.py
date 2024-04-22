#! C:\Users\Kostiantyn\IdeaProjects\OnlineWebScrapperSpring\python\scrapper\scrappervenv\Scripts\python.exe
from bs4 import BeautifulSoup
import requests
import psycopg2
from postgresAPI import insert_product

def scrapper():
    id = 1
    test_list = []
    product = 5, 200, "Iphone", "Phones", "Iphone 15 Pro MAX", "", "Iphone  15 PRO MAX"
    product2 = 3, 200, "Iphone", "Phones", "Iphone 15 Pro MAX", "", "Iphone  15 PRO MAX"

    test_list.append(product)
    test_list.append(product2)
    print(test_list)
    return test_list

if __name__ == '__main__':
    insert_product(scrapper())