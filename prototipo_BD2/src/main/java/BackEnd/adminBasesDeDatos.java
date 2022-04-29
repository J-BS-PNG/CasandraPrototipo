/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import BaseDeDatos.ConectarCassandra;
import com.datastax.oss.driver.api.core.cql.*;
import java.util.ArrayList;
import java.util.Iterator;
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
    public String[] addX(int n, String arr[], String x)
    {
        int i;
  
        // create a new array of size n+1
        String newarr[] = new String[n + 1];
  
        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
  
        newarr[n] = x;
  
        return newarr;
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
            return true;
        }catch(Exception ex){
            System.out.println("Error: " + ex);
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
    
    
    public String[] obtenerNombres(){
        try{
            String[] alimentos = {};
            ResultSet res = conexion.consultaBD("select nombre from restaurante.inventarioAlimentos;");
            if (!(res == null)){
                Iterator<Row> iterador = res.iterator();              
                while (iterador.hasNext()){
                   alimentos= addX(alimentos.length, alimentos, iterador.next().getString("nombre"));
                }
                
            }
                return  alimentos;
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        return null;
    }
    
    public producto obtenerElemento(String nombre){
        try{
            ResultSet res = conexion.consultaBD("select * from restaurante.inventarioAlimentos where nombre='"+nombre+"' ALLOW FILTERING;");
            Row row = res.one();
            producto p= new producto(row.getInt("idInventario"), row.getString("nombre"), row.getString("tipo"), row.getString("descripcion"), row.getInt("valornutricional"));
            return  p;              
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        return null;
    }
    
    public void eliminarElemento(int id){
        try{
            System.out.println(id);
            String query= "delete from restaurante.inventarioAlimentos where idinventario="+id+";";
            ResultSet res = conexion.consultaBD(query);           
            JOptionPane.showMessageDialog(null, "Dato eliminado exitosamente");
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
    public boolean actualizarProducto(producto alimento){
        try{
            String dato = "INSERT INTO restaurante.inventarioAlimentos (idinventario, nombre, tipo, descripcion, valornutricional) VALUES ("
                    + String.valueOf(alimento.getId()) + ", "
                    + "'"+alimento.getNombre()+"', "
                    + "'"+alimento.getTipo()+"', "
                    + "'"+alimento.getDescripcion()+"', "
                    + String.valueOf(alimento.getValorNutricional())+");";
            conexion.insert(dato);
            JOptionPane.showMessageDialog(null, "Dato actualizado");
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public void cerrarBase(){
        conexion.cerraCassandra();
    }
    
}
