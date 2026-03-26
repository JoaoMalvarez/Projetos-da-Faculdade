public class dequePrint <T>{
	private static final int TAM_DEQUE = 100;
	private	int inicio, fim, qtde, tamanho;
	private T e[ ];	
	// Construtor que Inicia o Deque
	// como vazio e tamanho padrão
	public dequePrint() {
		this(TAM_DEQUE);
	}
	// Construtor que Inicia o Deque
	// como vazio e tamanho informado
	// pelo usuário da classe
	public dequePrint(int tamanho) {
		this.inicio = 0;
		this.fim = 0;
		this.qtde = 0;
		this.tamanho = tamanho;
		this.e = (T[]) new Object[tamanho];
	}
	// Verifica se o Deque está vazio
	// retornando true (se vazio)
	// e false (caso contrário)
	public boolean qisEmpty( ) {
		return qtde == 0;
	}
	// Verifica se o Deque está cheio
	// retornando true (se cheio)
	// e false (caso contrário)

	public boolean qisFull( ) {
		return qtde == this.tamanho;
	}
	// Obtém o elemento do início do Deque
	public T getLeft ( ) throws Exception {
		if (! qisEmpty( )){
		    return e[inicio];
		} else {
			throw new Exception("deque empty");
		} 		
	}
	// Obtém o elemento do fim do deque 
	public T getRight ( ) throws Exception {
		if (! qisFull( )){
		    if (fim == 0)
		      return e[this.tamanho-1];
		    else
		      return e[fim-1];
		} else {
			throw new Exception("deque empty");
		} 
	}
	// Insere no “início-1” do Deque 	
	public void enqueueLeft ( T e ) throws Exception {
		if (! qisFull( )){
		    if (inicio == 0){
		      this.e[this.tamanho-1] = e;
		      inicio = this.tamanho-1;
		    } else this.e[--inicio] = e;
		    qtde++;
		  } else 
			  throw new Exception("deque overflow");		
	}
	// Insere no “fim” do Deque 
	public void enqueueRight ( T e ) throws Exception {
		if (! qisFull( )){
		    this.e[fim++] = e;
		    fim = fim % this.tamanho;
		    qtde++;
		} else 
			throw new Exception("deque overflow");
		
	}
	// Remove e retorna um elemento do início do Deque 
	public T dequeueLeft( ) throws Exception {
		T aux;
		if (! qisEmpty( )){
		   aux = e[inicio];
		   inicio = ++inicio % this.tamanho;
		   qtde--;
		   return aux;
		}else{
			throw new Exception("deque underflow");
		}
	}	
	// Remove e retorna um elemento  do final do Deque 
	public T dequeueRight( ) throws Exception {
		  T aux;
		  if (! qisEmpty( )){
		    if (fim == 0) {
		      aux = e[this.tamanho-1];
		      fim = this.tamanho-1;
		    } else {
		      aux = e[fim-1];
		      fim--;
		    }
		    qtde--;
		    return aux;
		  }else{
			  throw new Exception("deque underflow");
		  } 		
	}	
	// Retorna o total de elementos
	// armazenados no deque
	public int size() {
		return qtde;
	}
	
	@Override
	public String toString() {
	   try {
		int indiceNovo = (inicio + qtde) % e.length;
		
		StringBuilder sb = new StringBuilder();
		sb.append("[Deque] quantidade: ")
			.append(qtde)
			.append(", capacidade: ")
			.append(e.length);
		if (qtde != 0) {
			sb.append(", primeiro (Esquerda): ")
				.append(getLeft())
				.append(", último (Direita): ")
				.append(getRight());
		} 
		
		sb.append("\nConteudo do Deque': [ ");
		if (qtde != 0) {
			if (indiceNovo <= inicio) {
				for (int i = inicio; i < e.length; ++i)
					sb.append("[" + e[i] + "]");
				for (int i = 0; i < indiceNovo; ++i)
					sb.append("[" + e[i] + "]");
			} else {
				for (int i = inicio; i < indiceNovo; ++i)
					sb.append("[" + e[i] + "]");
			}
		}
		sb.append(" ]");
		return sb.toString();
	   }catch(Exception e) {
		   return "Erro: " + e.getMessage();
	   }
	}

}