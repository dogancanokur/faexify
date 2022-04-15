import axios from "axios";

export const signUp = (body) => {
    axios.post('/api/v1.0/users', body);
    // .then((response) => {
    //     console.log(response);
    //     this.setState({pendingApiCall: false});
    // })
    // .catch((error) => {
    //     console.log(error);
    //     this.setState({pendingApiCall: false});
    // });
}
