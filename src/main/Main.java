/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.ControlaCliente;
import controller.ControlaPedido;
import controller.ControlaProduto;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Cliente;
import model.Pedido;
import model.Produto;
import resources.Entrada;
import resources.FormatoData;

/**
 *
 * @author leonardo
 */
public class Main {

    public static void main(String[] args) {

        ControlaProduto controlaProduto = new ControlaProduto();
        ControlaCliente controlaCliente = new ControlaCliente();
        ControlaPedido controlaPedido = new ControlaPedido();

        int opcao;

        do {

            opcao = Entrada.leiaInt(""
                    + "[1] Cadastrar cliente\n"
                    + "[2] Listar clientes\n"
                    + "[3] Consultar cliente\n"
                    + "[4] Excluir cliente\n"
                    + "[5] Editar cliente\n"
                    + "[6] Cadastrar produto\n"
                    + "[7] Listar produtos\n"
                    + "[8] Consultar produto\n"
                    + "[9] Excluir produto\n"
                    + "[10] Editar produto\n"
                    + "[11] Alterar estoque produto\n"
                    + "[12] Cadastrar pedido\n"
                    + "[13] Listar pedidos\n"
                    + "[14] Consultar pedido\n"
                    + "[15] Excluir pedido\n"
                    + "[16] Editar pedido\n");

            switch (opcao) {
                case 1: {
                    Cliente cliente = new Cliente(
                            Entrada.leiaString("DIGITE O NOME DA PESSOA"),
                            LocalDate.parse(Entrada.leiaString("DIGITE A DATA DE NASCIMENTO DA PESSOA dd/MM/yyyy"), FormatoData.FORMATO_1),
                            Entrada.leiaString("DIGITE O CPF DA PESSOA"),
                            Entrada.leiaString("DIGITE O ENDERECO DA PESSOA"),
                            Entrada.leiaChar("DIGITE O SEXO DA PESSOA")
                    ); //Cria novo cliente com entrada do usuario
                    controlaCliente.salvar(cliente); //Salva o cliente
                    break; //Encerra o case 1
                }

                case 2: {
                    ArrayList<Cliente> clientes = controlaCliente.recuperarTodos();
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente);
                    }
                    break;
                }

                case 3: {
                    Cliente cliente = controlaCliente.recuperarPorId(Entrada.leiaInt("DIGITE O ID DA PESSOA A SER CONSULTADA"));
                    System.out.println(cliente);
                    break;
                }

                case 4: {
                    controlaCliente.excluir(Entrada.leiaInt("DIGITE O ID DA PESSOA A EXCLUIR"));
                    break;
                }

                case 5: {
                    controlaCliente.editar(Entrada.leiaInt("DIGITE O ID DA PESSOA A EDITAR"));
                    break;
                }

                case 6: {
                    Produto produto = new Produto(
                            Entrada.leiaString("DIGITE O NOME DO PRODUTO"),
                            Entrada.leiaString("DIGITE O TIPO DO PRODUTO"),
                            Entrada.leiaDouble("DIGITE O VALOR DO PRODUTO"),
                            Entrada.leiaInt("DIGITE O ESTOQUE DO PRODUTO")
                    ); //Instancia novo produto com entrada do usuario

                    controlaProduto.salvar(produto); //Salva o produto
                    break; //Encerra o case 1
                }

                case 7: {
                    ArrayList<Produto> produtos = controlaProduto.recuperarTodos();
                    for (Produto produto : produtos) {
                        System.out.println(produto);
                    }
                    break;
                }

                case 8: {
                    Produto produto = controlaProduto.recuperarPorId(Entrada.leiaInt("DIGITE O ID DO PRODUTO A SER CONSULTADO"));
                    System.out.println(produto);
                    break;
                }

                case 9: {
                    controlaProduto.excluir(Entrada.leiaInt("DIGITE O ID DO PRODUTO A SER EXCLUIDO"));
                    break;
                }

                case 10: {
                    controlaProduto.editar(Entrada.leiaInt("DIGITE O ID DO PRODUTO A SER EDITADO"));
                    break;
                }

                case 11: {
                    controlaProduto.alterarEstoque(Entrada.leiaInt("DIGITE O ID DO PRODUTO A SER ALTERADO ESTOQUE"));
                    break;
                }

                case 12: {
                    Pedido pedido = new Pedido(
                            LocalDate.now(),
                            controlaCliente.recuperarPorId(Entrada.leiaInt("DIGITE O ID DO CLIENTE QUE ESTA FAZENDO O PEDIDO")));

                    char confirmacao;

                    do {

                        Produto produtoTemporario = controlaProduto.recuperarPorId(Entrada.leiaInt("DIGITE O ID DO PRODUTO A SER ADIONADO AO PEDIDO"));
                        int quantidade = Entrada.leiaInt("DIGITE A QUANTIDADE DO PRODUTO");
                        produtoTemporario.setQuantidade(quantidade);
                        controlaProduto.diminuiEstoque(produtoTemporario, quantidade);
                        pedido.adiconaProduto(produtoTemporario);

                        String confirmacaoString = Entrada.leiaString("DESEJA ADICIONAR MAIS UM PRODUTO?");
                        confirmacao = confirmacaoString.trim().toUpperCase().charAt(0);

                    } while (confirmacao != 'N');

                    controlaPedido.salvar(pedido); //Salva o produto
                    break; //Encerra o case 1
                }

                case 13: {
                    ArrayList<Pedido> pedidos = controlaPedido.recuperarTodos();
                    for (Pedido pedido : pedidos) {
                        System.out.println(pedido);
                    }
                    break;
                }

                case 14: {
                    Pedido pedido = controlaPedido.recuperarPorId(Entrada.leiaInt("DIGITE O ID DO PEDIDO A SER CONSULTADO"));
                    System.out.println(pedido);
                    break;
                }

                case 15: {
                    controlaPedido.excluir(Entrada.leiaInt("DIGITE O ID DO PEDIDO A SER EXCLUIDO"));
                    break;
                }

                case 16: {
                    controlaPedido.editar(Entrada.leiaInt("DIGITE O ID DO PEDIDO A SER EDITADO"));
                    break;
                }
            }

        } while (opcao
                != 99);
        
    }
    
    
}
