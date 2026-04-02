export const ProductDetail = ({product={}})=>{
    return(
    <tr>
        <td>{product.name}</td>
        <td>{product.price}</td>
        <td>{product.description}</td>
    </tr>
    )
}