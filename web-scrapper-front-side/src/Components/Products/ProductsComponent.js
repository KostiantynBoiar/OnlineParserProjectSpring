import React, { Component } from 'react';
import axios from 'axios';

class ProductsComponent extends Component {
    state = {
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

    render() {
        return (
            <div>
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
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default ProductsComponent;
