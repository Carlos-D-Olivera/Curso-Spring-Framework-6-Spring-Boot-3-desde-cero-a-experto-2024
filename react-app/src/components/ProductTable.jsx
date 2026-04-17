import { ProductDetail } from "./ProductDetail"

export const ProductTable = ({products, handlerRemove, handlerSelected})=>{
    return(
    <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>update</th>
                        <th>remove</th>
                    </tr>
                </thead>  
                <tbody>
                    {products.map( product =>{
                        return <ProductDetail product={product} key={product.name} handlerRemove = {handlerRemove} handlerSelected = {handlerSelected}/>
                    })}
                </tbody>  
    </table>
    )
}