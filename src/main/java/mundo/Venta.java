/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.sql.Date;


/**
 *
 * @author juand
 */
public class Venta {
    private int idVenta;
    private int idUsuario;
    private int idJuego;    
    private Date fecha_venta;
    private int cantidadVender;
    private int idVendedor;

    public Venta() {
    
    }

    public Venta(int idVenta, int idUsuario, int idJuego, Date fecha_venta, int cantidadVender, int idVendedor) {
        this.idVenta = idVenta;
        this.idUsuario = idUsuario;
        this.idJuego = idJuego;
        this.fecha_venta = fecha_venta;
        this.cantidadVender = cantidadVender;
        this.idVendedor = idVendedor;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getCantidadVender() {
        return cantidadVender;
    }

    public void setCantidadVender(int cantidadVender) {
        this.cantidadVender = cantidadVender;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    void setFechaVenta(Date fechaVenta) {

       this.fecha_venta=fechaVenta;

    }
    
    
    
    
    
    
    
}
