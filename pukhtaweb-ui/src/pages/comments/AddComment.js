import React,{Component} from 'react';

class AddComment extends Component{
    constructor() {
        super();
    
        this.state = {
            comment: ''
        };
    
        this.handleChange = this.handleChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);

        console.log("[AddComment] constructor");
    }
    componentDidMount() {
      console.log("[AddComment] componentDidMount");
    }
  
    componentWillUnmount() {
      console.log("[AddComment] componentWillUnmount");
    }
    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;
    
        this.setState({
          [name]: value
        });
    }
    
    onSubmit(e) {
        e.preventDefault();
        const idBook = this.props.match.params.idBook;
        console.log('The form was submitted with the following data:');
        console.log(this.state);
        fetch(`http://localhost:8080/api/comment/${idBook}/register`, {
        method: "POST",
        headers: {
          "content-type" : "application/json"
        },
        body: JSON.stringify(this.state)
        });
        }
    render(){
    console.log("[AddComment] render"); 
    return(
    <div >
    <form onSubmit={this.onSubmit}>
                
                <div >
                    <label htmlFor="Comment"></label>
                    <input type="text" id="comment"  placeholder="Enter comment" name="comment" value={this.state.comment} onChange={this.handleChange}/>
                </div> 
                
                  <button>Add</button>
                
    </form>
    </div>
);
}
}
export default AddComment;