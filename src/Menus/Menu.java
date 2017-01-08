
package Menus;

import Aplicações.Conexao;
import Classes.Usuario;
import java.sql.Connection;

public class Menu {
    //Conexão
    static Connection con = Conexao.getConnection(); 
    //atributos
    public int op;
    public boolean sair = false;
    static String status="";
    static String q;
    
    public  void Menu(Usuario u){
    
    
    }
}
