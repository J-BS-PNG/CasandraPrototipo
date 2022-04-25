/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;


/**
 *
 * @author Jos_s
 */
public class ConectarCassandra {
    
    CqlSession session;
    public ConectarCassandra(){
        try{
            session = CqlSession.builder().build();
            //ResultSet rs = session.execute("select release_version from system.local");
            //Row row = rs.one();
            //System.out.println(row.getString("release_version"));
            System.out.println("Base de datos conectada");
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        
    }
    public ResultSet consultaBD(String consulta){
        try{
            ResultSet rs = session.execute(consulta);
            return rs;
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        return null;
    }
    
    public boolean insert(String query){
        try{
            session.execute(query);
            return true;
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
        return false;
    }
    public void cerraCassandra(){
        session.close();
    }
}
