import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Switch,  Redirect, Route } from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';

var AppContainer = (props) => {
  return (
    <div>
      <div className="py-3 text-center" style={{backgroundColor: 'yellow'}}>
        <Link to='/'>Home</Link> | &nbsp;
        <Link to='/products'>Products</Link> | &nbsp;
      </div>
      {props.children}
    </div>
  );
};

var NoMatch = (props) => {
  var goApp = () => props.history.push("/");
  return (
  <div>
    Route did not match<br></br>
    <button onClick={goApp}>Go Home</button>
  </div>
    );
};

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <AppContainer>
        <Switch>
          <Route exact path='/' component={App}/>
          <Route path="*" component={NoMatch}/>
        </Switch>
      </AppContainer>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
