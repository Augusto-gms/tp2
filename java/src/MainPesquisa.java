import colecoes.*;
import java.util.*;
import modelos.*;
import pesquisa.*;

public class MainPesquisa{
  public static int isFim(String s){
    int resp = 0;
    if(s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){resp = 1;}
    return resp;
  }
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    try{
      //lendo arquivo csv
      ColecaoRestaurantes colecao = ColecaoRestaurantes.lerCsv();
      int n = colecao.getTamanho();

      //criando array temporario com o tamanho do csv
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
      //limpando buffer(so funcionou assim)
      sc.nextLine();
      //criando array com os ids correspondentes
      Restaurante[] array = new Restaurante[i];
      for(int j = 0; j < i; j++){
        array[j] = tmp[j];
      }
      //pesquisando de forma sequencial
      PesquisaSequencial p = new PesquisaSequencial();
      String busca = sc.nextLine();
      while(isFim(busca) != 1){
        p.pesquisar(array, i, busca);
        p.criarLog();
        busca = sc.nextLine();
      }
      sc.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}