
import { useEffect, useRef } from "react"

export const AlertModal = ({opened, content={}, confirmAction, onClose}) =>{

    const modalRef = useRef(null);
    const modalInstance = useRef(null);

    useEffect(()=>{
            
        modalInstance.current = new bootstrap.Modal(modalRef.current)

        modalRef.current.addEventListener('hidden.bs.modal', () => {
            onClose();
        })

    },[]);

    useEffect(()=>{

        if(opened){
            modalInstance.current.show();
        }else{
            modalInstance.current.hide();
            onClose();
        }
    },[opened])

    return (
        <div className="modal" ref={modalRef} aria-labelledby="exampleModalLabel">
            <div className="modal-dialog">
                <div className="modal-content">
                <div className="modal-header">
                    <h1 className="modal-title fs-5" id="exampleModalLabel">{content.title}</h1>
                    <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div className="modal-body">
                    {content.message}
                </div>
                <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" onClick={()=>{modalInstance.current.hide(); onClose()}}>Close</button>
                    {   
                        content.type == "alert" && 
                        ( 
                        <button type="button" className="btn btn-danger" onClick={()=>{confirmAction(); onClose()}}>Remove</button>
                        )
                    }
                </div>
                </div>
            </div>
        </div>
    )
}