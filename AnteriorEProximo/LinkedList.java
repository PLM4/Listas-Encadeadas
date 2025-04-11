package AnteriorEProximo;

public class LinkedList {

    private No cabeca;
    private No rabo;
    private int tamanho;

    public LinkedList() {
        cabeca = null;
        rabo = null;
        this.tamanho = 0;
    }

    public void add(int valor) {
        No novoNo = new No(valor);
        if (cabeca == null) {
            cabeca = novoNo;
            rabo = novoNo;
        } else {
            rabo.setProximo(novoNo);
            rabo = novoNo;
        }
        tamanho += 1;
    }

    public void removeCabeca() {
        if (size() == 0) {
            System.out.println("Não há valor na lista.\n");
        } else {
            System.out.println("O valor " + cabeca.getValor() + " foi removido com sucesso.\n");
            cabeca = cabeca.getProximo();
            this.tamanho--;
        }
    }

    public void removeIndex(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Indice invalido.");
            return;
        }

        if (index == 0) {
            cabeca = cabeca.getProximo();
            if (cabeca == null) {
                rabo = null;
            }
        } else {
            No atual = cabeca;

            for (int i = 0; i < index-1; i++) {
                atual = atual.getProximo();
            }

            No removerNo = atual.getProximo();
            atual.setProximo(removerNo.getProximo());

            if (removerNo == rabo) {
                rabo = atual;
            }
        }
        this.tamanho--;
        System.out.println("Indice " + index + " foi removido com sucesso.");
    }

    public int size() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "cabeca=" + cabeca +
                ", rabo=" + rabo +
                ", tamanho=" + tamanho +
                '}';
    }

    public void mostrarLista() {
        System.out.println(cabeca);
    }
}
