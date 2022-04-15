import React from "react";
import {signUp} from "../api/apiCalls";

class UserSignUpPage extends React.Component {
    state = {
        username: null, displayName: null, password: null, passwordRepeat: null, pendingApiCall: false
    }

    onChangeInput = event => {
        const {name, value} = event.target;
        this.setState({
            [name]: value
        });
    };

    onClickSignUp = async event => {
        event.preventDefault();
        const {username, displayName, password} = this.state;
        const body = {username, displayName, password};
        this.setState({pendingApiCall: true});
        try {
            const response = await signUp(body);
            console.log(response);
        } catch (error) {
            console.log(error);
        }
        this.setState({pendingApiCall: false});
    }

    render() {
        const {pendingApiCall} = this.state;
        return (<div className="container">
            <form action="">
                <h1>Sign Up</h1>

                <div className="form-group">
                    <label htmlFor="{'username'}">Username</label>
                    <input className="form-control" type="text"
                           id={'username'} name={'username'}
                           onChange={this.onChangeInput}/>
                </div>

                <div className="form-group">
                    <label htmlFor="{'displayName'}">Display Name</label>
                    <input className="form-control" type="text"
                           id={'displayName'} name={'displayName'}
                           onChange={this.onChangeInput}/>
                </div>

                <div className="form-group">
                    <label htmlFor="{'password'}">Password</label>
                    <input className="form-control" type="password"
                           id={'password'} name={'password'}
                           onChange={this.onChangeInput}/>
                </div>

                <div className="form-group">
                    <label htmlFor="{'passwordRepeat'}">Password Repeat</label>
                    <input className="form-control" type="password"
                           id={'passwordRepeat'} name={'passwordRepeat'}
                           onChange={this.onChangeInput}/>
                </div>

                <div className="text-center">
                    <button className={"btn btn-primary " + (pendingApiCall ? 'cursor-not-allowed' : '')}
                            disabled={pendingApiCall}
                            onClick={this.onClickSignUp}>
                        {/*conditional rendering*/
                            pendingApiCall && <span className="spinner-border spinner-border-sm"></span>}
                        &nbsp;Sign Up
                    </button>
                </div>

            </form>
        </div>)
    }

}

export default UserSignUpPage;