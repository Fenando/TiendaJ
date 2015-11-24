package DAL;

import BLL.Cliente;
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
public class ClienteDAL {
    
    /**
     * CRUD
     */
    public void create(Cliente c){
    
                try {
            PreparedStatement ps = new Conector().getConn().prepareStatement(              
                    "insert into cliente values(?,?)"); 
                    
            ps.setInt(1,c.getRut());
            ps.setString(2, c.getNombre());
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Cliente> readClientes(){
        try {
            ArrayList<Cliente> aList = new ArrayList<>();
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select * from cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setRut(rs.getInt("rut"));
                c.setNombre(rs.getString("nombre"));
                aList.add(c);
                }
            return aList;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
