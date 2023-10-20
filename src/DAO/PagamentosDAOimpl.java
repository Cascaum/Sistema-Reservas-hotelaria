/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Pagamentos;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */

// CUIDA DA PARTE DE CONEXAO DO FORMULARIO COM O BANCO DE DADOS
public class PagamentosDAOimpl extends BDconexaoDAO implements PagamentosDAO { // DECLARAÇÃO DA CLASSE "PagamentosDAOimpl" QUE EXTENDE A CLASSE "BDconexaoDAO" E IMPLEMENTA A INTERFACE "PagamentosDAO"

    private BDconexaoDAO mysql = new BDconexaoDAO(); // DECLARAÇÃO DA INSTÂNCIA "mysql"
    private Connection cn = mysql.conectar(); // DECLARAÇÃO DA INSTÂNCIA "cn"
    private String sSQL = ""; // DECLARAÇÃO DE UMA VARIAVEL "sSQL" INICIALMENTE VAZIA
    public Integer totalregistros; // DECLARAÇÃO DA VARIAVEL "totalregistros" QUE ACESSA E MOSTRA A QUANTIDADE DE REGISTROS NO BANCO

    @Override
    public DefaultTableModel mostrar(String buscar) { // DECLARAÇÃO DA CLASSE RESPONSAVEL PELA CONSULTA E RETORNO DOS DADOS DO BANCO     
        DefaultTableModel modelo; // CRIA VARIAVEL PARA ARMAZENAR O MODELO DA TABELA DE INTERFACE GRÁFICA
        String[] titulos = {"ID Pagamento", "ID Reservas", "Tipo Comprovante", "Num Comprovante", "Taxa", "Total Pagamento", "Data Emissão", "Data Pagamento"}; // DEFINE O TÍTULO DAS COLUNAS NA LISTA QUE APARECE PARA VERIFICAÇÃO EM CADA TELA DO SISTEMA
        String[] registro = new String[8]; // DECLARA A QUANTIDADE DE REGISTROS
        totalregistros = 0; // DECLARA O TOTAL DE REGISTROS COMO SENDO ZERO INICIALMENTE

        modelo = new DefaultTableModel(null, titulos); // CRIA UMA "NOVA" TABELA E DEFINE A MESMA COMO "modelo". *Tabela = Lista de consulta que aparece no sistema
        sSQL = "select * from tb_pagamentos where id_reserva=" + buscar + " order by id_pagamento"; // CRIA UM SELECT DE CONSULTA SQL QUE SELECIONA OS CAMPOS DA TABELA "tb_pagamentos"
        // FILTRA A BUSCA BASEANDO-SE NO ID DA RESERVA

        try { // BLOCO TRY RESPONSÁVEL POR EXECUTAR A CONSULTA DO sSQL
            Statement st = cn.createStatement(); // OBJETO USADO PARA EXECUTAR A CONSULTA
            ResultSet rs = st.executeQuery(sSQL); // OBJETO RETORNADO PELA CONSULTA PARA ITERAR PELOS REGISTROS
            while (rs.next()) { // BUSCA CADA UM DOS REGISTROS NO BANCO E ADICIONA EM UMA NOVA LINHA NA TABELA
                registro[0] = rs.getString("id_pagamento");
                registro[1] = rs.getString("id_reserva");
                registro[2] = rs.getString("tipo_comprovante");
                registro[3] = rs.getString("num_comprovante");
                registro[4] = rs.getString("taxa");
                registro[5] = rs.getString("total_pagamento");
                registro[6] = rs.getString("data_emissao");
                registro[7] = rs.getString("data_pagamento");

                totalregistros = totalregistros + 1; // VARIÁVEL RESPONSÁVEL POR CONTABILIZAR A QUANTIDADE DE REGISTROS NO BANCO
                modelo.addRow(registro); // ADICIONA UM NOVO REGISTRO A TABELA "modelo"
            }
            return modelo; // RETORNA O OBJETO "modelo" QUE CUIDA DA APRESENTAÇÃO DOS DADOS DA TABELA
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO DA CONSULTA
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    // FUNÇÃO QUE RECEBE A CLASSE "Pagamentos" RESPONSÁVEL POR INSERIR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean inserir(Pagamentos dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_pagamento"
        sSQL = "insert into tb_pagamento (id_reserva, tipo_comprovante, num_comprovante, taxa, total_pagamento, data_emissao, data_pagamento)"
                + "values(?,?,?,?,?,?,?)";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS.
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprovate());
            pst.setString(3, dts.getNum_comprovante());
            pst.setDouble(4, dts.getTaxa());
            pst.setDouble(5, dts.getTotal_pagamento());
            pst.setDate(6, java.sql.Date.valueOf(dts.getData_emissao().toString()));
            pst.setDate(7, java.sql.Date.valueOf(dts.getData_pagamento().toString()));

            // TRECHO RESPONSÁVEL POR VERIFICAR SE O INSERT OBTEVE SUCESSO
            int n = pst.executeUpdate(); // ARMAZENA A PRIMEIRA INSERÇÃO EM n
            if (n != 0) { // SE A PRIMEIRA INSERÇÃO OBTEVE SUCESSO 
                return true;
            } else {
                return false;
            }
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA INSERÇÃO DA QUERY
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    // FUNÇÃO QUE RECEBE A CLASSE "Quartos" RESPONSÁVEL POR EDITAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean editar(Pagamentos dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA EDIÇÃO DOS DADOS NA TABELA "tb_pagamentos"
        sSQL = "update tb_pagamentos set id_reserva=?, tipo_comprovante=?, num_comprovante=?, taxa=?, total_pagamento=?, data_emissao=?, data_pagamento=?"
                + "where id_pagamentto=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS.
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprovate());
            pst.setString(3, dts.getNum_comprovante());
            pst.setDouble(4, dts.getTaxa());
            pst.setDouble(5, dts.getTotal_pagamento());
            pst.setDate(6, java.sql.Date.valueOf(dts.getData_emissao().toString()));
            pst.setDate(7, java.sql.Date.valueOf(dts.getData_pagamento().toString()));
            pst.setInt(8, dts.getIdpagamento());

            // TRECHO RESPONSÁVEL POR VERIFICAR SE O INSERT OBTEVE SUCESSO
            int n = pst.executeUpdate(); // ARMAZENA A PRIMEIRA INSERÇÃO EM n
            if (n != 0) { // SE A PRIMEIRA INSERÇÃO OBTEVE SUCESSO
                return true;
            } else {
                return false;
            }
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA INSERÇÃO DA QUERY
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    // FUNÇÃO QUE RECEBE A CLASSE "Quartos" RESPONSÁVEL POR DELETAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean deletar(Pagamentos dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA DELEÇÃO DOS DADOS NA TABELA "tb_pagamentos"
        sSQL = "delete from tb_pagamentos where id_pagamento=?";
        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS.
            PreparedStatement pst = cn.prepareCall(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"

            pst.setInt(1, dts.getIdpagamento());

            // TRECHO RESPONSÁVEL POR VERIFICAR SE O INSERT OBTEVE SUCESSO
            int n = pst.executeUpdate(); // ARMAZENA A PRIMEIRA INSERÇÃO EM n
            if (n != 0) { // SE A SEGUNDA INSERÇÃO OBTEVE SUCESSO
                return true;
            } else {
                return false;
            }
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA INSERÇÃO DA QUERY
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
