/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassAndForm;

    import java.sql.*;
    import Conexion.Conexion;
    import javax.swing.JOptionPane;
    import org.omg.CORBA.ORB;
public class Lector extends BibliotecaApp.lectorPOA{
      private ORB orb;
    Conexion conectar = new Conexion();
    @Override
    public boolean insertarLector(String nombre, int celular, String observacion) {
         boolean resultado = false;
        try {
            String sentenciaSql = "insert into lector (nombre,celular,observacion)"
                    + "values('"+ nombre + celular+ observacion+"')";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if(valor > 0){
                resultado = true;
            }
            //Se cierran los recursos
            st.close();
            conectar.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo lector " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarLector(int dnilector) {
         String lista = "";
        try{
            String sentenciSql = "SELECT * FROM lector WHERE dnilector = " + dnilector;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                 lista += rs.getLong(2) + " - "
                       + rs.getString(3)+ " - "
                       + rs.getString(4)+  "\n";

            }
            //Se cierran los recursos.
            rs.close();
            conectar.conex.close();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el catch: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarLector(int dnilector, String nombre, int celular, String observacion) {
        boolean resultado = false;
        try {
            String sentenciaSql ="UPDATE lector SET  nombre, celular,observacion = (nombre,celular,observacion)"
                    + "values('"+ nombre +"','"+ celular +observacion+"')WHERE dnilector = " + dnilector;;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if(valor > 0){
                resultado = true;
            }
            //Se cierran los recursos
            st.close();
            conectar.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo alquiler. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarLector(int dnilector) {
       boolean resultado = false;
        try {
            String sentenciaSql = "DELETE FROM lector WHERE dnilector = " + dnilector;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if(valor > 0){
                resultado = true;
            }
            //Se cierran los recursos
            st.close();
            conectar.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo lector. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarLector() {
        String lista = "";
        try{
            String sentenciSql = "Select * from lector ";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                 lista += rs.getLong(2) + " - "
                       + rs.getString(3)+ " - "
                       + rs.getString(4)+  "\n";
            }
            //Se cierran los recursos.
            rs.close();
            conectar.conex.close();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el catch: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public ResultSet cargarTablaLector() {
        ResultSet resultado = null;
        try {
            String query = "Select dnilector,nombre,celular, observacion from lector";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    
}
