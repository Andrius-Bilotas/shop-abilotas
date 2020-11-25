import React from 'react';
import PropTypes from 'prop-types';

function ProductCardComponent({ name, price }) {
    return (
        <div className="card mx-auto mb-5" style={{ width: '18rem' }}>
            <img src="https://picsum.photos/150/150" className="card-img-top" alt="title" />
            <div className="card-body text-center">
                <h5 className="card-title">{name}</h5>
                <p className="card-text">{price} EUR</p>
                <a href="#0" className="btn btn-primary">Details</a>
            </div>
        </div>
    );
}

export default ProductCardComponent;