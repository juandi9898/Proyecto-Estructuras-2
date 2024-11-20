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
public class Videojuego {
    
    private int idVideojuego;
    private String titulo;
    private String descripcion;
    private String genero;
    private String plataforma;
    private Double precio;
    private Date fechaLanzamiento;
    private  int cantUDisp;
    private int idVendedor;
    
    
    public Videojuego() {
    
    }

    public Videojuego(int idVideojuego, String titulo, String descripcion, String genero, String plataforma, Double precio, Date fechaLanzamiento, int cantUDisp, int idVendedor) {
        this.idVideojuego = idVideojuego;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.genero = genero;
        this.plataforma = plataforma;
        this.precio = precio;
        this.fechaLanzamiento = fechaLanzamiento;
        this.cantUDisp = cantUDisp;
        this.idVendedor = idVendedor;
    }

    public int getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(int idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getCantUDisp() {
        return cantUDisp;
    }

    public void setCantUDisp(int cantUDisp) {
        this.cantUDisp = cantUDisp;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    
    
  
 
    

   
    
    
    
    
    
    
    
    
}
