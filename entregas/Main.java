import java.io.*;
import java.util.*;

//classe data
class Data{
  private int ano;
  private int mes;
  private int dia;

  public Data(int ano, int mes, int dia){
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  // metodos getters
  int getAno(){return this.ano;}

  int getMes(){return this.mes;}

  int getDia(){return this.dia;}

  // metodo parse para transformar a string em uma data
  public static Data parseData(String s){
    Scanner sc = new Scanner(s);

    sc.useDelimiter("-");
    int ano = sc.nextInt();
    int mes = sc.nextInt();
    int dia = sc.nextInt();
    sc.close();
    return new Data(ano, mes, dia);
  }

  // metodo para printar no formato correto de data
  public String formatar(){
    return String.format("%02d/%02d/%04d", dia, mes, ano);
  }
}

// classe hora
class Hora{
  private int hora;
  private int minuto;

  public Hora(int hora, int minuto){
    this.hora = hora;
    this.minuto = minuto;
  }

  // metodos getters
  public int getHora(){
    return this.hora;
  }

  public int getMinuto(){
    return this.minuto;
  }

  // metodos setters
  public void setHora(int hora){
    if(hora > 0 && hora < 24){
      this.hora = hora;
    }
  }

  public void setMinuto(int minuto){
    if(minuto > 0 && minuto < 60){
      this.minuto = minuto;
    }
  }

  // metodo parse para converter a string em horario
  public static Hora parseHora(String s){
    Scanner sc = new Scanner(s);

    sc.useDelimiter(":");
    int hora = sc.nextInt();
    int minuto = sc.nextInt();
    sc.close();
    return new Hora(hora, minuto);
  }

  // metodo para printar no formato correto de horario
  public String formatar(){
    return String.format("%02d:%02d", hora, minuto);
  }
}

// classe restaurante
class Restaurante{
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

  // construtor
  public Restaurante(int id, String nome, String cidade, int capacidade, double avaliacao, String tiposCozinha[],
      int faixaPreco, Hora horarioAbertura, Hora horarioFechamento, Data dataAbertura, boolean aberto){
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

  // getters
  public int getId(){return this.id;}
  public String getNome(){return this.nome;}
  public String getCidade(){return this.cidade;}
  public int getCapacidade(){return this.capacidade;}
  public double getAvaliacao(){return this.avaliacao;}
  public String[] getTiposCozinha(){return this.tiposCozinha;}
  public int getFaixaPreco(){return this.faixaPreco;}
  public Hora getHorarioAbertura(){return this.horarioAbertura;}
  public Hora getHorarioFechamento(){return this.horarioFechamento;}
  public Data getDataAbertura(){return this.dataAbertura;}
  public boolean getAberto(){return this.aberto;}

  // setters
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
    // locale para o doube ler . e nao ,
    sc.useLocale(Locale.US);
    sc.useDelimiter(",");

    // lendo id,nome,cidade,capacidade,avaliacao
    int id = sc.nextInt();
    String nome = sc.next();
    String cidade = sc.next();
    int capacidade = sc.nextInt();
    double avaliacao = sc.nextDouble();

    // lendo os tipos de cozinha e colocando no array tiposCozinha
    String tipos = sc.next();
    int tam = 1;
    for (int i = 0; i < tipos.length(); i++) {
      if(tipos.charAt(i) == ';')tam++;
    }
    Scanner tmp = new Scanner(tipos);
    tmp.useDelimiter(";");
    String[] tiposCozinha = new String[tam];
    int j = 0;
    while(j < tam)tiposCozinha[j++] = tmp.next();
    tmp.close();

    // lendo faixaPreco
    String preco = sc.next();
    int faixaPreco = preco.length();

    // lendo os horarioAbertura e horarioFechamento
    String horarios = sc.next();
    Scanner scH = new Scanner(horarios);
    scH.useDelimiter("-");
    // lendo horario de abertura
    Hora horarioAbertura = Hora.parseHora(scH.next());
    // lendo horairo de fechamento
    Hora horarioFechamento = Hora.parseHora(scH.next());
    scH.close();

    // lendo dataAbertura
    Data dataAbertura = Data.parseData(sc.next());
    // lendo aberto
    boolean aberto = sc.nextBoolean();

    sc.close();
    // criando novo Restaurante
    return new Restaurante(id, nome, cidade, capacidade, avaliacao, tiposCozinha, faixaPreco, horarioAbertura,
        horarioFechamento, dataAbertura, aberto);
  }

