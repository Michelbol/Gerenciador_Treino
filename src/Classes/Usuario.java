
package Classes;

import Aplicações.Conexao_Banco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Usuario {
   Connection con = Conexao_Banco.getConnection();
   String q;
   static String status="";
   private String login;
   private String senha;
   private int idusuario;
   private int conexao;
   private int permissao;
   
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
    public int getPermissao() {
        return permissao;
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
    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
   
}
