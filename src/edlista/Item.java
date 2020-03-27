package edlista;

public class Item {

    private String descricao;
    private int quant;
    private int prioridade;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuant() {
        return quant;
    }

    public boolean setQuant(int quant) {
        if (quant > 0 && quant <= 10) {
            this.quant = quant;
            return true;
        } else {
            return false;
        }
    }

    public int getPrioridade() {
        return prioridade;
    }

    public boolean setPrioridade(int prioridade) {

        if (prioridade >= 1 && prioridade <= 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Item{" + "descricao=" + descricao + ", quant=" + quant + ", prioridade=" + prioridade + '}';
    }

}
