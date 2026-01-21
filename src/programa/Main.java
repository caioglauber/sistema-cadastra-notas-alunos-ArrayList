
package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        
        long matricula;
        
        System.out.print("Entre com o numero de Alunos para cadastrar: ");
        int numAlunos = sc.nextInt();
        
        List<Aluno> alunos = new ArrayList<>();
        
        for(int i = 0; i< numAlunos;i++){
            System.out.println();
            System.out.println("Aluno #" + (i+1));
            System.out.println("Digite a Matricula: ");
            matricula = sc.nextLong();
            
            while(matriculaExiste(alunos, matricula)){
                System.out.println("Matricula ja Existe. Insira uma nova Matricula: ");
                matricula = sc.nextLong();
            }
            
            
            System.out.print("Digite o nome do Aluno: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Digite a nota do Aluno: ");
            double nota = sc.nextDouble();
            
            alunos.add(new Aluno(matricula, nome, nota));
            
        }
        
        System.out.println();
        System.out.print("Entre com a Matricula para incrementar Pontos para o Aluno: ");
        matricula = sc.nextLong();
        
        int indice = posicao(alunos, matricula);
        
        if(indice >= 0){
            
            System.out.print("Quantos pontos deseja Adicionar?");
            double pontos = sc.nextDouble();
            double notaAluno = alunos.get(indice).getNota();
            
            while((notaAluno + pontos) > 10){
                System.out.print("Entre com menor numero de Pontos. (Nota maxima é 10): ");
                pontos = sc.nextDouble();
            }
            alunos.get(indice).aumentarNota(pontos);
            
        }else{
            System.out.println("Matricula Inexistente!");
        }
        
        System.out.println("Lista dos Alunos");
        System.out.println();
        for(Aluno aluno : alunos){
            System.out.println(aluno);
        }
                
    }
    
    public static boolean matriculaExiste(List<Aluno> alunos, long matricula){
        Aluno aluno = alunos.stream().filter(x-> x.getMatricula() == matricula).findFirst().orElse(null);
        
        return aluno != null;
    }
    
    public static Integer posicao(List<Aluno> alunos, long matricula) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula() == matricula) {

                return i;
            }

           
        }
         return -1;
        
    }
    
    
    
}
