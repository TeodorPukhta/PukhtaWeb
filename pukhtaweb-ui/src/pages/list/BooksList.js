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
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>User</th>
                        <th>Book</th>
                    </tr>
                </thead>
                <tbody>
                {
                    this.state.items.map(item => <BooksItem item={ item } />)
                    
                }
                </tbody>
            </table>
        );
    }
}

export default BooksList;