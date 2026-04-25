#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int comparacoes=0;
int movimentacoes=0;

//"classe" Data
typedef struct{
  int ano;
  int mes;
  int dia;
} Data;

Data* criar_data(int ano, int mes, int dia){
  //alocando memoria do tamanho da struct
  Data* data = malloc(sizeof(Data));
  //construindo
  data->ano = ano;
  data->mes = mes;
  data->dia = dia;

  return data;
}
//metodos getters
int get_ano(Data* data){return data->ano;}
int get_mes(Data* data){return data->mes;}
int get_dia(Data* data){return data->dia;}
//metodos setters
void set_ano(Data* data, int ano){
  data->ano = ano;
}
void set_mes(Data* data, int mes){
  data->mes = mes;
}
void set_dia(Data* data, int dia){
  data->dia = dia;
}
//metodo parse
Data* parse_data(char* s){
  Data* data_mod = malloc(sizeof(Data));
  sscanf(s, "%d-%d-%d", &data_mod->ano, &data_mod->mes, &data_mod->dia);
  return data_mod;
}
void formatar_data(Data* data, char* buffer){
  sprintf(buffer, "%02d/%02d/%04d", data->dia, data->mes, data->ano);
}
//fim da "classe Data"

//inicio da "classe Hora"
typedef struct{
  int hora;
  int minuto;
} Hora;
//metodo construtor
Hora* criar_hora(int hora, int minuto){
  Hora* horario = malloc(sizeof(Hora));
  horario->hora = hora;
  horario->minuto = minuto;

  return horario;
}
//metodos getters
int get_hora(Hora* horario){return horario->hora;}
int get_minuto(Hora* horario){return horario->minuto;}
//metodos setters
void set_hora(Hora* horario, int hora){
  horario->hora = hora;
}
void set_minuto(Hora* horario, int minuto){
  horario->minuto = minuto;
}
//metodo parseHora
Hora* parse_hora(char* s){
  Hora* hora_mod = malloc(sizeof(Hora));
  sscanf(s, "%d:%d",&hora_mod->hora,&hora_mod->minuto);
  return hora_mod;
}
void formatar_hora(Hora* horario, char* buffer){
  sprintf(buffer, "%02d:%02d", horario->hora, horario->minuto);
}
//fim da "classe" Hora

//inicio da "classe" restaurante
typedef struct{
  int id;
  char* nome;
  char* cidade;
  int capacidade;
  double avaliacao;
  int n_tipos_cozinha;
  char** tipos_cozinha;
  int faixa_preco;
  Hora* horario_abertura;
  Hora* horario_fechamento;
  Data* data_abertura;
  int aberto;
} Restaurante;
//metodo construtor
Restaurante* criar_restaurante(int id, char* nome, char* cidade, int capacidade, double avaliacao, int n_tipos_cozinha, char** tipos_cozinha, int faixa_preco, 
Hora* horario_abertura, Hora* horario_fechamento, Data* data_abertura, int aberto){
  //alocando memoria
  Restaurante* restaurante = malloc(sizeof(Restaurante));
  //construindo variaveis
  restaurante->id = id;
  restaurante->nome = nome;
  restaurante->cidade = cidade;
  restaurante->capacidade = capacidade;
  restaurante->avaliacao = avaliacao;
  restaurante->n_tipos_cozinha = n_tipos_cozinha;
  restaurante->tipos_cozinha = tipos_cozinha;
  restaurante->faixa_preco = faixa_preco;
  restaurante->horario_abertura = horario_abertura;
  restaurante->horario_fechamento = horario_fechamento;
  restaurante->data_abertura = data_abertura;
  restaurante->aberto = aberto;

  return restaurante;
}
//metodos getters
int get_id(Restaurante* restaurante){return restaurante->id;}
char* get_nome(Restaurante* restaurante){return restaurante->nome;}
char* get_cidade(Restaurante* restaurante){return restaurante->cidade;}
int get_capacidade(Restaurante* restaurante){return restaurante->capacidade;}
double get_avaliacao(Restaurante* restaurante){return restaurante->avaliacao;}
int get_n_tipos_cozinha(Restaurante* restaurante){return restaurante->n_tipos_cozinha;}
char** get_tipos_cozinha(Restaurante* restaurante){return restaurante->tipos_cozinha;}
int get_faixa_preco(Restaurante* restaurante){return restaurante->faixa_preco;}
Hora* get_horario_abertura(Restaurante* restaurante){return restaurante->horario_abertura;}
Hora* get_horario_fechamento(Restaurante* restaurante){return restaurante->horario_fechamento;}
Data* get_data_abertura(Restaurante* restaurante){return restaurante->data_abertura;}
int get_aberto(Restaurante* restaurante){return restaurante->aberto;}

