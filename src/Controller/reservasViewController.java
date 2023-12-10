/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ReservasDAOimpl;
import Model.Reservas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */
public class reservasViewController {

    private ReservasDAOimpl func = new ReservasDAOimpl(); //DECLARAÇÃO E INICIALIZAÇÃO DA "func" APARTIR DA "ReservasDAOimpl"

    public int getQtdRegistros() { //CRIAÇÃO DE UM NOVO MÉTODO 
        return func.totalregistros; //RETORNA O VALOR "totalregistros" DE "ReservasDAOimpl" REFERENCIANDO A "func"
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (ReservasDAOimpl)
    public DefaultTableModel mostrar(String buscar, DefaultTableModel modelo) { //CRIA UMA "DefaultTableModel modelo" E CHAMA O MÉTODO "mostrar" REPASSANDO O "buscar" COMO REFERÊNCIA
        try { //BLOCO TRY RESPONSÁVEL POR CUIDAR DE EXCESSÕES QUE PODEM VIR A OCORRER
            modelo = func.mostrar(buscar); //RETORNA O MÉTODO MOSTRAR DA CLASSE "ReservasDAOimpl" E ARMAZENA EM UM "modelo"
            return modelo; //RETORNA O "modelo"
        } catch (Exception e) { //TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo; //RETORNA O MODELO CASO O TRY NÃO SEJA EXECUTADO
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (ReservasDAOimpl)
    public boolean inserir(Reservas dts) {
        return func.inserir(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (ReservasDAOimpl)
    public boolean editar(Reservas dts) {
        return func.editar(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (ReservasDAOimpl)
    public boolean deletar(Reservas dts) {
        return func.deletar(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (ReservasDAOimpl)
    public boolean pago(Reservas dts) {
        return func.pago(dts);
    }
}
