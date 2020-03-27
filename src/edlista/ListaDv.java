package edlista;

public class ListaDv {

    private int tamanho;
    private int fim;
    private Item[] vetor;

    public ListaDv() {

        tamanho = 0;
        fim = -1;
        vetor = null;

    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean setTamanho(int tamanho) {

        if (tamanho <= 2 || tamanho >= 20) {
            this.tamanho = tamanho;
            return false;
        }

        fim = -1;
        tamanho = tamanho;
        vetor = new Item[tamanho];
        return true;

    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public boolean vazia() {
        return (fim == -1);

    }

    public boolean Cheia() {
        return ((fim + 1) == tamanho);
    }

    public boolean AdicionaFinal(Item item) {
        if (Cheia() == true) {
            return false;
        } else {
            fim++;
            vetor[fim] = item;
            return true;
        }

    }

    public Item consultar(Item item) {
        if (vazia() == true) {
            return null;
        }
        int i;

        for (i = 0; i <= fim && item.getDescricao() != vetor[i].getDescricao(); i++);

        if (i > fim) {
            return null;
        }

        Item retorno = new Item();
        retorno.setDescricao(vetor[i].getDescricao());
        retorno.setQuant(vetor[i].getQuant());
        retorno.setPrioridade(vetor[i].getPrioridade());
        return retorno;

    }

    public Item retira(Item item) {

        if (vazia() == true) {
            return null;
        }
        int i;

        for (i = 0; i <= fim && item.getDescricao() != vetor[i].getDescricao(); i++);

        if (i > fim) {
            return null;
        }
        Item achei = vetor[i];

        for (; i < fim; i++) {
            vetor[i] = vetor[i + 1];
            vetor[i] = null;
            fim--;
        }
        return achei;
    }

    public boolean modificarItem(Item antigo, Item modificado) {

        if (vazia()) {
            return false;
        }

        int i;

        for (i = 0; i < fim && !antigo.getDescricao().equals(vetor[i].getDescricao()); i++);

        if (i > fim) {
            return false;
        }

        vetor[i] = modificado;

        return true;
    }
    
    public String getLista(){
        if(vazia()) return "lisa vazia!!!";
        
        String aux = " " ;
        
        for(int i=9;i<fim;i++){
            
            aux = aux + vetor[i].toString() + "\n";
        }
        return aux;
    }

}
