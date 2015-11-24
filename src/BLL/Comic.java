package BLL;

import DAL.ComicDAL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Comic {
    
    private int codigo;
    private String nombre;
    private int numero;

    public Comic() {
    }

    public Comic(int codigo, String nombre, int numero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String create(Comic c){
        try {
            new ComicDAL().create(c);
            return "Comic ingresado";
        } catch (Exception ex) {
            return "comic no ingresado";
        }
    }
    public ArrayList<Comic> readBodega(){
       return new ComicDAL().readBodega();
    }
    public ArrayList<Comic> readTodo(){
       return new ComicDAL().readTodo();
    }
    public String totalizador(){
        return "El valor total en bodega es $"
                +new ComicDAL().totalizador()*1000;
    
    }
    public ArrayList<Comic> readTodoPorNombre(String name){
       return new ComicDAL().readPorNombre(name);
    }
}
