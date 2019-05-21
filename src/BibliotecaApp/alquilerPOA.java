package BibliotecaApp;


/**
* BibliotecaApp/alquilerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from biblioteca.idl
* domingo 19 de mayo de 2019 12:28:32 AM COT
*/

public abstract class alquilerPOA extends org.omg.PortableServer.Servant
 implements BibliotecaApp.alquilerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarAlquiler", new java.lang.Integer (0));
    _methods.put ("consultarAlquiler", new java.lang.Integer (1));
    _methods.put ("actualizarAlquiler", new java.lang.Integer (2));
    _methods.put ("eliminarAlquiler", new java.lang.Integer (3));
    _methods.put ("listarAlquiler", new java.lang.Integer (4));
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
       case 0:  // BibliotecaApp/alquiler/insertarAlquiler
       {
         int id_lector = in.read_long ();
         int id_libro = in.read_long ();
         boolean $result = false;
         $result = this.insertarAlquiler (id_lector, id_libro);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // BibliotecaApp/alquiler/consultarAlquiler
       {
         int id_alquiler = in.read_long ();
         String $result = null;
         $result = this.consultarAlquiler (id_alquiler);
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 2:  // BibliotecaApp/alquiler/actualizarAlquiler
       {
         int id_alquiler = in.read_long ();
         int id_lector = in.read_long ();
         int id_libro = in.read_long ();
         boolean $result = false;
         $result = this.actualizarAlquiler (id_alquiler, id_lector, id_libro);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // BibliotecaApp/alquiler/eliminarAlquiler
       {
         int id_alquiler = in.read_long ();
         boolean $result = false;
         $result = this.eliminarAlquiler (id_alquiler);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // BibliotecaApp/alquiler/listarAlquiler
       {
         String $result = null;
         $result = this.listarAlquiler ();
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 5:  // BibliotecaApp/alquiler/shutdown
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
    "IDL:BibliotecaApp/alquiler:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public alquiler _this() 
  {
    return alquilerHelper.narrow(
    super._this_object());
  }

  public alquiler _this(org.omg.CORBA.ORB orb) 
  {
    return alquilerHelper.narrow(
    super._this_object(orb));
  }


} // class alquilerPOA
