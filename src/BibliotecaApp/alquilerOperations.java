package BibliotecaApp;


/**
* BibliotecaApp/alquilerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from biblioteca.idl
* domingo 19 de mayo de 2019 12:28:32 AM COT
*/

public interface alquilerOperations 
{
  boolean insertarAlquiler (int id_lector, int id_libro);
  String consultarAlquiler (int id_alquiler);
  boolean actualizarAlquiler (int id_alquiler, int id_lector, int id_libro);
  boolean eliminarAlquiler (int id_alquiler);
  String listarAlquiler ();
  void shutdown ();
} // interface alquilerOperations
