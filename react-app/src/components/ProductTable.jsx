import { ProductDetail } from "./ProductDetail"

export const ProductTable = ({products, handlerRemove})=>{
    return(
    <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>remove</th>
                    </tr>
                </thead>  
                <tbody>
                    {products.map( product =>{
                        return <ProductDetail product={product} key={product.name} handlerRemove = {handlerRemove}/>
                    })}
                </tbody>  
    </table>
    )
}