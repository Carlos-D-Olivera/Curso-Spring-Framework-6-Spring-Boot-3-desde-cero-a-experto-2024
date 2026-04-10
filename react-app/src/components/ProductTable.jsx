import { ProductDetail } from "./ProductDetail"
import { PropTypes } from "prop-types"

export const ProductTable = ({products})=>{
    return(
    <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                    </tr>
                </thead>  
                <tbody>
                    {products.map( product =>{
                        return <ProductDetail product={product} key={product.name} />
                    })}
                </tbody>  
    </table>
    )
}

ProductTable.propTypes = {
    products: PropTypes.array.isRequired
}