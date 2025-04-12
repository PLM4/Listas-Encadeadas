package CircularSimples;

public class LinkedListCircular {

    private No cabeca;
    private No rabo;
    private int tamanho;

    public LinkedListCircular() {
        cabeca = null;
        rabo = null;
        this.tamanho = 0;
    }

    public void add(int valor) {
        No novoNo = new No(valor);
        if (isEmpty()) {
            cabeca = novoNo;
            rabo = novoNo;
            cabeca.setProximo(cabeca);
        } else {
            rabo.setProximo(novoNo);
            novoNo.setProximo(cabeca);
            rabo = novoNo;
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
        rabo.setProximo(cabeca);

        if (cabeca == null) {
            rabo = null;
        }
        this.tamanho--;
    }

    public void set(int index, int valor) {
        if (size() == 0) {
            System.out.println("Lista vazia.\n");
            return;
        }
    
        if (index < 0 || index >= size()) {
            System.out.println("Indice invalido.\n");
            return;
        }
    
        No atual = cabeca;
    
        for (int i = 0; i < index; i++) {
            atual = atual.getProximo();
        }
        
        atual.setValor(valor);
        System.out.println("Valor no indice " + index + " atualizado para valor: " + valor + "\n");
    }
    

    public void removeIndex(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Indice invalido ou lista vazia.\n");
            return;
        }

        if (index == 0) {
            cabeca = cabeca.getProximo();
            if (cabeca == null) {
                rabo = null;
            }
        } else {
            No atual = cabeca;

            for (int i = 0; i < index - 1; i++) {
                atual = atual.getProximo();
            }

            No removerNo = atual.getProximo();
            atual.setProximo(removerNo.getProximo());

            if (removerNo == rabo) {
                rabo = atual;
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

        if (cabeca.getValor() == valor) {
            cabeca = cabeca.getProximo();
            rabo.setProximo(cabeca);
            if (cabeca == null) {
                rabo = null;
            }
        } else {
            No atual = cabeca;

            for (int i = 0; i < size() - 1; i++) {
                if (valor == atual.getProximo().getValor()) {
                    No removerNo = atual.getProximo();
                    atual.setProximo(removerNo.getProximo());
                    break;
                }
                atual = atual.getProximo();
            }

        }
        this.tamanho--;
        System.out.println("O valor " + valor + " foi removido com sucesso.\n");
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
        if (isEmpty()) {
            System.out.println("Não há valor na lista.\n");
            return;
        }

        No atual = cabeca;

        do {
            System.out.printf(atual.getValor() + " -> ");
            atual = atual.getProximo();
        } while (atual != cabeca);

        System.out.println("Volta ao começo");
    }
}
