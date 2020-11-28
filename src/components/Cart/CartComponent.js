import React, {useState} from 'react';
import axios from 'axios';

function CartComponent({image, name, id, onRemove}) {

    return (
        <tr>
            <td><img src={process.env.PUBLIC_URL + image} style={{width: '50px', height: '50px'}} alt=""/></td>
            <td className="align-middle">{name}</td>
            <td><button className="btn btn-danger" onClick={() =>onRemove(id)}>Remove from cart</button></td>
        </tr>
    );
}

export default CartComponent;