
package programa;

public class Aluno {
    private long matricula;
    private String nome;
    private double nota;

    public Aluno() {
    }

    public Aluno(long matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public long getMatricula() {
        return matricula;
    }

   
    public void aumentarNota(double pontos){
      
           this.nota += pontos;
    }
    
    @Override
    public String toString(){
       
        return "Matricula: " + matricula
               + ", "
               +  ", Nome: "+ nome
               + String.format(", Nota: %.1f", nota);
               
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    
    
    
}
