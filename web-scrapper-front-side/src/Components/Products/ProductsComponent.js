import React, { Component } from 'react';
import axios from 'axios';
import ScrapperButton from './ScrapperButton';
import DeleteButton from './DeleteButton';
import DropDown from './DropDown';



class ProductsComponent extends Component {
    

    markets = [
        'rozetka',
        'comfy',
        'allo',
        'fua'
    ]

    
    state = {
        selectedMarket: '',
        products: []
    };

    componentDidMount() {
        this.fetchProducts();
    }

    fetchProducts = () => {
        axios.get('http://localhost:8082/api/v1/products')
            .then(response => {
                this.setState({ products: response.data });
            })
            .catch(error => {
                console.log(error);
            });
    };

    handleMarketSelect = (selectedMarket) => {
        this.setState({ selectedMarket });
    };
    
    render() {
        return (
            <div>
                <DropDown marketsList={this.markets} onMarketSelect={this.handleMarketSelect} />
                <ScrapperButton shopName={this.state.selectedMarket} />
                <h1>All Products</h1>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Description</th>
                            <th>Image</th>
                            <th>Category</th>
                            <th>Brand</th>
                            <th>Timestamp</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.products.map(product => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.name}</td>
                                <td>{product.price}</td>
                                <td>{product.description}</td>
                                <td>{product.image}</td>
                                <td>{product.category}</td>
                                <td>{product.brand}</td>
                                <td>{product.timestamp}</td>
                                <DeleteButton id = {parseInt(product)}/>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default ProductsComponent;
