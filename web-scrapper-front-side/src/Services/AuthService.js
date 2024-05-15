import axios from "axios";

const API_URL = 'http://localhost:8081';

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

class AuthService {

    executeBasicAuthenticationService(username, password) {
        return axios.get(`${API_URL}/api/v1/users/auth`, {
            headers: { Authorization: this.createBasicAuthToken(username, password) }
        });
    }

    createBasicAuthToken(username, password) {
        return 'Basic ' + window.btoa(username + ":" + password);
    }

    registerSuccessfulLogin(username, password) {
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, username);
        this.setupAxiosInterceptors(this.createBasicAuthToken(username, password));
    }

    registerSuccessfulLoginForJwt(username, token) {
        sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, username);
        this.setupAxiosInterceptors(this.createJWTToken(token));
    }

    createJWTToken(token) {
        return 'Bearer ' + token;
    }

    logout() {
        sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
    }

    isUserLoggedIn() {
        return sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME) !== null;
    }

    getLoggedInUserName() {
        return sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME) || '';
    }

    setupAxiosInterceptors(token) {
        axios.interceptors.request.use(
            (config) => {
                if (this.isUserLoggedIn()) {
                    config.headers.Authorization = token;
                }
                return config;
            },
            (error) => {
                return Promise.reject(error);
            }
        );
    }
}

export default new AuthService();
