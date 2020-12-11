import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

function ProductAdministrationComponent({ name, id, image }) {
    return (
        <tr>
            <th scope="row">{id}</th>
            <td><img src={process.env.PUBLIC_URL + image} style={{width: '50px', height: '50px'}} alt=""/></td>
            <td className="align-middle"><Link to={`/admin/products/${id}`}>{name}</Link></td>
        </tr>
    );
}

ProductAdministrationComponent.propTypes = {
    name: PropTypes.string.isRequired,
    id: PropTypes.number.isRequired,
    image: PropTypes.string.isRequired
}

export default ProductAdministrationComponent;