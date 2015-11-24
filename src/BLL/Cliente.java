package BLL;

import DAL.ClienteDAL;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Cliente {
    
    private int rut;
    private String nombre;

    public Cliente() {
    }

    public Cliente(int rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void create(Cliente c){
        
        new ClienteDAL().create(c);
    
    }
    public ArrayList<Cliente> readClientes(){
        return new ClienteDAL().readClientes();
    
    }
}
