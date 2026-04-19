import java.util.*;

public class Main {
  public static void main(String[] args) {
    try{
      ColecaoRestaurantes colecao = ColecaoRestaurantes.lerCsv();

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
