
package Menus;

import Classes.Usuario;
import Classes.Dieta;
import Classes.Minhas_Medidas;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Menu_Opcoes_Administrador_Academia implements Menu { 
    //atributos
    private int op;
    private boolean sair;
    private final String status="";
    private String q;
    
    @Override
    public void Menu(Usuario u){
        while(!sair){
        op = Integer.parseInt(JOptionPane.showInputDialog(""
            + "01 - Menu Atleta\n"
            + "02 - \n"
            + "03 - \n"
            + "04 - \n"
            + "05 - \n"
            + "06 - \n"));
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
                    
                    break;
                case 6:
               
                    break;    
            }
        }
    
    }
}
