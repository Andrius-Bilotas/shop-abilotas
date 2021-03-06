import React from 'react';
import ReactDOM from 'react-dom';
import ProductListContainer from './components/ProductList/ProductListContainer';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Switch, Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import NavigationComponent from './components/Navigation/NavigationComponent';
import ProductAdministrationContainer from './components/ProductAdministration/ProductAdministrationContainer';
import ProductContainer from './components/Product/ProductContainer';
import NewProductContainer from './components/Product/NewProductContainer';
import UpdateProductContainer from './components/Product/UpdateProductContainer';
import CartContext from './components/Context/CartContext';
import CartContainer from './components/Cart/CartContainer';
import CartSummaryContainer from './components/Cart/CartSummaryContainer';

var NoMatch = (props) => {
  var goApp = () => props.history.push("/");
  return (
    <div>
      Route did not match<br></br>
      <button onClick={goApp}>Go Home</button>
    </div>
  );
};

class UserService {
  constructor() {
    this._name = "";
    this._productCount = 0
  }

  get name() {
    return this._name;
  }

  get productCount() {
    return this._productCount;
  }

  set name(name) {
    this._name = name;
    this.updateName();
  }

  set productCount(productCount) {
    this._productCount = productCount;
    this.updateCount();
  }

  updateCount = () => {}

  updateName = () => {}
}

var userService = new UserService();

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter basename={process.env.PUBLIC_URL}>
      <CartContext.Provider value={{userService: userService}}>
        <NavigationComponent />
          <Switch>
            <Route exact path='/' component={ProductListContainer} />
            <Route exact path='/products' component={ProductListContainer} />
            <Route exact path='/products/:id' component={ProductContainer} />
            <Route exact path='/admin' component={ProductAdministrationContainer} />
            <Route exact path='/admin/products' component={ProductAdministrationContainer} />
            <Route exact path='/admin/products/new' component={NewProductContainer} />
            <Route exact path='/admin/products/:id' component={UpdateProductContainer} />
            <Route exact path='/cart' component={CartContainer} />
            <Route path="*" component={NoMatch} />
          </Switch>
      </CartContext.Provider>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
