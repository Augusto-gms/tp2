package ordenacao;
import modelos.Restaurante;
import java.io.*;

public class Insercao{
  private int comparacoes;
  private int movimentacoes;
  private long tempoExecucao;
  //construtor vazio para incializar as variaveis
  public Insercao(){
    this.comparacoes = 0;
    this.movimentacoes = 0;
    this.tempoExecucao = 0;
  }

  public void ordenar(Restaurante[] array, int n){
		for (int i = 1; i < n; i++) {
			Restaurante tmp = array[i];
        int j = i - 1;
          this.comparacoes++;
          while ((j >= 0) && (compareTo(array[j], tmp) > 0)){
            array[j + 1] = array[j];
            this.movimentacoes++;
            j--;
          }
        array[j + 1] = tmp;
      }
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
      FileWriter w = new FileWriter(matricula + "_insercao.txt");
      PrintWriter p = new PrintWriter(w);
      
      p.print(matricula + "\t" + this.comparacoes + "\t" + this.movimentacoes + "\t" + this.tempoExecucao + "ms\n");
      
      p.close();
      w.close();
    }catch(IOException e){
        e.printStackTrace();
    }
    }
}
