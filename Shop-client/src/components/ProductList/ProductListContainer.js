import React, { Component } from 'react';
import ProductCardComponent from './ProductCardComponent';
import axios from 'axios';

export default class ProductListContainer extends Component {
    constructor() {
        super();
        this.state = { product: [] };
    }


    componentDidMount() {
        axios.get('/spring-boot-starter/api/products')
            .then((response) => {
                this.setState({ product: response.data });
                console.log(this.state);
            })
            .catch((error) => {
                console.log(error);
            })
    }

    render() {
        return (
            <main className="container pt-5">
                <div className="row">
                    {this.state.product.map((item) => {
                        return (
                            <ProductCardComponent 
                            name={item.title} 
                            price={item.price} 
                            image={item.image} 
                            id={item.id} 
                            key={item.id} 
                            />
                        )
                    })}
                </div>
            </main>
        );
    }
}