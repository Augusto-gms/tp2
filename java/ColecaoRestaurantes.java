import java.util.*;
import java.io.*;

public class ColecaoRestaurantes{
  private int tamanho;
  Restaurante[] restaurantes;
  public ColecaoRestaurantes(){
    this.tamanho = 0;
    this.restaurantes = new Restaurante[1000];
  }
  int getTamanho(){return tamanho;}
  public Restaurante[] getRestaurantes(){return restaurantes;}
  
  public void lerCsv(String path) throws Exception{
    File csv = new File(path);
    Scanner sc = new Scanner(csv);

    while(sc.hasNextLine() && tamanho < restaurantes.length){
      String linha = sc.nextLine();

        if(linha.length() > 0){
        Restaurante r = Restaurante.parseRestaurante(linha);
        this.restaurantes[tamanho] = r;
        this.tamanho++;
      }
    }
    sc.close();
  }
  public static ColecaoRestaurantes lerCsv() throws Exception{
    ColecaoRestaurantes colecao = new ColecaoRestaurantes();
    colecao.lerCsv("/home/augusto/restaurantes.csv");
    return colecao;
  }
}
