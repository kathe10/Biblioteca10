package BibliotecaApp;

/**
* BibliotecaApp/libroHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from biblioteca.idl
* domingo 19 de mayo de 2019 12:28:32 AM COT
*/

public final class libroHolder implements org.omg.CORBA.portable.Streamable
{
  public BibliotecaApp.libro value = null;

  public libroHolder ()
  {
  }

  public libroHolder (BibliotecaApp.libro initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BibliotecaApp.libroHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BibliotecaApp.libroHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BibliotecaApp.libroHelper.type ();
  }

}