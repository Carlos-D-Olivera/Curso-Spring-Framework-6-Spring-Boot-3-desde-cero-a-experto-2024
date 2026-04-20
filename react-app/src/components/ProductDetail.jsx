export const ProductDetail = ({product={}, handlerRemove, handlerSelected})=>{
    return(
    <tr>
        <td>{product.name}</td>
        <td>{product.price}</td>
        <td>{product.description}</td>
        <td>
            <button onClick={()=>handlerSelected(product)}>
                Update
            </button>
        </td>
        <td>
            <button onClick={()=>handlerRemove(product.name)}>
                Remove
            </button>
        </td>
    </tr>
    )
}
