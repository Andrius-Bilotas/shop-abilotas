import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import CartContext from '../Context/CartContext';
import axios from 'axios';

function ProductComponent({ product }) {

    const context = useContext(CartContext);

    const handleCLick = (event) => {
        event.preventDefault();
        console.log(context.userService.name);
        //if (context.userService.name > 0) {
            console.log("praejo if");
            axios.post(`/spring-boot-starter/api/users/${context.userService.name}/cart-products`, {title: product.title, image: product.image, id: product.id})
            .then((response) => {
                context.userService.productCount = response.data.length;
                context.userService.updateCount();
                console.log(response);
            })
            .catch((error) => {
                console.log(error);
            })
        //}
    }

    return (
        <div className="row">
            <div className="col-3 border">
                <img className="mx-auto d-block img-fluid" src={process.env.PUBLIC_URL + product.image} alt="" />
            </div>
            <div className="col-9">
                <h3>{product.title}</h3>
                <h5>Description:</h5>
                <p>{product.description}</p>
                <b>Price: </b> <i>{product.price}</i> EUR
                <br></br>
                <p>Quantity in stock: {product.quantity}</p>
                <button className="btn btn-primary mr-3" onClick={handleCLick}>Add to cart</button>
                <Link to={`/`} className="btn btn-default border">Back</Link>
            </div>
        </div>
    );
}

export default ProductComponent;