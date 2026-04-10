import { useEffect, useState } from "react";
import { listProduct } from "../services/ProductService";
import { ProductTable } from "./ProductTable";
import PropTypes from "prop-types";
import { ProductForm } from "./ProductForm";




export const ProductApp = ({title}) =>{

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
            <h1>{ title }</h1>   
            <ProductForm></ProductForm>
            <ProductTable products={products}/>      
        </>
    )
}

ProductApp.propTypes = {
    title: PropTypes.string.isRequired
}
