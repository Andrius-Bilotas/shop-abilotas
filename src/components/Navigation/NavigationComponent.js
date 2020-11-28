import { Link } from 'react-router-dom';
import React, { useContext, useState } from 'react';
import CartContext from '../Context/CartContext';
import axios from 'axios';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faShoppingCart } from '@fortawesome/free-solid-svg-icons'

function NavigationComponent(props) {

  var context = useContext(CartContext);
  var newName = "";
  const [count, setCount] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    context.userName = newName;
    axios.get(`https://itpro2017.herokuapp.com/api/users/${newName}/cart-products`)
        .then((response) => {
            setCount(response.data.length);
            //console.log(count);
            //console.log(response.data.length);
        })
    //setName(newName);
    //console.log(newName);
    //console.log(name);
  }

  const handleChange = (e) => {
    e.preventDefault();
    newName = e.target.value;
  }

  return (
    <div>
      <header className="container-fluid py-3" style={{ backgroundColor: '#6495ED' }}>
        <div className="row">
          <ul className="nav">
            <li className="nav-item">
              <Link to='/' className="nav-link" style={{ color: 'black' }}>Home</Link>
            </li>
            <li className="nav-item">
              <Link to='/admin' className="nav-link" style={{ color: 'black' }}>Admin</Link>
            </li>
          </ul>
          <div className="col-2">
            <form onSubmit={handleSubmit}>
              <input className="form-control" type="text" name="userName" onChange={handleChange} />
            </form>
          </div>
          <div className="col-8 text-right">
            <Link to='/cart' className="btn btn-default"><FontAwesomeIcon icon={faShoppingCart} /> {count} Items</Link>
          </div>
        </div>
      </header>
      {props.children}
    </div>
  );
};

export default NavigationComponent;