import ordenacao.*;
import colecoes.*;
import modelos.*;
import pesquisa.*;
import java.util.*;

public class MainHeap{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    try{
      ColecaoRestaurantes colecao = ColecaoRestaurantes.lerCsv();
      int n = colecao.getTamanho();

      Restaurante[] tmp = new Restaurante[n];
      int id, i = 0;
      id = sc.nextInt();
      while(id >= 0){
        Restaurante r = colecao.pesquisarId(id);
        if(r != null){
          tmp[i++] = r;
        }
        id = sc.nextInt();
      }
      Restaurante[] array = new Restaurante[i];
      for (int j = 0; j < i; j++) {
        array[j] = tmp[j];
      }

    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
