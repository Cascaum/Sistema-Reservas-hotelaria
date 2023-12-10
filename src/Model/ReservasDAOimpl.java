 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Reservas;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */
public class ReservasDAOimpl extends BDconexaoDAO implements ReservasDAO { // DECLARAÇÃO DA CLASSE "ReservasDAOimpl" QUE EXTENDE A CLASSE "BDconexaoDAO" E IMPLEMENTA A INTERFACE "ReservasDAO"

    private BDconexaoDAO mysql = new BDconexaoDAO(); // DECLARAÇÃO DA INSTÂNCIA "mysql"
    private Connection cn = mysql.conectar(); // DECLARAÇÃO DA INSTÂNCIA "cn"
    private String sSQL = ""; // DECLARAÇÃO DE UMA VARIAVEL "sSQL" INICIALMENTE VAZIA
    public Integer totalregistros; // DECLARAÇÃO DA VARIAVEL "totalregistros" QUE ACESSA E MOSTRA A QUANTIDADE DE REGISTROS NO BANCO

    @Override
    public DefaultTableModel mostrar(String buscar) { // DECLARAÇÃO DA CLASSE RESPONSAVEL PELA CONSULTA E RETORNO DOS DADOS DO BANCO     
        DefaultTableModel modelo; // CRIA VARIAVEL PARA ARMAZENAR O MODELO DA TABELA DE INTERFACE GRÁFICA
        String[] titulos = {"ID Reserva", "ID Quarto", "Número", "ID Cliente", "Nome Cliente", "ID Funcionario", "Funcionario", "Tipo Reserva", "Data Reserva", "Data Entrada", "Data Saída", "Valor Quarto", "Estado"}; // DEFINE O TÍTULO DAS COLUNAS NA LISTA QUE APARECE PARA VERIFICAÇÃO EM CADA TELA DO SISTEMA
        String[] registro = new String[13]; // DECLARA A QUANTIDADE DE REGISTROS
        totalregistros = 0; // DECLARA O TOTAL DE REGISTROS COMO SENDO ZERO INICIALMENTE

        modelo = new DefaultTableModel(null, titulos); // CRIA UMA "NOVA" TABELA E DEFINE A MESMA COMO "modelo". *Tabela = Lista de consulta que aparece no sistema
        // CRIA UM SELECT DE CONSULTA SQL QUE SELECIONA OS CAMPOS DA TABELA "id_reserva"
        sSQL = "select r.id_reserva,r.id_quarto,q.numero,r.id_cliente,"
                + "(select nome_pessoa from tb_pessoas where id_pessoa=r.id_cliente) as clienten,"
                + // VARIAVEL "clienten" CRIADA PARA GUARDAR A CONSULTA
                "r.id_funcionario,(select nome_pessoa from tb_pessoas where id_pessoa=r.id_funcionario) as funcionarion,"
                + // VARIAVEL "funcionarion" CRIADA PARA GUARDAR A CONSULTA
                "r.tipo_reserva,r.data_reserva,r.data_entrada,r.data_saida,"
                + "r.valor_quarto,r.estado from tb_reservas r inner join tb_quartos q on r.id_quarto=q.id_quarto "
                + "where r.data_reserva like '%" + buscar + "%' order by id_reserva desc";
        // FILTRA A BUSCA BASEANDO-SE NA DATA DA RESERVA

        try { // BLOCO TRY RESPONSÁVEL POR EXECUTAR A CONSULTA DO sSQL 
            Statement st = cn.createStatement(); // OBJETO USADO PARA EXECUTAR A CONSULTA
            ResultSet rs = st.executeQuery(sSQL); // OBJETO RETORNADO PELA CONSULTA PARA ITERAR PELOS REGISTROS
            boolean registrosEncontrados = false; // Variável para verificar se registros foram encontrados
            while (rs.next()) { // BUSCA CADA UM DOS REGISTROS NO BANCO E ADICIONA EM UMA NOVA LINHA NA TABELA.
                registro[0] = rs.getString("id_reserva");
                registro[1] = rs.getString("id_quarto");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("id_cliente");
                registro[4] = rs.getString("clienten");
                registro[5] = rs.getString("id_funcionario");
                registro[6] = rs.getString("funcionarion");
                registro[7] = rs.getString("tipo_reserva");
                registro[8] = rs.getString("data_reserva");
                registro[9] = rs.getString("data_entrada");
                registro[10] = rs.getString("data_saida");
                registro[11] = rs.getString("valor_quarto");
                registro[12] = rs.getString("estado");

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

    // FUNÇÃO QUE RECEBE A CLASSE "Reservas" RESPONSÁVEL POR INSERIR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean inserir(Reservas dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA INSERÇÃO DOS DADOS NA TABELA "tb_reservas"
        sSQL = "insert into tb_reservas (id_quarto, id_cliente, id_funcionario, tipo_reserva, data_reserva, data_entrada, data_saida, valor_quarto, estado)"
                + "values(?,?,?,?,?,?,?,?,?)";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS 
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"
            pst.setInt(1, dts.getIdquarto());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdfuncionario());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, java.sql.Date.valueOf(dts.getData_reserva().toString()));
            pst.setDate(6, java.sql.Date.valueOf(dts.getData_entrada().toString()));
            pst.setDate(7, java.sql.Date.valueOf(dts.getData_saida().toString()));
            pst.setDouble(8, dts.getValor_quarto());
            pst.setString(9, dts.getEstado());

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

    // FUNÇÃO QUE RECEBE A CLASSE "Reservas" RESPONSÁVEL POR EDITAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean editar(Reservas dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA EDIÇÃO DOS DADOS NA TABELA "tb_reservas"
        sSQL = "update tb_reservas set id_quarto=?, id_cliente=?, id_funcionario=?, tipo_reserva=?, data_reserva=?, data_entrada=?, data_saida=?, valor_quarto=?, estado=?"
                + "where id_reserva=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdquarto());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdfuncionario());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, java.sql.Date.valueOf(dts.getData_reserva().toString()));
            pst.setDate(6, java.sql.Date.valueOf(dts.getData_entrada().toString()));
            pst.setDate(7, java.sql.Date.valueOf(dts.getData_saida().toString()));
            pst.setDouble(8, dts.getValor_quarto());
            pst.setString(9, dts.getEstado());
            pst.setInt(10, dts.getIdreserva());

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

    // FUNÇÃO QUE RECEBE A CLASSE "Reservas" PARA VALIDAR SE FOI PAGA
    @Override
    public boolean pago(Reservas dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA EDIÇÃO DOS DADOS NA TABELA "tb_reserva" VALIDANDO SE A RESERVA FOI PAGA
        sSQL = "update tb_reservas set estado='PAGO'"
                + "where id_reserva=?";

        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"

            pst.setInt(1, dts.getIdreserva());

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
        } finally {
            // FECHAR CONEXAO NO BANCO COM BLOCO FINALLY PARA GARANTIR QUE OCORRA COM EXITO INDIPENDENTE DE EXCESSÃO
            fecharConexao(cn);
        }
    }

    // FUNÇÃO QUE RECEBE A CLASSE "Reservas" RESPONSÁVEL POR DELETAR AS INFORMAÇÕES DO SISTEMA NO BANCO DE DADOS
    @Override
    public boolean deletar(Reservas dts) { // "dts" É UM OBJETO CRIADO PARA IDENTIFICAR QUE O CÓDIGO ESTÁ DIRETAMENTE ITERADO  AO BANCO
        // CRIAÇÃO DE UMA QUERY PARA DELEÇÃO DOS DADOS NA TABELA "id_reserva"
        sSQL = "delete from tb_reservas where id_reserva=?";
        try { // BLOCO RESPONSÁVEL PELA EXECUÇÃO DAS QUERYS
            PreparedStatement pst = cn.prepareStatement(sSQL); // OBJETO CRIADO PARA EXECUTAR A QUERY "sSQL"

            pst.setInt(1, dts.getIdreserva());

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
