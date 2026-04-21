package ordenacao;
import modelos.Restaurante;
import java.io.*;

public class Mergesort{
  private int comparacoes;
  private int movimentacoes;
  private long tempoExecucao;
  private Restaurante[] array;
  //construtor vazio para inicializar as variaveis
  public Mergesort(){
    this.comparacoes = 0;
    this.movimentacoes = 0;
    this.tempoExecucao = 0;
  }
  public void sort(Restaurante[] array){
    this.array = array;
    mergesort(0, array.length - 1);
  }
  public void mergesort(int esq, int dir){
    if(esq < dir){
      int meio = (esq + dir) / 2;
      mergesort(esq, meio);
      mergesort(meio + 1, dir);
      intercalar(esq, meio, dir);
    }
  }
  //intercala dir e esq
  public void intercalar(int esq, int meio, int dir){
    int n1, n2, i, j, k;
    
    //definir tamanho dos dois subarrays
    n1 = meio - esq + 1;
    n2 = dir - meio;

    Restaurante[] a1 = new Restaurante[n1+1];
    Restaurante[] a2 = new Restaurante[n2+1];

    //inicializa primeiro subarray
    for(i = 0; i < n1; i++){
      a1[i] = array[esq+i];
    }
    //incializa segundo subarray
    for(j = 0; j < n2; j++){
      a2[j] = array[meio+j+1];
    }
  
    //sentinela no final dos subarrays
    a1[i] = a2[j] = null;

    //intercalacao 
    for(i = j = 0, k = esq; k <= dir; k++){
    array[k] = (a1[i] != null && (a2[j] == null || compareTo(a1[i], a2[j]) <= 0)) ? a1[i++] : a2[j++];
    }
  }
  //compareTo
  private int compareTo(Restaurante e1, Restaurante e2){
    int resp = e1.getCidade().compareTo(e2.getCidade());
    if(resp == 0){
      resp = e1.getNome().compareTo(e2.getNome());
    }
    return resp;
  }
  //criar log
  public void criarLog(){
    String matricula = "898723";
    try{
      FileWriter w = new FileWriter(matricula + "_mergesort.txt");
      PrintWriter p = new PrintWriter(w);

      p.print(matricula + "\t" + this.comparacoes + "\t" + this.movimentacoes + "\t" + this.tempoExecucao + "ms\n");

      p.close();
      w.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