  public String formatar(){
    String tipos = "";
    String preco = "";
    // colocando os valores do array tiposCozinha em uma Stirng
    for(int i = 0; i < tiposCozinha.length; i++){
      tipos += tiposCozinha[i];
      if (i < tiposCozinha.length - 1) {
        tipos += ',';
      }
    }
    for(int i = 0; i < faixaPreco; i++){
      preco += "$";
    }
    // printando string formatada
    return String.format(Locale.US, "[%d ## %s ## %s ## %d ## %.1f ## [%s] ## %s ## %s-%s ## %s ## %b]", id, nome,
        cidade, capacidade, avaliacao, tipos, preco, horarioAbertura.formatar(), horarioFechamento.formatar(),
        dataAbertura.formatar(), aberto);
  }
}

// classe colecao
class ColecaoRestaurantes{
  private int tamanho;
  private Restaurante[] restaurantes;

  // construtor vazio para inicializar
  public ColecaoRestaurantes(){
    this.tamanho = 0;
    this.restaurantes = new Restaurante[1000];
  }

  // metodos getters
  public int getTamanho(){return tamanho;}
  public Restaurante[] getRestaurantes(){return restaurantes;}

  //processando o csv e mandando para a parse
  public void lerCsv(String path) throws Exception{
    File csv = new File(path);
    Scanner sc = new Scanner(csv);

    // "limpa" o cabecalho
    sc.nextLine();
    while(sc.hasNextLine() && tamanho < restaurantes.length){
      String linha = sc.nextLine();

      // percorre toda a linha chamando parse
      if(linha.length() > 0) {
        Restaurante r = Restaurante.parseRestaurante(linha);
        // recebe o restaurante e aumenta o tamanho
        this.restaurantes[this.tamanho++] = r;
      }
    }
    sc.close();
  }

  public static ColecaoRestaurantes lerCsv() throws Exception{
    ColecaoRestaurantes colecao = new ColecaoRestaurantes();
    //le o arquivo csv no caminho correto
    //colecao.lerCsv("/tmp/restaurantes.csv");
    colecao.lerCsv("/home/augusto/tp2/entregas/restaurantes.csv");
    return colecao;
  }

  public Restaurante pesquisarId(int id){
    Restaurante resp = null;
    // percorre todo o array buscando o id digitado
    for(int i = 0; i < tamanho; i++) {
      if(restaurantes[i].getId() == id) {
        resp = restaurantes[i];
        i = tamanho;
      }
    }
    return resp;
  }
}

// classe para os metodos de ordenacao
class Ordenacao{
  public static int comparacoes;
  public static int movimentacoes;
  private Restaurante[] array;
  private int n;

  public Ordenacao(){
    this.comparacoes = 0;
    this.movimentacoes = 0;
  }

  // metodo de ordenacao por isercao
  public void insercao(Restaurante[] array, int n){
    for(int i = 1; i < n; i++) {
      Restaurante tmp = array[i];
      movimentacoes++;
      int j = i - 1;
      comparacoes++;
      while((j >= 0) && (compareTo(array[j], tmp) > 0)){
        array[j + 1] = array[j];
        movimentacoes++;
        j--;
      }
      array[j + 1] = tmp;
      movimentacoes++;
    }
  }

