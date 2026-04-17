public class Main {
  public static void main(String[] args) {
    /*
    String sD = "2006-01-02";
    Data d = Data.parseData(sD); 
    System.out.println(d.formatar());

    String sH = "10:30";
    Hora h = Hora.parseHora(sH);
    System.out.println(h.formatar());
    */
    String dadosCsv = "1,Central Park Bistro,São Paulo,150,4.5,Italiana;Francesa;Contemporânea,3,08:00-23:30,2006-01-02,true";
    Restaurante r = Restaurante.parseRestaurante(dadosCsv);
    System.out.println(r.formatar());
  }
}
