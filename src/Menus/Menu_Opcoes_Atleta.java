
package Menus;

import Aplicações.Conexao_Banco;
import Avaliacao.Avaliacao_Menu;
import Classes.Aula_Diaria;
import Classes.Exercicio_Dia;
import Classes.Usuario;
import Classes.Dieta;
import Classes.Minhas_Medidas;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Menu_Opcoes_Atleta implements Menu {   
static Connection con = Conexao_Banco.getConnection(); 
    //atributos
    private int op;
    private boolean sair;
    private final String status="";
    private String q;
//Cadastros
    @Override
    public void Menu(Usuario u){
        while(!sair){            
                op = Integer.parseInt(JOptionPane.showInputDialog(""
                + "01 - Exercicios De Hoje\n"
                + "02 - Sua dieta\n"
                + "03 - Avaliação\n"
                + "04 - Aula Diarias\n"
                + "05 - Minhas Medidas\n"
                + "06 - Sair do Sistema\n"));            
            switch(op){
                case 1:
                    Exercicio_Dia ed = new Exercicio_Dia();
                    ed.exerc_diario_atleta(u);
                    break;
                case 2:
                    Dieta dieta = new Dieta();
                    dieta.dieta(u);
                    break;
                case 3:
                    Avaliacao_Menu aval = new Avaliacao_Menu();
                    aval.Menu(u);
                    break;
                case 4: 
                    Aula_Diaria ad = new Aula_Diaria();
                    ad.Aulas_Dia();                    
                    break;
                case 5:
                    Minhas_Medidas mm = new Minhas_Medidas();
                    mm.Consuta_Medidas(u);
                    break;
                case 6:
                    sair = true;
                    break;    
            }
        }
    }
    
}
