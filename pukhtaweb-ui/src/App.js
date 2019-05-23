import React, { Component } from 'react';
import './App.css';
import { Route, Link, BrowserRouter as Router, Switch, NavLink } from 'react-router-dom';
import BooksList from './pages/list/BooksList';
import Registration from './pages/account/Registration';
import PageNotfound from './pages/common/PageNotFound';
import AddBook from './pages/AddBook';

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
          {/* <Link to="/account">Register</Link> */}
          <NavLink exact to ="/">Start Page </NavLink>
          <NavLink to ="/account">Sign up </NavLink>  
          {/* <NavLink exact to ="/addbook">Add Book</NavLink>   */}
          <NavLink exact to ="/newbook">Add Book</NavLink>
        </div>
        <Switch>
          <Route exact path="/" component={BooksList} />  
          <Route path="/account" component={Registration} />
          {/* <Route component={PageNotfound} />  */}
          {/* <Route path="/addbook" component={AddBook} />  */}
          <Route path="/newbook" component={AddBook}/>    
        </Switch>
      </div>
      </Router>
    );
  }
}

export default App;