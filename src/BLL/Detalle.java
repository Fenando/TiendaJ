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
public class Detalle{
    
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
    public String create(Detalle d){
    
        int x = new DetalleDAL().create(d);
         String r;
        switch (x) {
            case 1:
                r = "Detalle Ingresado correctamente";
                break;
            case 2:
                r= "Error al ingresar detalle";
                break;
            
            default:
                r= "Ha ocurrido un error faltal";
        }
        return r;
    }
    public ArrayList<String[]> readPorVenta(int code){
       ArrayList<String[]> sl = new ArrayList<>();
       for(Object[]o:new DetalleDAL().readPorNombre(code) ){
           sl.add(new String[]{o[0].toString(),o[1].toString(),o[2].toString()});
       } 
       
        return sl;
        
    } 
    public ArrayList<String> readInforme(){
        int tComic = 0;
        int i;
        ArrayList<Object[]> ol = new DetalleDAL().readInforme();
            for (Object[] o : ol ){
                tComic += Integer.parseInt(o[0].toString()); 
                //System.out.println(o[0]);
            }
        int tVentas = tComic *1000; 
        ArrayList<String> sl = new ArrayList<>();
        sl.add(String.valueOf(tComic));
        sl.add(String.valueOf(tVentas));
        sl.add(ol.get(0)[1].toString());
        return sl;
    }
  
    }
   
        
    
    


    
      
   

