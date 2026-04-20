import modelos.Restaurante;
import colecoes.ColecaoRestaurantes;
import ordenacao.Selecao;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    try{
      ColecaoRestaurantes colecao = ColecaoRestaurantes.lerCsv();

      Restaurante[] lista = colecao.getRestaurantes();
      int n = colecao.getTamanho();

      Selecao algoritmo = new Selecao();
      algoritmo.ordenar(lista, n);
      algoritmo.criarLog();
  
      System.out.println("===== RESTAURANTES ORDENADOOS POR CIDADE =====");
      for(int i = 0; i < n; i++){
        System.out.println(lista[i].formatar());
      }
      
      System.out.println("===== RESTAURANTES LISTADOS =====");
      int id = 0;
      Scanner sc = new Scanner(System.in);
      while(id >= 0){
        id = sc.nextInt();
        Restaurante restaurantes = colecao.pesquisarId(id);
        if(restaurantes != null){
          System.out.println(restaurantes.formatar());
        }
      }
    }catch(Exception e){
      System.err.println("erro ao carregar restaurantes: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
