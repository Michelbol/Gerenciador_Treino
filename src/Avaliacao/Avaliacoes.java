
package Avaliacao;

import Aplicações.Conexao;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class Avaliacoes {
//Conexão
    Connection con = Conexao.getConnection();
//Atributos
    String q;
    static String status = "";
    private String data_hora;
    private String nomeusuario;
    private int idavaliacao;
    boolean avaliacao;
//Construtor
    public Avaliacoes(String data_hora, String nomeusuario, int idavaliacao) {
        this.data_hora = data_hora;
        this.nomeusuario = nomeusuario;
        this.idavaliacao = idavaliacao;
    }
    public Avaliacoes(){
    }
//too String
    @Override
    public String toString() {
        return "Avaliacoes{" + "data_hora=" + data_hora + ", nomeusuario=" + nomeusuario + ", idavaliacao=" + idavaliacao + '}';
    }
    
//objetos
    ArrayList Avaliacoes_Medico = new ArrayList();
    Avaliacao_Menu_Horario hora;
    
    public boolean Marcar_Avalicao(Usuario u){
       data_hora = hora.hora_avaliacao();
        q = "insert into avaliacao(idUsuario, Dia_avaliacao) "
            + "values ("+u.getIdusuario()+", "+"'"+ data_hora +"')";
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
    public Collection Verifica_Avaliacoes_Medico(Usuario u){
        q = "select a.idAvaliacao, u.Login, a.Dia_avaliacao from avaliacao a "
            + "join usuario u on a.idUsuario = u.idUsuario "
            + "where a.idMedico = " + u.getIdusuario() + " and a.Finalizado = 'NAO'";
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(q);
        status = "Consulta realizada com sucesso";
            while(rs.next()){
                idavaliacao = rs.getInt("idAvaliacao");
                data_hora = rs.getString("Dia_avaliacao");
                nomeusuario = rs.getString("Login");
                Avaliacoes a = new Avaliacoes(data_hora, nomeusuario, idavaliacao);
                Avaliacoes_Medico.add(a);                
        }
        }catch (SQLException e){
            status = "Não foi possivel alterar o registro erro: " +e.getMessage() +" sql executado " + q;
            System.out.println(status);
        }
    return Avaliacoes_Medico;
    }
}