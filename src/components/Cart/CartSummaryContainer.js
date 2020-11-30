import React, { Component } from 'react';
import CartSummaryComponent from './CartSummaryComponent';


export default class CartSummaryContainer extends Component {
    constructor(props) {
        super(props);
        this.state = {productCount: props.ctx.userService.productCount, userService: props.ctx.userService};
        props.ctx.userService.updateCount = () => this.setState({productCount: this.state.userService.productCount});
        props.ctx.userService.updateName = () => this.setState({name: this.state.userService.name});
    }



    render() {
        return (
            <CartSummaryComponent count={this.state.productCount} />
        );
    }
}

