package org.colivera.springbootdifactura2.models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice {

    @Autowired
    private Client cliente;

    @Value("${invoice.description.office}")
    private String description;
    @Autowired
    @Qualifier("default")
    private List<Item> items;


    public Invoice(){
        System.out.println("Creando el componente de la factura");
        System.out.println(cliente);
        System.out.println(description);
    }

    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura");
        cliente.setName(cliente.getName().concat(" Pepe"));
        description = description.concat(" del cliente: ").concat(cliente.getName()).concat(" ").concat(cliente.getLastName());
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal(){
//        int total = 0;

//        for(Item item : items){
//            total += item.getImporte();
//        }
        /*

            Primero iteramos la lista de items
            pero cada vez que tomamos un item
            vamos a tomar su importe y asi con el
            .map tenemos una lista/flujo de los
            precios luego con reduce los sumamos

         */
        int total = items.stream()
                .map(item -> item.getImporte())
                .reduce(0, (sum, importe) -> sum + importe);
        return total;
    }
}
