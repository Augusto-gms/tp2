import java.util.*;

public class Data{
  private int ano;
  private int mes;
  private int dia;
  public Data(int ano, int mes, int dia){
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }
  int getAno(){return this.ano;}
  int getMes(){return this.mes;}
  int getDia(){return this.dia;}
  public static Data parseData(String s){
    Scanner sc = new Scanner(s);

    sc.useDelimiter("-");
    int ano = sc.nextInt();
    int mes = sc.nextInt();
    int dia = sc.nextInt();
    sc.close();
    return new Data(ano,mes,dia);
  }
  public String formatar(){
    return String.format("%02d/%02d/%04d", dia,mes,ano);
  }
}
