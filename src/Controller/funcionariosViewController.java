/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.FuncionariosDAOimpl;
import Model.Funcionarios;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */
public class funcionariosViewController {

    private FuncionariosDAOimpl func = new FuncionariosDAOimpl(); // DECLARAÇÃO E INICIALIZAÇÃO DA "func" APARTIR DA "funcionariosDAOimpl"

    public int getQtdRegistros() { // CRIAÇÃO DE UM NOVO MÉTODO 
        return func.totalregistros; // RETORNA O VALOR "totalregistros" DE "funcionariosDAOimpl" REFERENCIANDO A "func"
    }
    // MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (funcionariosDAOimpl) 

    public DefaultTableModel mostrar(String buscar, DefaultTableModel modelo) {  // CRIA UMA "DefaultTableModel modelo" E CHAMA O MÉTODO "mostrar" REPASSANDO O "buscar" COMO REFERÊNCIA
        try { // BLOCO TRY RESPONSÁVEL POR CUIDAR DE EXCESSÕES QUE PODEM VIR A OCORRER
            modelo = func.mostrar(buscar); // RETORNA O MÉTODO MOSTRAR DA CLASSE "funcionariosDAOimpl" E ARMAZENA EM UM "modelo"
            return modelo; // RETORNA O "modelo"
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo; // RETORNA O MODELO CASO O TRY NÃO SEJA EXECUTADO
    }

    // MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (funcionariosDAOimpl)
    public boolean inserir(Funcionarios dts) {
        return func.inserir(dts);
    }

    // MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (funcionariosDAOimpl)
    public boolean editar(Funcionarios dts) {
        return func.editar(dts);
    }

    // MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (funcionariosDAOimpl)
    public boolean deletar(Funcionarios dts) {
        return func.deletar(dts);
    }

}
