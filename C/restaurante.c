#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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
  int ano, mes, dia;
  sscanf(s, "%d-%d-%d", &ano, &mes, &dia);
  return criar_data(ano, mes, dia);
}
void formatar_data(Data* data, char* buffer){
  sprintf(buffer, "%02d/%02d/%04d", data->dia, data->mes, data->ano);
  printf("%s\n", buffer);
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
  int hora, minuto;
  sscanf(s, "%d:%d", &hora, &minuto);
  return criar_hora(hora, minuto);
}
void formatar_hora(Hora* horario, char* buffer){
  sprintf(buffer, "%02d:%02d", horario->hora, horario->minuto);
  printf("%s\n", buffer);
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

}
void formatar_restaurante(Restaurante* r, char* buffer){
  sprintf(buffer, "%d %s %s %d %lf %d %s %d %s %s %s %d", r->id,r->nome,r->cidade,r->capacidade,r->avaliacao,r->n_tipos_cozinha,r->tipos_cozinha,r->faixa_preco,r->horario_abertura,r->horario_fechamento,r->data_abertura,r->aberto);
  printf("%s\n", buffer);
}

int main(){
  //testando Data
  char* entrada = "2006-07-04";
  char saida[20];

  Data* data = parse_data(entrada);
  formatar_data(data, saida);

  //testando Hora
  char* entrada2 = "22:30";
  char saida2[10];

  Hora* hora = parse_hora(entrada2);
  formatar_hora(hora, saida2);

  //testando Restaurante
  char* entrada3 = "1,Central Park Bistro,São Paulo,150,4.5,Italiana;Francesa;Contemporânea,3,08:00-23:30,2006-01-02,true";
  char saida3[200];
  
  Restaurante* r(entrada3);
  formatar_restaurante(r, saida2);

  free(data);
  free(hora);
  free(r);
}
