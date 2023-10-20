/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Funcionarios;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */

// DEFINE O ACESSO PARA MANIPULAR OS DADOS DO FUNCIONARIO
public interface FuncionariosDAO {
    public DefaultTableModel mostrar(String buscar); // MÉTODO RESPONSÁVEL POR EXIBIR AS FUNÇÕES ADOTADAS PARA O FUNCIONARIO
    public boolean inserir (Funcionarios dts); // MÉTODO RESPONSÁVEL POR INSERIR AS FUNÇÕES ADOTADAS PARA O FUNCIONARIO
    public boolean editar (Funcionarios dts); // MÉTODO RESPONSÁVEL POR EDITAR AS FUNÇÕES ADOTADAS PARA O FUNCIONARIO
    public boolean deletar (Funcionarios dts); // MÉTODO RESPONSÁVEL POR DELETAR AS FUNÇÕES ADOTADAS PARA O FUNCIONARIO
    public DefaultTableModel login(String login, String senha); // MÉTODO RESPONSÁVEL POR MANUPULAR AS FUNÇÕES DE LOGIN ADOTADAS PARA O FUNCIONARIO

}
