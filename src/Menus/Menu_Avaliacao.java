
package Menus;

import Classes.Marcar_Avaliacoes;
import Classes.Exames;
import Classes.Usuario;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Menu_Avaliacao extends Menu { 
   //Obejtos 
    Marcar_Avaliacoes avaliacoes;
    Menu_Opcoes_Atleta menu;
    Exames ex;
    
    @Override
    public void Menu(Usuario u){
        while(!sair){
            op = Integer.parseInt(JOptionPane.showInputDialog(""
                + "01 - Marcar Avaliação\n"
                + "02 - Minhas Avaliações\n"
                + "03 - Voltar Menu"));
            switch(op){
                case 01:
                    avaliacoes = new Marcar_Avaliacoes();
                    avaliacoes.Marcar_Avalicao(u);
                    break;
                case 02:
                    ex = new Exames();
                    ArrayList consulta_exame = new ArrayList(ex.Consulta_Exame(u));
                    JOptionPane.showMessageDialog(null, consulta_exame.toArray());
                    break;
                case 03:
                    sair = true;
                    break;
            }
        }
    }    
}
