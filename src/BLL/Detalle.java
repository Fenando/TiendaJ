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
    public void readPorVenta(){
        
        try {
            ResultSet rs = new DetalleDAL().readInforme();
            while (rs.next()) {
                System.out.println(rs.getString("c.nombre"));
                System.out.println(rs.getString("contador"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Detalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        new Detalle().readPorVenta();
    }
    
}
