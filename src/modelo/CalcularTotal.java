
package modelo;



public class CalcularTotal {
     //metodo que devuelve array de enteros
     public int[] calcular( String textoInversion1 , String textoInversion2 , String textoInversion3, 
                          String textGananciaInv1, String textGananciaInv2, String textGananciaInv3,
                          String textValorPersona1) 
     {
         // Obtener textos de cada campo
         int numInv1 = Integer.parseInt(textoInversion1);
         int numInv2 = Integer.parseInt(textoInversion2);
         int numInv3 = Integer.parseInt(textoInversion3);
         int numGanInv1 = Integer.parseInt(textGananciaInv1);
         int numGanInv2 = Integer.parseInt(textGananciaInv2);
         int numGanInv3 = Integer.parseInt(textGananciaInv3);
         int numValorPer1 = Integer.parseInt(textValorPersona1);

         // Calculo Total Invertido
         int totalAc = numInv1 + numInv2 + numInv3;
         // Calculo Total Ganancias
         int totalAcGan = numGanInv1 + numGanInv2 + numGanInv3;
         // Calculo Porcentaje
         int PorcenPersona1 = (numValorPer1*100)/totalAc;
         // Calculo Total Ganncia
         int GanPersona1 = (PorcenPersona1*totalAcGan)/100;
         
         System.out.println("Resultado: " + totalAcGan);

         //return totalAc, totalAcGan;
         return new int[]{totalAc, totalAcGan, PorcenPersona1, GanPersona1};
    } 
    
}