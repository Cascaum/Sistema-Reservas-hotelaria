/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Quartos;
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
public class QuartosDAOimpl extends BDconexaoDAO implements QuartosDAO { // DECLARAÇÃO DA CLASSE "QuartosDAOimpl" QUE EXTENDE A CLASSE "BDconexaoDAO" E IMPLEMENTA A INTERFACE "QuartosDAO"

    private BDconexaoDAO mysql = new BDconexaoDAO(); // DECLARAÇÃO DA INSTÂNCIA "mysql"
    private Connection cn = mysql.conectar(); // DECLARAÇÃO DA INSTÂNCIA "cn"
    private String sSQL = ""; // DECLARAÇÃO DE UMA VARIAVEL "sSQL" INICIALMENTE VAZIA
    public Integer totalregistros; // DECLARAÇÃO DA VARIAVEL "totalregistros" QUE ACESSA E MOSTRA A QUANTIDADE DE REGISTROS NO BANCO

    @Override
    public DefaultTableModel mostrar(String buscar) { // DECLARAÇÃO DA CLASSE RESPONSAVEL PELA CONSULTA E RETORNO DOS DADOS DO BANCO
        DefaultTableModel modelo; // CRIA VARIAVEL PARA ARMAZENAR O MODELO DA TABELA DE INTERFACE GRÁFICA
        String[] titulos = {"ID", "Número", "Andar", "Descrição", "Caracteristicas", "Preço", "Estado", "Tipo de Quarto"}; // DEFINE O TÍTULO DAS COLUNAS NA LISTA QUE APARECE PARA VERIFICAÇÃO EM CADA TELA DO SISTEMA
        String[] registro = new String[8]; // DECLARA A QUANTIDADE DE REGISTROS
        totalregistros = 0; // DECLARA O TOTAL DE REGISTROS COMO SENDO ZERO INICIALMENTE

        modelo = new DefaultTableModel(null, titulos); // CRIA UMA "NOVA" TABELA E DEFINE A MESMA COMO "modelo". *Tabela = Lista de consulta que aparece no sistema
        sSQL = "select * from tb_quartos where andar like '%" + buscar + "%' order by id_quarto"; // CRIA UM SELECT DE CONSULTA SQL QUE SELECIONA OS CAMPOS DA TABELA "tb_quartos"
        // FILTRA A BUSCA BASEANDO-SE NO ANDAR DO QUARTO

        try { // BLOCO TRY RESPONSÁVEL POR EXECUTAR A CONSULTA DO sSQL
            Statement st = cn.createStatement(); // OBJETO USADO PARA EXECUTAR A CONSULTA
            ResultSet rs = st.executeQuery(sSQL); // OBJETO RETORNADO PELA CONSULTA PARA ITERAR PELOS REGISTROS
            boolean registrosEncontrados = false; // Variável para verificar se registros foram encontrados
            while (rs.next()) { // BUSCA CADA UM DOS REGISTROS NO BANCO E ADICIONA EM UMA NOVA LINHA NA TABELA
                registro[0] = rs.getString("id_quarto");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("andar");
                registro[3] = rs.getString("descricao");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("preco_diaria");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipo_quarto");

                totalregistros = totalregistros + 1; // VARIÁVEL RESPONSÁVEL POR CONTABILIZAR A QUANTIDADE DE REGISTROS NO BANCO
                modelo.addRow(registro); // ADICIONA UM NOVO REGISTRO A TABELA "modelo"
                
                registrosEncontrados = true; // Marcar que registros foram encontrados
            }
            if (!registrosEncontrados) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
            return modelo; // RETORNA O OBJETO "modelo" QUE CUIDA DA APRESENTAÇÃO DOS DADOS DA TABELA
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO DA CONSULTA
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    @Override
    public DefaultTableModel mostrarquartos(String buscar) { // DECLARAÇÃO DA CLASSE RESPONSAVEL PELA CONSULTA E RETORNO DOS DADOS DO BANCO REFERENTE AOS QUARTOS DISPONÍVEIS. *Usado na reserva.   
        DefaultTableModel modelo; // CRIA VARIAVEL PARA ARMAZENAR O MODELO DA TABELA DE INTERFACE GRÁFICA
        String[] titulos = {"ID", "Número", "Andar", "Descrição", "Caracteristicas", "Preço", "Estado", "Tipo de Quarto"}; // DEFINE O TÍTULO DAS COLUNAS NA LISTA QUE APARECE PARA VERIFICAÇÃO EM CADA TELA DO SISTEMA
        String[] registro = new String[8];  // DECLARA A QUANTIDADE DE REGISTROS
        totalregistros = 0; // DECLARA O TOTAL DE REGISTROS COMO SENDO ZERO INICIALMENTE

        modelo = new DefaultTableModel(null, titulos);  // CRIA UMA "NOVA" TABELA E DEFINE A MESMA COMO "modelo". *Tabela = Lista de consulta que aparece no sistema
        sSQL = "select * from tb_quartos where andar like '%" + buscar + "%' and estado='Disponível' order by id_quarto"; // CRIA UM SELECT DE CONSULTA SQL QUE SELECIONA OS CAMPOS DA TABELA "tb_quartos"
        // FILTRA A BUSCA BASEANDO-SE NO STATUS "Disponível" DO QUARTO

        try { // BLOCO TRY RESPONSÁVEL POR EXECUTAR A CONSULTA DO sSQL
            Statement st = cn.createStatement(); // OBJETO USADO PARA EXECUTAR A CONSULTA
            ResultSet rs = st.executeQuery(sSQL); // OBJETO RETORNADO PELA CONSULTA PARA ITERAR PELOS REGISTROS

            while (rs.next()) { // BUSCA CADA UM DOS REGISTROS NO BANCO E ADICIONA EM UMA NOVA LINHA NA TABELA
                registro[0] = rs.getString("id_quarto");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("andar");
                registro[3] = rs.getString("descricao");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("preco_diaria");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipo_quarto");

                totalregistros = totalregistros + 1; // VARIÁVEL RESPONSÁVEL POR CONTABILIZAR A QUANTIDADE DE REGISTROS NO BANCO
                modelo.addRow(registro); // ADICIONA UM NOVO REGISTRO A TABELA "modelo"
            }
            return modelo; // RETORNA O OBJETO "modelo" QUE CUIDA DA APRESENTAÇÃO DOS DADOS DA TABELA
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO DA CONSULTA
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    // FUNÇÃO QUE RECEBE A CLASSE "Quartos" RESPONSÁVEL POR INSERIR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean inserir(Quartos dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_quartos"
        sSQL = "insert into tb_quartos (numero, andar, descricao, caracteristicas, preco_diaria, estado, tipo_quarto)"
                + "values(?,?,?,?,?,?,?)";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS.
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getAndar());
            pst.setString(3, dts.getDescricao());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getValordiaria());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipoquarto());

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
    public boolean editar(Quartos dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA EDIÇÃO DOS DADOS NA TABELA "tb_quartos"
        sSQL = "update tb_quartos set numero=?, andar=?, descricao=?, caracteristicas=?, preco_diaria=?, estado=?, tipo_quarto=? "
                + "where id_quarto=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS.
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getAndar());
            pst.setString(3, dts.getDescricao());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getValordiaria());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipoquarto());
            pst.setInt(8, dts.getIdquarto());

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

    // FUNÇÃO QUE RECEBE A CLASSE "Quartos" RESPONSÁVEL POR EDITAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS E DESOCUPAR.
    @Override
    public boolean desocupar(Quartos dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA EDIÇÃO DOS DADOS NA TABELA "tb_quartos"
        sSQL = "update tb_quartos set estado='Disponível' "
                + "where id_quarto=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS.
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"

            pst.setInt(1, dts.getIdquarto());

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

    // FUNÇÃO QUE RECEBE A CLASSE "Quartos" RESPONSÁVEL POR EDITAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS E OCUPAR.
    @Override
    public boolean ocupar(Quartos dts) { 
        sSQL = "update tb_quartos set estado='Ocupado' " +
                "where id_quarto=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS.
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"

            pst.setInt(1, dts.getIdquarto());

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
    public boolean deletar(Quartos dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA DELEÇÃO DOS DADOS NA TABELA "tb_quartos"
        sSQL = "delete from tb_quartos where id_quarto=?";
        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS. 
            PreparedStatement pst = cn.prepareCall(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"

            pst.setInt(1, dts.getIdquarto());

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
