import React from 'react';
import { Link } from 'react-router-dom';

function ProductComponent({ product }) {
    return (
        <div className="row">
            <div className="col-3 border">
                <img className="mx-auto d-block" src={process.env.PUBLIC_URL + product.image} style={{width: '200px', height:'200px'}} alt=""/>
            </div>
            <div className="col-9">
                <h3>{ product.title }</h3>
                <h5>Description:</h5>
                <p>{product.description}</p>
                <b>Price: </b> <i>{product.price}</i> EUR
                <br></br>
                <p>Quantity in stock: {product.quantity}</p>
                <Link to={`/`} className="btn btn-primary">Back</Link>
            </div>
        </div>
    );
}

export default ProductComponent;