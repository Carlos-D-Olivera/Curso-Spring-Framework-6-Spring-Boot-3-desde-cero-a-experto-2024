import { useState } from "react";

const initProducts = [
    {
        name: 'Monitor Samsung 65',
        price: 1500000,
        description: 'El monitor es increible!'
    },
    {
        name: 'Iphone 16',
        price: 6800000,
        description: 'El telefono es muy bueno!'
    }
]

export const ProductApp = () =>{

    const [products, setProducts] = useState(initProducts);

    //setProducts(initProducts);

    return (        
        <>
            <h1>Hola mundo React</h1>   
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
                        return(
                        <tr key={product.name}>
                            <td>{product.name}</td>
                            <td>{product.price}</td>
                            <td>{product.description}</td>
                        </tr>)
                    })}
                </tbody>  
            </table>      
        </>
    )
}