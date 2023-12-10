/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.QuartosDAOimpl;
import Model.Quartos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */
public class quartosViewController {

    private QuartosDAOimpl func = new QuartosDAOimpl(); //DECLARAÇÃO E INICIALIZAÇÃO DA "func" APARTIR DA "QuartosDAOimpl"

    public int getQtdRegistros() { //CRIAÇÃO DE UM NOVO MÉTODO 
        return func.totalregistros; //RETORNA O VALOR "totalregistros" DE "QuartosDAOimpl" REFERENCIANDO A "func"
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (QuartosDAOimpl)
    public DefaultTableModel mostrar(String buscar, DefaultTableModel modelo) { //CRIA UMA "DefaultTableModel modelo" E CHAMA O MÉTODO "mostrar" REPASSANDO O "buscar" COMO REFERÊNCIA
        try { //BLOCO TRY RESPONSÁVEL POR CUIDAR DE EXCESSÕES QUE PODEM VIR A OCORRER
            modelo = func.mostrar(buscar); //RETORNA O MÉTODO MOSTRAR DA CLASSE "QuartosDAOimpl" E ARMAZENA EM UM "modelo"
            return modelo; //RETORNA O "modelo"
        } catch (Exception e) { //TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo; //RETORNA O MODELO CASO O TRY NÃO SEJA EXECUTADO
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (QuartosDAOimpl) 
    public boolean inserir(Quartos dts) {
        return func.inserir(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (QuartosDAOimpl)
    public boolean editar(Quartos dts) {
        return func.editar(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (QuartosDAOimpl)
    public boolean deletar(Quartos dts) {
        return func.deletar(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (QuartosDAOimpl)
    public boolean ocupar(Quartos dts) {
        return func.ocupar(dts);
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (QuartosDAOimpl)
    public boolean desocupar(Quartos dts) {
        return func.desocupar(dts);
    }
}
