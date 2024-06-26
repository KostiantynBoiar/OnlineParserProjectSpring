from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.firefox.options import Options
from selenium.webdriver.common.by import By
import datetime

"""
TODO:
    make this scrapper asynchronous
"""


def scrapper(main_url='https://rozetka.com.ua/ua/notebooks/c80004') -> list:

    options = Options()
    options.add_argument('--headless')

    items = []
    driver = webdriver.Firefox(options=options)

    try:
        driver.get(main_url)
        driver.implicitly_wait(2)
        last_page = driver.find_element(By.CSS_SELECTOR,
                                        'body > rz-app-root > div > div > rz-category > div > main > rz-catalog > div > div > section > rz-catalog-paginator > app-paginator > div > ul > li:last-child > a').text
        id = 0
        # print(soup)
        print(f'Last page: {last_page}')

        for i in range(1, int(5)):

            url = f'{main_url}/page={i}/'
            driver.get(url)
            print(f'URL: {url}')
            html_content = driver.page_source
            soup = BeautifulSoup(html_content, 'lxml', from_encoding='utf-8')  # Specify encoding

            goods_cards = soup.find_all(class_='goods-tile__inner')

            for cards in goods_cards:
                id += 1

                card_name_until = (cards.find(class_='goods-tile__title').text).split('/')
                card_brand = (card_name_until[0].split(' '))[2]
                card_name = (card_name_until[0]).replace('Ноутбук', '')
                card_price = (cards.find(class_='goods-tile__price-value').text).replace('₴', '').replace('\xa0', '')
                card_description = (''.join(card_name_until[1:])).replace('Ноутбук', '')
                img = ''
                card_category = (url.split('/'))[4]
                timestamp = datetime.datetime.now().strftime('%d.%m.%Y %H:%M:%S')
                row = id, card_price, card_brand, card_category, card_description, img, card_name, timestamp
                items.append(row)



    except Exception as e:
        print(f'Exception, something went wrong! {e}')

    finally:
        driver.quit()
        print(items)
        return items

