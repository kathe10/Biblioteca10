package BibliotecaApp;


/**
* BibliotecaApp/libroPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from biblioteca.idl
* domingo 19 de mayo de 2019 12:28:32 AM COT
*/

public abstract class libroPOA extends org.omg.PortableServer.Servant
 implements BibliotecaApp.libroOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarLibro", new java.lang.Integer (0));
    _methods.put ("consultarLibro", new java.lang.Integer (1));
    _methods.put ("actualizarLibro", new java.lang.Integer (2));
    _methods.put ("eliminarLibro", new java.lang.Integer (3));
    _methods.put ("listarLibro", new java.lang.Integer (4));
    _methods.put ("shutdown", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // BibliotecaApp/libro/insertarLibro
       {
         String titulo = in.read_wstring ();
         int autor = in.read_long ();
         int categoria = in.read_long ();
         int editorial = in.read_long ();
         int paginas = in.read_long ();
         String descripcion = in.read_wstring ();
         String portada = in.read_wstring ();
         boolean $result = false;
         $result = this.insertarLibro (titulo, autor, categoria, editorial, paginas, descripcion, portada);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // BibliotecaApp/libro/consultarLibro
       {
         int asin = in.read_long ();
         String $result = null;
         $result = this.consultarLibro (asin);
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 2:  // BibliotecaApp/libro/actualizarLibro
       {
         int asin = in.read_long ();
         String titulo = in.read_wstring ();
         int autor = in.read_long ();
         int categoria = in.read_long ();
         int editorial = in.read_long ();
         int paginas = in.read_long ();
         String descripcion = in.read_wstring ();
         String portada = in.read_wstring ();
         boolean $result = false;
         $result = this.actualizarLibro (asin, titulo, autor, categoria, editorial, paginas, descripcion, portada);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // BibliotecaApp/libro/eliminarLibro
       {
         int asin = in.read_long ();
         boolean $result = false;
         $result = this.eliminarLibro (asin);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // BibliotecaApp/libro/listarLibro
       {
         String $result = null;
         $result = this.listarLibro ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 5:  // BibliotecaApp/libro/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:BibliotecaApp/libro:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public libro _this() 
  {
    return libroHelper.narrow(
    super._this_object());
  }

  public libro _this(org.omg.CORBA.ORB orb) 
  {
    return libroHelper.narrow(
    super._this_object(orb));
  }


} // class libroPOA
