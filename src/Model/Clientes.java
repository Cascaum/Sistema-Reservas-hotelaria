/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Pessoas;

/**
 *
 * @author rafas
 */

public class Clientes extends Pessoas { // CLASSE RESPONSÁVEL PELA CRIAÇÃO DAS VARIAVEIS QUE COMPÕE/DEFINEM OS CLIENTES NO SISTEMA, EXTENDENDO DADOS DA CLASSE PESSOAS
    private String codigo_cliente; // DECLARA O CÓDIGO DO CLIENTE

    // INICIA UM MÉTODO CONSTRUTOR VAZIO
    public Clientes() {
    }
    
    // INICIA O MÉTODO
    public Clientes(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    // INICIA OS MÉTODO GET´s | SET´s
    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    
    
}
