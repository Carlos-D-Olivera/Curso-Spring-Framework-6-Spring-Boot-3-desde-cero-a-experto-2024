import { ProductDetail } from "./ProductDetail"

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