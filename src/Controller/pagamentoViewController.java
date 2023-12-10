/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.PagamentosDAOimpl;
import Model.Pagamentos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */
public class pagamentoViewController {

    private PagamentosDAOimpl func = new PagamentosDAOimpl(); //DECLARAÇÃO E INICIALIZAÇÃO DA "func" APARTIR DA "PagamentosDAOimpl"

    public int getQtdRegistros() { //CRIAÇÃO DE UM NOVO MÉTODO 
        return func.totalregistros; //RETORNA O VALOR "totalregistros" DE "PagamentosDAOimpl" REFERENCIANDO A "func"
    }
//MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (PagamentosDAOimpl)

    public DefaultTableModel mostrar(String buscar, DefaultTableModel modelo) { //CRIA UMA "DefaultTableModel modelo" E CHAMA O MÉTODO "mostrar" REPASSANDO O "buscar" COMO REFERÊNCIA
        try {//BLOCO TRY RESPONSÁVEL POR CUIDAR DE EXCESSÕES QUE PODEM VIR A OCORRER
            modelo = func.mostrar(buscar); //RETORNA O MÉTODO MOSTRAR DA CLASSE "clientesDAOimpl" E ARMAZENA EM UM "modelo"
            return modelo; //RETORNA O "modelo"
        } catch (Exception e) { //TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo; //RETORNA O MODELO CASO O TRY NÃO SEJA EXECUTADO
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (PagamentosDAOimpl)
    public boolean inserir(Pagamentos dts) {
        return func.inserir(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (PagamentosDAOimpl)
    public boolean editar(Pagamentos dts) {
        return func.editar(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (PagamentosDAOimpl)
    public boolean deletar(Pagamentos dts) {
        return func.deletar(dts);
    }

}
