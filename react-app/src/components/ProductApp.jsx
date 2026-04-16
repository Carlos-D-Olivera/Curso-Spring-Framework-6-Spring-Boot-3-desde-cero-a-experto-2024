import { useEffect, useState } from "react";
import { listProduct } from "../services/ProductService";
import { ProductTable } from "./ProductTable";
import PropTypes from "prop-types";
import { ProductForm } from "./ProductForm";




export const ProductApp = ({title}) =>{

    //Se usa useState para indicar que se renderizara un nuevo valor de products
    //                   cada vez que se use setProducts
    const [products, setProducts] = useState([]);


    //Se usa useEffect para hacer que se ejecute la funcion listProduct una sola vez, al momento de cargar el componente.
    useEffect(()=>{
        const result = listProduct();
        setProducts(result);
    }, [])
    
    const handlerAddProduct = (product) =>{
        console.log(product);
        setProducts([...products, {...product}]) //Se esparcen los productos para que se 
    }

    return (        
        <>
            <h1>{ title }</h1>   
            <ProductForm handlerAdd = {handlerAddProduct} />
            <ProductTable products={products}/>      
        </>
    )
}

ProductApp.propTypes = {
    title: PropTypes.string.isRequired
}
