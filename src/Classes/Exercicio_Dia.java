
package Classes;

public class Exercicio_Dia {
    private String Dia_Semana;
    private String Nome_Exercicio;
    private String Descricao;
    private String Musculo;
//Get
    public String getDia_Semana() {
        return Dia_Semana;
    }
    public String getNome_Exercicio() {
        return Nome_Exercicio;
    }
    public String getDescricao() {
        return Descricao;
    }
    public String getMusculo() {
        return Musculo;
    }
//Set
    public void setMusculo(String Musculo) {
        this.Musculo = Musculo;
    }
    public void setDia_Semana(String Dia_Semana) {
        this.Dia_Semana = Dia_Semana;
    }    
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }    
    public void setNome_Exercicio(String Nome_Exercicio) {
        this.Nome_Exercicio = Nome_Exercicio;
    }
//Construtor
    public Exercicio_Dia(String Dia_Semana, String Nome_Exercicio, String Descricao, String Musculo) {
        this.Dia_Semana = Dia_Semana;
        this.Nome_Exercicio = Nome_Exercicio;
        this.Descricao = Descricao;
        this.Musculo = Musculo;
    }
    public Exercicio_Dia(){
    }
//toString
    @Override
    public String toString() {
        return "Dia_Semana=" + Dia_Semana + ", Nome_Exercicio=" + Nome_Exercicio + ", Descricao=" + Descricao + ", Musculo=" + Musculo;
    }
}
