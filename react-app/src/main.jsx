import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
//import './index.css'
//import {App} from './App.jsx'
import {ProductApp} from './components/ProductApp.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ProductApp title='Lista de Productos!'/>
  </StrictMode>,
)
