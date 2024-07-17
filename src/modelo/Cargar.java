package modelo;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Cargar 
{  
  public static String[] cargarArchivo(String textoMes, String referencia, String UrlUser)
  {
      System.out.println(referencia);
      
      // variables fuera de bucles
      String nombreMes;
        
      if (referencia.equals("Mes Actual"))
      {
        // Convertir número a entero
        //int numeroMes = Integer.parseInt(textoMes);
        // Ir a funcion con # y obtener nombre del mes
        //nombreMes = Guardar.obtenerNombreMes(numeroMes);
        // ubicacion del archivo
        String url = UrlUser;    
        // Ir a funcion con ubicacion y obtener archivo        
         return Cargar.GetArchivo(url);
      }
      else
      {
        // Convertir número a entero
        int numeroMes = Integer.parseInt(textoMes)-1;
        // Ir a funcion con # y obtener nombre del mes
        nombreMes = Guardar.obtenerNombreMes(numeroMes);
        // ubicacion del archivo
        String url = UrlUser +"/"+ nombreMes + ".txt";    
        // Ir a funcion con ubicacion y obtener archivo        
        return Cargar.GetArchivo(url);
      }     
  }
  
   static String[] GetArchivo(String url) 
   {  
      List<String> lineas = new ArrayList<>(); 
      try (BufferedReader reader = new BufferedReader(new FileReader(url)))          
      {
         String linea;
         while ((linea = reader.readLine()) != null) 
         {
           lineas.add(linea);
         }
      } 
      catch (IOException e) 
      {
        JOptionPane.showMessageDialog(null, "Error al get archivo", "Error", JOptionPane.ERROR_MESSAGE);
      }
      //Create array of strings = size as the lineas collection
      String[] arrayResult = new String[lineas.size()];
      //toArray() copy elements of lineas and assign result to arrayResult
      lineas.toArray(arrayResult);
      /*for (String linea : lineas) 
      {
        System.out.println(linea); 
      } */

      //se aumenta Devolver la lista de líneas
      return arrayResult;
   }
}