  // metodo para trocar elementos
  private void swap(Restaurante[] array, int i, int j){
    Restaurante tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  // metodo para comparar
  private int compareTo(Restaurante e1, Restaurante e2){
    int resp = e1.getDataAbertura().getAno() - e2.getDataAbertura().getAno();
    if(resp == 0){
      resp = e1.getDataAbertura().getMes() - e2.getDataAbertura().getMes();
      if(resp == 0){
        resp = e1.getDataAbertura().getDia() - e2.getDataAbertura().getDia();
         if(resp == 0){
          resp = e1.getNome().compareTo(e2.getNome());
         }
      }
    }
    return resp;
  }
  // metodo de ordenacao por mergesort

  // pegando direita e esquerda
  public void mergesort(Restaurante[] array){
    this.array = array;
    sort(0, array.length - 1);
  }

  public void sort(int esq, int dir){
    if(esq < dir){
      int meio = (esq + dir) / 2;
      sort(esq, meio);
      sort(meio + 1, dir);
      intercalar(esq, meio, dir);
    }
  }

  // intercala direita e esquerda
  public void intercalar(int esq, int meio, int dir){
    int n1, n2, i, j, k;

    // definir tamanho dos dois subarrays
    n1 = meio - esq + 1;
    n2 = dir - meio;

    Restaurante[] a1 = new Restaurante[n1 + 1];
    Restaurante[] a2 = new Restaurante[n2 + 1];

    // inicializa primeiro subarray
    for(i = 0; i < n1; i++){
      a1[i] = array[esq + i];
    }
    // incializa segundo subarray
    for(j = 0; j < n2; j++){
      a2[j] = array[meio + j + 1];
    }
    // sentinelas para null
    a1[i] = a2[j] = null;

    // intercalacao
    for(i = j = 0, k = esq; k <= dir; k++){
      comparacoes++;
      if(a2[j] == null || (a1[i] != null && compareTo(a1[i], a2[j]) <= 0)){
        array[k] = a1[i++];
      }else{
        array[k] = a2[j++];
      }
      movimentacoes++;
    }
  }

  // metodo de ordenacao por heapsort
  public void heapsort(Restaurante[] array){
    this.n = array.length;
    // Alterar o vetor ignorando a posicao zero
    Restaurante[] tmp = new Restaurante[n + 1];
    for(int i = 0; i < n; i++){
      tmp[i + 1] = array[i];
    }
    this.array = tmp;

    // contrucao do heap
    for(int tamHeap = 2; tamHeap <= n; tamHeap++){
      construir(tamHeap);
    }
    // ordenacao
    int tamHeap = n;
    while(tamHeap > 1){
      swap(this.array, 1, tamHeap--);
      reconstruir(tamHeap);
    }
    // altera o vetor para voltar para posicao 0
    tmp = this.array;
    for(int i = 0; i < n; i++){
      array[i] = tmp[i + 1];
    }
  }

  // sobe o elemento ate sua posicao correta
  private void construir(int tamHeap){
    for(int i = tamHeap; i > 1 && compareTo(array[i], array[i / 2]) > 0; i /= 2){
      comparacoes++;
      swap(array, i, i / 2);
      movimentacoes++;
    }
  }

  // desce o elemtendo 1 ate sua posicao correta
  private void reconstruir(int tamHeap){
    int i = 1;
    while(i <= (tamHeap / 2)) {
      // pega maior filho pra compaarar com o pai
      int filho = getMaiorFilho(i, tamHeap);
      comparacoes++;
      if(compareTo(array[i], array[filho]) < 0){
        // se for menor troca e continua
        swap(array, i, filho);
        movimentacoes++;
        i = filho;
      }else{
        i = tamHeap;
      }
    }
  }

  // retorna o indice do maior filho
  public int getMaiorFilho(int i, int tamHeap){
    int filho;
    if(2 * i == tamHeap || compareTo(array[i * 2], array[2 * i + 1]) > 0){
      filho = 2 * i;
    }else{
      filho = 2 * i + 1;
    }
    return filho;
  }
}

class PesquisaSequencial{
  public static int comparacoes;
  public void pesquisar(Restaurante[] array, int n, String busca){
    boolean resp = false;
    for(int i = 0; i < n; i++){
      this.comparacoes++;
      if(compareTo(array[i], busca) == 0){
        resp = true;
        i = n;
      }
    }
    System.out.println(resp ? "SIM" : "NAO");
  }

  private int compareTo(Restaurante e1, String e2){
    int resp = e1.getNome().compareTo(e2);
    return resp;
  }
}
class Lista{
  private Restaurante[] array;
  private int n;
  //metodo construtor recebendo numero de registros
  public Lista(int tamanho){
    array = new Restaurante[tamanho];
    n = 0;
  }
  //metodos de insercao
  private void inserirInicio(Restaurante restaurante)throws Exception{
    if(n >= array.length)
      throw new Exception("erro ao inserir no inicio");
    for(int  i=n; i>0; i--){
      array[i] = array[i-1];
    }
    array[0] = restaurante;
    n++;
  }

  private void inserir(Restaurante restaurante, int pos)throws Exception{
    if(n >= array.length || pos < 0 || pos > n)
      throw new Exception("erro ao inserir em qualquer posicao");
    for(int i=n; i>pos; i--){
      array[i] = array[i-1];
    }
    array[pos] = restaurante;
    n++;
  }

  private void inserirFim(Restaurante restaurante)throws Exception{
    if(n>= array.length)
      throw new Exception("erro ao inserir no fim");
    array[n++] = restaurante;
  }

  //metodos de remocao
  private Restaurante removerInicio()throws Exception{
    if(n == 0)
      throw new Exception("erro ao remover no inicio");
    Restaurante resp = array[0];
    n--;
    for(int i=0; i<n; i++){
      array[i] = array[i+1];
    }
    return resp;
  }

  private Restaurante removerFim()throws Exception{
    if(n == 0)
      throw new Exception("erro ao remover do fim");
    return array[--n];
  }
  
  private Restaurante remover(int pos)throws Exception{
    if(n == 0 || pos < 0 || pos > n)
      throw new Exception("erro ao remover de qualquer posicao");
    Restaurante resp = array[pos];
    n--;
    for(int i=pos; i<n; i++){
      array[i] = array[i+1];
    }
    return resp;
  }

