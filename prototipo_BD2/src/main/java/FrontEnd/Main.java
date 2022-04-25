/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;
import BaseDeDatos.ConectarCassandra;
import com.datastax.oss.driver.api.core.cql.*;
import java.util.UUID;
import BackEnd.*;
/**
 *
 * @author Jos_s
 */
public class Main {
     public static void main(String Args[]){
        adminBasesDeDatos admin = new adminBasesDeDatos();
        //conexion.insert("INSERT INTO restaurante.alimentos (idAlimentos, nombre, tipo) VALUES (010, 'Gelato', 'Postre');");
        
        //String data = "Hola " + Integer.valueOf(11);
        //System.out.println(data);
        //ResultSet res = conexion.consultaBD("select * from store.shopping_cart");
        //Row row = res.one();
        producto p = new producto(1, "Gelato", "Postre", "LLeva chocolate", 232);
        admin.guardarProducto(p);
        admin.cerrarBase();

    }
}
