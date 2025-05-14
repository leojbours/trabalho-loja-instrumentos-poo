/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Pedido;
import model.Produto;
import resources.Entrada;
import resources.FormatoData;

/**
 *
 * @author leonardo
 */
public class ControlaPedido {

    ArrayList<Pedido> pedidos = new ArrayList<>();
    ControlaCliente controlaCliente = null;
    ControlaProduto controlaProduto = null;

    public ControlaPedido(ControlaCliente controlaCliente, ControlaProduto controlaProduto) {
        this.controlaCliente = controlaCliente;
        this.controlaProduto = controlaProduto;
    }

    int contador = 1;

    public void salvar(Pedido pedido) {
        pedido.setId(contador);
        pedidos.add(pedido);
        contador++;
    }

    public ArrayList<Pedido> recuperarTodos() {
        return pedidos;
    }

    public Pedido recuperarPorId(int id) {
        Pedido pedido = null;

        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                pedido = p;
            }
        }

        return pedido;
    }

    public void editar(int id) {
        Pedido pedido = recuperarPorId(id);

        System.out.println(pedido);

        //Chama o metodo de recuperar cliente e define esse novo cliente no pedido
        pedido.setCliente(controlaCliente.recuperarPorId(Entrada.leiaInt("DIGITE O ID DA NOVA PESSOA")));
        //Altera a data, passa uma string formatando ela para passar pro LocalDate
        pedido.setData(LocalDate.parse(Entrada.leiaString("DIGITE A NOVA DATA"), FormatoData.FORMATO_1));
        //Chama o metodo alteraProduto do pedido e passa como parametro um produto recuperado por id

        String respostaAlteraProduto = Entrada.leiaString("DESEJA ALTERAR O PRODUTO?");

        char respostaAlteraProdutoChar = respostaAlteraProduto.trim().toUpperCase().charAt(0);

        if (respostaAlteraProdutoChar == 'S') {
            Produto produtoAlterado = controlaProduto.recuperarPorId(Entrada.leiaInt("DIGITE O CODIGO DO PRODUTO A SER MODIFICADO"));
            int quantidade = Entrada.leiaInt("DIGITE A NOVA QUANTIDADE DO PRODUTO");
            produtoAlterado.setQuantidade(quantidade);
            pedido.alteraProduto(produtoAlterado);

        }

        char confirmacao;

        String confirmacaoString = Entrada.leiaString("DESEJA ADICIONAR MAIS UM PRODUTO?");
        confirmacao = confirmacaoString.trim().toUpperCase().charAt(0);

        if (confirmacao == 'S') {
            while (confirmacao != 'N') {

                Produto produtoTemporario = controlaProduto.recuperarPorId(Entrada.leiaInt("DIGITE O ID DO PRODUTO A SER ADIONADO AO PEDIDO"));
                int quantidade = Entrada.leiaInt("DIGITE A QUANTIDADE DO PRODUTO");
                produtoTemporario.setQuantidade(quantidade);
                controlaProduto.diminuiEstoque(produtoTemporario, quantidade);
                pedido.adiconaProduto(produtoTemporario);

                confirmacaoString = Entrada.leiaString("DESEJA ADICIONAR MAIS UM PRODUTO?");
                confirmacao = confirmacaoString.trim().toUpperCase().charAt(0);

            }
        }

    }

    public void excluir(int id) {
        Pedido pedido = recuperarPorId(id);

        pedidos.remove(pedido);
    }
}
