
package Menus;

import Aplicações.Conexao_Banco;
import Avaliacao.Avaliacoes;
import Classes.Usuario;
import Classes.Dieta;
import Classes.Minhas_Medidas;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Menu_Opcoes_Medico implements Menu {
    static Connection con = Conexao_Banco.getConnection(); 
    //atributos
    private int op;
    private boolean sair;
    private final String status="";
    private String q;
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
                    Avaliacoes av = new Avaliacoes();
                    ArrayList aval = new ArrayList(av.Verifica_Avaliacoes_Medico(u));
                    JOptionPane.showMessageDialog(null, aval.toArray());
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4: 
                    if (u.getIdusuario() != 0 ){
                        Menu menu_Atleta = new Menu_Opcoes_Atleta();
                        menu_Atleta.Menu(u);
                    }
                    break;
                case 5:
                    sair = true;
                    break;    
            }
        }
    }
    
}
