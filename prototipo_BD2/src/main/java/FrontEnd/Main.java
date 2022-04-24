/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;
import BaseDeDatos.ConectarCassandra;
import com.datastax.oss.driver.api.core.cql.*;
/**
 *
 * @author Jos_s
 */
public class Main {
     public static void main(String Args[]){
        ConectarCassandra conexion = new ConectarCassandra();
        ResultSet res = conexion.consultaBD("select * from store.shopping_cart");
        Row row = res.one();
        System.out.println();
        conexion.cerraCassandra();

    }
}
