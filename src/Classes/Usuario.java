
package Classes;

import Aplicações.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Usuario {
   Connection con = Conexao.getConnection();
   String q;
   static String status="";
   private String login;
   private String senha;
   private int idusuario;
   private int conexao;
   
//get
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }
    public int getConexao() {
        return conexao;
    }
    public int getIdusuario() {
        return idusuario;
    }
//set
    public void setLogin(String login) {
        if(login == null){
            this.login = "";
        }else{
        this.login = login;
        }
    }
    public void setSenha(String senha) {
        if(senha == null){
            this.senha = "";
        }else{
        this.senha = senha;
        }
    }
    public void setConexao(int conexao) {
        this.conexao = conexao;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    public Usuario verificaUsuario(String Login, String Senha){
        Usuario u = new Usuario();
        q = "select * from usuario where Login = '"+ Login +"'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            
            if(rs.next()){
                u.idusuario = rs.getInt("idUsuario");
                u.login = rs.getString("Login");
                u.senha = rs.getString("Senha");
            }else{
                u.idusuario = 0;
                u.login = "";
                u.senha = "";                
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }
            if(u.login.equals(Login) && u.senha.equals(Senha) && u.idusuario != 0){
                JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso");
                q = "update usuario set conexao = 'Online' where usuario.login = " + "'" + u.login + "'";
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
                idusuario = 0;
                return u;
            }
    }
   
}
