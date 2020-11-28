import React, { Component } from 'react';
import CartContext from '../Context/CartContext';
import axios from 'axios';
import CartComponent from './CartComponent';

export default class CartContainer extends Component {

    constructor() {
        super();
        this.state = { products: [] };
        //this.removeItem = this.removeItem.bind(this);
    };


    componentDidMount() {
        let userName = this.context.userName;
        //console.log(userName);
        if (userName.length > 0) {
            axios.get(`https://itpro2017.herokuapp.com/api/users/${userName}/cart-products`)
                .then((response) => {
                    this.setState({ products: response.data });
                    //console.log(userName);
                    //console.log(this.state);
                })
                .catch((error) => {
                    console.log(error);
                })
        }
    };

    removeItem = (id) => {
        let userName = this.context.userName;
        axios.delete(`https://itpro2017.herokuapp.com/api/users/${userName}/cart-products/${id}`)
            .then((response) => {
                this.setState({ products: response.data });
                //console.log(userName);
                //console.log(this.state);
            })
            .catch((error) => {
                console.log(error);
            })
    };

    render() {
        return (
            <main className="container pt-5">
                <div className="row">
                    <table className="table">
                        <tbody>
                            {
                                this.state.products.map(product => {
                                    return (
                                        <CartComponent name={product.title}
                                            image={product.image}
                                            key={product.id}
                                            id={product.id}
                                            userName={this.context.userName} 
                                            onRemove={this.removeItem}/>
                                    )
                                })
                            }
                        </tbody>
                    </table>
                </div>
            </main>
        );
    }
}

CartContainer.contextType = CartContext;