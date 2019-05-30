import React, { Component } from 'react';
import BooksItem from './BooksItem';

class BooksList extends Component {
      
    constructor() {
        super();
        console.log("[BooksList] constructor");
        this.state = {
            items:[]
        };
    }

    componentDidMount() {
        console.log("[BooksList] componentDidMount");
        let initialItems = [];
        fetch('http://localhost:8080/api/list')
            .then(response => {
                return response.json();
                
            }).then(data => {
                initialItems = data.map((planet) => {
                console.log(planet)
                return planet
            });

            this.setState({
                items: initialItems,
            });
        });
    }
    
    componentWillUnmount() {
        console.log("[BooksList] componentWillUnmount");
    }

    render() {
        console.log("[BooksList] render");

         

        return (
            <div align="center" className="bookslist">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>User</th>
                        <th>Book</th>
                        <th>Accept</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                {
                    this.state.items.map(item => <BooksItem item={ item } />)
                    
                }
                </tbody>
            </table>
            </div>
        );
    }
}

export default BooksList;