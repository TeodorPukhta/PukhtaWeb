import React,{Component} from 'react';
import {Link} from 'react-router-dom';
class SignUpForm extends Component{
    constructor() {
        super();
    
        this.state = {
            email: '',
            password: '',
            name: '',
            hasAgreed: false
        };
    
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;
    
        this.setState({
          [name]: value
        });
    }
    
    handleSubmit(e) {
        e.preventDefault();
    
        console.log('The form was submitted with the following data:');
        console.log(this.state);
    }
render(){
    return(
<div >
    <form onSubmit={this.handleSubmit}>

                <div >
                    <label htmlFor="name">Full Name</label>
                    <input type="text" id="name"  placeholder="Enter your full name" name="name" value={this.state.name} onChange={this.handleChange}/>
                </div>
              
              
                <div>
                    <label htmlFor="password">password</label>
                    <input type="password" id="password" placeholder="Enter your full password" name="password" value={this.state.password} onChange={this.handleChange}/>
                </div>
            
                <div>
                    <label  htmlFor="email">email</label>
                    <input type="email" id="email" placeholder="Enter your full email" name="email" value={this.state.email} onChange={this.handleChange}/>
                </div>
                
                <div >
                  <label >
                    <input  type="checkbox" name="hasAgreed" value={this.state.hasAgreed} onChange={this.handleChange}/>
                    I agreed with
                    <a href="">this</a>
                  </label>
                </div>

                <h1></h1>
                
                <div>
                  <button>Sign up</button>
                  <hr></hr>
                  <Link to="/sign-in">I am already member</Link>
                </div>
    </form>
</div>
);
}
}
export default SignUpForm;