
package Dieta;

import Classes.Usuario;
import Menus.Menu;
import javax.swing.JOptionPane;


public class Dieta_Cadastro implements Menu {
    private int op;
    private boolean sair;

    @Override
    public void Menu(Usuario u) {
    while(!sair){
        op = Integer.parseInt(JOptionPane.showInputDialog(""
            + "01 - Incluir Dieta\n"
            + "02 - Alterar Dieta\n"
            + "03 - Conultar Dieta\n"
            + "04 - \n"
            + "05 - Sair do Sistema\n"));
            switch(op){
                case 1:
                                     
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4: 
                    
                    break;
                case 5:
                    sair = true;
                    break;    
            }
        }    
    }
    
}
