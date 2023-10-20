/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */
public class ClientesDAOimpl extends BDconexaoDAO implements ClientesDAO { // DECLARAÇÃO DA CLASSE "ClienteDAOimpl" QUE EXTENDE A CLASSE "BDconexaoDAO" E IMPLEMENTA A INTERFACE "ClientesDAO"
    private final BDconexaoDAO mysql = new BDconexaoDAO(); // DECLARAÇÃO DA INSTÂNCIA "mysql"
    private final Connection cn = mysql.conectar(); // DECLARAÇÃO DA INSTÂNCIA "cn"
    private String sSQL = ""; // DECLARAÇÃO DE UMA VARIAVEL "sSQL" INICIALMENTE VAZIA
    private String sSQL2 = ""; // DECLARAÇÃO DE UMA VARIAVEL "sSQL2" INICIALMENTE VAZIA
    public Integer totalregistros; // DECLARAÇÃO DA VARIAVEL "totalregistros" QUE ACESSA E MOSTRA A QUANTIDADE DE REGISTROS NO BANCO

    @Override
    public DefaultTableModel mostrar(String buscar) { // DECLARAÇÃO DA CLASSE RESPONSAVEL PELA CONSULTA E RETORNO DOS DADOS DO BANCO
        DefaultTableModel modelo; // CRIA VARIAVEL PARA ARMAZENAR O MODELO DA TABELA DE INTERFACE GRÁFICA
        String[] titulos = {"ID", "Nome", "Documento", "Numero DOC", "Endereço", "Telefone", "Email", "Código"}; // DEFINE O TÍTULO DAS COLUNAS NA LISTA QUE APARECE PARA VERIFICAÇÃO EM CADA TELA DO SISTEMA
        String[] registro = new String[8]; // DECLARA A QUANTIDADE DE REGISTROS
        totalregistros = 0; // DECLARA O TOTAL DE REGISTROS COMO SENDO ZERO INICIALMENTE

        modelo = new DefaultTableModel(null, titulos); // CRIA UMA "NOVA" TABELA E DEFINE A MESMA COMO "modelo". *Tabela = Lista de consulta que aparece no sistema
        // CRIA UM SELECT DE CONSULTA SQL QUE SELECIONA OS CAMPOS DA TABELA "tb_clientes"
        sSQL = "select p.id_pessoa,p.nome_pessoa,p.tipo_documento,p.num_documento,"
                + "p.endereco,p.telefone,p.email,c.codigo_cliente from tb_pessoas p inner join tb_clientes c "
                + "on p.id_pessoa=c.id_pessoa where num_documento like '%"
                + buscar + "%' order by id_pessoa desc";
        // FILTRA A BUSCA BASEANDO-SE NO NÚMERO DE DOCUMENTO DO USUÁRIO DO SISTEMA

        try { // BLOCO TRY RESPONSÁVEL POR EXECUTAR A CONSULTA DO sSQL 
            Statement st = cn.createStatement(); // OBJETO USADO PARA EXECUTAR A CONSULTA
            ResultSet rs = st.executeQuery(sSQL); // OBJETO RETORNADO PELA CONSULTA PARA ITERAR PELOS REGISTROS
            boolean registrosEncontrados = false; // Variável para verificar se registros foram encontrados
            while (rs.next()) { // BUSCA CADA UM DOS REGISTROS NO BANCO E ADICIONA EM UMA NOVA LINHA NA TABELA.
                registro[0] = rs.getString("id_pessoa");
                registro[1] = rs.getString("nome_pessoa");
                registro[2] = rs.getString("tipo_documento");
                registro[3] = rs.getString("num_documento");
                registro[4] = rs.getString("endereco");
                registro[5] = rs.getString("telefone");
                registro[6] = rs.getString("email");
                registro[7] = rs.getString("codigo_cliente");

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

    // FUNÇÃO QUE RECEBE A CLASSE "Clientes" RESPONSÁVEL POR INSERIR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean inserir(Clientes dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // VALIDAR SE JÁ NÃO EXISTEM UM DADO IGUAL
        String numeroDocumento = dts.getNum_documento(); // RECEBE O DADO
        String verificaSQL = "SELECT COUNT(*) FROM tb_pessoas WHERE num_documento=?"; // VERIFICA POR MEIO DE CONTAGE SE TEM O DADO NO BANCO
        try {
            PreparedStatement verificaPst = cn.prepareStatement(verificaSQL); // CRIA CONEXÃO COM O BANCO DE DADOS
            verificaPst.setString(1, numeroDocumento); // VERIFICA SE HÁ ALGUM REGISTRO NA TABELA QUE POSSUI O MESMO DADO. *Ao valor da variável numeroDocumento ao primeiro parâmetro da consulta 
            ResultSet resultSet = verificaPst.executeQuery(); // EXECUTA A QUERY

            if (resultSet.next()) { // CASO O JÁ TENHA UM DADO IGUAL NO BANCO
                int count = resultSet.getInt(1);
                if (count > 0) { // SE RETORNAR 1, INDICA QUE JÁ EXISTE O DADO IGUAL BANCO
                    JOptionPane.showMessageDialog(null, "Um cliente com o número de documento " + numeroDocumento + " já está cadastrado.");
                    return false;
                }
            }

            // CASO NÃO TENHA DADOS IGUAIS, EXECUTA A QUERY DE INSERÇÃO
            // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_pessoas"
            sSQL = "insert into tb_pessoas (nome_pessoa, tipo_documento, num_documento, endereco, telefone, email)"
                    + "values(?,?,?,?,?,?)";
            // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_clientes"
            sSQL2 = "insert into tb_clientes (id_pessoa, codigo_cliente)"
                    + "values((select id_pessoa from tb_pessoas order by id_pessoa desc limit 1),?)";

            // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS 
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            PreparedStatement pst2 = cn.prepareStatement(sSQL2); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL2"

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getTipo_documento());
            pst.setString(3, dts.getNum_documento());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getTelefone());
            pst.setString(6, dts.getEmail());

            pst2.setString(1, dts.getCodigo_cliente());

            // TRECHO RESPONSÁVEL POR VERIFICAR SE O INSERT OBTEVE SUCESSO
            int n = pst.executeUpdate(); // ARMAZENA A PRIMEIRA INSERÇÃO EM n
            if (n != 0) { // SE A PRIMEIRA INSERÇÃO OBTEVE SUCESSO 
                int n2 = pst2.executeUpdate(); // ARMAZENA A SEGUNDA INSERÇÃO EM n2
                if (n2 != 0) { // SE A SEGUNDA INSERÇÃO OBTEVE SUCESSO
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA INSERÇÃO DA QUERY
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    // FUNÇÃO QUE RECEBE A CLASSE "Clientes" RESPONSÁVEL POR EDITAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean editar(Clientes dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA EDIÇÃO DOS DADOS NA TABELA "tb_pessoas"
        sSQL = "update tb_pessoas set nome_pessoa=?, tipo_documento=?, num_documento=?, endereco=?, telefone=?, email=?"
                + "where id_pessoa=?";
        // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_clientes"
        sSQL2 = "update tb_clientes set codigo_cliente=?"
                + "where id_pessoa=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            PreparedStatement pst2 = cn.prepareStatement(sSQL2); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL2"

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getTipo_documento());
            pst.setString(3, dts.getNum_documento());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getTelefone());
            pst.setString(6, dts.getEmail());
            pst.setInt(7, dts.getId_pessoa());

            pst2.setString(1, dts.getCodigo_cliente());
            pst2.setInt(2, dts.getId_pessoa());

            // TRECHO RESPONSÁVEL POR VERIFICAR SE O INSERT OBTEVE SUCESSO
            int n = pst.executeUpdate(); // ARMAZENA A PRIMEIRA INSERÇÃO EM n
            if (n != 0) { // SE A PRIMEIRA INSERÇÃO OBTEVE SUCESSO 
                int n2 = pst2.executeUpdate(); // ARMAZENA A SEGUNDA INSERÇÃO EM n2
                if (n2 != 0) { // SE A SEGUNDA INSERÇÃO OBTEVE SUCESSO
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA INSERÇÃO DA QUERY
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    // FUNÇÃO QUE RECEBE A CLASSE "Clientes" RESPONSÁVEL POR DELETAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean deletar(Clientes dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA DELEÇÃO DOS DADOS NA TABELA "tb_clientes"
        sSQL = "delete from tb_clientes where id_pessoa=?";
        // CRIAÇÃO DE UMA QUERY PARA DELEÇÃO DOS DADOS NA TABELA "tb_pessoas"
        sSQL2 = "delete from tb_pessoas where id_pessoa=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            PreparedStatement pst2 = cn.prepareStatement(sSQL2); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL2"

            pst.setInt(1, dts.getId_pessoa());

            pst2.setInt(1, dts.getId_pessoa());

            // TRECHO RESPONSÁVEL POR VERIFICAR SE O INSERT OBTEVE SUCESSO
            int n = pst.executeUpdate(); // ARMAZENA A PRIMEIRA INSERÇÃO EM n
            if (n != 0) { // SE A SEGUNDA INSERÇÃO OBTEVE SUCESSO
                int n2 = pst2.executeUpdate(); // ARMAZENA A SEGUNDA INSERÇÃO EM n2
                if (n2 != 0) { // SE A SEGUNDA INSERÇÃO OBTEVE SUCESSO
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA INSERÇÃO DA QUERY
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

}
