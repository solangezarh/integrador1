package com.integrador.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class ProductoM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "imagen")
    private String imagen;

    
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProvedorM proveedor;

    
    
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private CategoriaM categoria;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    private MarcaM marca;

    // Getters and Setters

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public CategoriaM getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaM categoria) {
        this.categoria = categoria;
    }

    public MarcaM getMarca() {
        return marca;
    }

    public void setMarca(MarcaM marca) {
        this.marca = marca;
    }
}
