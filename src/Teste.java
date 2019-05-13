public class Teste {
    public static void main(String[] args) {
        ListaDuplamenteEncadeadaOrdenada lista = new ListaDuplamenteEncadeadaOrdenada();
        System.out.println(lista.size());
        lista.insere(1, "Joao");
        lista.insere(2, "Jose");
        lista.insere(1, "ze");
        lista.insere(2, "paula");
        lista.listar();
        lista.desistir("ze");
        lista.listar();
        lista.atender();
        lista.listar();
    }
    
}
