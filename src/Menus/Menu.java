
package Menus;

import Aplicações.Conexao;
import java.sql.Connection;

public class Menu {
    //Conexão
    static Connection con = Conexao.getConnection(); 
    //atributos
    public int op;
    public boolean sair = false;
    static String status="";
    static String q;
}
