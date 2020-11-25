import React, { Component } from 'react';
import ProductAdministrationComponent from './ProductAdministrationComponent';
import axios from 'axios';

export default class ProductAdministrationContainer extends Component {
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
            <main className="container pt-5">
                <div className="row">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Image</th>
                                <th scope="col">Title</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.product.map((item) => {
                                    return (
                                    <ProductAdministrationComponent 
                                        name={item.title}
                                        image={item.image}
                                        id={item.id}
                                        key={item.id}
                                    />
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