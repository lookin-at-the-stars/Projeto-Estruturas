// arquivo: src/apl2/Node.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {
    private String id;
    private String nome;
    private float nota;
    private Node anterior;
    private Node proximo;

    // Construtor
    public Node(String id, String nome, float nota) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
		//ANTERIOR = NO ANTERIOR NÓ USADO NA LINKED LIST (AINDA NÃO FEITO)
        this.anterior = null;
		//POXIMO = NO PROXIMO NÓ USADO NA LINKED LIST (AINDA NÃO FEITO)
        this.proximo = null;
    }

	 public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getNota() {
        return nota;
    }

    public Node getAnterior() {
        return anterior;
    }

    public Node getProximo() {
        return proximo;
    }

	public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
	
	 @Override
    public String toString() {
        return id + ";" + nome + ";" + nota;
    }
}
