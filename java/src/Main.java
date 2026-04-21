import modelos.Restaurante;
import colecoes.ColecaoRestaurantes;
import ordenacao.Insercao;
import ordenacao.Mergesort;
import pesquisa.PesquisaSequencial;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try{
      //pesquisando por id
      ColecaoRestaurantes colecao = ColecaoRestaurantes.lerCsv();
      int n = colecao.getTamanho();
      //criando array
      Restaurante[] res = new Restaurante[n];
      int id = 0, i = 0;
      while(id >= 0){
        id = sc.nextInt();
        Restaurante r = colecao.pesquisarId(id);
        if(r != null){
          res[i++] = r;
        } 
      }

      //criando array correspondentes aos ids digitados
      Restaurante[] array = new Restaurante[i];
      for(int j = 0; j < i; j++){
        array[j] = res[j];
      }

      //ordenando pelo metodo de Insercao
      Insercao insercao = new Insercao();
      insercao.ordenar(array, i);
      insercao.criarLog();
      System.out.println("===== RESTAURANTES ORDENADOS POR CIDADE =====");
      for(int j = 0; j < i; j++){
        System.out.println(array[j].formatar());
      }

      //pesquisando de forma sequencial
      PesquisaSequencial p = new PesquisaSequencial();
      while(sc.hasNextLine()){
        String nome = sc.nextLine();
        if(nome.equals("FIM")) break;
        p.pesquisar(array,i,nome);
        p.criarLog();
      }

      //ordendando pelo metodo de Mergesort
      Mergesort mergesort = new Mergesort();
      mergesort.sort(array);
      mergesort.criarLog();
      System.out.println("===== RESTAURANTES ORDENADOS POR CIDADE COM DESEMPATE POR NOME =====");
      for(int j = 0; j < i; j++){
        System.out.println(array[j].formatar());
      }

    }catch(Exception e){
      System.err.println("erro ao carregar restaurantes: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
