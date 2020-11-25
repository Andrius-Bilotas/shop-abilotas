import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

function ProductCardComponent({ name, price, image, id }) {
    return (
        <div className="card mx-auto mb-5" style={{ width: '18rem' }}>
            <img src={process.env.PUBLIC_URL + image} className="card-img-top" alt="title"/>
            <div className="card-body text-center">
                <h5 className="card-title">{name}</h5>
                <p className="card-text">{price} EUR</p>
                <Link 
                to={`/products/${id}`} 
                className="btn btn-primary"
                >
                    Details
                </Link>
            </div>
        </div>
    );
}

ProductCardComponent.propTypes = {
    name: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired
}

export default ProductCardComponent;