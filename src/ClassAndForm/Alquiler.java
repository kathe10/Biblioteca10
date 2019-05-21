
package ClassAndForm;

/**
 *
 * @author Kathe
 */

    import java.sql.*;
    import Conexion.Conexion;
    import javax.swing.JOptionPane;
    import org.omg.CORBA.ORB;

public class Alquiler extends BibliotecaApp.alquilerPOA {
    private ORB orb;
    Conexion conectar = new Conexion();
    
    @Override
    public boolean insertarAlquiler(int id_lector, int id_libro) {
          boolean resultado = false;
        try {
            String sentenciaSql = "insert into alquiler (id_lector, id_libro)"
                    + "values('"+ id_lector +"','"+ id_libro +"')";
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
    public String consultarAlquiler(int id_alquiler) {
        String lista = "";
        try{
            String sentenciSql = "SELECT * FROM alquiler WHERE id_alquiler = " + id_alquiler;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                lista += rs.getLong(2) + " - " 
                        + rs.getString(3)+  "\n";
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
    public boolean actualizarAlquiler(int id_alquiler, int id_lector, int id_libro) {
         boolean resultado = false;
        try {
            String sentenciaSql ="UPDATE alquiler SET id_lector, id_libro = (id_lector, id_libro)"
                    + "values('"+ id_lector +"','"+ id_libro +"')WHERE idcargo = " + id_libro;;
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
    public boolean eliminarAlquiler(int id_alquiler) {
         boolean resultado = false;
        try {
            String sentenciaSql = "DELETE FROM alquiler WHERE idcargo = " + id_alquiler;
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
    public String listarAlquiler() {
        String lista = "";
        try{
            String sentenciSql = "Select * from alquiler ";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                lista += rs.getLong(2) + " - " 
                        + rs.getString(3)+  "\n";
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
    
    public ResultSet cargarTablaAlquiler() {
        ResultSet resultado = null;
        try {
            String query = "Select id_alquiler,id_lector,id_libro from alquiler";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
}
