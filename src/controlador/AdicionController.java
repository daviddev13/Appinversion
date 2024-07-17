package controlador;

import static controlador.AnalisisController.ventanaAnalisis;
import vistas.*;
import modelo.Guardar;

public class AdicionController {
    private static String UrlUser;
    
    private static String tipoMovEfectivo;
    private static String tipoMovCA;
    private static String tipoMovPrestamo;
    private static String Diferencia;
    
    public static VistaAdicion ventanaAdd = new VistaAdicion();
    
    public static VistaObservaciones ventanaObs = new VistaObservaciones();
    public static void mostrar()
    {
       ventanaObs.setVisible(true);
    }
    public static void ocultar()
    {
       ventanaObs.setVisible(false);
    }
    public static void getDataWindowObs()
    {
       tipoMovEfectivo = ventanaObs.getjComboBox2().getSelectedItem().toString();
       tipoMovCA = ventanaObs.getjComboBox4().getSelectedItem().toString();
       tipoMovPrestamo = ventanaObs.getjComboBox6().getSelectedItem().toString();
       //System.out.println("el tipo de movi efectivo:"+tipoMovEfectivo);
    }
    public static void getDatosWindowAnalisis()
    {
       Diferencia = ventanaAnalisis.getjLabel3().getText();
       //System.out.println(Diferencia);
    } 
    
    public static void mostrarAdd()
    {
        ventanaAdd.setVisible(true);
    }
     public static void ocultarAdd()
    {
        ventanaAdd.setVisible(false);
    }
    public static void getDataWindowAdd()
    {
       UrlUser = ventanaAdd.getjTextField1().getText();
       //System.out.println("Urluser:"+UrlUser);
    }
    
    public static void SaveAdd()
    {
       System.out.println("Save observaciones clicked!");
       getDataWindowAdd();
       System.out.println("Urluser:"+UrlUser);
       if(UrlUser == "")
       {
         System.out.println("Error");
       }
       else
       {
          getDataWindowObs();
          getDatosWindowAnalisis();
          //Ordenar datos a guardar
          String TotalSave = Diferencia + "<br>"+"MovimientoEfectivo: " + tipoMovEfectivo 
                       + "<br>"+ "MovimientoCuentaAhorro: " + tipoMovCA 
                       + "<br>"+ "MovimientoPrestamo: " + tipoMovPrestamo;
          System.out.println(TotalSave);
          // Llamar a un método para guardar el contenido en un archivo
          Guardar.guardarAnalisis(TotalSave,UrlUser);  
          ocultarAdd();
       }
    }
}
