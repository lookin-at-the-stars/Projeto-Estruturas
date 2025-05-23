//*************************** ATENÇÃO! *****************************
// As assinaturas dos métodos desta classe não devem ser alteradas!
//*************************** ATENÇÃO! *****************************
// arquivo: src/apl2/Operation.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

package apl2;

import java.time.LocalDate;

public class Operation {

	/**
	 * <p>Recebe como parâmetro uma lista encadeada do tipo {@code LinkedListOriginal}, sendo que os nós da lista estão
	 * populados com o conteúdo da base de dados original (conteúdo do arquivo dados.txt).</p>
	 * <p>A operação {@code map()} deve mapear os dados originais para uma lista encadeada do tipo {@code DLinkedList} e
	 * retornar a referência da {@code DLinkedList} que possui os dados mapeados para a nova estrutura usada pelo sistema de notas.</p>
	 * 
	 * @param original Base de dados original carregada em uma {@code LinkedListOriginal}.
	 * @return Uma nova {@code DLinkedList} que contém o mapeamento da coleção de dados {@code original} para a nova estrutura usada pelo sistema de notas. 
	 */
    public static DLinkedList map(final LinkedListOriginal original) {
        DLinkedList novaLista = new DLinkedList();
        NodeOriginal atual = original.getHead();
        while (atual != null) {
            String idAntigo = String.format("%03d", atual.getId());
            String nome = atual.getNome();
            int inteiro = atual.getInteiro();
            int decimo = atual.getDecimo();

            float nota;
            if (inteiro == -1 || decimo == -1) {
                nota = 99.9f;
            } else {
                nota = Float.parseFloat(inteiro + "." + decimo);
            }

            String idNovo = gerarNovoId(idAntigo);
            novaLista.append(idNovo, nome, nota);
            atual = atual.getNext();
        }
        return novaLista;
    }
	private static String gerarNovoId(String idAntigo) {
        LocalDate hoje = LocalDate.now();
        int ano = hoje.getYear() % 100;
        int semestre = (hoje.getMonthValue() <= 6) ? 1 : 2;
        return String.format("%02d.S%d-%s", ano, semestre, idAntigo);
    }
	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveNonGraded()} deve filtrar os nós que não possuem notas válidas (caso de "ausência de nota")
	 * e retornar uma nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas válidas.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas válidas.
	 */
    public static DLinkedList filterRemoveNonGraded(final DLinkedList data) {
        DLinkedList filtrada = new DLinkedList();
        Node atual = data.getHead();
        while (atual != null) {
            if (atual.getNota() != 99.9f) {
                filtrada.append(atual.getId(), atual.getNome(), atual.getNota());
            }
            atual = atual.getProximo();
        }
        return filtrada;
    }

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveGraded()} deve filtrar os nós que possuem notas válidas e retornar uma nova lista do
	 * tipo {@code DLinkedList} contendo apenas os nós com notas inválidas (caso de "ausência de nota").</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas inválidas.
	 */
	    public static DLinkedList filterRemoveGraded(final DLinkedList data) {
        DLinkedList filtrada = new DLinkedList();
        Node atual = data.getHead();
        while (atual != null) {
            if (atual.getNota() == 99.9f) {
                filtrada.append(atual.getId(), atual.getNome(), atual.getNota());
            }
            atual = atual.getProximo();
        }
        return filtrada;
    }

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}, e a média de notas válidas, calculadas com a
	 * operação {@code reduce()}.</p>
	 * <p>A operação {@code filterRemoveBelowAverage()} deve filtrar os nós que possuem notas abaixo da média e retornar uma
	 * nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas acima da média.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @param average Média de notas válidas calculada com a operação {@code reduce()}.
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada somente com pessoas com notas maiores do que {@code average}.
	 */
	public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average) {
        DLinkedList filtrada = new DLinkedList();
        Node atual = data.getHead();
        while (atual != null) {
            if (atual.getNota() > average) {
                filtrada.append(atual.getId(), atual.getNome(), atual.getNota());
            }
            atual = atual.getProximo();
        }
        return filtrada;
    }
	
	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}.</p>
	 * <p>A operação {@code reduce()} deve calcular a média das notas contidas na coleção de dados passada como parâmetro e
	 * retornar a média calculada.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @return Média das notas ({@code float}) contidas na coleção de dados ({@code data}).
	 */
	    public static float reduce(final DLinkedList data) {
        float soma = 0;
        int qtd = 0;
        Node atual = data.getHead();
        while (atual != null) {
            if (atual.getNota() != 99.9f) {
                soma += atual.getNota();
                qtd++;
            }
            atual = atual.getProximo();
        }
        if (qtd == 0) return 0;
        return soma / qtd;
    }

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code mapToString()} deve mapear todos os nós da coleção de dados passada como parâmetro para uma única
	 * {@code String}, sendo que cada dado de uma pessoa é separado por ponto-e-vírgula (;) e cada pessoa é separada por uma
	 * quebra de linha.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return {@code String} com a coleção de dados separada por ponto-e-vírgula (dados de cada pessoa) e quebras de linha (cada pessoa).
	 */
	public static String mapToString(final DLinkedList data) {
        StringBuilder sb = new StringBuilder();
        Node atual = data.getHead();
        while (atual != null) {
            sb.append(atual.toString()).append("\n");
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}
