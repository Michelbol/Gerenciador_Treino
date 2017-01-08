
package Menus;

import Classes.Usuario;
import static Menus.Menu_Opcoes_Atleta.status;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Gerenciamento_Menus extends Menu {
    public static void main(String[] args) {
    //Objetos
        Usuario u = new Usuario();
        Menu menu_Atleta = new Menu_Opcoes_Atleta();
        Menu menu_adm = new Menu_Opcoes_Administrador_Academia();
        Menu menu_medico = new Menu_Opcoes_Medico();
    //Tela Login -- Implementar verificação em Permissões
       
        while(u.getIdusuario() == 0){
            u.setLogin(JOptionPane.showInputDialog("Digite seu Login: "));
            if (u.getLogin() == null){
                u.setLogin("");
            }
            u.setSenha(JOptionPane.showInputDialog("Digite sua Senha: "));
            u = u.verificaUsuario(u.getLogin(), u.getSenha());
            if (u.getIdusuario() ==0 ){
            
            }else{    
                switch(u.getPermissao()){
                //Menus
                    case 1:
            
                        break;
                    case 2:
                        if (u.getIdusuario() != 0 ){
                        menu_Atleta.Menu(u);
                        }
                        break;
                    case 3:
            
                        break;
                    case 4:
                        if (u.getIdusuario() != 0 ){
                            menu_adm.Menu(u);
                        }
                        break;
                    case 5:
                        if (u.getIdusuario() != 0 ){
                            menu_medico.Menu(u);
                        }
                        break;
                }
            }
        }
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

