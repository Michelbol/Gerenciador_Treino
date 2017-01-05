
package Menus;

import Aplicações.Conexao;
import Classes.Usuario;
import java.sql.Connection;

public class Menu {
    //Conexão
    Connection con = Conexao.getConnection(); 
    //atributos
    int op;
    boolean sair = false;
    static String status="";
    
}
