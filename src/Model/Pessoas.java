/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafas
 */
public class Pessoas { // CLASSE RESPONSÁVEL PELA CRIAÇÃO DAS VARIAVEIS QUE COMPÕE/DEFINEM AS INFORMAÇÕES DAS PESSOAS NO SISTEMA
    private int id_pessoa; // DECLARA O ID DA PESSOA. *Definido como alto increment
    private String nome; // DECLARA O NOME.
    private String tipo_documento; // DECLARA O TIPO DO DOCUMENTO.
    private String num_documento; // DECLARA O NUMERO .
    private String endereco; // DECLARA O INDEREÇO.
    private String telefone; // DECLARA O TELEFONE.
    private String email; // DECLARA O EMAIL.

    // INICIA O MÉTODO CONSTRUTOR VAZIO
    public Pessoas() {
    }
 
    // INICIA O MÉTODO CONSTRUTOR
    public Pessoas(int id_pessoa, String nome, String tipo_documento, String num_documento, String endereco, String telefone, String email) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // INICIA OS MÉTODO GET´s | SET´s
    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
}
