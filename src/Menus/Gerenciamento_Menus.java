
package Menus;

import Aplicações.Conexao;
import Classes.Usuario;
import static Menus.Menu_Opcoes_Atleta.status;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Gerenciamento_Menus {
    public static void main(String[] args) {
    //Conexão
        Connection con = Conexao.getConnection();
    //Atributos
        String q;
    //Objetos
        Usuario u = new Usuario();
        Menu_Opcoes_Atleta menu_Atleta = new Menu_Opcoes_Atleta();
    //Tela Login
        while(u.getIdusuario() == 0){
                u.setLogin(JOptionPane.showInputDialog("Digite seu Login: "));
                if (u.getLogin() == null){
                    u.setLogin("");
                }
            u.setSenha(JOptionPane.showInputDialog("Digite sua Senha: "));
            u = u.verificaUsuario(u.getLogin(), u.getSenha());
    //Menus
            if (u.getIdusuario() != 0){
                menu_Atleta.Menu(u);
    //Saindo do Sistema
                q = "update usuario set conexao = 'Offline' where usuario.login = " + "'" + u.getLogin() + "'";
                try{
                    Statement st = con.createStatement();
                    st.executeUpdate(q);
                    status = "Alteração realizada com sucesso";
                }catch(SQLException e){
                    status = "Não foi possivel alterar o registro erro: " +e.getMessage()+" sql executado "+ q;
                }
            }
        }
    }
}   

