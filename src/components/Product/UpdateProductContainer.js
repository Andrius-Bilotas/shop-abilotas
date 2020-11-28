import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default class NewProductContainer extends Component {
    constructor() {
        super();
        this.state = {
            title: "",
            image: "",
            description: "",
            price: 0,
            quantity: 0
        };
    }

    handleChange = (event) => {
        this.setState({
                [event.target.name] : event.target.value
        })
    }

    componentDidMount() {
        axios.get(`https://itpro2017.herokuapp.com/api/products/${this.props.match.params.id}`)
            .then((response) => {
                this.setState({ 
                    title: response.data.title,
                    image: response.data.image,
                    description: response.data.description,
                    price: response.data.price,
                    quantity: response.data.quantity
                });
            })
            .catch((error) => {
                console.log(error);
            })
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(this.state);
        axios.put(`https://itpro2017.herokuapp.com/api/products/${this.props.match.params.id}`, this.state)
            .then((response) => {
                console.log(response);
                this.props.history.push("/admin/products");
            })
            .catch((error) => {
                console.log(error);
            })
    }

    render() {
        return (
            <main className="container pt-5">
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="title"><b>Title</b></label>
                        <input name="title" type="text" className="form-control" value={this.state.title} onChange={this.handleChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="image"><b>Image URL</b></label>
                        <input name="image" type="text" className="form-control" value={this.state.image} onChange={this.handleChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="description"><b>Description</b></label>
                        <input name="description" type="text" className="form-control" value={this.state.description} onChange={this.handleChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="price"><b>Price</b></label>
                        <input name="price" type="text" className="form-control" value={this.state.price} onChange={this.handleChange}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity"><b>Quantity</b></label>
                        <input name="quantity" type="text" className="form-control" value={this.state.quantity} onChange={this.handleChange}/>
                    </div>
                    <button type="submit" className="btn btn-primary mr-4">Save</button> 
                    <Link to="/admin/products" className="btn btn-default border">Cancel</Link>
                </form>
            </main>
        );
    }
}