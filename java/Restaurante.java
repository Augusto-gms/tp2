import java.util.*;
import java.util.Locale;

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
    if(avaliacao > 0.0 && avaliacao < 5.0){
      this.avaliacao = avaliacao;
    }else{
      System.out.println("erroAvaliacao");
    }
  }
  public void setTiposCozinha(String[] tiposCozinha){
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
    //locale para o doube ler . e nao ,
    sc.useLocale(Locale.US);
    sc.useDelimiter(",");

    //lendo id,nome,cidade,capacidade,avaliacao
    int id = sc.nextInt();
    String nome = sc.next();
    String cidade = sc.next();
    int capacidade = sc.nextInt();
    double avaliacao = sc.nextDouble();

    //lendo os tipos de cozinha e colocando no array tiposCozinha
    String tipos = sc.next();
    int tam = 1;
    for(int i = 0; i < tipos.length(); i++){
      if(tipos.charAt(i) == ';')tam++;
    }
    Scanner tmp = new Scanner(tipos);
    tmp.useDelimiter(";");
    String[] tiposCozinha = new String[tam];
    int j = 0;
    while(j < tam)tiposCozinha[j++] = tmp.next();
    tmp.close();

    //lendo faixaPreco
    int faixaPreco = sc.nextInt();

    //lendo os horarioAbertura e horarioFechamento
    String horarios = sc.next();
    Scanner scH = new Scanner(horarios);
    scH.useDelimiter("-");
    //lendo horario de abertura 
    Hora horarioAbertura = Hora.parseHora(scH.next());
    //lendo horairo de fechamento 
    Hora horarioFechamento = Hora.parseHora(scH.next());
    scH.close();

    //lendo dataAbertura
    Data dataAbertura = Data.parseData(sc.next());

    //lendo aberto
    boolean aberto = sc.nextBoolean();

    //criando novo Restaurante
    return new Restaurante(id,nome,cidade,capacidade,avaliacao,tiposCozinha,faixaPreco,horarioAbertura,horarioFechamento,dataAbertura,aberto);
  }
  public String formatar(){
    String tipos = "";
    String preco = "";
    //colocando os valores do array tiposCozinha em uma Stirng
    for(int i = 0; i < tiposCozinha.length; i++){tipos += tiposCozinha[i];}
    for(int i = 0; i < faixaPreco; i++){
      preco += "$";
    }
    //printando string formatada 
    return String.format("%d %s %s %d %s %s %s-%s %s %b",id,nome,cidade,capacidade,tipos,preco,horarioAbertura.formatar(),horarioFechamento.formatar(),dataAbertura.formatar(),aberto);
  }
}
