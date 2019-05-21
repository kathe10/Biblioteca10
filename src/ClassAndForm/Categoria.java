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

public class Categoria extends BibliotecaApp.categoriaPOA {
    private ORB orb;
    Conexion conectar = new Conexion();
    
    @Override
    public boolean insertarCategoria(String ca_categoria) {
        boolean resultado = false;
        try {
            String sentenciaSql = "insert into categoria (ca_categoria)"
                    + "values('"+ ca_categoria +"')";
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva categoria " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarCategoria(int id_categoria) {
        String lista = "";
        try{
            String sentenciSql = "SELECT * FROM categoria WHERE id_categoria = " + id_categoria;
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
    public boolean actualizarCategoria(int id_categoria, String ca_categoria) {
        boolean resultado = false;
        try {
            String sentenciaSql ="UPDATE categoria SET  ca_categoria = (ca_categoria)"
                    + "values('"+ ca_categoria+"')WHERE idcargo = " + id_categoria;;
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva categoria. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarcategoria(int id_categoria) {
        boolean resultado = false;
        try {
            String sentenciaSql = "DELETE FROM categoria WHERE id_categoria = " + id_categoria;
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva categoria. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarCategoria() {
       String lista = "";
        try{
            String sentenciSql = "Select * from categoria ";
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
     public ResultSet cargarTablaCategoria() {
        ResultSet resultado = null;
        try {
            String query = "Select id_categoria,ca_categoria from categoria";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
}
