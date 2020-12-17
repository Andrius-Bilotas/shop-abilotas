import React, { Component } from 'react';
import CartContext from '../Context/CartContext';
import axios from 'axios';
import CartComponent from './CartComponent';

export default class CartContainer extends Component {

    constructor() {
        super();
        this.state = { products: [] };
    };


    componentDidMount() {
        let userName = this.context.userService.name;
        //console.log(userName);
        if (userName.length > 0) {
            axios.get(`/spring-boot-starter/api/users/${userName}/cart-products`)
                .then((response) => {
                    this.setState({ products: response.data });
                    //console.log(userName);
                    console.log(this.state.products);
                })
                .catch((error) => {
                    console.log(error);
                })
        }
    };

    removeItem = (id) => {
        let userName = this.context.userService.name;
        axios.delete(`/spring-boot-starter/api/users/${userName}/cart-products/${id}`)
            .then((response) => {
                this.setState({ products: response.data });
                this.context.userService.productCount = response.data.length;
                this.context.userService.updateCount();
                //console.log(userName);
                console.log(this.state);
            })
            .catch((error) => {
                console.log(error);
            })
    };

    quantityChange = (id, e) => {
        let newQuantity = e.target.value;
        let userName = this.context.userService.name;
        axios.put(`/spring-boot-starter/api/users/${userName}/cart-products/${id}?quantity=${newQuantity}`)
            .then((response) => {
                this.setState({ products: response.data })
            })
            .catch((error) => {
                console.log(error);
            })
    }

    render() {
        return (
            <main className="container pt-5">
                <div className="row">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Picture</th>
                                <th scope="col">Title</th>
                                <th scope="col">Quantity in cart</th>
                                <th scope="col">price/1pcs</th>
                                <th scope="col">total price</th>
                                <th scope="col">action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.products.map(product => {
                                    return (
                                        <CartComponent name={product.title}
                                            image={product.image}
                                            key={product.id}
                                            id={product.id}
                                            quantity={product.quantity}
                                            quantityInCart={product.quantityInCart}
                                            price={product.price}
                                            quantityChange={this.quantityChange}
                                            userName={this.context.userName} 
                                            onRemove={this.removeItem}/>
                                    )
                                })
                            }
                            <tr>
                                <td colspan="4"></td>
                                <td>
                                    <b>Total amount: {
                                        this.state.products.reduce((acc, elem) => {
                                            return acc + (elem.price * elem.quantityInCart);
                                        }, 0)
                                    }</b>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </main>
        );
    }
}

CartContainer.contextType = CartContext;