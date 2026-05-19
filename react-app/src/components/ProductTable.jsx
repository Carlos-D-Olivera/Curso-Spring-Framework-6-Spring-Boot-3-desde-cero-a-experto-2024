import { ProductDetail } from "./ProductDetail"

export const ProductTable = ({products, handlerRemove, handlerSelected})=>{
    return(
    <table className="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Update</th>
                        <th>Remove</th>
                    </tr>
                </thead>  
                <tbody>
                    {products.map( product =>{
                        return <ProductDetail product={product} key={product.id} handlerRemove = {handlerRemove} handlerSelected = {handlerSelected}/>
                    })}
                </tbody>  
    </table> 
    )
}