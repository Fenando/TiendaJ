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
    
    public String create(Cliente c){
        
        int x = new ClienteDAL().create(c);
        System.out.println(x);
        String r;
        switch (x) {
            case 1:
                r = "Ingresado correctamente";
                break;
            case 2:
                r= "Error conexión con la Base de datos";
                break;
            case 3:
                r= "El rut ya existe";
                break;
            default:
                r= "Ha ocurrido un error faltal";
        }
        return r;
    }
    public ArrayList<Cliente> readClientes(){
        return new ClienteDAL().readClientes();
    
    }
}
