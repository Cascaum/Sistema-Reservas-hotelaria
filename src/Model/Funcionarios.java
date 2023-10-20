/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafas
 */

public class Funcionarios extends Pessoas{ // CLASSE RESPONSÁVEL PELA CRIAÇÃO DAS VARIAVEIS QUE COMPÕE/DEFINEM OS FUNCIONARIOS NO SISTEMA, EXTENDENDO DADOS DA CLASSE PESSOAS
    private Double salario; // DECLARA O SALARIO
    private String acesso; // DECLARA O ACESSO. SE É ADM OU NORMAL
    private String login; // DECLARA O LOGIN
    private String senha; // DECLARA A SENHA
    private String estado; // SABER SE O USUÁRIO ESTÁ LOGADO OU NÃO.

    // INICIA O MÉTODO CONSTRUTOR VAZIO
    public Funcionarios() {
    }
    
    // INICIA O MÉTODO CONSTRUTOR
    public Funcionarios(Double salario, String acesso, String login, String senha, String estado) {
        this.salario = salario;
        this.acesso = acesso;
        this.login = login;
        this.senha = senha;
        this.estado = estado;
    }

    // INICIA OS MÉTODO GET´s | SET´s
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
