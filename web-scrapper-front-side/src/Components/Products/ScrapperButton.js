import React from 'react';
import axios from 'axios';

const ScrapperButton = ({ shopName }) => {
    
    const handleClick = () => {
        axios.post(`http://127.0.0.1:8000/api/v1/products/post/${shopName}/`)
            .then(response => {
                console.log(response.data); // Handle response as needed
            })
            .catch(error => {
                console.error('Error:', error);
            });
    };

    return (
        <button onClick={handleClick}>Run Scrapper for {shopName}</button>
    );
};

export default ScrapperButton;