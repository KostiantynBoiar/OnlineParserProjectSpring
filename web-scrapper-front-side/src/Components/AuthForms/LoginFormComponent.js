import React, { Component } from 'react';
import AuthService from '../../Services/AuthService';

class LoginFormComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            username: 'example',
            password: 'example',
            loginError: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.loginClicked = this.loginClicked.bind(this);
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value,
            loginError: '' // Clear any previous login error when input changes
        });
    }

    loginClicked() {
        const { username, password } = this.state;

        // Call the authentication service with username and password
        AuthService.executeBasicAuthenticationService(username, password)
            .then(response => {
                // If authentication is successful, store token and redirect
                AuthService.registerSuccessfulLogin(response.data.token);
                this.props.history.push('/');
            })
            .catch(error => {
                // If authentication fails, update state to show error message
                this.setState({
                    loginError: 'Invalid credentials' // Show error message
                });
            });
    }

    render() {
        return (
            <div>
                <h1>Login</h1>
                <div className="container">
                    {this.state.loginError && (
                        <div className="alert alert-warning">{this.state.loginError}</div>
                    )}
                    User Name:{' '}
                    <input
                        type="text"
                        name="username"
                        value={this.state.username}
                        onChange={this.handleChange}
                    />
                    Password:{' '}
                    <input
                        type="password"
                        name="password"
                        value={this.state.password}
                        onChange={this.handleChange}
                    />
                    <button className="btn btn-success" onClick={this.loginClicked}>
                        Login
                    </button>
                </div>
            </div>
        );
    }
}

export default LoginFormComponent;
