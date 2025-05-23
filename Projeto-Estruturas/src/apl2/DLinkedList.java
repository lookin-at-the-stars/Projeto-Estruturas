package apl2;

// TODO: Colocar a identificação dos(as) integrantes aqui.

public class DLinkedList {
    private Node head;
    private Node tail;
    private int count;

    public DLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void insert(String id, String nome, float nota) {
        Node novo = new Node(id, nome, nota);
        if (isEmpty()) {
            head = tail = novo;
        } else {
            novo.setProximo(head);
            head.setAnterior(novo);
            head = novo;
        }
        count++;
    }

    public void append(String id, String nome, float nota) {
        Node novo = new Node(id, nome, nota);
        if (isEmpty()) {
            head = tail = novo;
        } else {
            tail.setProximo(novo);
            novo.setAnterior(tail);
            tail = novo;
        }
        count++;
    }

    public Node removeHead() {
        if (isEmpty()) return null;
        Node removido = head;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getProximo();
            head.setAnterior(null);
        }
        removido.setProximo(null);
        removido.setAnterior(null);
        count--;
        return removido;
    }

    public Node removeTail() {
        if (isEmpty()) return null;
        Node removido = tail;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getAnterior();
            tail.setProximo(null);
        }
        removido.setProximo(null);
        removido.setAnterior(null);
        count--;
        return removido;
    }

    public Node removeNode(String id) {
        Node atual = head;
        while (atual != null) {
            if (atual.getId().equals(id)) {
                if (atual == head) return removeHead();
                if (atual == tail) return removeTail();
                atual.getAnterior().setProximo(atual.getProximo());
                atual.getProximo().setAnterior(atual.getAnterior());
                atual.setProximo(null);
                atual.setAnterior(null);
                count--;
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public Node getHead() { return head; }
    public Node getTail() { return tail; }

    public Node getNode(String id) {
        Node atual = head;
        while (atual != null) {
            if (atual.getId().equals(id)) return atual;
            atual = atual.getProximo();
        }
        return null;
    }

    public int count() { return count; }
    public boolean isEmpty() { return head == null; }

    public void clear() {
        while (!isEmpty()) removeHead();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(count).append(")\n");
        Node atual = head;
        while (atual != null) {
            sb.append(atual.toString()).append(" -> \n");
            atual = atual.getProximo();
        }
        sb.append("null.");
        return sb.toString();
    }
}