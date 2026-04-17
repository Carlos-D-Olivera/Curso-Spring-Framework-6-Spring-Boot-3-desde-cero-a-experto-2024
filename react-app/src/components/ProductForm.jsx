import { useEffect, useState } from "react"

const initialDataForm = {
    name: '',
    description: '',
    price: ''
}

export const ProductForm = ({handlerAdd, handlerSelected})=>{

    const [form, setForm] = useState(initialDataForm);

    const {name, description, price} = form;

    useEffect(()=>{
        setForm(product)
    })

    return (
        <form onSubmit={(event)=>{            
            event.preventDefault();
            
            if(!name || !description || !price){
                alert('Debe completar los datos del formulario');
            }

            //console.log(form)
            handlerAdd(form)
            setForm(initialDataForm);
        }}>
            <div>
                <input placeholder="Name" name="name" value={name} style={{marginBottom:'2px'}}                
                    onChange={(event)=>setForm({
                    ...form, 
                    name: event.target.value
                })} />
            </div>
            <div>
                <input placeholder="Description" name="description" value={description} onChange={(event)=>setForm({
                    ...form,
                    description: event.target.value
                })} />
            </div>
            <div>
                <input placeholder="Price" name="price" value={price} style={{marginBottom:'2px'}}   
                    onChange={(event)=>setForm({
                    ...form,
                    price: event.target.value
                })} />
            </div>
            <button type="submit">Create</button>
        </form>
    )
}