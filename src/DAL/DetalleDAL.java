package DAL;

import BLL.Detalle;
import BLL.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class DetalleDAL {
    
    /**
     * CRUD
     */
         public void create(Detalle d){
    
                try {
            PreparedStatement ps = new Conector().getConn().prepareStatement(              
                    "insert into detalle(id_venta,codigoComic) values(?,?)"); 
                    
            ps.setInt(1,d.getId_venta());
            ps.setInt(2, d.getCodigoComic());
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public ArrayList<Detalle> readPorNombre(int code){
        
        try {
            ArrayList<Detalle> aList = new ArrayList<>();
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select d.* , c.nombre "
                            + "from detalle d "
                            + "join comic c "
                            + "on d.codigoComic = c.codigo "
                            + "where d.id_venta = "+code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Detalle d = new Detalle();
                d.setIdDetalle(rs.getInt("d.idDetalle"));
                d.setCodigoComic(rs.getInt("d.codigoComic"));
                d.setNombre(rs.getString("c.nombre"));
                aList.add(d);
            }
            return aList;
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
         public ResultSet readInforme(){
        
        try {
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select count(*) as contador , c.* "
                            + "from detalle d "
                            + "join venta v "
                            + "on d.id_venta = v.idVenta "
                            + "join cliente c "
                            + "on v.rut = c.rut "
                            + "group by c.rut ");
             ResultSet rs = ps.executeQuery();
             
             return rs;
            
            } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         }
    }
    

