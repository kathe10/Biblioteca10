package BibliotecaApp;


/**
* BibliotecaApp/libroOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from biblioteca.idl
* domingo 19 de mayo de 2019 12:28:32 AM COT
*/

public interface libroOperations 
{
  boolean insertarLibro (String titulo, int autor, int categoria, int editorial, int paginas, String descripcion, String portada);
  String consultarLibro (int asin);
  boolean actualizarLibro (int asin, String titulo, int autor, int categoria, int editorial, int paginas, String descripcion, String portada);
  boolean eliminarLibro (int asin);
  String listarLibro ();
  void shutdown ();
} // interface libroOperations
