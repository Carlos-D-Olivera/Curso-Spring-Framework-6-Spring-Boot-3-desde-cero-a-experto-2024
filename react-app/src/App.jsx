import { useState } from 'react'
import './App.css'

export const App = () => {
  const [count, setCount] = useState(0)

  // let variable = 0;

  // function incrementar(){
  //    setCount(count+1);
  // }

  // let count = 0;

  // function setCount(count){
  //   console.log("entro")
  //   document.getElementById('counter').textContent = "El conteo es " + count;
  // }

  return (
    <>
      <section id="center">
        <div>
          <h1>Get started</h1>          
        </div>
        <button className="counter" id="counter" onClick={()=>setCount((count) => count+1 )}> 
          El conteo es es {count}
        </button>
        <button className="counter minus" onClick={()=>setCount(count-1)} >Restar</button>
      </section>

      <div className="ticks"></div>
    </>
  )
}