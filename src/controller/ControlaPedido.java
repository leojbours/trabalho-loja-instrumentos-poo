/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Pedido;
import resources.Entrada;
import resources.FormatoData;

/**
 *
 * @author leonardo
 */
public class ControlaPedido {

    ArrayList<Pedido> pedidos = new ArrayList<>();
    ControlaCliente controlaCliente = new ControlaCliente();
    ControlaProduto controlaProduto = new ControlaProduto();
    
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
        
        //Chama o metodo de recuperar cliente e define esse novo cliente no pedido
        pedido.setCliente(controlaCliente.recuperarPorId(Entrada.leiaInt("DIGITE O ID DA NOVA PESSOA")));
        //Altera a data, passa uma string formatando ela para passar pro LocalDate
        pedido.setData(LocalDate.parse(Entrada.leiaString("DIGITE A NOVA DATA"), FormatoData.FORMATO_1));
        //Chama o metodo alteraProduto do pedido e passa como parametro um produto recuperado por id
        pedido.alteraProduto(controlaProduto.recuperarPorId(Entrada.leiaInt("DIGITE O CODIGO DO PRODUTO A SER ALTERADO")));
    }

    public void excluir(int id) {
        Pedido pedido = recuperarPorId(id);
        
        pedidos.remove(pedido);
    }
}
