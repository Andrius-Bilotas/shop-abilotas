import React, { Component } from 'react';
import axios from 'axios';
import ProductComponent from './ProductComponent';

export default class ProductContainer extends Component {
    constructor() {
        super();
        this.state = {product: {}};
    }

    componentDidMount() {
        axios.get(`https://itpro2017.herokuapp.com/api/products/${this.props.match.params.id}`)
            .then((response) => {
                this.setState({product: response.data});
            })
            .catch((error) => {
                console.log(error);
            })
    }

    render() {
        return (
            <main className="container pt-5">
                 <ProductComponent product={this.state.product} />
            </main>
        );
    }
}