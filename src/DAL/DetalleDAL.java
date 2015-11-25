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
    public void create(Detalle d) {

        try {
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "insert into detalle(id_venta,codigoComic) values(?,?)");

            ps.setInt(1, d.getId_venta());
            ps.setInt(2, d.getCodigoComic());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Object[]> readPorNombre(int code) {

        try {
            ArrayList<Object[]> aList = new ArrayList<>();
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select d.* , c.nombre "
                    + "from detalle d "
                    + "join comic c "
                    + "on d.codigoComic = c.codigo "
                    + "where d.id_venta = " + code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] d = new Object[3];
                d[0]= rs.getInt("d.idDetalle");
                d[1]= rs.getInt("d.codigoComic");
                d[2]= rs.getString("c.nombre");
                aList.add(d);
            }
            return aList;
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public ArrayList<Object[]> readInforme() {
        ArrayList<Object[]> xs = new ArrayList<>();
        try {

            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select count(*) as contador , c.* "
                    + "from detalle d "
                    + "join venta v "
                    + "on d.id_venta = v.idVenta "
                    + "join cliente c "
                    + "on v.rut = c.rut "
                    + "group by c.rut "
                    + "order by contador DESC ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                xs.add(new Object[]{rs.getInt("contador"), rs.getString("c.nombre")});

            }
            return xs;

        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
