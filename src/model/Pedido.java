/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author maiconceppo Aprimorado por leonardo
 */
public class Pedido {

    private int id;
    private LocalDate data;

    private Cliente cliente;

    private final ArrayList<Produto> produtos = new ArrayList<>();

    public Pedido(LocalDate data, Cliente cliente) {
        this.data = data;
        this.cliente = cliente;
    }

    public double valorTotal() {
        double soma = 0;
        for (Produto produto : produtos) {
            soma += produto.getPreco() * produto.getQuantidade();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //leonardo fez testa parte
        
        sb.append("Pedido #").append(id).append(" {\n");
        sb.append("CIENTE:").append(cliente.getNome()).append("\n");
        sb.append("PRODUTOS: \n");

        for (Produto produto : produtos) {
            sb.append(produto.getNome()).append(String.format(" (%d)", produto.getQuantidade()));
            sb.append("\n");
        }
        
        sb.append("VALOR TOTAL: ").append(String.format("%.2f", valorTotal()));
        
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void alteraProduto(Produto p) {
        for (Produto produto : produtos) {
            if (produto.getId() == p.getId()) { //Compara id para encontrar produto a ser alterado
                produto = p; //Salva o produto editado/alterado
            }
        }
    }
    
    public void adiconaProduto(Produto produto) {
        produtos.add(produto);
    }

}
