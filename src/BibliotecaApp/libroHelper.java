package BibliotecaApp;


/**
* BibliotecaApp/libroHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from biblioteca.idl
* domingo 19 de mayo de 2019 12:28:32 AM COT
*/

abstract public class libroHelper
{
  private static String  _id = "IDL:BibliotecaApp/libro:1.0";

  public static void insert (org.omg.CORBA.Any a, BibliotecaApp.libro that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static BibliotecaApp.libro extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (BibliotecaApp.libroHelper.id (), "libro");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static BibliotecaApp.libro read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_libroStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, BibliotecaApp.libro value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static BibliotecaApp.libro narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof BibliotecaApp.libro)
      return (BibliotecaApp.libro)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      BibliotecaApp._libroStub stub = new BibliotecaApp._libroStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static BibliotecaApp.libro unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof BibliotecaApp.libro)
      return (BibliotecaApp.libro)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      BibliotecaApp._libroStub stub = new BibliotecaApp._libroStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}