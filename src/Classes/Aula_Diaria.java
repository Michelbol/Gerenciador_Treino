
package Classes;

import Aplicações.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;


public class Aula_Diaria {
//Conexão
    public Connection con = Conexao.getConnection();
//Atributos
    private String Nome_Aula;
    private String Hora_Aula;
    private String Dia_Aula;
    public static String q;
    public static String status = "";
//Listas
    public static List Horario_Aulas = new ArrayList();
//get
    public String getNome_Aula() {
        return Nome_Aula;
    }
    public String getDia_Aula() {
        return Dia_Aula;
    }
    public String getHora_Aula() {
        return Hora_Aula;
    }
//set    
    public void setNome_Aula(String Nome_Aula) {
        this.Nome_Aula = Nome_Aula;
    }
    public void setHora_Aula(String Hora_Aula) {
        this.Hora_Aula = Hora_Aula;
    }
    public void setDia_Aula(String Dia_Aula) {
        this.Dia_Aula = Dia_Aula;
    }
//TooString
    @Override
    public String toString() {
        return "Nome_Aula=" + Nome_Aula + ", Hora_Aula=" + Hora_Aula + ", Dia_Aula=" + Dia_Aula;
    }
    
    //Objetos
    Aula_Diaria ad;
    Calendar c = Calendar.getInstance();
    
    public Collection Aulas_Dia(){
        q = "select ad.Aula_Nome, ad.Horario_Aula, s.Dia from aulas_diarias ad " +
            "inner join semana s on ad.idsemana = s.idSemana "+
            "where ad.idSemana = " + c.get(Calendar.DAY_OF_WEEK);
        try{ 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);            
            while(rs.next()){
                ad = new Aula_Diaria();
                ad.setNome_Aula(rs.getString("Aula_Nome"));
                ad.setHora_Aula(rs.getString("Horario_Aula"));
                ad.setDia_Aula(rs.getString("Dia"));
                Horario_Aulas.add(ad);
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }
            return Horario_Aulas;
    }
}
