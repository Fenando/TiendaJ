package DAL;
import BLL.Venta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class VentaDAL {
    
    /**
     * CRUD
     */
       public int create(Venta v){
    
                try {
            PreparedStatement ps = new Conector().getConn().prepareStatement(              
                    "insert into venta values(?,?)"); 
                    
            ps.setInt(1,v.getIdVenta());
            ps.setInt(2, v.getRut());
            ps.executeUpdate();
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
                    if (ex.getErrorCode()==1062) {
                        return 3;
                    }else{
                    return 2;
                    }
        }
                
    }
}
