
package Avaliacao;

import Exames.Exames;
import Classes.Usuario;
import Menus.Menu;
import Menus.Menu_Opcoes_Atleta;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Avaliacao_Menu extends Menu { 
   //Obejtos 
    Avaliacoes avaliacoes;
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
                    avaliacoes = new Avaliacoes();
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
