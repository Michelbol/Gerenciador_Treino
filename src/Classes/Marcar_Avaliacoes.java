
package Classes;

import Opcoes_Menu.Menu_Avaliacao_Horario;
import Aplicações.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Marcar_Avaliacoes {
//Conexão
    Connection con = Conexao.getConnection();
//Atributos
    String q;
    static String status = "";
    private String data_hora;
    boolean avaliacao;
//objetos
    Menu_Avaliacao_Horario hora = new Menu_Avaliacao_Horario();
    
    public boolean Marcar_Avalicao(int idUsuario){
       data_hora = hora.hora_avaliacao();
        q = "insert into avaliacao(idUsuario, Dia_avaliacao) "
            + "values ("+idUsuario+", "+"'"+ data_hora +"')";
        try{
            Statement st = con.createStatement();
            st.executeUpdate(q);
            status = "Registro incluido com sucesso";
            avaliacao = true;
        }catch(SQLException e){
            status = "Não foi possivel alterar o registro erro: " +e.getMessage()+" sql executado "+ q;
            System.out.println(status);
            avaliacao = false;
        }
        return avaliacao;
    }
}