/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Funcionarios;
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
// CUIDA DA PARTE DE CONEXAO DO FORMULARIO COM O BANCO DE DADOS
public class FuncionariosDAOimpl extends BDconexaoDAO implements FuncionariosDAO { // DECLARAÇÃO DA CLASSE "FuncionariosDAOimpl" QUE EXTENDE A CLASSE "BDconexaoDAO" E IMPLEMENTA A INTERFACE "FuncionariosDAO"

    private BDconexaoDAO mysql = new BDconexaoDAO(); // DECLARAÇÃO DA INSTÂNCIA "mysql"
    private Connection cn = mysql.conectar(); // DECLARAÇÃO DA INSTÂNCIA "cn"
    private String sSQL = ""; // DECLARAÇÃO DE UMA VARIAVEL "sSQL" INICIALMENTE VAZIA
    private String sSQL2 = ""; // DECLARAÇÃO DE UMA VARIAVEL "sSQL2" INICIALMENTE VAZIA
    public Integer totalregistros; // DECLARAÇÃO DA VARIAVEL "totalregistros" QUE ACESSA E MOSTRA A QUANTIDADE DE REGISTROS NO BANCO

    @Override
    public DefaultTableModel mostrar(String buscar) { // DECLARAÇÃO DA CLASSE RESPONSAVEL PELA CONSULTA E RETORNO DOS DADOS DO BANCO
        DefaultTableModel modelo; // CRIA VARIAVEL PARA ARMAZENAR O MODELO DA TABELA DE INTERFACE GRÁFICA
        String[] titulos = {"ID", "Nome", "Documento", "Numero DOC", "Endereço", "Telefone", "Email", "Salário", "Acesso", "Login", "Senha", "Estado"}; // DEFINE O TÍTULO DAS COLUNAS NA LISTA QUE APARECE PARA VERIFICAÇÃO EM CADA TELA DO SISTEMA
        String[] registro = new String[12]; // DECLARA A QUANTIDADE DE REGISTROS
        totalregistros = 0; // DECLARA O TOTAL DE REGISTROS COMO SENDO ZERO INICIALMENTE

        modelo = new DefaultTableModel(null, titulos); // CRIA UMA "NOVA" TABELA E DEFINE A MESMA COMO "modelo". *Tabela = Lista de consulta que aparece no sistema
        // CRIA UM SELECT DE CONSULTA SQL QUE SELECIONA OS CAMPOS DA TABELA "tb_funcionarios"
        sSQL = "select p.id_pessoa,p.nome_pessoa,p.tipo_documento,p.num_documento,"
                + "p.endereco,p.telefone,p.email,f.salario,f.acesso,f.login,f.senha,f.estado from tb_pessoas p inner join tb_funcionarios f "
                + "on p.id_pessoa=f.id_pessoa where num_documento like '%"
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
                registro[7] = rs.getString("salario");
                registro[8] = rs.getString("acesso");
                registro[9] = rs.getString("login");
                registro[10] = rs.getString("senha");
                registro[11] = rs.getString("estado");

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

    // FUNÇÃO QUE RECEBE A CLASSE "Funcionarios" RESPONSÁVEL POR INSERIR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS.

    /**
     *
     * @param dts
     * @return
     */
    @Override
    public boolean inserir(Funcionarios dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO.
        // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_pessoas".
        sSQL = "insert into tb_pessoas (nome_pessoa, tipo_documento, num_documento, endereco, telefone, email)"
                + "values(?,?,?,?,?,?)";
        // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_funcionarios".
        sSQL2 = "insert into tb_funcionarios (id_pessoa, salario, acesso, login, senha, estado)"
                + "values((select id_pessoa from tb_pessoas order by id_pessoa desc limit 1),?,?,?,?,?)";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS. 
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            PreparedStatement pst2 = cn.prepareStatement(sSQL2); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL2"

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getTipo_documento());
            pst.setString(3, dts.getNum_documento());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getTelefone());
            pst.setString(6, dts.getEmail());

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getSenha());
            pst2.setString(5, dts.getEstado());

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

    // FUNÇÃO QUE RECEBE A CLASSE "Funcionarios" RESPONSÁVEL POR EDITAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS

    /**
     *
     * @param dts
     * @return
     */
    @Override
    public boolean editar(Funcionarios dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA EDIÇÃO DOS DADOS NA TABELA "tb_pessoas"
        sSQL = "update tb_pessoas set nome_pessoa=?, tipo_documento=?, num_documento=?, endereco=?, telefone=?, email=?"
                + "where id_pessoa=?";
        // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_funcionarios"
        sSQL2 = "update tb_funcionarios set salario=?, acesso=?, login=?, senha=?, estado=?"
                + "where id_pessoa=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS. 
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            PreparedStatement pst2 = cn.prepareStatement(sSQL2); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL2"

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getTipo_documento());
            pst.setString(3, dts.getNum_documento());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getTelefone());
            pst.setString(6, dts.getEmail());
            pst.setInt(7, dts.getId_pessoa());

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getSenha());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getId_pessoa());

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

    // FUNÇÃO QUE RECEBE A CLASSE "Funcionarios" RESPONSÁVEL POR DELETAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS

    /**
     *
     * @param dts
     * @return
     */
    @Override
    public boolean deletar(Funcionarios dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA DELEÇÃO DOS DADOS NA TABELA "tb_funcionarios"
        sSQL = "delete from tb_funcionarios where id_pessoa=?";
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

    // FUNÇÃO DESTINADA AO CADASTRO E VALIDAÇÃO DO ACESSO DOS USUÁRIOS DO SISTEMA

    /**
     *
     * @param login
     * @param senha
     * @return
     */
    @Override
    public DefaultTableModel login(String login, String senha) { // METODO QUE RECEBE O LOGIN E SENHA PARA ACESSO AO SISTEMA
        DefaultTableModel modelo; // CRIA VARIAVEL PARA ARMAZENAR O MODELO DA TABELA DE INTERFACE GRÁFICA
        String[] titulos = {"ID", "Nome", "Acesso", "Login", "Senha", "Estado"}; // DEFINE O TÍTULO DAS COLUNAS NA LISTA QUE APARECE PARA VERIFICAÇÃO EM CADA TELA DO SISTEMA
        String[] registro = new String[6]; // DECLARA A QUANTIDADE DE REGISTROS
        totalregistros = 0; // DECLARA O TOTAL DE REGISTROS COMO SENDO ZERO INICIALMENTE

        modelo = new DefaultTableModel(null, titulos); // CRIA UMA "NOVA" TABELA E DEFINE A MESMA COMO "modelo". *Tabela = Lista de consulta que aparece no sistema
        // CRIA UM SELECT DE CONSULTA SQL QUE SELECIONA OS CAMPOS DA TABELA "tb_funcionarios"
        sSQL = "select p.id_pessoa,p.nome_pessoa,"
                + "f.acesso,f.login,f.senha,f.estado from tb_pessoas p inner join tb_funcionarios f "
                + "on p.id_pessoa=f.id_pessoa where f.login='"
                + login + "' and f.senha='" + senha + "' and f.estado='A'";
        // FILTRA A BUSCA BASEANDO-SE NO LOGIN ATIVO

        try { // BLOCO TRY RESPONSÁVEL POR EXECUTAR A CONSULTA DO sSQL 
            Statement st = cn.createStatement(); // OBJETO USADO PARA EXECUTAR A CONSULTA
            ResultSet rs = st.executeQuery(sSQL); // OBJETO RETORNADO PELA CONSULTA PARA ITERAR PELOS REGISTROS
            while (rs.next()) { // BUSCA CADA UM DOS REGISTROS NO BANCO E ADICIONA EM UMA NOVA LINHA NA TABELA.
                registro[0] = rs.getString("id_pessoa");
                registro[1] = rs.getString("nome_pessoa");
                registro[2] = rs.getString("acesso");
                registro[3] = rs.getString("login");
                registro[4] = rs.getString("senha");
                registro[5] = rs.getString("estado");

                totalregistros = totalregistros + 1; // VARIÁVEL RESPONSÁVEL POR CONTABILIZAR A QUANTIDADE DE REGISTROS NO BANCO
                modelo.addRow(registro); // ADICIONA UM NOVO REGISTRO A TABELA "modelo"
            }
            return modelo; // RETORNA O OBJETO "modelo" QUE CUIDA DA APRESENTAÇÃO DOS DADOS DA TABELA
        } catch (Exception e) { // TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO DA CONSULTA
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
}
