/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Quartos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */

// DEFINE O ACESSO PARA MANIPULAR OS DADOS DO QUARTO
public interface QuartosDAO {
    public DefaultTableModel mostrar(String buscar); // MÉTODO RESPONSÁVEL POR EXIBIR AS FUNÇÕES ADOTADAS PARA O QUARTO
    public DefaultTableModel mostrarquartos(String buscar); // MÉTODO RESPONSÁVEL POR EXIBIR AS FUNÇÕES ADOTADAS PARA O QUARTO VAGO 
    public boolean inserir(Quartos dts); // MÉTODO RESPONSÁVEL POR POR INSERIR DADOS DE UM QUARTO
    public boolean editar(Quartos dts); // MÉTODO RESPONSÁVEL POR POR EDITAR DADOS DE UM QUARTO
    public boolean desocupar(Quartos dts); // MÉTODO RESPONSÁVEL POR IMPLEMENTAR AS FUNÇÕES RELACIONADAS A DESOCUPAÇÃO DO QUARTO
    public boolean ocupar(Quartos dts); // MÉTODO RESPONSÁVEL POR IMPLEMENTAR AS FUNÇÕES RELACIONADAS A OCUPAÇÃO DO QUARTO
    public boolean deletar(Quartos dts); // MÉTODO RESPONSÁVEL POR POR DELETAR DADOS DE UM QUARTO
    
}
