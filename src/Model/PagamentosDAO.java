/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Model.Pagamentos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */

// DEFINE O ACESSO PARA MANIPULAR OS DADOS DO PAGAMENTO
public interface PagamentosDAO {
    public DefaultTableModel mostrar(String buscar); // MÉTODO RESPONSÁVEL POR EXIBIR AS FUNÇÕES ADOTADAS PARA O PAGAMENTO
    public boolean inserir(Pagamentos dts); // MÉTODO RESPONSÁVEL POR POR INSERIR DADOS DE UM PAGAMENTO
    public boolean editar(Pagamentos dts); // MÉTODO RESPONSÁVEL POR POR EDITAR DADOS DE UM PAGAMENTO
    public boolean deletar(Pagamentos dts); // MÉTODO RESPONSÁVEL POR POR DELETAR DADOS DE UM PAGAMENTO
    
}
