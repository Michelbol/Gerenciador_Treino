
package Avaliacao;

import Aplicações.Conexao_Banco;
import Exames.Exames;
import Classes.Usuario;
import Menus.Menu;
import Menus.Menu_Opcoes_Atleta;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Avaliacao_Menu implements Menu { 
    static Connection con = Conexao_Banco.getConnection(); 
    //atributos
    private int op;
    private boolean sair;
    private String status="";
    private String q;   
    
    @Override
    public void Menu(Usuario u){
        while(!sair){
            op = Integer.parseInt(JOptionPane.showInputDialog(""
                + "01 - Marcar Avaliação\n"
                + "02 - Minhas Avaliações\n"
                + "03 - Voltar Menu"));
            switch(op){
                case 01:
                    Avaliacoes avaliacoes = new Avaliacoes();
                    avaliacoes.Marcar_Avalicao(u);
                    break;
                case 02:
                    Exames ex = new Exames();
                    ex.Consulta_Exame(u);
                    break;
                case 03:
                    sair = true;
                    break;
            }
        }
    }    
}
