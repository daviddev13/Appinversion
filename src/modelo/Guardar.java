package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;


public class Guardar
{ 
   public static void guardarEnArchivo(String Datos, String UrlUser) 
   {            
      //Define variables fuera de bucles
      String nombreMes; 
      int numeroMesInt;
      
      // Eliminar etiquetas <html>
      String Datos1 = Datos.replaceAll("<html>", "");
      String ToSave = Datos1.replaceAll("<br>|</html>", "\n");
      
      System.out.println("Datos a guardar:"+ToSave);
      
      // Separar la cadena en líneas
      String[] lineas = ToSave.split("\n");
        
      //Obtener mes al iterar sobre líneas 
      numeroMesInt = KnowMes(lineas);
      
      // Ir a funcion con # y obtener nombre del mes
      nombreMes = obtenerNombreMes(numeroMesInt);
      
      // Ir a funcion y obtener ruta archivo
      Path urlarchivo = getUrl(nombreMes, UrlUser);
      
      try
      {
        // Ubicacion y nombre del nuevo archivo
        //File archivo = new File("urlarchivo");
        File archivo = urlarchivo.toFile();
          
        // Creacion del nuevo archivo.
        archivo.createNewFile();
       
        //Escribir en el archivo y guardarlo 
        try (FileWriter writer = new FileWriter(archivo)) 
        {
           // Write the contenido to the file.
           writer.write(ToSave);
        
           // Close the FileWriter object.
           writer.close();
           
           System.out.println("Guardado con exito");
           JOptionPane.showMessageDialog(null, "Contenido guardado en " + archivo.getAbsolutePath(), "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
      }
      catch (IOException e) 
      {
         JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
      }
   } 
   
   public static void guardarAnalisis(String TotalSave,String UrlUser)            
   { 
      //Define variables fuera de bucles
      String nombreMes; 
      int numeroMesInt;
      
      // Eliminar la etiqueta <html>
      //String cleanHtmlData = SaveDiferencia.replaceAll("<html>|</html>", "");

      // Separar la cadena en líneas
      String[] lines = TotalSave.split("<br>");
      
      //Obtener mes al iterar sobre líneas 
      numeroMesInt = KnowMes(lines);
      
      // Ir a funcion con # y obtener nombre del mes
      nombreMes = obtenerNombreMes(numeroMesInt);
      
      // Ir a funcion y obtener ruta archivo
      Path urlarchivo = getUrl(nombreMes, UrlUser);
      
      // Crear una cadena con las líneas ordenadas
      StringBuilder toGuardar2 = new StringBuilder();
      
      for (String line : lines) 
      {
         // Verificar si la línea contiene "Mes:" y omitirla si es el caso
         if (line.contains("Mes:")) {
            continue;
         }
         // Eliminar las etiquetas HTML y añadir a la cadena
         String cleanLine = line.replaceAll("<.*?>", "").trim();
       
         toGuardar2.append(cleanLine).append(System.getProperty("line.separator"));
      }
      
      try
      {
        File archivo = urlarchivo.toFile();
          
        //Escribir en el archivo y guardarlo 
        try (FileWriter writer = new FileWriter(archivo, true)) 
       {
           // Write the contenido to the file.
           writer.write(toGuardar2.toString());
           
            // salto de línea para separar datos antiguos de nuevos
           writer.write(System.getProperty("line.separator"));
        
           // Close the FileWriter object.
           writer.close();
           
           // Mensaje de éxito
          JOptionPane.showMessageDialog(null, "Contenido guardado en " + archivo.getAbsolutePath(), "Guardado Exitoso", JOptionPane.INFORMATION_MESSAGE);
       }
      }
      catch (IOException e) 
      {
         JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
      }
   }
   
   // Metodo para obtener url 
   static Path getUrl(String nombreMes, String UrlUser) 
   {  
      System.out.println(UrlUser);
       
      // Obtener la ruta absoluta del directorio actual
      Path directorioActual = Paths.get(UrlUser);
      
       // Obtener la ruta del archivo
      return directorioActual.resolve(nombreMes + ".txt");
      
   }
   
   //Metodo que almacena urlusuario en config.txt
    public static void saveUrl(String urlUsuario) 
    {
        try
        {
           // Obtener la ruta absoluta del directorio actual
           Path directorioActual = Paths.get(urlUsuario);
      
           // Obtener la ruta del archivo
           Path urlarchivo= directorioActual.resolve("config.txt");
        
           File archivo = urlarchivo.toFile();
          
           // Creacion del nuevo archivo.
           archivo.createNewFile();
       
           //Escribir en el archivo y guardarlo 
           try (FileWriter writer = new FileWriter(archivo))
           {
           // Write the contenido to the file.
           writer.write(urlUsuario);
        
           // Close the FileWriter object.
           writer.close();
           
           System.out.println("Guardado con exito");
           }
      }
      catch (IOException e) 
      {
         JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
      }
   }

   // Método para saber mes a partir de datos recibidos
   static int KnowMes(String[] lineas) 
   {  
      int numeroMesInt=0;
      //Obtener mes al iterar sobre líneas  
      for (String linea : lineas) 
      {
        //Encontrar linea con inicio "Mes:"
        if (linea.startsWith("Mes:")) 
        {
           // Extraer número de la linea Mes
           String numeroMes = linea.split(": ")[1].trim();

           // Convertir número a entero
           numeroMesInt =Integer.parseInt(numeroMes); 

           // Terminar busqueda una vez encuentra línea Mes
           break; 
        }
      }
      return numeroMesInt;
   }
   
   // Método para obtener el nombre del mes a partir del número
   static String obtenerNombreMes(int numeroMes) 
   {  
       String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
       // Asegurarse de que el número del mes esté dentro del rango válido
       if (numeroMes >= 1 && numeroMes <= 12) 
       {
          return nombresMeses[numeroMes - 1];
       }
       else 
       {
          return "Mes no válido";
       }
    }
}


