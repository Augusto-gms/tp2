import colecoes.*;
import java.util.*;
import modelos.*;

public class MainId{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try{
      //pesquisando por id
      ColecaoRestaurantes colecao = ColecaoRestaurantes.lerCsv();
      int n = colecao.getTamanho();
      //criando array
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

      //criando array correspondentes aos ids digitados
      Restaurante[] array = new Restaurante[i];
      for(int j = 0; j < i; j++){
        array[j] = tmp[j];
      }
      sc.close();
    }catch(Exception e){
      System.err.println("erro ao carregar restaurantes: " + e.getMessage());
      e.printStackTrace();
    }
  }
}