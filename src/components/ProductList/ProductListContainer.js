import React, { Component } from 'react';
import ProductCardComponent from './ProductCardComponent';
import axios from 'axios';

export default class ProductListContainer extends Component {
    constructor() {
        super();
        this.state = { product: [] };
    }


    componentDidMount() {
        axios.get('https://itpro2017.herokuapp.com/api/products')
            .then((response) => {
                this.setState({ product: response.data });
                //console.log(this.state);
            })
            .catch((error) => {
                console.log(error);
            })
    }

    render() {
        return (
            <div className="row">
                {this.state.product.map((item) => {
                    return (
                        <ProductCardComponent name={item.title} price={item.price} key={item.id} />
                    )
                })}
            </div>
        );
    }
}