import React from 'react';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faShoppingCart } from '@fortawesome/free-solid-svg-icons'

function CartSummaryComponent({count}) {
    return (
        <Link to='/cart' className="btn btn-default">
            <FontAwesomeIcon icon={faShoppingCart} /> {count} Items
            </Link>
    );
}

export default CartSummaryComponent;