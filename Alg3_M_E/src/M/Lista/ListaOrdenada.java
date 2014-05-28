package M.Lista;

/**
 * Classe responsavel pela ordena��o do dodos ontes da insers�o no arquivo
 * @author Neimar, Aur�lio *
 * @param <T>
 */
public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	/**
	 * M�todo de ordena��o de dados
	 * @param novo
	 * @return
	 */
	private Nodo<T> findBefore(Nodo<T> novo) {
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		
		while (atual != null) {
			
			if (atual.compareTo(novo) < 0) {
				anterior = atual;
				atual = atual.getNext();
			}
			
			if (atual.compareTo(novo) == 0)
				return atual;
			
			if (atual.compareTo(novo) > 0)
				return anterior;
		}
		return anterior;
	}
	
	
	@Override
	public void insert(Nodo<T> novo) {
		Nodo<T> anterior = findBefore(novo);
		if (anterior == null) {
			super.insert(novo);
		} else {
			super.insert(novo, anterior);
		}
	}


	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		insert(novo);
	}
	
	
	@Override
	public void append(Nodo<T> novo) {
		insert(novo);
	}
	
}