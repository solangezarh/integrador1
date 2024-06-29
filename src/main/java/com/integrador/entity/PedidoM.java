package com.integrador.entity;



import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pedidos")
public class PedidoM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;
    
    @ManyToOne // la relacion de muchos a uno con cliente y pedido
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private ClienteM cliente; 

    @Column(name = "nombre_cliente", nullable = false, length = 50)
    private String nombreCliente;

    @Column(name = "fecha_pedido", nullable = false)
    private java.sql.Date fechaPedido;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "total", nullable = false)
    private Double total;

    @OneToMany(mappedBy = "pedido") // la relacion de 
    private List<DetallePedidoM> detallesPedido;

    
    
    
    
    
    // Getters and Setters

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public java.sql.Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(java.sql.Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<DetallePedidoM> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedidoM> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }
}
