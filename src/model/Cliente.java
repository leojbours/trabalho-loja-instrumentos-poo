/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import resources.FormatoData;

/**
 *
 * @author leonardo
 */
public class Cliente {

    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String endereco;
    private char sexo;

    public Cliente(String nome, LocalDate dataNascimento, String cpf, String endereco, Character sexo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.sexo = sexo;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CLIENTE ID #").append(id).append(" {\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Data nascimento: ").append(FormatoData.FORMATO_1.format(dataNascimento)).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Endereco: ").append(endereco).append("\n");
        sb.append("Sexo: ").append(sexo).append("\n");
        sb.append("}\n");
        
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
    
}

