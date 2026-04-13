import java.util.*;

public class Restaurantes{
  //variavaeis privadas
  private int id;
  private String nome;
  private String cidade;
  private int capacidade;
  private double avaliacao;
  private String tiposCozinha;
  private int faixaPreco;
  private Hora horarioAbertura;
  private Hora horarioFechamento;
  private Data dataAbertura;
  private boolean aberto;
  //metodo construtor
  public Restaurantes(int id, String nome, String cidade, int capacidade, double avaliacao, String tiposCozinha, int faixaPreco, Hora horarioAbertura, Hora horarioFechamento, Data dataAbertura, boolean aberto){
      this id = id;
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
  int getId(){return this.id;}
  String getNome(){return this.nome;}
  String getCidade(){return this.cidade;}
  int getCapacidade(){return this.capacidade;}//fzr set
  double getAvaliacao(){return this.avaliacao;}//fzr set
  String getTiposCozinha(){return this.tiposCozinha;}//fzr set
  int getFaixaPreco(){return this.faixaPreco;}//fzr set
  Hora getHorarioAbertura(){return this.horarioAbertura;}//fzr set
  Hora getHorarioFechamento(){return this.horarioFechamento;}//fzr set
  Data getDataAbertura(){return this.dataAbertura;}
  boolean getAberto(){return this.aberto;}//fzr set

  void setCapacidade(int capacidade){
      this.capacidade = capacidade; 
  }
  void setAvaliacao(double avaliacao){
      if(avaliacao > 5 || avaliacao < 0){
        System.out.println("erroAvaliacao");
      }else{
        this.avaliacao = avaliacao;
      }
  }
  void setTiposCozinha(String tiposCozinha){
    this.tiposCozinha = tiposCozinha;
  }
  void setFaixaPreco(String faixaPreco){
      if(faixaPreco.length > 4){
        System.out.println("erroFaixaPreco");
      }else{
        this.faixaPreco = Integer.parseInt(faixaPreco);
      }
  }
}
