package BLL;

import DAL.DetalleDAL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Detalle extends Comic{
    
    private int idDetalle;
    private int id_venta;
    private int codigoComic;
    
    
    public Detalle() {
    }

    public Detalle(int idDetalle, int id_venta, int codigoComic) {
        this.idDetalle = idDetalle;
        this.id_venta = id_venta;
        this.codigoComic = codigoComic;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getCodigoComic() {
        return codigoComic;
    }

    public void setCodigoComic(int codigoComic) {
        this.codigoComic = codigoComic;
    }
    public void create(Detalle d){
    
        new DetalleDAL().create(d);
    }
    public ArrayList<Detalle> readPorVenta(int code){
       return new DetalleDAL().readPorNombre(code);
        
    } 
    public ArrayList<String> readInforme(){
        int tComic = 0;
        ArrayList<Object[]> ol = new DetalleDAL().readInforme();
            for (Object[] o : ol ){
                tComic =+ Integer.parseInt(o[0].toString()); 
            }
        int tVentas = tComic *1000; 
        ArrayList<String> sl = new ArrayList<>();
        sl.add(String.valueOf(tComic));
        sl.add(String.valueOf(tVentas));
        sl.add(ol.get(0)[1].toString());
        return sl;
    }
         public static void main(String[] args) {
        new Detalle().readInforme();
    }
    }
   
        
    
    


    
      
   

