import React,{Component} from 'react';

class AddBook extends Component{
    constructor() {
        super();
    
        this.state = {
            name: '',
            genre: '',
            description: '',
            author: '',
            year: '',
        };
    
        this.handleChange = this.handleChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);

        console.log("[AddBook] constructor");
    }
    componentDidMount() {
      console.log("[AddBook] componentDidMount");
    }
  
    componentWillUnmount() {
      console.log("[AddBook] componentWillUnmount");
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
    
        console.log('The form was submitted with the following data:');
        console.log(this.state);
      fetch("http://localhost:8080/api/book/add", {
      method: "POST",
      headers: {
        "content-type" : "application/json"
      },
      body: JSON.stringify(this.state)
    });
    }
render(){
  console.log("[AddBook] render"); 
    return(
<div>
<form onSubmit={this.onSubmit}>
  <div>
  <label  htmlFor="name">Name</label>
  <input type="text" id="name" placeholder="Enter name" name="name" value={this.state.name} onChange={this.handleChange}/>  
  </div> 

  <div>
  <label  htmlFor="genre">Genre</label>
  <input type="text" id="genre" placeholder="Enter genre" name="genre" value={this.state.genre} onChange={this.handleChange}/>  
  </div>  

  <div>
  <label  htmlFor="description">Description</label>
  <input type="text" id="description" placeholder="Enter short description" name="description" value={this.state.description} onChange={this.handleChange}/>  
  </div>  

  <div>
  <label  htmlFor="author">Author</label>
  <input type="text" id="author" placeholder="Enter author" name="author" value={this.state.author} onChange={this.handleChange}/>  
  </div>  

  <div>
  <label  htmlFor="year">Year</label>
  <input type="text" id="year" placeholder="Enter year" name="year" value={this.state.year} onChange={this.handleChange}/>  
  </div>  

  <h1>Confirm</h1>
                
                <div>
                  <button>Add</button>
                  <hr></hr>
                </div>
</form>
</div>
);
}
}
export default AddBook;