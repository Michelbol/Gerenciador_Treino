
package Classes;

import Aplicações.Conexao_Banco;
import static Classes.Usuario.status;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexao_Sistema {
    Connection con = Conexao_Banco.getConnection();
    String q;
    public Usuario Tela_Login(){
        Usuario u = new Usuario();
        while(u.getIdusuario() == 0){
            u.setLogin(JOptionPane.showInputDialog("Digite seu Login: "));
            if (u.getLogin() == null){
                u.setLogin("");
            }else{
            u.setSenha(JOptionPane.showInputDialog("Digite sua Senha: "));
            u = verificaUsuario(u.getLogin(), u.getSenha());
            }
        }
        return u;
    }
    public Usuario verificaUsuario(String Login, String Senha){
        Usuario u = new Usuario();
        q = "select * from usuario where Login = '"+ Login +"'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            
            if(rs.next()){
                u.setIdusuario(rs.getInt("idUsuario"));
                u.setLogin(rs.getString("Login"));
                u.setSenha(rs.getString("Senha"));
                u.setPermissao(rs.getInt("idPermissoes"));
            }else{
                u.setIdusuario(0);
                u.setLogin("");
                u.setSenha("");
                u.setPermissao(0);
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }
            if(u.getLogin().equals(Login) && u.getSenha().equals(Senha) && u.getIdusuario() != 0){
                JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso");
                q = "update usuario set conexao = 'Online' where usuario.login = " + "'" + u.getLogin() + "'";
                try{
                Statement st = con.createStatement();
                st.executeUpdate(q);
                }catch(SQLException e){
                status = "Não foi possivel alterar o registro erro: " +e.getMessage()+" sql executado "+ q;
                    System.out.println(status);
                }            
                return u;
            }else{
                JOptionPane.showMessageDialog(null,"Usuario ou senha não cadastrado");
                u.setIdusuario(0);
                return u;
            }
    }    
}
