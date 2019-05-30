import React, { Component } from 'react';
import CommentItem from './CommentItem';


class CommentsList extends Component {
    
    constructor() {
        super();
        console.log("[CommentsList] constructor");
        this.state = {
            items:[]
        };
    }


    componentWillUnmount() {
        console.log("[CommentsList] componentWillUnmount");
    } 
    
    componentDidMount(){
        const idBook = this.props.match.params.idBook;
        console.log("[CommentsList] componentDidMount");
        console.log(idBook);
        let initialItems = [];
        fetch(`http://localhost:8080/api/comments/${idBook}/comment`)
            .then(response => {
                return response.json();
                
            }).then(data => {
                console.log(data)
                initialItems = data.map((planet) => {
                return planet});

            this.setState({
                items: initialItems,
            });
        });
    }
    render() {
        console.log("[CommentsList] render");        
        return (
            <table>
                <thead>
                    <tr>
                        <th>User</th>
                        <th>Comment</th>
                        <th>Accept</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                {
                    
                    this.state.items.map(item => <CommentItem item={ item } />)
                   
                }
                </tbody>
            </table>
        );
    }
}

export default CommentsList; 