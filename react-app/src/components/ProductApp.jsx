import { useEffect, useState } from "react";
import { findAll, create, update, remove } from "../services/ProductService";
import { ProductTable } from "./ProductTable";
import { ProductForm } from "./ProductForm";
import { AlertModal } from "./AlertModal";
import { HttpStatusCode } from "axios";




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
        getProducts();
    }, [])


    const getProducts = async () => {
        const result = await findAll();
        console.log(result);
        setProducts(result.data._embedded.products);
    }

    const [alertContent, setAlertContent] = useState({title:"", message:"", type:"alert"})

    const [onConfirm, setConfirmAction] = useState(()=>()=>{});
    
    const handlerAddProduct = async (product) =>{
        console.log(product);
        
        if(product.id > 0){

            const response = await update(product);
            
            const productBd = response.data;


            if(productBd.id){            
                say("Listo ✅","Producto actualizado!");
            }else{
                say("ERROR","Error al actualizar");
            }

            setProducts(products.map(p=>{
                if(p.id == productBd.id){
                    return {...productBd}
                }else{
                    return p;
                }
            }))
        }else{
            const response = await create(product)

            if(response.status == HttpStatusCode.Created){                            
                say("Listo ✅","Producto creado!");
            }else{
                say("Listo","Error al crear");
            }

            const productBd = response.data;
            
            setProducts([...products, {...productBd}]);
        }

    }    

    function alert(title, message){
        setAlertContent({title: title, message: message, type: "alert"});
        setOpen(true);
    }

    function say(title, message){
        setAlertContent({title: title, message: message});
        setOpen(true);
    }    

    const onClose = () =>{
        setOpen(false);
    }

    const handlerRemoveProduct = (id) =>{
        setIdDelete(id);
        alert("Cuidado!","¿Estas seguro que deseas eliminar este producto?");
    }

    const removeProduct = async () =>{     
        if(idDelete > 0) {
            
            const response = await remove(idDelete);
            
            if(response.status == HttpStatusCode.Ok){
                say("Listo ✅","Producto eliminado!");
                setProducts(products.filter(product => product.id != idDelete))
            }else{
                say("ERROR","Error al eliminar")
            }
            
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
                    <ProductForm handlerAdd = {handlerAddProduct} productSelected = {productSelected} handlerSelected = {handlerProductSelected}/>
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