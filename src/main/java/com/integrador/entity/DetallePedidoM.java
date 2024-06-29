package com.integrador.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "Detalles_Pedido")
public class DetallePedidoM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Integer idDetallePedido;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private PedidoM pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private ProductoM producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    // Getters and Setters

    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public PedidoM getPedido() {
        return pedido;
    }

    public void setPedido(PedidoM pedido) {
        this.pedido = pedido;
    }

    public ProductoM getProducto() {
        return producto;
    }

    public void setProducto(ProductoM producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
