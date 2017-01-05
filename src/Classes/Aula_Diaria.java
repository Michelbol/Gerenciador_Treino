
package Classes;


public class Aula_Diaria {
    private String Nome_Aula;
    private String Hora_Aula;
    private String Dia_Aula;
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
}
