import React ,{Component} from 'react'





class AdminLogin extends Component {
  constructor(props) {
    super(props)
      this.state = {username :"abcd", password:"pwd",
      hasLoginFailed:false,
      hasLoginSucces: false
    }
    this.handleChange=this.handleChange.bind(this);
    this.loginClicked=this.loginClicked.bind(this);
  }

  render(){
    return(
      <div>
        <h1>Enter Credentials to login </h1> <br/>

        {this.state.hasLoginFailed && <div> Invalid Credentials </div>}
        {this.state.hasLoginSucces && <div>Login Successfull </div>}
        UserName  : <input type="text" name="username" value={this.state.username} onChange={this.handleChange} /> <br/>
        <br></br>
         Password :  <input type="text" name="password" value ={this.state.password} onChange={this.handleChange}/> <br/>
         <br></br>
         <button onClick={this.loginClicked}>Login</button>
      </div>
    )
  }

    handleChange(event){
      this.setState({
        [event.target.name]:event.target.value
      })
    } 
    loginClicked(){
      if(this.state.username === 'Admin' && this.state.password === 'Admin@123'){
       
        
        this.setState({
          hasLoginFailed: false,
          hasLoginSucces: true
 
        })
        console.log(this.state)
      } 
      else {
          this.setState({
             hasLoginFailed: true,
             hasLoginSucces: false 
          })
          console.log(this.state)
      
        }
    }

}
  

export default AdminLogin;
