import React from 'react';

function CartComponent({image, name, id, onRemove, quantity, quantityInCart, quantityChange, price}) {

    return (
        <tr>
            <td><img src={process.env.PUBLIC_URL + image} style={{width: '50px', height: '50px'}} alt=""/></td>
            <td className="align-middle">{name}</td>
            <td><input className="form-control" type="number" min="1" max={quantity} value={quantityInCart} onChange={(e) => quantityChange(id, e)}/></td>
            <td>{price}</td>
            <td>{price * quantityInCart}</td>
            <td><button className="btn btn-danger" onClick={() =>onRemove(id)}>Remove from cart</button></td>
        </tr>
    );
}

export default CartComponent;