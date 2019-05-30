import React, { Component } from 'react';
import './App.css';
import { Route, Link, BrowserRouter as Router, Switch, NavLink } from 'react-router-dom';
import BooksList from './pages/list/BooksList';
import Registration from './pages/account/Registration';
import PageNotfound from './pages/common/PageNotFound';
import AddBook from './pages/AddBook';
import Details from './pages/Details';

class App extends Component {

  constructor() {
      super();
      console.log("[App] constructor");
  }

  componentDidMount() {
    console.log("[App] componentDidMount");
  }

  componentWillUnmount() {
    console.log("[App] componentWillUnmount");
  }

  render() {
    console.log("[App] render");
    
    return (
      <Router>
      <div className="App">
        <h1>PukhtaWeb</h1>  
        <div>
          <NavLink exact to ="/">Start Page </NavLink>
          <NavLink to ="/account">Sign up </NavLink>  
          <NavLink exact to ="/newbook">Add Book</NavLink>
        </div>
        <Switch>
          <Route exact path="/" component={BooksList} />  
          <Route path="/account" component={Registration} />
          <Route path="/newbook" component={AddBook}/>    
          <Route path='/details/:Id' component={Details} />
          <Route component={PageNotfound} /> 
        </Switch>
      </div>
      </Router>
    );
  }
}

export default App;