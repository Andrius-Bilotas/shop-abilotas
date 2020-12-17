import React, { Component } from 'react';
import ProductCardComponent from './ProductCardComponent';
import axios from 'axios';

export default class ProductListContainer extends Component {
    constructor() {
        super();
        this.state = { product: [] };
    }


    componentDidMount() {
        axios.get(`/spring-boot-starter/api/products?title=`)
            .then((response) => {
                this.setState({ product: response.data });
                console.log(this.state);
            })
            .catch((error) => {
                console.log(error);
            })
    }

    handleChange = e => {
        e.preventDefault();
        axios.get(`/spring-boot-starter/api/products?title=${e.target.value}`)
            .then(response => {
                this.setState({product: response.data})
            })
            .catch(error => {
                console.log(error);
            })
    }

    render() {
        return (
            <main className="container pt-3">
                <div className="row pb-3">
                    <form>
                        <input className="form-control" type="text" onChange={this.handleChange}/>
                    </form>
                </div>
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