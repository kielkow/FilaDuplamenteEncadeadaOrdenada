
public class ListaDuplamenteEncadeadaOrdenada {

    private Node inicio, fim;
    private int quantidade;

    public ListaDuplamenteEncadeadaOrdenada() {
        inicio = fim = null;
        quantidade = 0;
    }

    public boolean isEmpty() {
        return quantidade == 0;
    }

    public int size() {
        return quantidade;
    }

    public void insere(int atendimento, String nome) {
        if ((nome != "") && (atendimento == 1 || atendimento == 2)) {
            Node novo = new Node(atendimento, nome);
            if (isEmpty()) {
                inicio = fim = novo;
            } else if (atendimento == 2) {
                novo.anterior = fim;
                fim.proximo = novo;
                fim = novo;
            } else {
                Node aux = fim;
                while (aux.anterior.atendimento == 2) {
                    aux = aux.anterior;
                }
                aux.anterior.proximo = novo;
                novo.anterior = aux.anterior;
                aux.anterior = novo;
                novo.proximo = aux;
            }
            quantidade++;
        } else {
            System.out.println("Informacoes invalidas");
        }

    }

    public void desistir(String nome) {
        if (!isEmpty()) {
            Node aux = fim;
            while (aux.nome != nome) {
                aux = aux.anterior;
            }
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
            aux.proximo = aux.anterior = null;
            quantidade--;
        } else {
            System.out.println("Fila vazia");
        }
    }

    public void listar() {
        Node aux = inicio;
        for (int i = 0; i < quantidade; i++) {
            System.out.println(aux.nome);
            aux = aux.proximo;
        }
        
        Node preferencial = inicio;
        int cont = 0;
        for (int i = 0; i < quantidade; i++) {
            if(preferencial.atendimento == 1){
                cont++;
            }
            preferencial = preferencial.proximo;
        }
        
        Node normal = inicio;
        int cont2 = 0;
        for (int i = 0; i < quantidade; i++) {
            if(normal.atendimento == 2){
                cont2++;
            }
            normal = normal.proximo;
        }

        System.out.println("Total de Clientes:" + quantidade + "\n");
        System.out.println("Total de Clientes Preferenciais:" + cont + "\n");
        System.out.println("Total de Clientes Normais:" + cont2 + "\n");
    }

    public void atender() {
        inicio = inicio.proximo;
        inicio.anterior.proximo = null;
        inicio.anterior = null;
        quantidade--;
    }

}
