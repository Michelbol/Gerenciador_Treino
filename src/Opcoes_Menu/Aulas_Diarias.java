
package Opcoes_Menu;

import Classes.Aula_Diaria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Collection;

public class Aulas_Diarias extends Aula_Diaria {
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
