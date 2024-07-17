package modelo;

public class Analisis {
    
   static String[] diferencia(String[] MesAc, String[] MesAn) 
   {  
      //Extraer mes actual para guardad
      String TextMesAc =MesAc[0];
      //System.out.println(TextMesAc);
      
      // Extraer números de Mes Anterior
      String texEfecAn = MesAn[2].split(": ")[1].trim();
      String texCaAn = MesAn[3].split(": ")[1].trim();
      String texPresAn = MesAn[4].split(": ")[1].trim();
      
      // Pasar numeros a enteros 
      int NumEfecAn = Integer.parseInt(texEfecAn);
      int NumCaAn = Integer.parseInt(texCaAn);
      int NumPresAn = Integer.parseInt(texPresAn);
       
      int NumEfecAc = Integer.parseInt(MesAc[1]);
      int NumCaAc = Integer.parseInt(MesAc[2]);
      int NumPresAc = Integer.parseInt(MesAc[3]);
       
      // Calculo diferencia
      int DifEfec= NumEfecAc-NumEfecAn;
      int DifCa= NumCaAc-NumCaAn;
      int DifPres= NumPresAc-NumPresAn;
      int DifTotal = (NumEfecAc + NumCaAc + NumPresAc)- 
                     (NumEfecAn + NumCaAn + NumPresAn);
      
      // Strings para indicar si es ingreso o retiro
      String tipoDifEfec;
      String tipoDifCa;
      String tipoDifPres;
      String tipoDifTotal;

      // Determinar si es ingreso o retiro para cada diferencia
if (DifEfec > 0) {
    tipoDifEfec = "Ingreso";
} else if (DifEfec < 0) {
    tipoDifEfec = "Retiro";
} else {
    tipoDifEfec = "No Ingreso/Retiro";
}

if (DifCa > 0) {
    tipoDifCa = "Ingreso";
} else if (DifCa < 0) {
    tipoDifCa = "Retiro";
} else {
    tipoDifCa = "No Ingreso/Retiro";
}

if (DifPres > 0) {
    tipoDifPres = "Ingreso";
} else if (DifPres < 0) {
    tipoDifPres = "Retiro";
} else {
    tipoDifPres = "No Ingreso/Retiro";
}

if (DifTotal > 0) {
    tipoDifTotal = "Ingreso";
} else if (DifTotal < 0) {
    tipoDifTotal = "Retiro";
} else {
    tipoDifTotal = "No Ingreso/Retiro";
}

      // Convertir enteros a cadenas
      String strDifEfec = (tipoDifEfec + "Efectivo: ");
      String strDifCa = String.valueOf(tipoDifCa+"CuentaAhorro: ");
      String strDifPres = String.valueOf(tipoDifPres+"Prestamo: ");
      String strDifTotal = String.valueOf("Diferencia_Total: "+DifTotal);
      
      String valDifEfec = String.valueOf(DifEfec);
      String valDifCa = String.valueOf(DifCa);
      String valDifPres = String.valueOf(DifPres);
      
      // Crear arreglo de cadenas
      String[] Diferencias = {strDifEfec, 
                              strDifCa,
                              strDifPres,
                              strDifTotal,
                              valDifEfec,
                              valDifCa,
                              valDifPres,
                              TextMesAc
                             };
      
      return Diferencias;
    }
}