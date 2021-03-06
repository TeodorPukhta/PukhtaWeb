import React, { Component } from 'react';
import {Link} from 'react-router-dom';

class BooksItem extends Component {

    constructor() {
        super();
        console.log("[BooksItem] constructor");
    }

    componentDidMount() {
        console.log("[BooksItem] componentDidMount");
    }
    
    componentWillUnmount() {
        console.log("[BooksItem] componentWillUnmount");
    }

    render() {
        console.log("[BooksItem] render");        

        const item = this.props.item;
        return (
            
            <tr key={ item.id }>
                <td>{ item.id }</td>
                <td>{ item.user }</td>
                <td>{ item.book }</td>
                <td>{ item.accept}</td>
                <td><Link to={"/details/" +item.id}>Details</Link></td>
            </tr>
         
        );
    }
}

export default BooksItem;