package ordenacao;
import modelos.Restaurante;
import java.io.*;

public class Selecao{
  private int comparacoes;
  private int movimentacoes;
  private long tempoExecucao;
  //construtor vazio para incializar as variaveis
  public Selecao(){
    this.comparacoes = 0;
    this.movimentacoes = 0;
    this.tempoExecucao = 0;
  }
  public void ordenar(Restaurante[] array, int n){
    //tmepo inicial de execucao
    long inicio = System.currentTimeMillis();
    
    for(int i = 0; i < n-1; i++){
      int menor = i;
      for(int j = i+1; j < n; j++){
        this.comparacoes++;
        if(compareTo(array[j], array[menor]) < 0){
          menor = j;
        }
      }
      swap(array, i,menor);
      this.movimentacoes += 3;
    }

    //tempo final de execucao
    long fim = System.currentTimeMillis();
    //tempo total de execucao
    this.tempoExecucao = fim - inicio;
  }

  //metodo para trocar elementos
  private void swap(Restaurante[] array, int i, int j){
    Restaurante tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  //metodo para comparar
  private int compareTo(Restaurante e1, Restaurante e2){
    int resp = e1.getCidade().compareTo(e2.getCidade());
    return resp;
  }

  public void criarLog(){
    String matricula = "898723";
    try{
      FileWriter w = new FileWriter(matricula + ".txt");
      PrintWriter p = new PrintWriter(w);
      
      p.print(matricula + "\t" + this.comparacoes + "\t" + this.movimentacoes + "\t" + tempoExecucao + "ms\n");
      
      p.close();
      w.close();
    }catch(IOException e){
        e.printStackTrace();
    }
    }
}
