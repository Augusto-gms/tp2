package pesquisa;
import java.io.*;
import modelos.Restaurante;

public class PesquisaSequencial{
  private int comparacoes;
  private long tempoExecucao;
  public PesquisaSequencial(){
    this.comparacoes = 0;
    this.tempoExecucao = 0;
  }
  public void pesquisar(Restaurante[] array, int n, String busca){
    boolean resp = false;
    for(int i = 0; i < n; i++){
      this.comparacoes++;
      if(compareTo(array[i], busca) == 0){
        resp = true;
        i = n;
      }
    }
    System.out.println(resp ? "SIM" : "NAO");
  }

  private int compareTo(Restaurante e1, String e2){
    int resp = e1.getNome().compareTo(e2);
    return resp;
  }

  public void criarLog(){
    String matricula = "898723";
    try{
      FileWriter w = new FileWriter(matricula + "_sequencial.txt");
      PrintWriter p = new PrintWriter(w);
      
      p.print(matricula + "\t" + this.comparacoes + "\t" + this.tempoExecucao + "ms\n");

      p.close();
      w.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
