package BLL;

import DAL.ClienteDAL;
import DAL.ExCodigoDuplicadoDAL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void validaRut(String x) throws ExRutInvalidoBLL{
        System.out.println(x.matches("[\\w]]{8,9}"));
        if (x.matches("[a-zA-Z0-9_]{8,9}")) {
            try {
               int i = Integer.parseInt(x);
               this.setRut(i);
            } catch (Exception e) {
                throw new ExRutInvalidoBLL("Ingresa solo numeros enteros");
            }
        }else{
            throw new ExRutInvalidoBLL("Longitud de Rut no valida");
        }
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
        
        int x=0;
        try {
            x = new ClienteDAL().create(c);
            System.out.println(x);
        } catch (ExCodigoDuplicadoDAL ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
        System.out.println(x);
        String r="";
        switch (x) {
            case 1:
                r = "Ingresado correctamente";
                break;
            case 2:
                r= "Error conexión con la Base de datos";
                break;
            case 3:
                //r= "El rut ya existe";
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
