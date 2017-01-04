
package Menu;

import Opcoes_Menu.Exercicios_Diarios;
import Opcoes_Menu.Menu_Avaliacao;
import Aplicações.Conexao;
import Classes.Usuario;
import Interfaces.Menu;
import Opcoes_Menu.Aulas_Diarias;
import Opcoes_Menu.Dieta;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Menu_Opcoes_Atleta implements Menu {
//Conexão
    Connection con = Conexao.getConnection();    
//atributos
    int op;
    boolean sair = false;
    static String status="";
//objetos
    Exercicios_Diarios ed;
    Dieta dieta;
    Menu_Avaliacao aval;
    Aulas_Diarias ad;
    
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
                    ed = new Exercicios_Diarios();
                    ArrayList exerc_dia = new ArrayList(ed.exerc_diario_atleta(u));
                    JOptionPane.showMessageDialog(null, exerc_dia.toArray());
                    break;
                case 2:
                    dieta = new Dieta();
                    ArrayList diet = new ArrayList(dieta.dieta(u));
                    JOptionPane.showMessageDialog(null, diet.toArray());
                    break;
                case 3:
                    aval = new Menu_Avaliacao();
                    aval.Menu(u);
                    break;
                case 4: 
                    ad = new Aulas_Diarias();
                    JOptionPane.showMessageDialog(null,ad.Aulas_Dia());
                    break;
                case 5:
                    
                    break;
                case 6:
                    sair = true;
                    break;    
            }
        }
    }
    
}
