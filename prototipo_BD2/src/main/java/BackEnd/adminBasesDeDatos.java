/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import BaseDeDatos.ConectarCassandra;
import com.datastax.oss.driver.api.core.cql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jos_s
 */
public class adminBasesDeDatos {
    ConectarCassandra conexion;
    public adminBasesDeDatos(){
        conexion = new ConectarCassandra();
    }
    
    public boolean guardarProducto(producto alimento){
        try{
            String dato = "INSERT INTO restaurante.inventarioAlimentos (idinventario, nombre, tipo, descripcion, valornutricional) VALUES ("
                    + String.valueOf(alimento.getId()) + ", "
                    + "'"+alimento.getNombre()+"', "
                    + "'"+alimento.getTipo()+"', "
                    + "'"+alimento.getDescripcion()+"', "
                    + String.valueOf(alimento.getValorNutricional())+");";
            conexion.insert(dato);
            JOptionPane.showMessageDialog(null, "Dato Guardado");
            System.out.println(dato);
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public int obtenerId(){
        try{
            ResultSet res = conexion.consultaBD("select max(idInventario) as maximo from restaurante.inventarioAlimentos;");
            if (!(res == null)){
                Row row = res.one();
                int idProducto = row.getInt("maximo");
                return idProducto + 1;
            }
                return  1;
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        return -1;
    }
    
    public void cerrarBase(){
        conexion.cerraCassandra();
    }
    
}
