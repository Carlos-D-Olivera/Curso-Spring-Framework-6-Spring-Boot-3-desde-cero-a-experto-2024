import { useEffect, useState } from "react";
import { listProduct } from "../services/ProductService";
import { ProductTable } from "./ProductTable";



export const ProductApp = () =>{

    //Se usa useState para indicar que se renderizara un nuevo valor de products
    //                   cada vez que se use setProducts
    const [products, setProducts] = useState([]);


    //Se usa useEffect para hacer que se 
    useEffect(()=>{
        const result = listProduct();
        setProducts(result);
    }, [])
    

    return (        
        <>
            <h1>Productos</h1>   
            <ProductTable products={products}/>      
        </>
    )
}