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

/**
 *
 * @author Kathe
 */
public class Autor extends BibliotecaApp.autorPOA {
    private ORB orb;
    Conexion conectar = new Conexion();
    
    
    @Override
    public boolean insertarAutor(String au_autor) {
       boolean resultado = false;
        try {
            String sentenciaSql = "insert into autor (au_autor)"
                    + "values('"+ au_autor +"')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo autor " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarAutor(int au_idautor) {
         String lista = "";
        try{
            String sentenciSql = "SELECT * FROM autor WHERE au_autor = " + au_idautor;
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
    public boolean actualizarAutor(int au_idautor, String au_autor) {
        boolean resultado = false;
        try {
            String sentenciaSql ="UPDATE autor SET  au_autor = (au_autor)"
                    + "values('"+ au_autor+"')WHERE idcargo = " + au_idautor;;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if(valor > 0){
                resultado = true;
            }
            //Se cierran los recursos
            st.close();
            conectar.conex.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo autor. " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarAutor(int au_idautor) {
       boolean resultado = false;
        try {
            String sentenciaSql = "DELETE FROM autor WHERE au_idautor = " + au_idautor;
            
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if(valor > 0){
                resultado = true;
                cargarTablaAutor();
            }
            //Se cierran los recursos
            st.close();
            conectar.conex.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo autor. " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarAutor() {
        String lista = "";
        try{
            String sentenciSql = "Select * from autor ";
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
    public ResultSet cargarTablaAutor() {
        ResultSet resultado = null;
        try {
            String query = "Select au_idautor,au_autor from autor";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
}
