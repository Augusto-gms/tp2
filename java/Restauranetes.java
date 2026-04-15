import java.util.*;

public class Restaurante{
  // variáveis privadas
  private int id;
  private String nome;
  private String cidade;
  private int capacidade;
  private double avaliacao;
  private String tiposCozinha[];
  private int faixaPreco;
  private Hora horarioAbertura;
  private Hora horarioFechamento;
  private Data dataAbertura;
  private boolean aberto;

  //construtor
  public Restaurante(int id, String nome, String cidade, int capacidade, double avaliacao, String tiposCozinha[], int faixaPreco, Hora horarioAbertura, Hora horarioFechamento, Data dataAbertura, boolean aberto) {
    this.id = id;
    this.nome = nome;
    this.cidade = cidade;
    this.capacidade = capacidade;
    this.avaliacao = avaliacao;
    this.tiposCozinha = tiposCozinha;
    this.faixaPreco = faixaPreco;
    this.horarioAbertura = horarioAbertura;
    this.horarioFechamento = horarioFechamento;
    this.dataAbertura = dataAbertura;
    this.aberto = aberto;
  }

  //getters
  public int getId() { return this.id; }
  public String getNome() { return this.nome; }
  public String getCidade() { return this.cidade; }
  public int getCapacidade() { return this.capacidade; }
  public double getAvaliacao() { return this.avaliacao; }
  public String[] getTiposCozinha() { return this.tiposCozinha; }
  public int getFaixaPreco() { return this.faixaPreco; }
  public Hora getHorarioAbertura() { return this.horarioAbertura; }
  public Hora getHorarioFechamento() { return this.horarioFechamento; }
  public Data getDataAbertura() { return this.dataAbertura; }
  public boolean getAberto() { return this.aberto; }

  //setters
  public void setCapacidade(int capacidade){
    this.capacidade = capacidade;
  }
  public void setAvaliacao(double avaliacao){
    if(avaliacao > 0 && avaliacao < 5){
      this.avaliacao = avaliacao;
    }else{
      System.out.println("erroAvaliacao");
    }
  }
  public void setTiposCozinha(String tiposCozinha[]){
    this.tiposCozinha = tiposCozinha;
  }
  public void setFaixaPreco(int faixaPreco){
    this.faixaPreco = faixaPreco;
  }
  public void setHorarioAbertura(Hora horarioAbertura){
    this.horarioAbertura = horarioAbertura;
  }
  public void setHorarioFechamento(Hora horarioFechamento){
    this.horarioFechamento = horarioFechamento;
  }
  public void setAberto(boolean aberto){
    this.aberto = aberto;
  }
  public static Restaurante parseRestaurante(String s){
    Scanner sc = new Scanner(s);
    sc.useDelimiter(",");
    
    int id = sc.nextInt();
    String nome = sc.next();
    String cidade = sc.next();
    int capacidade = sc.nextInt();
    double avaliacao = sc.nextDouble();
    String tiposCozinha = sc.next();
    int faixaPreco = sc.nextInt();

    Hora abertura = Hora.parseHora(sc.next());
    Hora fechamento = Hora.parseHora(sc.next());
    Data data = Data.parseData(sc.next());

    boolean aberto = sc.nextBoolean();
    sc.close();
    return new Restaurante(id,nome,cidade,capacidade,avaliacao,tiposCozinha,faixaPreco,abertura,fechamento,data,aberto);
  }
}
