package pesquisa;
import modelos.Restaurante;
import java.io.*;

public class PesquisaSequencial{
  private int comparacoes;
  private long tempoExecucao;
  public PesquisaSequencial(){
    this.comparacoes = 0;
    this.tempoExecucao = 0;
  }
  public void pesquisar(Restaurante[] array, int n, String busca){
    long inicio = System.currentTimeMillis(); 
    boolean resp = false;
    for(int i = 0; i < n; i++){
      this.comparacoes++;
      if(array[i].getNome().equals(busca)){
        resp = true;
        i = n;
      }
    }
    long fim = System.currentTimeMillis();
    this.tempoExecucao = fim - inicio;
    System.out.println(resp ? "SIM" : "NAO");
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
