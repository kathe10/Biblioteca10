package BibliotecaApp;


/**
* BibliotecaApp/lectorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from biblioteca.idl
* domingo 19 de mayo de 2019 12:28:32 AM COT
*/

public interface lectorOperations 
{
  boolean insertarLector (String nombre, int celular, String observacion);
  String consultarLector (int dnilector);
  boolean actualizarLector (int dnilector, String nombre, int celular, String observacion);
  boolean eliminarLector (int dnilector);
  String listarLector ();
  void shutdown ();
} // interface lectorOperations