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
public class Libro extends BibliotecaApp.libroPOA{
    private ORB orb;
    Conexion conectar = new Conexion();
    @Override
    public boolean insertarLibro(String titulo, int autor, int categoria, int editorial, int paginas, String descripcion, String portada) {
       boolean resultado = false;
        try {
            String sentenciaSql = "insert into libro (titulo,autor,categoria,editorial,paginas,descripcion,portada)"
                    + "values('"+ titulo + autor+ categoria+ editorial + paginas+ descripcion+portada+"')";
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
    public String consultarLibro(int asin) {
          String lista = "";
        try{
            String sentenciSql = "SELECT * FROM libro WHERE asin = " + asin;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                 lista += rs.getLong(2) + " - "
                       + rs.getString(3)+ " - "
                       + rs.getString(4)+ " - "
                       + rs.getString(5)+ " - "
                       + rs.getString(6)+ " - "
                       + rs.getString(7)+ " - "
                       + rs.getString(8)+  "\n";

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
    public boolean actualizarLibro(int asin, String titulo, int autor, int categoria, int editorial, int paginas, String descripcion, String portada) {
        boolean resultado = false;
        try {
            String sentenciaSql ="UPDATE libro SET  titulo, autor,categoria,editorial,paginas,descripcion,portada = (titulo,autor,categoria,editorial,paginas,descripcion,portada)"
                    + "values('"+ titulo+"','"+ autor +categoria+ editorial+"','"+ paginas +descripcion+portada+"')WHERE dnilector = " + asin;
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo libro. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarLibro(int asin) {
         boolean resultado = false;
        try {
            String sentenciaSql = "DELETE FROM libro WHERE  = " + asin;
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar un nuevo libro. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarLibro() {
        String lista = "";
        try{
            String sentenciSql = "Select * from libro ";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                 lista += rs.getLong(2) + " - "
                       + rs.getString(3)+ " - "
                       + rs.getString(4)+ " - "
                       + rs.getString(5)+ " - "
                       + rs.getString(6)+ " - "
                       + rs.getString(7)+ " - "
                       + rs.getString(8)+  "\n";
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
    public ResultSet cargarTablaLibro() {
        ResultSet resultado = null;
        try {
            String query = "Select asin,titulo,autor,categoria,editorial, paginas, descripcion, portada from libro";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
}
