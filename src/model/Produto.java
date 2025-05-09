/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maiconceppo
 * Aprimorado por Leonardo
 */
public class Produto {

    private int id;
    private String nome;
    private String tipo;
    private Double preco;
    private int quantidade = 0;
    private int quantidadeEstoque;

    // Construtor
    public Produto(String nome, String tipo, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PRODUTO ID #").append(id).append(" {\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Tipo: ").append(tipo).append("\n");
        sb.append("Preco: ").append(String.format("%.2f", preco)).append("\n");
        sb.append("Quantidade em estoque: ").append(quantidadeEstoque).append("\n");
        sb.append("Valor total em estoque: ").append(valorEmEstoque()).append("\n");
        sb.append("}\n");
        
        return sb.toString();
    }
    
    public Double valorEmEstoque() {
        return preco * quantidadeEstoque;
    }
    
    public Double valorProdutoQuantidade() {
        return preco * quantidade;
    }
    
    public void diminuiEstoque(int valor) {
        quantidadeEstoque -= valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
   
}
