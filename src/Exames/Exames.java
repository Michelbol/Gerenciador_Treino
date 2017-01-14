
package Exames;

import Aplicações.Conexao_Banco;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;


public class Exames {
//Conexao
    Connection con = Conexao_Banco.getConnection();
//atributos
    private int idavaliacao;
    private String dia_avaliacao;
    String q;
    String status = "";
//get
    public int getIdavaliacao() {
        return idavaliacao;
    }
    public String getDia_avaliacao() {
        return dia_avaliacao;
    }
//set
    public void setIdavaliacao(int idavaliacao) {
        this.idavaliacao = idavaliacao;
    }
    public void setDia_avaliacao(String dia_avaliacao) {
        this.dia_avaliacao = dia_avaliacao;
    }
//Listas
    static List meus_exames = new ArrayList();
//toString
    @Override
    public String toString() {
        return "idavaliacao=" + idavaliacao + ", dia_avaliacao=" + dia_avaliacao;
    }
//Construtores
    public Exames(int idavaliacao, String dia_avaliacao) {
        super();
        this.idavaliacao = idavaliacao;
        this.dia_avaliacao = dia_avaliacao;
    } 
    public Exames() {
        super();
    }
    
    public void Consulta_Exame(Usuario u){
                    q = "select av.idAvaliacao as Codigo, av.Dia_avaliacao as Seu_Exame from avaliacao av\n" +
                        "where idusuario ="+ u.getIdusuario() +";";
                    try{
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(q);           
                    while(rs.next()){ 
                        idavaliacao = rs.getInt("Codigo");
                        dia_avaliacao = rs.getString("Seu_Exame");
                        Exames ex = new Exames(idavaliacao, dia_avaliacao);
                        meus_exames.add(ex);
                    }
                    }catch(SQLException e){
                    status = e.getMessage();
                    System.out.println(status);
                    }
            JOptionPane.showMessageDialog(null, meus_exames.toArray());
    }
    
}
