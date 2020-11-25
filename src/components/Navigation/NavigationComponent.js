import { Link } from 'react-router-dom';
import React from 'react';

function NavigationComponent(props) {
    return (
      <div>
        <header className="container-fluid py-3" style={{backgroundColor: '#6495ED'}}>
            <ul className="nav">
                <li className="nav-item">
                <Link to='/' className="nav-link" style={{color: 'black'}}>Home</Link>
                </li>
                <li className="nav-item">
                <Link to='/admin' className="nav-link" style={{color: 'black'}}>Admin</Link>
                </li>
            </ul>
        </header>
        {props.children}
      </div>
    );
  };

  export default NavigationComponent;