Restaurante* parse_Restaurante(char* s){
	Restaurante* r = malloc(sizeof(Restaurante));
  r->faixa_preco = 0;
  r->aberto = 0;
  r->nome = malloc(50*sizeof(char));
  r->cidade = malloc(50*sizeof(char));
	char tmp_ha[6],tmp_hf[6],tmp_da[11];
  char* tipos = malloc(30*sizeof(char));
  char preco[5], tmp_aberto[15];
  //lendo
	sscanf(s, "%d,%[^,],%[^,],%d,%lf,%[^,],%[^,],%[^-]-%[^,],%[^,],%s",&r->id,r->nome,r->cidade,&r->capacidade,&r->avaliacao,tipos,preco,tmp_ha,tmp_hf,tmp_da,tmp_aberto);
	r->horario_abertura = parse_hora(tmp_ha);
	r->horario_fechamento = parse_hora(tmp_hf);
	r->data_abertura = parse_data(tmp_da);
  r->aberto = (strcmp(tmp_aberto, "true") == 0) ? 1 : 0;
  //convertendo o preco em $ para int
  for(int k = 0; preco[k] != '\0'; k++){
    r->faixa_preco++;
  }
  //contando quantos tipos de cozinha tem
  r->n_tipos_cozinha = 1;
  int i = 0;
  while(tipos[i] != '\0'){
    if(tipos[i] == ';')
      r->n_tipos_cozinha++;
    i++;
  }
  //alocando memoria
  r->tipos_cozinha = malloc(r->n_tipos_cozinha*sizeof(char*));
  for(int k = 0; k < r->n_tipos_cozinha; k++){
    r->tipos_cozinha[k] = malloc(30*sizeof(char));
  }
  char* ptr = tipos;
  int j = 0;
  while(j < r->n_tipos_cozinha){
    int lido = 0;
    sscanf(ptr, "%[^;]%n", r->tipos_cozinha[j], &lido);
    ptr += lido+1;
    j++;
  }
  free(tipos);
  return r;
}
void formatar_restaurante(Restaurante* r, char* buffer){
  char tipos[50];
  int k = 0;
  for(int i = 0; i < r->n_tipos_cozinha; i++){
    int j = 0;
    while(r->tipos_cozinha[i][j] != '\0'){
      tipos[k++] = r->tipos_cozinha[i][j++];
    }
    if(i < r->n_tipos_cozinha - 1){
      tipos[k++] = ',';
    }
  }
  tipos[k] = '\0';
  char preco[6];
  for(int i = 0; i < r->faixa_preco; i++){
    preco[i] = '$';
  }
  preco[r->faixa_preco] = '\0';
  char tmp_ha[6], tmp_hf[6], tmp_da[11];
  formatar_hora(r->horario_abertura, tmp_ha);
  formatar_hora(r->horario_fechamento, tmp_hf);
  formatar_data(r->data_abertura, tmp_da);
  char* tmp_aberto = (r->aberto > 0) ? "true" : "false";
  sprintf(buffer, "[%d ## %s ## %s ## %d ## %.1f ## [%s] ## %s ## %s-%s ## %s ## %s]", r->id,r->nome,r->cidade,r->capacidade,r->avaliacao,tipos,preco,tmp_ha,tmp_hf,tmp_da,tmp_aberto);
  printf("%s\n", buffer);
}
//fim da "classe restaurante"

typedef struct{
  int tamanho;
  Restaurante** restaurantes;
} Colecao_Restaurantes;
//metodo construtor
Colecao_Restaurantes* criar_colecao(){
  //alocando memoria
  Colecao_Restaurantes* c = malloc(sizeof(Colecao_Restaurantes));
  c->tamanho = 0;
  c->restaurantes = malloc(1000*sizeof(Restaurante*));
  return c;
}
//metodos getters
int get_tamanho(Colecao_Restaurantes* c){return c->tamanho;}
Restaurante** get_restaurantes(Colecao_Restaurantes* c){return c->restaurantes;}

//processa cada restaurantte do arquivo restaurantes.csv
void ler_csv_colecao(Colecao_Restaurantes* c, char* path){
  FILE* file = fopen(path, "r");
  //verificando se o arquivo nao esta vazio
  if(file == NULL){
    printf("erro ao abrir arquivo");
    exit(EXIT_FAILURE);
  }
  char* linha = malloc(500*sizeof(char));
  //limpando cabecalho
  fgets(linha, 500, file);

  while(fgets(linha, 500, file) != NULL){
    if(linha[0] != '\0' && linha[0] != '\n'){
      Restaurante* r = parse_Restaurante(linha);
      c->restaurantes[c->tamanho++] = r;
    }
  }
  free(linha);
  fclose(file);
}
//le o caminho do arquivo
Colecao_Restaurantes* ler_csv(){
  Colecao_Restaurantes* c = criar_colecao();
  char* caminho = "/tmp/restaurantes.csv";
  //char* caminho = "/home/augusto/restaurantes.csv";
  ler_csv_colecao(c, caminho);
  return c;
}
//pesquisa o id digitado na main
Restaurante* pesquisarId(Colecao_Restaurantes* c,int id){
  Restaurante* resp = NULL;
  for(int i = 0; i < c->tamanho; i++){
    if(c->restaurantes[i]->id == id){
      resp = c->restaurantes[i];
      i = c->tamanho;
    }
  }
  return resp;
}
//metodo para trocar
void swap(Restaurante** array, int i, int j){
  Restaurante* tmp = array[i];
  array[i] = array[j];
  array[j] = tmp;
}

