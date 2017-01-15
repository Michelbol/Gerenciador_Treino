
package Dieta;

import Aplicações.Conexao_Banco;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Dieta {
//Conexão
    Connection con = Conexao_Banco.getConnection();
//Atributos
    String q;
    static String status = "";
    private String Dia_Semana;
    private String Refeicao;
    private String Descricao;

    public Dieta(String Dia_Semana, String Refeicao, String Descricao) {
        this.Dia_Semana = Dia_Semana;
        this.Refeicao = Refeicao;
        this.Descricao = Descricao;
    }
    public Dieta(){
    }

    @Override
    public String toString() {
        return "Dia_Semana=" + Dia_Semana + ", Refeicao=" + Refeicao + ", Descricao=" + Descricao;
    }
   
    static List dieta = new ArrayList();
    
    public void Verifica_Dieta_Usuario (Usuario u){
        q = "select s.Dia as Dia, d.Refeicao, d.Descricao from dieta d " +
            "inner join semana s on s.idSemana = d.idDieta " +
            "inner join usuario u on u.idUsuario = d.idUsuario " +
            "where "+u.getIdusuario()+" = d.idUsuario";
        System.out.println(q);
        try{ 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);            
            while(rs.next()){
                Dia_Semana = rs.getString("dia");
                Refeicao = rs.getString("Refeicao");
                Descricao = rs.getString("descricao");
                Dieta d = new Dieta(Dia_Semana, Refeicao ,Descricao);
                dieta.add(d);
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }        
        JOptionPane.showMessageDialog(null, dieta.toArray());
    }
    
}
