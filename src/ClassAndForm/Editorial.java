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

public class Editorial extends BibliotecaApp.editorialPOA {
    
    private ORB orb;
    Conexion conectar = new Conexion();
    
    
    @Override
    public boolean insertarEditorial(String ed_editorial) {
         boolean resultado = false;
        try {
            String sentenciaSql = "insert into editorial (id_editorial)"
                    + "values('"+ ed_editorial +"')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva editorial " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarEditorial(int id_editorial) {
        String lista = "";
        try{
            String sentenciSql = "SELECT * FROM editorial WHERE id_editorial = " + id_editorial;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                lista += rs.getLong(2) +  "\n";
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
    public boolean actualizarEditorial(int id_editorial, String ed_editorial) {
        boolean resultado = false;
        try {
            String sentenciaSql ="UPDATE editorial SET  ed_editorial = (ed_editorial)"
                    + "values('"+ ed_editorial+"')WHERE idcargo = " + id_editorial;;
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva editorial. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarEditorial(int id_editorial) {
        boolean resultado = false;
        try {
            String sentenciaSql = "DELETE FROM categoria WHERE id_editorial = " + id_editorial;
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva editorial. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarEditorial() {
         String lista = "";
        try{
            String sentenciSql = "Select * from editorial ";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                lista += rs.getLong(2) +   "\n";
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
    public ResultSet cargarTablaEditorial() {
        ResultSet resultado = null;
        try {
            String query = "Select id_editorial,ed_editorial from editorial";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
}