//metodo para comparar
int compare_to(Restaurante* e1, Restaurante* e2){
  int resp = strcmp(e1->nome, e2->nome);
  return resp;
}

//ordenando por slecao
void ordenar_selecao(Restaurante** array, int n){
  for(int i = 0; i < n; i++){
    int menor = i;
    for(int j = i+1; j<n; j++){
      if(compare_to(array[j], array[menor]) < 0)
        menor = j;
    }
    swap(array,i,menor);
  }
}

//pesquisando de forma binaria
void pesquisa_binaria(Restaurante** array, int n, char* busca){
  comparacoes=0;
  int resp=0, esq=0, dir=n-1;

  while(esq <= dir){
    comparacoes++;
    int meio = (esq+dir)/2;
    int decisao = strcmp(array[meio]->nome, busca);

    comparacoes++;
    if(decisao == 0){
      resp = 1;
      esq = dir+1;
    }else{
      comparacoes++;
      if(decisao < 0){
      esq = meio+1;
    }else{
      dir = meio-1;
    }
    }
  }
  printf("%s", resp ? "SIM\n" : "NAO\n");
}

void liberar_memoria(Colecao_Restaurantes* c) {
  for (int i = 0; i < c->tamanho; i++) {
    free(c->restaurantes[i]->nome);
    free(c->restaurantes[i]->cidade);
    free(c->restaurantes[i]->horario_abertura);
    free(c->restaurantes[i]->horario_fechamento);
    free(c->restaurantes[i]->data_abertura);

    for (int j = 0; j < c->restaurantes[i]->n_tipos_cozinha; j++) {
      free(c->restaurantes[i]->tipos_cozinha[j]);
    }
    free(c->restaurantes[i]->tipos_cozinha);
    free(c->restaurantes[i]);
  }
  // Libera a estrutura da coleção
  free(c->restaurantes);
  free(c);
}
//metodo para controlar o loop "FIM"
int isFim(char* s){
  int resp = 0;
  if(s[0] == 'F' && s[1] == 'I' && s[2] == 'M')resp = 1;
  return resp;
}
int main(){
  //variaveis para contar tempo de execucao
  clock_t inicio;
  clock_t fim;
  double tempoExecucao;
  //cria a colecao
  Colecao_Restaurantes* colecao = ler_csv();
  int n = colecao->tamanho;

  //cria um array temporario para pesquisar os ids
  Restaurante** tmp = malloc(n*sizeof(Restaurante*));
  int id=0, i=0;
  while(scanf("%d", &id) > 0){
    Restaurante* r = pesquisarId(colecao, id);
    if(r != NULL){
      tmp[i++] = r;
    }
  }
  //armazena em um array apenas os ids encontrados
  Restaurante** array = malloc(i*sizeof(Restaurante*));
  for(int j = 0; j < i; j++){
    array[j] = tmp[j];
  }
  
  //printa os restaurantes correspondentes aos ids idsos
  char saida[500];
  /*for(int j=0; j<i; j++){
    formatar_restaurante(array[j], saida);
  }*/

  //ordenando pelo metodo de selecao
  ordenar_selecao(array,i);
  /*for(int j=0; j<i; j++){
    formatar_restaurante(array[j],saida);
  }*/

  //pesquisando de forma binaria e criando log
  char busca[100];
  //comeco da execucao
  inicio = clock();
  //lendo ate \n \r. programa so funcionava no verde com \r no final
  while(scanf(" %[^\n\r]", busca) == 1 && isFim(busca) == 0){
    pesquisa_binaria(array,i,busca);
  }
  //fim da execucao
  fim = clock();
  tempoExecucao = ((double)(fim-inicio)/CLOCKS_PER_SEC) * 1000.0;
  //criando arquivo de log
  FILE* log_pesquisa = fopen("898723_binaria.txt", "w");
  if(log_pesquisa != NULL){
    fprintf(log_pesquisa, "898723\t%d\t%.1f\n", comparacoes, tempoExecucao);
    fclose(log_pesquisa);
  }

  //chama metodo para liberar e liberar memorira de tmp e array
  free(tmp);
  free(array);
  liberar_memoria(colecao);
}
