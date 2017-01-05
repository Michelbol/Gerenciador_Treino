
package Opcoes_Menu;

import Menus.Menu;
import javax.swing.JOptionPane;


public class Menu_Avaliacao_Horario extends Menu {
    
    public String hora_avaliacao(){		
        String data = JOptionPane.showInputDialog("Digite a data de sua avaliação: Ano/Mes/Dia ");
        String hora = "00:00";
        op = Integer.parseInt(JOptionPane.showInputDialog("Segue abaixo Horarios Disponíveis:\n"
                + "01 - 08:00\n"
                + "02 - 09:00\n"
                + "03 - 10:00\n"
                + "04 - 11:00\n"
                + "05 - 12:00\n"
                + "06 - 13:00\n"
                + "07 - 14:00\n"
                + "08 - 15:00\n"
                + "09 - 16:00\n"
                + "10 - 17:00\n"));
        switch(op){
            case 01:
                hora = "08:00:00";
                break;
            case 02:
                hora = "09:00:00";
                break;
            case 03:
                hora = "10:00:00";
                break;
            case 04:
                hora = "11:00:00";
                break;    
            case 05:
                hora = "12:00:00";
                break;   
            case 06:
                hora = "13:00:00";
                break;    
            case 07:
                hora = "14:00:00";
                break;    
            case 8:
                hora = "15:00:00";
                break;    
            case 9:
                hora = "16:00:00";
                break;    
            case 10:
                hora = "17:00:00";
                break;    
        }
    String data_hora = data +" "+ hora;
        return data_hora;
    }
    
}
    
    

