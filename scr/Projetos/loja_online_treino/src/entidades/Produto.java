package entidades;

public class Produto {

    private String nome;
    private double preco;
    private int quantidade;

    // Construtor
    public Produto(String nome, double preco, int quantidade) {
        this.setNome(nome);
        this.setPreco(preco);
        this.quantidade = quantidade;
    }

    // Método para reduzir o estoque
    public boolean reduzirEstoque(int qtd) {
        if (quantidade >= qtd) {
            quantidade -= qtd;
            return true;
        }
        return false;
    }

    // Método para repor o estoque
    public void reporEstoque(int qtd) {
        this.quantidade += qtd;
    }

    @Override
    public String toString() {
        return getNome() + "," + getPreco() + "," + quantidade;
    }

    public static Produto fromString(String linha) {
        String[] parts = linha.split(",");
        return new Produto(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]));
    }

    // Getters e Setters
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
