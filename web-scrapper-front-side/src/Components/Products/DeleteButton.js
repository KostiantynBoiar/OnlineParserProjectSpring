import axios from 'axios';

const DeleteButton = ({ id }) => {
    const handleClick = () => {
        axios.delete(`http://localhost:8082/api/v1/products/delete/id/${id}`)
            .then(response => {
                console.log(`Item has been deleted by id = ${id}`);
                window.location.reload();
            })
            .catch(error => {
                console.log(`Something went wrong: ${error}`);
            });
    };

    return (
        <>
            <button onClick={handleClick} className='product-delete-button'>
                Delete
            </button>
        </>
    );
}

export default DeleteButton;