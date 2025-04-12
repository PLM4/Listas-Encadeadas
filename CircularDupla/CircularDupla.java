package CircularDupla;

public class CircularDupla {

    private No cabeca;
    private No rabo;
    private int tamanho;

    public CircularDupla() {
        cabeca = null;
        rabo = null;
        this.tamanho = 0;
    }

    public void add(int valor) {
        No novoNo = new No(valor);
        if (isEmpty()) {
            cabeca = novoNo;
            rabo = novoNo;
            cabeca.setAnterior(rabo);
            rabo.setProximo(cabeca);
        } else {
            rabo.setProximo(novoNo);
            novoNo.setAnterior(rabo);
            rabo = novoNo;
            cabeca.setAnterior(rabo);
            rabo.setProximo(cabeca);
        }
        tamanho += 1;
    }

    public void remove() {
        if (cabeca == null) {
            System.out.println("Não há valor na lista.\n");
            return;
        }

        System.out.println("O valor " + cabeca.getValor() + " foi removido com sucesso.\n");

        cabeca = cabeca.getProximo();
        cabeca.setAnterior(rabo);
        rabo.setProximo(cabeca);

        if (cabeca == null) {
            rabo = null;
        }
        this.tamanho--;
    }

    public void set(int index, int valor) {
        No atual = cabeca;

        if (index < 0 || index >= size()) {
            System.out.println("Indice invalido ou lista vazia.\n");
            return;
        }

        if (cabeca == null || rabo == null) {
            cabeca.setValor(valor);
            rabo.setValor(valor);
        } else {
            for (int i = 0; i < index - 1; i++) {
                atual = atual.getProximo();
            }
        }
        atual.setValor(valor);
    }

    public void removeIndex(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Indice invalido ou lista vazia.\n");
            return;
        }

        if (index == 0) {
            cabeca = cabeca.getProximo();
            if (cabeca != null) {
                cabeca.setAnterior(rabo);
            } else {
                rabo.setProximo(cabeca);
            }
        } else {
            No atual = cabeca;

            for (int i = 0; i < index - 1; i++) {
                atual = atual.getProximo();
            }

            No anterior = atual.getAnterior();
            No proximo = atual.getProximo();

            if (anterior != null) {
                anterior.setProximo(proximo);
            }

            if (proximo != null) {
                proximo.setAnterior(anterior);
            } else {
                rabo = anterior;
            }
        }
        this.tamanho--;
        System.out.println("Indice " + index + " foi removido com sucesso.\n");
    }

    public void removePrimeiroValorCorrespondente(int valor) {
        if (isEmpty()) {
            System.out.println("Não há valor na lista.\n");
            return;
        }

        No atual = cabeca;

        do {
            if (atual.getValor() == valor) {
                No anterior = atual.getAnterior();
                No proximo = atual.getProximo();

                if (atual == cabeca) {
                    cabeca = proximo;
                    rabo.setProximo(cabeca);
                    cabeca.setAnterior(rabo);
                } else if (atual == rabo) {
                    rabo = anterior;
                    rabo.setProximo(cabeca);
                    cabeca.setAnterior(rabo);
                } else {
                    anterior.setProximo(proximo);
                    proximo.setAnterior(anterior);
                }

                this.tamanho--;
                System.out.println("O valor " + valor + " foi removido com sucesso.\n");
                return;
            }
            atual = atual.getProximo();
        } while (atual != cabeca);

        System.out.println("Valor não encontrado na lista.\n");
    }

    public int size() {
        return this.tamanho;
    }

    public void clear() {
        cabeca = null;
        rabo = null;
        tamanho = 0;
        System.out.println("Lista esvaziada com sucesso");
    }

    public void getNoByIndex(int index) {
        int indiceInterno = index - 1;

        if (indiceInterno < 0 || indiceInterno >= size()) {
            System.out.println("Indice invalido ou lista vazia.\n");
            return;
        }

        No atual = cabeca;

        for (int i = 0; i < indiceInterno; i++) {
            atual = atual.getProximo();
        }

        System.out.println("O valor do No é: " + atual.getValor() + "\n");
    }

    public void getFirst() {
        System.out.println("O primeiro valor é: " + cabeca);
    }

    public void getLast() {
        System.out.println("O ultimo valor é: " + rabo);
    }

    public boolean contains(int valor) {
        No atual = cabeca;

        if (cabeca.getValor() == valor) {
            return true;
        }

        for (int i = 0; i < size(); i++) {
            if (valor == atual.getProximo().getValor()) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public boolean isEmpty() {
        if (cabeca == null) {
            return true;
        }
        return false;
    }

    public int indexOf(int valor) {
        No atual = cabeca;

        for (int i = 0; i < size(); i++) {
            if (valor == atual.getValor()) {
                return i;
            }
            atual = atual.getProximo();
        }

        return -1;
    }

    public void mostrarLista() {
        No atual = cabeca;

        do {
            System.out.printf(atual.getValor() + " <-> ");
            atual = atual.getProximo();
        } while (atual != cabeca);
        System.out.println("Volta ao comeco da lista.\n");
    }
}
