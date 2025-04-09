package org.colivera.springbootdifactura2.models;

public class Item {

    private Product producto;
    private Integer quantity;

    public Item() {
    }

    public Item(Product producto, Integer quantity) {
        this.producto = producto;
        this.quantity = quantity;
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getImporte(){
        return quantity * producto.getPrice();
    }
}
