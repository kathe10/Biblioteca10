package BibliotecaApp;


/**
* BibliotecaApp/editorialOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from biblioteca.idl
* domingo 19 de mayo de 2019 12:28:32 AM COT
*/

public interface editorialOperations 
{
  boolean insertarEditorial (String ed_editorial);
  String consultarEditorial (int id_editorial);
  boolean actualizarEditorial (int id_editorial, String ed_editorial);
  boolean eliminarEditorial (int id_editorial);
  String listarEditorial ();
  void shutdown ();
} // interface editorialOperations
