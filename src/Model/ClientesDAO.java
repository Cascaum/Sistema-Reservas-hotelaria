/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Model.Clientes;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */

// DEFINE O ACESSO PARA MANIPULAR OS DADOS DO CLIENTE
public interface ClientesDAO { 
    public DefaultTableModel mostrar(String buscar); // MÉTODO RESPONSÁVEL POR EXIBIR AS FUNÇÕES ADOTADAS PARA O CLIENTE
    public boolean inserir (Clientes dts); // MÉTODO RESPONSÁVEL POR POR INSERIR DADOS DE UM CLIENTE
    public boolean editar (Clientes dts); // MÉTODO RESPONSÁVEL POR POR EDITAR DADOS DE UM CLIENTE
    public boolean deletar (Clientes dts); // MÉTODO RESPONSÁVEL POR POR DELETAR DADOS DE UM CLIENTE
    
}
