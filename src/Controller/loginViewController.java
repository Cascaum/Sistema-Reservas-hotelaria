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
public class loginViewController {

    private FuncionariosDAOimpl func = new FuncionariosDAOimpl(); //DECLARAÇÃO E INICIALIZAÇÃO DA "func" APARTIR DA "FuncionariosDAOimpl"

    public int getQtdRegistros() { //CRIAÇÃO DE UM NOVO MÉTODO 
        return func.totalregistros; //RETORNA O VALOR "totalregistros" DE "FuncionariosDAOimpl" REFERENCIANDO A "func"
    }

    //MÉTODO INTERMEDIARIO ENTRE O FRONT (FORMULÁRIO) E O BACK (FuncionariosDAOimpl)
    public DefaultTableModel realizarLogin(String usuario, String senha) { //CRIA UMA "DefaultTableModel modelo" E CHAMA O MÉTODO "mostrar" REPASSANDO O "buscar" COMO REFERÊNCIA
        try { //BLOCO TRY RESPONSÁVEL POR CUIDAR DE EXCESSÕES QUE PODEM VIR A OCORRER
            Funcionarios dts = new Funcionarios(); //CRIA INSTANCIA APARTIR DE "Funcionarios" E ATRIBUI A VARIAVEL "dts"
            dts.setLogin(usuario); //RECEBE USUARIO E CONFIGURA EM "dts"
            dts.setSenha(senha);//RECEBE SENHA E CONFIGURA EM "dts"

            return func.login(dts.getLogin(), dts.getSenha()); //RETORNA UMA FUNÇAO DE LOGIN USANDO OS DADOS INSERIDOS ANTERIORMENTE
        } catch (Exception e) { //TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO DA CONSULTA 
            JOptionPane.showMessageDialog(null, "Erro ao realizar login: " + e.getMessage());
            return new DefaultTableModel();
        }
    }
}
