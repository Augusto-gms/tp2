#include <stdio.h>
#include <stdlib.h>

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

  free(data);
  free(hora);
}
