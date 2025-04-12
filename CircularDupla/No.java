package CircularDupla;

public class No {
    private int valor;
    private No anterior;
    private No proximo;

    public No(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "No [valor=" + valor +
                ", anterior= " + (anterior != null ? anterior.getValor() : "null") +
                ", proximo= " + (proximo != null ? proximo.getValor() : "null") + "]\n";
    }

}

