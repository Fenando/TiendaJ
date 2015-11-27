/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Ferna
 */
public class ExCodigoDuplicadoDAL extends Exception{

    public ExCodigoDuplicadoDAL() {
        super();
       
        
    }

    @Override
    public String getMessage() {
         String m = "Error codigo duplicado";
        return m; //super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
