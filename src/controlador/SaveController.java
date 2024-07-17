package controlador;

import vistas.*;

import modelo.Guardar;

public class SaveController {
    private static String UrlUser;
    public static VistaConfirm ventanaConfirm = new VistaConfirm();
    public static VistaSave ventanaSave = new VistaSave();
    public static void mostrarConfirm()
    {
        ventanaConfirm.setVisible(true);
    }
    public static void ocultarConfirm()
    {
        ventanaSave.setVisible(false);
    }
    public static void mostrar()
    {
        ventanaSave.setVisible(true);
    }
    public static void ocultar()
    {
        ventanaSave.setVisible(false);
    }
    //Fijar Datos en jlabel2 de la VistaSave
    public static void setDatos(String Datos)
    {
       ventanaConfirm.setjLabel2Text(Datos);
    }
   
    public static void getDatosWindowSave()
    {
       UrlUser = ventanaSave.getjTextField1().getText();
       System.out.println("Urluser:"+UrlUser);
    } 
    public static void eventButtonSaveNew()
    {
       //System.out.println("Clicked Save1");
       System.out.println("Saving Data");  
       getDatosWindowSave();
       //Guardar.saveUrl(UrlUser);
       //SaveDatos();
       String Datos = ventanaConfirm.getjLabel2().getText();     
       //System.out.println(Datos);
       // Llamar a un método para guardar el contenido en un archivo
       Guardar.guardarEnArchivo(Datos,UrlUser);
       ocultar();  
       ocultarConfirm();
    }
}
 