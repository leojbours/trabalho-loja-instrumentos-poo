/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import model.Cliente;
import java.util.ArrayList;
import resources.Entrada;
import resources.FormatoData;

/**
 *
 * @author leonardo
 */
public class ControlaCliente {
    
    ArrayList<Cliente> clientes = new ArrayList<>();
    
    int contador = 1;
    
    private static ControlaCliente instance;
    
    public static ControlaCliente getInstance() {
        if (instance == null) {
            instance = new ControlaCliente();
        }
        return instance;
    }
    
    public void salvar(Cliente cliente) {
        cliente.setId(contador);
        clientes.add(cliente); //adiciona pessoa no array
        contador++;
    }
    
    public ArrayList<Cliente> recuperarTodos() {
        return clientes; //Retorna array com pessoas;
    }
    
    public Cliente recuperarPorId(int id) {
        Cliente cliente = null;
        
        for (Cliente c : clientes) { //Repete para cada cliente c dentro de clientes
            if (c.getId() == id) { //Verifica se o codigo do cliente é o mesmo informado
                cliente = c; //Tira o cliente do vetor e coloca na variavel
            }
        }
        
        return cliente; //Retorna cliente, caso n tiver nenhum com id retorna nulo
    }
    
    public void editar(int id) {
        //Chama metodo de recuperar cliente por id e armazena esse cliente na variavel
        Cliente cliente = recuperarPorId(id);
        
        cliente.setNome(Entrada.leiaString("DIGITE O NOME DA PESSOA"));
        cliente.setDataNascimento(LocalDate.parse(Entrada.leiaString("DIGITE A DATA DE NASCIMENTO (dd/MM/yyyy)"), FormatoData.FORMATO_1));
        cliente.setCpf(Entrada.leiaString("DIGITE O CPF DA PESSOA"));
        cliente.setEndereco(Entrada.leiaString("DIGITE O ENDEREÇO DA PESSOA:"));
        cliente.setSexo(Entrada.leiaChar("DIGITE O SEXO DA PESSOA"));
    }
    
    public void excluir(int id) {
        //Chama metodo de recuperar cliente por id e armazena esse cliente na variavel
        Cliente cliente = recuperarPorId(id);
        
        clientes.remove(cliente); //Remove o cliente que acabamos de recuperar
        
    }
}
