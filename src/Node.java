public class Node {
    int atendimento;
    String nome;
    Node anterior, proximo;

    public Node(int atendimento, String nome) {
        this.atendimento = atendimento;
        this.nome = nome;
        anterior = proximo = null;
    }
}
