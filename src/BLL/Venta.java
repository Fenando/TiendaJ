/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;


import DAL.VentaDAL;

/**
 *
 * @author fernando
 */
public class Venta {
    
    private int idVenta;
    private int rut;

    public Venta() {
    }

    public Venta(int idVenta, int rut) {
        this.idVenta = idVenta;
        this.rut = rut;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
    public void create(Venta v){
    
        new VentaDAL().create(v);
    }
    
}