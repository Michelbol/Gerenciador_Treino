
package Classes;

import Aplicações.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Minhas_Medidas {
    //Conexao
    Connection con = Conexao.getConnection();
    //Atributos
    private double peito;
    private double Biceps_Esq;
    private double Biceps_Dir;
    private double Ant_Braco_Esq;    
    private double Ant_Braco_Dir;
    private double Coxa_Esq;
    private double Coxa_Dir;
    private double Panturrilha_Esq;
    private double Panturrilha_Dir;
    private double Gordura;
    private double Abdomen;
    private double Altura;
    private double Peso;
    String q;
    String status;

    @Override
    public String toString() {
        return "Minhas_Medidas{" + "peito=" + peito + ", Biceps_Esq=" + Biceps_Esq + ", Biceps_Dir="
               + Biceps_Dir + ", Ant_Braco_Esq=" + Ant_Braco_Esq + ", Ant_Braco_Dir=" + Ant_Braco_Dir +
                ", Coxa_Esq=" + Coxa_Esq + ", Coxa_Dir=" + Coxa_Dir + ",\n Panturrilha_Esq=" + Panturrilha_Esq +
                ", Panturrilha_Dir=" + Panturrilha_Dir + ", Gordura=" + Gordura + ", Abdomen=" + Abdomen +
                ", Altura=" + Altura + ", Peso=" + Peso + '}';
    }
    
    
    public Minhas_Medidas Consuta_Medidas(Usuario u){
                    Minhas_Medidas mm = new Minhas_Medidas();
                    q = "select * from minhas_medidas where idUsuario =" + u.getIdusuario();
                    try{
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(q);           
                        while(rs.next()){ 
                            mm.peito = rs.getDouble("Peito");
                            mm.Biceps_Esq = rs.getDouble("Biceps_Esq");
                            mm.Biceps_Dir = rs.getDouble("Biceps_Dir");
                            mm.Ant_Braco_Esq = rs.getDouble("Ant_Braco_Esq");                        
                            mm.Ant_Braco_Dir = rs.getDouble("Ant_Braco_Dir");
                            mm.Coxa_Esq = rs.getDouble("Coxa_Esq");
                            mm.Coxa_Dir = rs.getDouble("Coxa_Dir");
                            mm.Panturrilha_Esq = rs.getDouble("Panturrilha_Esq");
                            mm.Panturrilha_Dir = rs.getDouble("Panturrilha_Dir");
                            mm.Gordura = rs.getDouble("Gordura");
                            mm.Abdomen = rs.getDouble("Abdomen");
                            mm.Altura = rs.getDouble("Altura");
                            mm.Peso = rs.getDouble("Peso");
                        }
                    }catch(SQLException e){
                        status = e.getMessage();
                        System.out.println(status);
                    }
            return mm;
    }
}
