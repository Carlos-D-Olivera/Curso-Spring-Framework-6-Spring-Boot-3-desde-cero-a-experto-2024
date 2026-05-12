
import { useEffect, useRef } from "react"

export const AlertModal = ({show}) =>{

    const modalRef = useRef(null);
    const modalInstance = useRef(null);

    useEffect(()=>{

        modalInstance.current = new bootstrap.Modal(modalRef.current)

        modalRef.current.addEventListener('hidden.bs.modal', () => {
            
        })

        if(show.isOpen){
            modalInstance.current.show();
        }else{
            modalInstance.current.hide()
        }

    },[show.isOpen])

    return (
        <div className="modal" ref={modalRef} tabIndex="-1" aria-labelledby="exampleModalLabel">
            <div className="modal-dialog">
                <div className="modal-content">
                <div className="modal-header">
                    <h1 className="modal-title fs-5" id="exampleModalLabel">{show.title}</h1>
                    <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div className="modal-body">
                    {show.message}
                </div>
                <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" onClick={()=>modalInstance.current.hide()}>Close</button>
                    <button type="button" className="btn btn-danger">Remove</button>
                </div>
                </div>
            </div>
        </div>
    )
}