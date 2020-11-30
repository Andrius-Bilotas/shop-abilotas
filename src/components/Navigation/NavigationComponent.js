import { Link } from 'react-router-dom';
import React, { useContext, useState } from 'react';
import CartContext from '../Context/CartContext';
import axios from 'axios';
import CartSummaryContainer from '../Cart/CartSummaryContainer';

function NavigationComponent(props) {

  var context = useContext(CartContext);
  var newName = "";
  //const [count, setCount] = useState(context.productCount);

  const handleSubmit = (e) => {
    e.preventDefault();
    context.userService.name = newName;
    context.userService.updateName();
    axios.get(`https://itpro2017.herokuapp.com/api/users/${newName}/cart-products`)
      .then((response) => {
        context.userService.productCount = response.data.length;
        context.userService.updateCount();
        //setCount(context.productCount);
        console.log(newName);
        console.log(context.userService.name);
        console.log(response.data);
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
              <CartSummaryContainer ctx={context}/>
            </div>
          </div>
        </header>
        {props.children}
      </div>
  );
};

export default NavigationComponent;