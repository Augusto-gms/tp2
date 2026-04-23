package ordenacao;
import modelos.*;

public class Heapsort {
  private int comparacoes;
  private int movimentacoes;
  private long tempoExecucao;
  private Restaurante[] array;
  private int n;
  public Heapsort() {
    this.comparacoes = 0;
    this.movimentacoes = 0;
    this.tempoExecucao = 0;
  }

  //metodo de ordenacao por heapsort
  public void heapsort(Restaurante[] array){
  this.n = array.length;
  // Alterar o vetor ignorando a posicao zero
  Restaurante[] tmp = new Restaurante[n+1];
  for (int i = 0; i < n; i++){
     tmp[i + 1] = array[i];
  }
   this.array = tmp;

  //contrucao do heap
  for (int tamHeap = 2; tamHeap <= n; tamHeap++){
    construir(tamHeap);
  }

  //ordenacao 
  int tamHeap = n;
  while (tamHeap > 1) {
    swap(this.array,1,tamHeap--);
    reconstruir(tamHeap);
  }

  //altera o vetor para voltar para posicao 0
  tmp = this.array;
  array = new Restaurante[n];
  for (int i = 0; i < n; i++){
    array[i] = tmp[i + 1];
    }
  }

  //sobe o elemento ate sua posicao correta
  private void construir(int tamHeap){
    for (int i = tamHeap; i > 1 && compareTo(array[i], array[i / 2]) > 0; i /= 2){
      comparacoes++;
      swap(array, i, i / 2);
      movimentacoes++;
    }
  }
  //desce o elemtendo 1 ate sua posicao correta
  private void reconstruir(int tamHeap){
    int i = 1;
    while (i <= (tamHeap / 2)){
      //pega maior filho pra compaarar com o pai
      int filho = getMaiorFilho(i, tamHeap);
      comparacoes++;
      if (compareTo(array[i], array[filho]) < 0){
        //se for menor troca e continua 
          swap(array, i, filho);
          movimentacoes++;
          i = filho;
      }else{
          i = tamHeap;
      }
    }
  }

  //retorna o indice do maior filho
  public int getMaiorFilho(int i, int tamHeap) {
    int filho;
    if (2 * i == tamHeap || compareTo(array[i*2], array[2*i+1]) > 0) {
      filho = 2 * i;
    } else {
      filho = 2 * i + 1;
    }
    return filho;
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
    if(resp == 0){
      //desempate por nome
      resp = e1.getNome().compareTo(e2.getNome());
    }
    return resp;
  }
}
