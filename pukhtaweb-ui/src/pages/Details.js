import React, { Component } from 'react';

import {BrowserRouter as Router, Route,NavLink,Switch} from 'react-router-dom';
import CommentList from './comments/CommentList';
import AddComment from './comments/AddComment';
class Details extends Component {
    
    constructor() {
        super();
        console.log("[Details] constructor");
        this.state = {
         Book:{
            idBook: '',
            nameBook: '',
            genreBook: '',
            descriptionBook: '',
            authorBook: '',
            yearBook: '',

            idUser: '',
            firstNameUser: '',
            surnameUser: '',
            emailUser: '',
            phoneUser: ''
        }
        };
        
    }


    componentWillUnmount() {
        console.log("[Details] componentWillUnmount");
    } 
    
    componentDidMount(){
        const Id = this.props.match.params.Id;
        console.log("[Details] getbook");
        let initialItems=[];
        fetch(`http://localhost:8080/api/list/${Id}/details`)
            .then(response => {
                return response.json();
                
            }).then(data => {
                console.log(data)
                initialItems = data;
                
                this.setState({
                    Book: initialItems,
                });
        });
    }
    render() {
        console.log("[Details] render");        
        return (
            <Router>
            <div>

                <b>Book:</b>{this.state.Book.nameBook}<br></br>
                <b>Genre:</b>{this.state.Book.genreBook}<br></br>
                <b>Description:</b>{this.state.Book.descriptionBook}<br></br>
                <b>Author:</b>{this.state.Book.authorBook}<br></br>
                <b>Year:</b>{this.state.Book.yearBook}<br></br>
              
                <br></br><br></br>
                <b>Owner name:</b>{this.state.Book.firstNameUser}<br></br>
                <b>Surname:</b>{this.state.Book.surnameUser}<br></br>
                <b>Email:</b>{this.state.Book.emailUser}<br></br>
                <b>Phone:</b>{this.state.Book.phoneUser}<br></br>
            </div>
            <br></br><br></br>
            <NavLink to ={"/comments/"+this.state.Book.idBook}>Comments</NavLink> | <NavLink to ={"/addComments/"+this.state.Book.idBook}>AddComment</NavLink>
            <Route exact path="/addComments/:idBook" component={AddComment}/>
            <Route exact path="/comments/:idBook" component={CommentList}/>
            </Router>
        );
    }
}

export default Details; 