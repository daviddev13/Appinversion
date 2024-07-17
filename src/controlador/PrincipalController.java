package controlador;

import java.util.Arrays;
import modelo.CalcularTotal;
import modelo.Cargar;
import vistas.*;

public class PrincipalController {
    
    //Datos que se piden  a usuario
    private static String Mes = "";
    private static String Inversion1 = "";
    private static String Inversion2 = "";
    private static String Inversion3 = "";
    private static String LugarInverison1 = "";
    private static String LugarInverison2 = "";
    private static String LugarInverison3 = "";
    private static String GananciaInv1 = "";
    private static String GananciaInv2 = "";
    private static String GananciaInv3 = "";
    
    private static String Persona1 = "";
    private static String ValorPersona1 = "";
    
    private static String UrlUser = "";
            
    public static VistaPrincipal ventanaPrincipal = new VistaPrincipal();
    public static VistaLoad ventanaLoad = new VistaLoad();
    
    public static void mostrar()
    {
       ventanaPrincipal.setVisible(true);
    }
    public static void ocultar()
    {
       ventanaPrincipal.setVisible(false);
    }
    public static void getDatosWindow()
    {
        Mes = ventanaPrincipal.getjTextField1().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField1().getText();;
        System.out.println("Mes en getDatosWindow: " + Mes);       
        Inversion1 =  ventanaPrincipal.getjTextField2().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField2().getText();
        Inversion2 =  ventanaPrincipal.getjTextField3().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField3().getText();
        Inversion3 =  ventanaPrincipal.getjTextField4().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField4().getText();
        Persona1 = ventanaPrincipal.getjTextField5().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField5().getText();
        GananciaInv1 = ventanaPrincipal.getjTextField6().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField6().getText();
        GananciaInv2 =  ventanaPrincipal.getjTextField7().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField7().getText();
        GananciaInv3 = ventanaPrincipal.getjTextField8().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField8().getText();
        ValorPersona1 = ventanaPrincipal.getjTextField10().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField10().getText();
        LugarInverison1 =  (String) ventanaPrincipal.getjComboBox1().getSelectedItem();
        LugarInverison2 =  (String)ventanaPrincipal.getjComboBox2().getSelectedItem();
        LugarInverison3 = (String) ventanaPrincipal.getjComboBox3().getSelectedItem(); 
        
    }
    public static void eventoBotonConfirmarDatos()
    {
       System.out.println("Clicked Confirmar Datos"); 
       getDatosWindow();
       SaveController.mostrarConfirm();
       //Ir a funcion calcular total actual
       CalcularTotal calculadora = new CalcularTotal();        
       int[] TotalAc = calculadora.calcular(Inversion1 , 
                                          Inversion2 , 
                                          Inversion3, 
                                          GananciaInv1, 
                                          GananciaInv2, 
                                          GananciaInv3,
                                          ValorPersona1);
       // Total Actual a string
       String strTotalAc = String.valueOf(TotalAc[0]);
       String strTotalGan = String.valueOf(TotalAc[1]);
       String strPorcenPer1 = String.valueOf(TotalAc[2]);
       String strGanPer1 = String.valueOf(TotalAc[3]);
       //System.out.println("Resultado: " + Arrays.toString(TotalAc));
       System.out.println("Resultado2: " + TotalAc[1]);
       
       String Datos = (
                        "<html>"
                          + "Mes: " + Mes 
                          + "<br>Total Invertido: " + strTotalAc
                          + "<br>Total Ganancia: " + strTotalGan
                          + "<br>Inversion "  + Persona1 + ": " + ValorPersona1 
                          + "<br>Porcentaje " + Persona1 + ": " + strPorcenPer1 
                          + "<br>Ganancia " + Persona1 + ": " + strGanPer1 
                    +"<br>"
                          + "<br>Inversion1: " + Inversion1 
                          + "<br>Lugar1: "+ LugarInverison1 
                          + "<br>Ganancia1: " + GananciaInv1 
                    +"<br>"
                          + "<br>Inversion2: " + Inversion2 
                          + "<br>Lugar2: "+ LugarInverison2 
                          + "<br>Ganancia2: " + GananciaInv2 
                    +"<br>"
                          + "<br>Inversion3: " + Inversion3 
                          + "<br>Lugar3: "+ LugarInverison3
                          + "<br>Ganancia3: " + GananciaInv3 +
                          
                        "</html>"
                      );

       //Envio datos a controlador de ventana save
       SaveController.setDatos(Datos);
    }
    public static void BottonLoadSave()
    {
        System.out.println("Load Save clicked!");
        getDataWindowSave();
        System.out.println("2:"+Mes+UrlUser);
        
        String[] Carga;            
        //getDatosWindow();
        String textoMesAct = Mes;
        String referencia = "Mes Actual";
       
        // método para cargar contenido anterior de archivo
        Carga = Cargar.cargarArchivo(textoMesAct,referencia,UrlUser);
     
        // Extraer número de la linea 
        String numMes = Carga[0].split(": ")[1].trim();
        String VI1 = Carga[7].split(": ")[1].trim();
        String VI2 = Carga[11].split(": ")[1].trim();
        String VI3 = Carga[15].split(": ")[1].trim();
        String GI1 = Carga[9].split(": ")[1].trim();
        String GI2 = Carga[13].split(": ")[1].trim();
        String GI3 = Carga[17].split(": ")[1].trim();
        String VIotro1 = Carga[3].split(": ")[1].trim();
        
        String selectedItem0 = Carga[8].split(": ")[1].trim();
        String selectedItem1 = Carga[12].split(": ")[1].trim();
        String selectedItem2 = Carga[16].split(": ")[1].trim();

           
        // Asignar el valor al campoEfectivo
        ventanaPrincipal.setjTextField1(numMes);
        ventanaPrincipal.setjTextField2(VI1);
        ventanaPrincipal.setjTextField3(VI2);
        ventanaPrincipal.setjTextField4(VI3);
        ventanaPrincipal.setjTextField6(GI1);   
        ventanaPrincipal.setjTextField7(GI2);  
        ventanaPrincipal.setjTextField8(GI3); 
        ventanaPrincipal.setjTextField10(VIotro1);
        
        ventanaPrincipal.setComboBox1(selectedItem0); 
        ventanaPrincipal.setComboBox2(selectedItem1); 
        ventanaPrincipal.setComboBox3(selectedItem2);
        
        ocultarLoadSave();
    }

    static String SendMes() 
    {
       String Datos2 = ventanaPrincipal.getjTextField1().getText();     
       //System.out.println("field1 es:"+Datos2);
       return Datos2;
    }
    
    public static void mostrarLoadSave()
    {
       ventanaLoad.setVisible(true);
    }
    public static void ocultarLoadSave()
    {
       ventanaLoad.setVisible(false);
    }
    public static void getDataWindowSave()
    {
       //Mes = ventanaLoad.getjTextField1().getText();
       UrlUser = ventanaLoad.getjTextField2().getText();
       System.out.println(UrlUser);
    }
}
