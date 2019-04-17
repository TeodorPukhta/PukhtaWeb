import React,{Component} from 'react';
import {Link} from 'react-router-dom';
class SignInForm extends Component{
    constructor() {
        super();

        this.state = {
            email: '',
            password: ''
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
    <form className="FormField" onSubmit={this.handleSubmit}>

              
                <div>
                    <label htmlFor="email">email</label>
                    <input type="email" id="email" placeholder="Enter your full email" name="email" value={this.state.email} onChange={this.handleChange}/>
                </div>
              
                <div>
                    <label htmlFor="password">password</label>
                    <input type="password" id="password" placeholder="Enter your full password" name="password" value={this.state.password} onChange={this.handleChange}/>
                </div>
            
                <div>
                  <button>Sign in</button>
                  <hr></hr>
                  <Link to="/">Create an account</Link>
                </div>
    </form>
</div>
);
}
}
export default SignInForm;