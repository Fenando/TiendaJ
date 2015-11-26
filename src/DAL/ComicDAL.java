/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Comic;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class ComicDAL {
    
    /**
     * CRUD
     */
    public int create(Comic c){ 
        try {
            PreparedStatement ps = new Conector().getConn().prepareStatement(              
                    "insert into comic values(?,?,?)"); 
                    
            ps.setInt(1,c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.setInt(3, c.getNumero());
            ps.executeUpdate();
            return 1;
            
        } catch (SQLException ex) {
            if (ex.getErrorCode()==1062) {
                return 3;
            }else{
                return 2;
            }
            
            
        }
    }
    public ArrayList<Comic> readBodega(){
        
        try {
            ArrayList<Comic> aList = new ArrayList<>();
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select nombre,codigo from comic");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comic c = new Comic();
                c.setNombre(rs.getString("nombre"));
                c.setCodigo(rs.getInt("codigo"));
                aList.add(c);
            }
            return aList;
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
        public ArrayList<Comic> readTodo(){
        
        try {
            ArrayList<Comic> aList = new ArrayList<>();
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select * from comic");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comic c = new Comic();
                c.setNombre(rs.getString("nombre"));
                c.setCodigo(rs.getInt("codigo"));
                c.setNumero(rs.getInt("numero"));
                aList.add(c);
            }
            return aList;
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    public int totalizador(){
        
        try {
            ArrayList<Comic> aList = new ArrayList<>();
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select count(*) from comic");
            ResultSet rs = ps.executeQuery();
           rs.next();
           return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    
    }
        public ArrayList<Comic> readPorNombre(String name){
        
        try {
            ArrayList<Comic> aList = new ArrayList<>();
            PreparedStatement ps = new Conector().getConn().prepareStatement(
                    "select * from comic where nombre like '%"+name+"%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comic c = new Comic();
                c.setNombre(rs.getString("nombre"));
                c.setCodigo(rs.getInt("codigo"));
                c.setNumero(rs.getInt("numero"));
                aList.add(c);
            }
            return aList;
        } catch (SQLException ex) {
            Logger.getLogger(ComicDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
  
    
}
