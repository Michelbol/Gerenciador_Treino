
package Menus;

import Avaliacao.Avaliacao_Menu;
import Classes.Aula_Diaria;
import Classes.Exercicio_Dia;
import Classes.Usuario;
import Classes.Dieta;
import Classes.Minhas_Medidas;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Menu_Opcoes_Atleta extends Menu {   
//objetos
    Exercicio_Dia ed;
    Dieta dieta;
    Avaliacao_Menu aval;
    Aula_Diaria ad;  
    Minhas_Medidas mm;
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
                    ed = new Exercicio_Dia();
                    ArrayList exerc_dia = new ArrayList(ed.exerc_diario_atleta(u));
                    JOptionPane.showMessageDialog(null, exerc_dia.toArray());
                    break;
                case 2:
                    dieta = new Dieta();
                    ArrayList diet = new ArrayList(dieta.dieta(u));
                    JOptionPane.showMessageDialog(null, diet.toArray());
                    break;
                case 3:
                    aval = new Avaliacao_Menu();
                    aval.Menu(u);
                    break;
                case 4: 
                    ad = new Aula_Diaria();
                    ArrayList aulaDiaria = new ArrayList(ad.Aulas_Dia());
                    if (aulaDiaria.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Infelizmente não temos nenhuma aula hoje");
                    }else{
                    JOptionPane.showMessageDialog(null,aulaDiaria.toArray());
                    }
                    break;
                case 5:
                    mm = new Minhas_Medidas();
                    JOptionPane.showMessageDialog(null, mm.Consuta_Medidas(u).toString());
                    break;
                case 6:
                    sair = true;
                    break;    
            }
        }
        switch(u.getPermissao()){
        //Menus
        case 1:
            
            break;
        case 2:
            break;
        case 3:
            
            break;
        case 4:
            if (u.getIdusuario() != 0 ){
                Menu menu_adm = new Menu_Opcoes_Administrador_Academia();
                menu_adm.Menu(u);
            }
            break;
        case 5:
            if (u.getIdusuario() != 0 ){
                Menu menu_medico = new Menu_Opcoes_Medico();
                menu_medico.Menu(u);
            }
            break;
    }
    }
    
}
