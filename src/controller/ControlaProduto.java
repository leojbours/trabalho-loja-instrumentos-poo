/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Produto;
import resources.Entrada;

/**
 *
 * @author leonardo
 */
public class ControlaProduto {
    
    ArrayList<Produto> produtos = new ArrayList<>();
    int contador = 1;
    
    public void alterarEstoque(int id) {
        Produto produto = recuperarPorId(id);
        produto.setQuantidadeEstoque(Entrada.leiaInt("DIGITE O NOVO VALOR EM ESTOQUE"));
    }
    
    public void diminuiEstoque(Produto p, int quantidade) { 
        p.diminuiEstoque(quantidade);
    }
    
    public void salvar(Produto produto) {
        produto.setId(contador);
        produtos.add(produto);
        contador++;
    }
    
    public ArrayList<Produto> recuperarTodos() {
        return produtos;
    }
    
    public Produto recuperarPorId(int idProduto) {
        Produto produto = null;
        
        for (Produto p : produtos) {
            if (p.getId() == idProduto) {
                produto = p;
            }
        }
        
        return produto;
    }
    
    public void editar(int idProduto) {
        Produto produto = recuperarPorId(idProduto); //Recupera o produto pelo id informado
        
        //Define os novos valores do produto
        produto.setNome(Entrada.leiaString("DIGITE O NOME DO PRODUTO"));
        produto.setTipo(Entrada.leiaString("DIGITE O TIPO DO PRODUTO"));
        produto.setPreco(Entrada.leiaDouble("DIGITE O PREÇO DO PRODUTO"));
        produto.setQuantidadeEstoque(Entrada.leiaInt("DIGITE O PREÇO DO PRODUTO"));
    }
    
    public void excluir(int idProduto) {
        Produto produto = recuperarPorId(idProduto);
        
        produtos.remove(produto);
    }
}
