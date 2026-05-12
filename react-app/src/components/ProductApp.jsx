import { useEffect, useState } from "react";
import { listProduct } from "../services/ProductService";
import { ProductTable } from "./ProductTable";
import { ProductForm } from "./ProductForm";
import { AlertModal } from "./AlertModal";




export const ProductApp = ({title}) =>{

    //Se usa useState para indicar que se renderizara un nuevo valor de products
    //                   cada vez que se use setProducts
    const [products, setProducts] = useState([]);

    const [opened, setOpen] = useState(false);

    const [idDelete, setIdDelete] = useState(0);

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


    //let alertContent = {title:"", message:""}

    const [alertContent, setAlertContent] = useState({title:"", message:""})

    const [onConfirm, setConfirmAction] = useState(()=>()=>{});
    
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

    function alert(title, message/*, onConfirm*/){
        //alertContent = {title: title, message: message};
        setAlertContent({title: title, message: message});
        //setConfirmAction(()=>onConfirm);        
        
        setOpen(true);
    }

    const onClose = () =>{
        setOpen(false);
    }

    const handlerRemoveProduct = (id) =>{
        setIdDelete(id);
        alert("Cuidado!","¿Estas seguro que deseas eliminar este producto?"/*, removeProduct*/);
    }

    const removeProduct = () =>{     
        if(idDelete > 0) {
            setProducts(products.filter(product => product.id != idDelete))
            setIdDelete(0)
        }
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
            <AlertModal opened={opened} content={alertContent} confirmAction={removeProduct} onClose={onClose}></AlertModal>
        </div>
    )
}