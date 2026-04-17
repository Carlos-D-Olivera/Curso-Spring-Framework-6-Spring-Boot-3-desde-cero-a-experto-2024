export const ProductDetail = ({product={}, handlerRemove})=>{
    return(
    <tr>
        <td>{product.name}</td>
        <td>{product.price}</td>
        <td>{product.description}</td>
        <td>
            <button onClick={()=>handlerRemove(product.name)}>
                Remove
            </button>
        </td>
    </tr>
    )
}
