from flask import *
from scrapper.rozetka_scrapper import *

app = Flask(__name__)

@app.route('/python/api/rozetka/get', methods=['GET'])
def rozetka_records():
    scrapper('https://rozetka.com.ua/ua/notebooks/c80004/')

if __name__ == '__main__':
    app.run(debug=True)