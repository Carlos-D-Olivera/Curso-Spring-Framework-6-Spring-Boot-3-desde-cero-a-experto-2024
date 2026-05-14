import { useEffect, useState } from "react"

const initialDataForm = {
    id: 0,
    name: '',
    description: '',
    price: ''
}

export const ProductForm = ({handlerAdd, productSelected, handlerSelected})=>{

    const [form, setForm] = useState(initialDataForm);

    const {id, name, description, price} = form;

    useEffect(()=>{
        setForm(productSelected)
    }, [productSelected])

    return (
        <form onSubmit={(event)=>{            
            event.preventDefault();
            
            if(!name || !description || !price){
                alert('Debe completar los datos del formulario');
                return;
            }

            //console.log(form)
            handlerAdd(form)
            setForm(initialDataForm);
        }}>
            <div>
                <input placeholder="Name" className="form-control my-3 w-75" name="name" value={name} style={{marginBottom:'2px'}}                
                    onChange={(event)=>setForm({
                    ...form, 
                    name: event.target.value
                })} />
            </div>
            <div>
                <input placeholder="Description" className="form-control my-3 w-75" name="description" value={description} style={{marginBottom:'2px'}}
                    onChange={(event)=>setForm({
                    ...form,
                    description: event.target.value
                })} />
            </div>
            <div>
                <input placeholder="Price" name="price" className="form-control my-3 w-75" value={price} style={{marginBottom:'2px'}}   
                    onChange={(event)=>setForm({
                    ...form,
                    price: event.target.value
                })} />
            </div>
            <button type="submit" className="btn btn-primary me-1">
                {id > 0? 'Update' : 'Create'}
            </button>
            <button type="button" className="btn btn-secondary" onClick={
                ()=>{
                    setForm(initialDataForm);
                    handlerSelected(initialDataForm);
                }}>Clear</button>
        </form>
    )
}