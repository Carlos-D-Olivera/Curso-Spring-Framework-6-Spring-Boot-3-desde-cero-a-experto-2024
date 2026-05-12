export const ProductDetail = ({product={}, handlerRemove, handlerSelected})=>{
    return(
    <tr>
        <td>{product.name}</td>
        <td>{product.price}</td>
        <td>{product.description}</td>
        <td>
            <button className="btn btn-secondary btn-sm" onClick={()=>handlerSelected(product)}>
                Update
            </button>
        </td>
        <td>
            <button className="btn btn-danger btn-sm" onClick={()=>handlerRemove(product.id)}>
                Remove
            </button>
        </td>
    </tr>
    )
}
