package com.integrador.entity;




import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Provedores")
public class ProvedorM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provedor")
    private Integer idProvedor;

    @Column(name = "nomproved", nullable = false, length = 50)
    private String nomproved;

    @Column(name = "numproved", nullable = false, length = 15)
    private String numproved;

    @OneToMany(mappedBy = "proveedor")
    private List<ProductoM> productos;

    // Getters and Setters

    public Integer getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }

    public String getNomproved() {
        return nomproved;
    }

    public void setNomproved(String nomproved) {
        this.nomproved = nomproved;
    }

    public String getNumproved() {
        return numproved;
    }

    public void setNumproved(String numproved) {
        this.numproved = numproved;
    }

    public List<ProductoM> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoM> productos) {
        this.productos = productos;
    }
}
