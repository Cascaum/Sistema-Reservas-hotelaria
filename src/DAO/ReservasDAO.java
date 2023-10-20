/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Reservas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */

// DEFINE O ACESSO PARA MANIPULAR OS DADOS DA RESERVA
public interface ReservasDAO {
    public DefaultTableModel mostrar(String buscar); // MÉTODO RESPONSÁVEL POR EXIBIR AS FUNÇÕES ADOTADAS PARA O RESERVA
    public boolean inserir(Reservas dts); // MÉTODO RESPONSÁVEL POR POR INSERIR DADOS DE UM RESERVA
    public boolean editar(Reservas dts); // MÉTODO RESPONSÁVEL POR POR EDITAR DADOS DE UM RESERVA
    public boolean pago(Reservas dts); // MÉTODO RESPONSÁVEL POR IMPLEMENTAR AS FUNÇÕES RELACIONADAS AO PAGAMENTO DA RESERVA
    public boolean deletar(Reservas dts); // MÉTODO RESPONSÁVEL POR POR DELETAR DADOS DE UM RESERVA
    
}
