import java.util.*;

public class Hora{
  private int hora;
  private int minuto;
  public Hora(int hora, int minuto){
      this.hora = hora;
      this.minuto = minuto;
  }
  int getHora(){return this.hora;}
  int getMinuto(){return this.minuto;}
  void setHora(int hora)}{
    if(hora > 23){
      System.out.println("erroHora");
    }else{
      this.hora = hora;
    }
  }
void setMinuto(int minuto){
  if(minuto > 59){
    System.out.println("erroMinuto");
  }else{
    this.minuto = minuto;
  }
}
  public static parseHora(String s){
    Scanner sc = new Scanner(s);

    sc.useDelimiter(":");
    sc.useDelimiter("-");
    int hora = sc.nextInt();
    int minuto = sc.nextInt();
    return new Hora(hora,minuto);
  }
  public String formatar(){
    return Stirng.format("%02d:%02d", hora,minuto);
  }
}