  public static void manipular(Restaurante[] array,int n,ColecaoRestaurantes c, Scanner sc)throws Exception{ 
    int num,pos; String op;
    num = sc.nextInt();
    Lista lista = new Lista(num+n);
    //colocando os restaurantes no fim
    for(int i=0; i<n; i++){
        lista.inserirFim(array[i]);
    }
    int k=0, id;
    Restaurante rm;
    //loop principal para ler todos registros
    while(k<num){
      op=sc.next();
      
      //verifica se a operacao eh de insercao
      if(op.charAt(0) == 'I'){
        if(op.charAt(1) == 'I'){
          id=sc.nextInt();
          Restaurante r = c.pesquisarId(id);
          lista.inserirInicio(r);
        }else if(op.charAt(1) == 'F'){
          id=sc.nextInt();
          Restaurante r = c.pesquisarId(id);
          lista.inserirFim(r);
        }else{
          pos=sc.nextInt();
          id=sc.nextInt();
          Restaurante r = c.pesquisarId(id);
          lista.inserir(r,pos);
        }
      }else if(op.charAt(0) == 'R'){
        if(op.charAt(1) == 'I'){
          rm=lista.removerInicio();
          System.out.println("(R)" + rm.getNome());
        }else if(op.charAt(1) == 'F'){
          rm=lista.removerFim();
          System.out.println("(R)" + rm.getNome());
        }else{
          pos=sc.nextInt();
          rm=lista.remover(pos);
          System.out.println("(R)" + rm.getNome());
        }
      //se nao for nem I nem R eh operacao invalida
      }else{
        System.out.println("operacao invalida");
      }
      k++;
    }
    lista.exibir();
  }

  public void exibir(){
    for(int i=0; i<n; i++){
      System.out.println(array[i].formatar());
    }
  }
}

public class Main{
  public static int isFim(String s){
    int resp = 0;
    if(s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M')resp = 1;
    return resp;
  }
  public static void exibir(Restaurante[] array,int n){
    for(int i=0; i<n; i++){
      System.out.println(array[i].formatar());
    }
  }
  public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);
    //variaveis pra contar tempo e nome do metodo de ordenacao/pesquisaa
    double inicio, fim;
    String metodo;
    //lendo dados do csv
    ColecaoRestaurantes colecao = ColecaoRestaurantes.lerCsv();
    int n = colecao.getTamanho();

    // criando array temporario para pegar os ids
    Restaurante[] tmp = new Restaurante[n];
    int id = 0, i = 0;
    id = sc.nextInt();
    while (id != -1) {
      Restaurante r = colecao.pesquisarId(id);
      if(r != null){
        tmp[i++] = r;
      }
      id = sc.nextInt();
    }

    // criando array correspondentes aos ids digitados
    Restaurante[] array = new Restaurante[i];
    for(int j = 0; j < i; j++) {
      array[j] = tmp[j];
    }
    
    //montando a lista passando array de ids, tamanho, array do csv e scanner(tava dando problema sem passar)
    //Lista.manipular(array,i,colecao,sc);

    
    
    //printando os restaurantes correspondentes aos ids digitados
    //exibir(array,i);
    
    //criando objeto de ordenacao
    Ordenacao ordenar = new Ordenacao();
    inicio = new Date().getTime();// inicia a cronometrar

    //METODOS DE ORDENACAO, DESCOMENTAR PRA USAR
    //ordenar.insercao(array, i); metodo="insercao";
    //ordenar.mergesort(array); metodo="mergesort";
    ordenar.heapsort(array); metodo="heapsort";
  
    fim = new Date().getTime();// termina de cronometrar
    double tempoExecucao = fim - inicio;
    //printa o array ordenado
    exibir(array,i);
    
    //cria log de acordo com os dados do metodo de ordenacao
    FileWriter fw = new FileWriter("898723_" + metodo + ".txt");
    fw.write("898723" + "\t" + Ordenacao.comparacoes + "\t" + Ordenacao.movimentacoes + "\t" + tempoExecucao);
    fw.close();



    /*
    //pesquisa sequencial
    PesquisaSequencial pesquisa = new PesquisaSequencial();
    //limpando buffer
    if(sc.hasNextLine())sc.nextLine();
    String busca = sc.nextLine();
    while(isFim(busca) == 0){
      //pesquisa.pesquisar(array,i,busca);
      busca = sc.nextLine();
    }
    */

    FileWriter fm = new FileWriter("898723_sequencial.txt");
    fm.write("898723" + "\t" + PesquisaSequencial.comparacoes + "\t");
    fm.close();
    sc.close();
  }
}
