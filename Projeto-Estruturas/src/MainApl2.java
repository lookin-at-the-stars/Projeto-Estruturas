//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// TODO: Colocar a identificação dos(as) integrantes aqui.
// TODO: Listar todas as referências consultadas para solucionar a atividade.

import apl2.DLinkedList;
import apl2.LinkedListOriginal;
import apl2.Node;
import apl2.Operation;

public class MainApl2 {
	
	public static void main(String[] args) {
		LinkedListOriginal list = new LinkedListOriginal();

		
		// TODO: Carregar o conteúdo do arquivo "dados.txt" e adicionar cada linha como um nó na LinkedListOriginal list.
		try {
			String dados = apl2.Data.loadTextFileToString("dados.txt");
			String[] linhas = dados.split("\n");
			for (String linha : linhas) {
				if (linha.trim().isEmpty()) continue;
				String[] partes = linha.split("#");
				int id = Integer.parseInt(partes[0]);
				String nome = partes[1];
				int inteiro = Integer.parseInt(partes[2]);
				int decimo = Integer.parseInt(partes[3]);
				list.append(id, nome, inteiro, decimo);
			}
		} catch (Exception e) {
			System.out.println("Erro ao carregar dados.txt: " + e.getMessage());
		}
		
		System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
		System.out.println(list);
		System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
		
		DLinkedList fixedList = Operation.map(list);
		System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
		System.out.println(fixedList);
		System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
		
		DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
		System.out.println(filteredGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
		
		DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
		System.out.println(filteredNonGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");

		float average = Operation.reduce(filteredGradedList);
		System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
		System.out.println(average);
		System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
		
		DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
		System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
		System.out.println(aboveAverageList);
		System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
		
		String contents = Operation.mapToString(fixedList);
		System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
		System.out.println(contents);
		System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
		
		
		// TODO: Salvar o conteúdo da String contents em um arquivo chamado "dados.csv".
		// Salvar o conteúdo da String contents em um arquivo chamado "dados.csv".
		try {
			apl2.Data.saveStringToTextFile("dados.csv", contents);
		} catch (Exception e) {
			System.out.println("Erro ao salvar dados.csv: " + e.getMessage());
		}
		
		Node test1 = fixedList.getNode("23.S1-999");
		System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

		Node test2 = fixedList.removeNode("23.S1-999");
		System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

		Node test3 = fixedList.getNode("23.S1-999");
		System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

		aboveAverageList.clear();
		System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

		DLinkedList testList = new DLinkedList();
		// Inserir um nó no início da lista testList com os dados ("ABC", "John Doe", 4.7f).
		testList.insert("ABC", "John Doe", 4.7f);
		// Inserir um nó no final da lista testList com os dados ("XYZ", "Jane Doe", 9.9f).
		testList.append("XYZ", "Jane Doe", 9.9f);
		// Inserir um nó no início da lista testList com os dados ("321", "Test", 2.3f).
		testList.insert("321", "Test", 2.3f);
		// Inserir um nó no final da lista testList com os dados ("Nothing", "Yada yada yada", 99.9f).
		testList.append("Nothing", "Yada yada yada", 99.9f);
		// Inserir um nó no início da lista testList com os dados ("qwerty", "QWERTY", 1.2f).
		testList.insert("qwerty", "QWERTY", 1.2f);
		// Inserir um nó no final da lista testList com os dados ("WASD", "wasd", 3.4f).
		testList.append("WASD", "wasd", 3.4f);
		// Inserir um nó no início da lista testList com os dados ("ijkl", "IJKL", 5.6f).
		testList.insert("ijkl", "IJKL", 5.6f);
		// Inserir um nó no final da lista testList com os dados ("1234", "Um Dois Tres Quatro", 7.8f).
		testList.append("1234", "Um Dois Tres Quatro", 7.8f);
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail());
		System.out.println("testList.removeHead(): " + testList.removeHead());
		System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail());
		System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		System.out.println("testList.getHead(): " + testList.getHead());
		System.out.println("testList.getTail(): " + testList.getTail() + '\n');
		// TODO: Inserir um nó no início da lista testList com os dados ("qwerty", "QWERTY", 1.2f).
		// TODO: Inserir um nó no final da lista testList com os dados ("WASD", "wasd", 3.4f).
		// TODO: Inserir um nó no início da lista testList com os dados ("ijkl", "IJKL", 5.6f).
		// TODO: Inserir um nó no final da lista testList com os dados ("1234", "Um Dois Tres Quatro", 7.8f).
		System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
		testList.clear();
		System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
	}

}
