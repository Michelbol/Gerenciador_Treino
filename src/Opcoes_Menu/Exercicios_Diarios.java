
package Opcoes_Menu;

import Classes.Exercicio_Dia;
import Classes.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;


public class Exercicios_Diarios extends Exercicio_Dia {
 //Objeto
    Exercicio_Dia ed;
//Verificando Exercicios Atleta
    public Collection exerc_diario_atleta(Usuario u){
        exercicios_dia.clear();
        q = "select s.Dia, e.nome_exercicio as Exercicio, m.Nome_Musculo as Musculo, e.Descricao from exercicios_diarios ed " +
        "inner join usuario u on ed.idUsuario = u.idUsuario " +
        "inner join semana s on ed.idSemana = s.idSemana " +
        "inner join exercicios e on ed.idExercicios = e.idExercicios " +
        "inner join musculo m on e.idmusculo = m.idmusculo " +
        "where u.idUsuario = "+ u.getIdusuario();
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
