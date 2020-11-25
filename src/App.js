import React, { Component } from 'react';
import ProductListComponent from './components/ProductList/ProductListContainer';


class App extends Component {
  render() {
    return (
      <div className="container pt-5">
        <main>
          <ProductListComponent />
        </main>
      </div>
    );
  }
}

export default App;
