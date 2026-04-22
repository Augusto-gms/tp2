package ordenacao;
import modelos.*;
import java.util.*;
import java.io.*;

public class HeapSort{
  private int comparacoes;
  private int movimentacoes;
  private long tempoExecucao;
  public HeapSort(){
    this.comparacoes = 0;
    this.movimentacoes = 0;
    this.tempoExecucao = 0;
  }
}
