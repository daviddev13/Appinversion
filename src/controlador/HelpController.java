package controlador;

import vistas.*;

public class HelpController {
    
    public static VistaHelp ventanaHelp = new VistaHelp();
    
    public static void mostrar()
    {
       ventanaHelp.setVisible(true);
    }
    public static void ocultar()
    {
       ventanaHelp.setVisible(false);
    }
}
