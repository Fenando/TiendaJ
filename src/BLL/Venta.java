/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;


import DAL.ClienteDAL;
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

    public void setRut(int rut) throws Exception {
        boolean b = false;
        for (Cliente c: new ClienteDAL().readClientes()) {
            if (c.getRut()==rut) {
            b = true;
            }
        }
        if (b) {
            this.rut = rut;
        }else{
            throw new Exception("Rut no valido, cliente no registrado");
        }
        
    }
    public String create(Venta v){
    
        int x = new VentaDAL().create(v);
         String r;
        switch (x) {
            case 1:
                r = "Venta Ingresada correctamente\n";
                break;
            case 2:
                r= "Error al ingresar la venta";
                break;
            case 3:
                r= "El codigo ya existe";
                break;
            default:
                r= "Ha ocurrido un error faltal";
        }
        return r;
    }
    
}
