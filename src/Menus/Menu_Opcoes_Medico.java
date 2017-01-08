
package Menus;

import Classes.Usuario;
import Classes.Dieta;
import Classes.Minhas_Medidas;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Menu_Opcoes_Medico extends Menu {
    @Override
    public void Menu(Usuario u){
        while(!sair){
        op = Integer.parseInt(JOptionPane.showInputDialog(""
            + "01 - Avaliações\n"
            + "02 - Dietas\n"
            + "03 - Treino\n"
            + "04 - Menu Atleta\n"
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
