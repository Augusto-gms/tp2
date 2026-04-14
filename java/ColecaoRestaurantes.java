public class ColecaoRestaurantes{
	int tamanho;
	Restaurante restaurantes[];
	public ColecaoRestaurantes(int tamanho, Restaurante[] restaurantes){
		this.tamanho = tamanho;
		this.restaurantes = restaurantes;
	}
	int getTamanho(){return this.tamanho;}
	Restaurante[]  getRestaurante(){return this.restaurante;}
	void setTamanho(int tamanho){
		this.tamanho = tamanho;
	}
	public void lerCsv(String path){
		File arquivo = new File(path);

		int tamanho = 0;
		Scanner cont = new Scanner(arquivo);
		while(cont.hasNextLine()){
			cont.nextLine();
			tamanho++;
		}
		cont.close();
		this.tamanho = tamanho;
			
	}
	
}
