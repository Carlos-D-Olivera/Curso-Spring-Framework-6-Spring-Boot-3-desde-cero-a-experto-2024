import { useEffect, useState } from "react";
import { listProduct } from "../services/ProductService";
import { ProductTable } from "./ProductTable";
import { ProductForm } from "./ProductForm";
import { AlertModal } from "./AlertModal";




export const ProductApp = ({title}) =>{

    //Se usa useState para indicar que se renderizara un nuevo valor de products
    //                   cada vez que se use setProducts
    const [products, setProducts] = useState([]);

    const [productSelected, setProductSelected] = useState({
        id: 0,
        name: '',
        description: '',
        price: ''       
    });

    //Se usa useEffect para hacer que se ejecute la funcion listProduct una sola vez, al momento de cargar el componente.
    useEffect(()=>{
        const result = listProduct();
        setProducts(result);
    }, [])

    const [show, setShow] = useState({
        isOpen: false,
        title: '', 
        message: ''
        }
    )
    
    const handlerAddProduct = (product) =>{
        console.log(product);
        //setProducts([...products, {...product}]) //Se esparcen los productos para que se 

        if(product.id > 0){
            setProducts(products.map(p=>{
                if(p.id == product.id){
                    return {...product}
                }else{
                    return p;
                }
            }))
        }else{
            setProducts([...products, {...product, id: new Date().getTime()}])
        }

    }

    const showWarning = (title, message) =>{
        
        setShow({isOpen: true, title: title, message: message});
        console.log("alert")
        //setTimeout(2000)
        //setShow({isOpen: false, title: '',  message: '' })

        return false;
    }

    const handlerRemoveProduct = (id) =>{
        showWarning( "Cuidado!", "¿Estas seguro que deseas eliminar este producto?")
        console.log(id);
        setProducts(products.filter(product => product.id != id))
    }

    const handlerProductSelected = (product) =>{
        setProductSelected(product);
    }

    return (        
        <div className="container my-4">
            <h1>{ title }</h1>
            <div className="row">
                <div className="col">
                    <ProductForm handlerAdd = {handlerAddProduct} productSelected = {productSelected}/>
                </div>
                <div className="col">
                    {
                        products.length > 0 ?
                        <ProductTable products={products} handlerRemove = {handlerRemoveProduct}  handlerSelected = {handlerProductSelected}/>                  
                        :
                        <div className="alert alert-warning">No hay productos en el sistema</div>
                    }
                </div>
            </div>   
            <AlertModal show={show}></AlertModal>
        </div>
    )
}