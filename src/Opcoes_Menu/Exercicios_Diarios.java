
package Opcoes_Menu;

import Aplicações.Conexao;
import Classes.Exercicio_Dia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Exercicios_Diarios {
//Conexão
    Connection con = Conexao.getConnection();
//Atributos
    String q;
    static String status = "";
//Listas
    static List exercicios_dia = new ArrayList();
 //Objeto
    Exercicio_Dia ed;
//Verificando Exercicios Atleta
    public Collection exerc_diario_atleta(int idusuario){
        exercicios_dia.clear();
        q = "select s.Dia, e.nome_exercicio as Exercicio, m.Nome_Musculo as Musculo, e.Descricao from exercicios_diarios ed " +
        "inner join usuario u on ed.idUsuario = u.idUsuario " +
        "inner join semana s on ed.idSemana = s.idSemana " +
        "inner join exercicios e on ed.idExercicios = e.idExercicios " +
        "inner join musculo m on e.idmusculo = m.idmusculo " +
        "where u.idUsuario = "+ idusuario;
        try{ 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);            
            while(rs.next()){
                ed = new Exercicio_Dia();
                ed.setDia_Semana(rs.getString("dia"));
                ed.setNome_Exercicio(rs.getString("Exercicio"));
                ed.setDescricao(rs.getString("descricao"));
                ed.setMusculo(rs.getString("Musculo"));
                exercicios_dia.add(ed);
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }
        return exercicios_dia;
    }
}