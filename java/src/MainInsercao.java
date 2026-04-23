import colecoes.*;
import java.util.*;
import modelos.*;
import ordenacao.*;

public class MainInsercao{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    try{

      ColecaoRestaurantes colecao = ColecaoRestaurantes.lerCsv();
      int n = colecao.getTamanho();

      Restaurante[] tmp = new Restaurante[n];
      int id = 0, i = 0;
      id = sc.nextInt();
      while(id >= 0){
        Restaurante r = colecao.pesquisarId(id);
        if(r != null){
          tmp[i++] = r;
        }
        id = sc.nextInt();
      }
      //criando array com restaurantes com os ids digitados
      Restaurante[] array = new Restaurante[i];
      for(int j = 0; j < i; j++){
        array[j] = tmp[j];
      }
      //ordenando pelo metodo de insercao 
      Insercao insercao = new Insercao();
      insercao.ordenar(array, i);
      insercao.criarLog();
      System.out.println("===== RESTAURANTES ORDENADOS POR CIDADE =====");
      for(int j = 0; j < i; j++){
        System.out.println(array[j].formatar());
      }
      sc.close();
    }catch(Exception e){
      System.err.println("erro ao carregar restaurantes" + e.getMessage());
      e.printStackTrace();
    }
  }
}