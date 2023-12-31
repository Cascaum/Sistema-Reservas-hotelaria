/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.reservasViewController;
import Controller.quartosViewController;
import Model.Quartos;
import Model.Reservas;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */
public class reservasView extends javax.swing.JInternalFrame {
//public static int idusuario;
    /**
     * CRIAÇAO DO FORMULARIO DE RESERVAS
     */
    private reservasViewController controller; //DECLARAÇÃO DA VARIAVEL
    private quartosViewController controller2; //DECLARAÇÃO DA VARIAVEL

    public reservasView() {
        controller = new reservasViewController(); //INICIALIZAÇAO DA VARIÁVEL
        controller2 = new quartosViewController(); //INICIALIZAÇAO DA VARIÁVEL
        initComponents();
        desativar();
        // BUSCAR "VAZIO" USADO PARA QUE TODAS AS INFORMAÇÕES JÁ ESTEJAM VISIVEIS AO ACESSAR A TABELA.
        // CASO QUEIRA QUE APARESSA APENAS AS PESQUISADAS, MUDAR PARA "null".
        mostrar(""); //TABELA NÃO POSSUI VALORES INICIALMENTE
    }
    
    
    private String acao = "salvar"; // DEIXAR AS COLUNAS OCULTAS, NÃO APARECENDO PARA O USUÁRIO
    void ocultar_coluna(){
        // OCULTA COLUNA DO "id_reserva" NA TABELA
        TB_lista.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(0).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(0).setPreferredWidth(0);
        // OCULTA COLUNA DO "id_quarto" NA TABELA
        TB_lista.getColumnModel().getColumn(1).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(1).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(1).setPreferredWidth(0);
        // OCULTA COLUNA DO "id_cliente" NA TABELA
        TB_lista.getColumnModel().getColumn(3).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(3).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(3).setPreferredWidth(0);
        // OCULTA COLUNA DO "id_funcionario" NA TABELA
        TB_lista.getColumnModel().getColumn(5).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(5).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(5).setPreferredWidth(0);
    }
    
    void desativar(){ // DEIXA AS COLUNAS DESATIVADAS APENAS PARA VISUALIZAÇÃO DOS DADOS DO USUÁRIO
        txt_id_reserva.setVisible(false); // CASO QUEIRA INFORMAR OS CAMPOS DE ID NO FORMULÁRIO, MUDAR PARA "setEnabled"
        CB_tipo.setEnabled(false);
        CB_estado.setEnabled(false);
        txt_id_quarto.setVisible(false); // CASO QUEIRA INFORMAR OS CAMPOS DE ID NO FORMULÁRIO, MUDAR PARA "setEnabled"
        txt_valor.setEnabled(false);
        txt_dt_entrada.setEnabled(false);
        txt_dt_reserva.setEnabled(false);
        txt_dt_saida.setEnabled(false);
        txt_funcionario.setEnabled(false);
        txt_id_funcionario.setVisible(false); // CASO QUEIRA INFORMAR OS CAMPOS DE ID NO FORMULÁRIO, MUDAR PARA "setEnabled"
        txt_numero.setEnabled(false);
        txt_id_cliente.setVisible(false);
        txt_cliente.setEnabled(false);

        btn_salvar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_busca_clientes.setEnabled(false);
        btn_busca_quartos.setEnabled(false);
        
        
        // LIMPA OS DADOS INSERIDOS NO FORMULÁRIO
        txt_valor.setText("");
        txt_id_quarto.setText("");

    }
    
    void ativar(){ // DEIXA AS COLUNAS ATIVADAS PARA ATUALIZAÇÃO OU INSERÇÃO DE DADOS DO USUÁRIO
        txt_id_reserva.setVisible(false);
        CB_tipo.setEnabled(true);
        CB_estado.setEnabled(true);
        txt_valor.setEnabled(true);
        txt_dt_entrada.setEnabled(true);
        txt_dt_reserva.setEnabled(true);
        txt_dt_saida.setEnabled(true);
        
        btn_salvar.setEnabled(true);
        btn_busca_clientes.setEnabled(true);
        btn_busca_quartos.setEnabled(true);
        btn_cancelar.setEnabled(true);
        
        txt_valor.setText("");
        txt_id_quarto.setText("");

    }
    
    //EXIBE A TABELA COM SUAS RESPECTIVAS INFORMAÇÕES
    void mostrar (String buscar){ // PUXA O METODO "mostrar" LINCADA A TABELA "modelo" NA CLASSE "reservasDAoimpl"
         try { //BLOCO TRY RESPONSÁVEL POR CUIDAR DE EXCESSÕES QUE PODEM VIR A OCORRER
            DefaultTableModel modelo = new DefaultTableModel(); //CRIA E DECLARA INSTÂNCIA 'DefaultTableModel' 

            TB_lista.setModel(controller.mostrar(buscar,modelo)); //CHAMA O MÉTODO "mostrar" DO "reservasViewController" PARA BUSCAR E MOSTRAR A TABELA/LISTA
            ocultar_coluna();
            LB_registros.setText("Total Registros " + Integer.toString(controller.getQtdRegistros())); //BUSCA E INFORMA A QUANTIDADE DE REGISTROS ENCONTRADOS
        } catch (Exception e) { //TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO DA CONSULTA 
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    void limpar(){ // LIMPA/RESETA OS VALORES DOS CAMPOS
        txt_id_reserva.setText("");
        txt_valor.setText("");
        txt_id_quarto.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_id_reserva = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CB_tipo = new javax.swing.JComboBox<>();
        btn_salvar = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_numero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_id_quarto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_id_cliente = new javax.swing.JTextField();
        txt_cliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_id_funcionario = new javax.swing.JTextField();
        txt_funcionario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_dt_reserva = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txt_dt_entrada = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        txt_dt_saida = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CB_estado = new javax.swing.JComboBox<>();
        btn_busca_quartos = new javax.swing.JButton();
        btn_busca_clientes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB_lista = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_pesquisar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_apagar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        LB_registros = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_pagamentos = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Reservas");

        jLabel3.setText("Quarto");

        txt_id_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_reservaActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo Reserva");

        CB_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESERVADA", "ALUGADA" }));
        CB_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_tipoActionPerformed(evt);
            }
        });

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Limpar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        txt_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Lista de Reservas");

        txt_id_quarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_quartoActionPerformed(evt);
            }
        });

        jLabel4.setText("Cliente");

        txt_id_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_clienteActionPerformed(evt);
            }
        });

        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });

        jLabel11.setText("Funcionário");

        txt_id_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_funcionarioActionPerformed(evt);
            }
        });

        txt_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_funcionarioActionPerformed(evt);
            }
        });

        jLabel13.setText("Data Reserva");

        jLabel14.setText("Data Entrada");

        jLabel15.setText("Data Saída");

        jLabel16.setText("Valor Quarto");

        txt_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorActionPerformed(evt);
            }
        });

        jLabel9.setText("Estado");

        CB_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALUGADO", "PAGO", "CANCELADO" }));
        CB_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_estadoActionPerformed(evt);
            }
        });

        btn_busca_quartos.setText("...");
        btn_busca_quartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busca_quartosActionPerformed(evt);
            }
        });

        btn_busca_clientes.setText("...");
        btn_busca_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busca_clientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CB_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_id_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(CB_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_dt_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_dt_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(txt_dt_saida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_busca_quartos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_busca_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_busca_quartos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_busca_clientes))
                        .addGap(51, 51, 51)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CB_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dt_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dt_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dt_saida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CB_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_novo))
                .addGap(49, 49, 49))
        );

        TB_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TB_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_listaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TB_lista);

        jLabel10.setText("Pesquisar");

        txt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisarActionPerformed(evt);
            }
        });

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_apagar.setText("Apagar");
        btn_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apagarActionPerformed(evt);
            }
        });

        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        LB_registros.setText("Total de registros");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Lista de Reservas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_apagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sair))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_registros)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_apagar)
                    .addComponent(btn_sair)
                    .addComponent(btn_buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LB_registros)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        btn_pagamentos.setText("Pagamentos");
        btn_pagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pagamentos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btn_pagamentos)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        if(txt_numero.getText().length() == 0){ //CHECA PELA QUANITDADE SE EXISTEM CARACTERES NO CAMPO
            JOptionPane.showMessageDialog(rootPane, "Insira o número do quarto.");
            txt_id_quarto.requestFocus();
            return;
            
        }
        
        Reservas dts = new Reservas(); //CRIA INSTANCIA APARTIR DE "Reservas" E ATRIBUI A VARIAVEL "dts"
        
        // CHAMA OS METODOS E REFERENCIA NO "dts"
        dts.setIdquarto(Integer.parseInt(txt_id_quarto.getText()));
        dts.setIdcliente(Integer.parseInt(txt_id_cliente.getText()));
        dts.setIdfuncionario(Integer.parseInt(txt_id_funcionario.getText()));
        
        int selecionado = CB_tipo.getSelectedIndex(); //RECEBE A INFORMAÇÃO REPASSADA NA COMBOBOX DO TIPO DA RESERVA
        dts.setTipo_reserva((String) CB_tipo.getItemAt(selecionado)); // REPASSA A INFORMAÇÃO SELECIOANDA NO COMBOBOX
        
        Calendar cal;
        int d,m,a;
        cal=txt_dt_reserva.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setData_reserva(new Date(a,m,d));
        
        cal=txt_dt_entrada.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setData_entrada(new Date(a,m,d));
        
        cal=txt_dt_saida.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setData_saida(new Date(a,m,d));
        
        dts.setValor_quarto(Double.parseDouble(txt_valor.getText()));
        
        selecionado = CB_estado.getSelectedIndex();
        dts.setEstado((String) CB_estado.getItemAt(selecionado));
              
        // VERIFICA SE A AÇÃO DO USUÁRIO
        if(acao.equals("salvar")){ //SE FOR SALVAR
            if(controller.inserir(dts)){ //CHAMA A FUNÇAO INSERIR CONTIDA NO "reservasViewController" E REPASSA PARA O "dts"
            JOptionPane.showMessageDialog(rootPane, "O registro de reserva foi inserida com sucesso.");
            mostrar("");
            desativar();
            
            // FUNÇÃO PARA OCUPAR O QUARTO
            Quartos dts2 = new Quartos();
            
            dts2.setIdquarto(Integer.parseInt(txt_id_quarto.getText()));
            controller2.ocupar(dts2);
            
            }
        } else if(acao.equals("editar")) { //SE FOR EDITAR
            dts.setIdreserva(Integer.parseInt(txt_id_reserva.getText())); //REALIZA EDIÇÃO USANDO O ID 
            dts.setIdfuncionario(Integer.parseInt(txt_id_funcionario.getText())); //REALIZA EDIÇÃO USANDO O ID 
            if(controller.editar(dts)){ //CHAMA A FUNÇAO EDITAR  CONTIDA NO "reservasViewController" E REPASSA PARA O "dts"
                JOptionPane.showMessageDialog(rootPane, "O registro da reserva foi editada com sucesso.");
                mostrar("");
                desativar();
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        ativar(); //AO PRECIONAR O BOTÃO, ATIVA TODOS OS CAMPOS PARA INSERIR INFORMAÇÕES
        btn_salvar.setText("Salvar");
        acao="salvar";
    }//GEN-LAST:event_btn_novoActionPerformed

    private void txt_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroActionPerformed
        txt_numero.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_txt_numeroActionPerformed

    private void CB_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_tipoActionPerformed
        CB_tipo.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_CB_tipoActionPerformed

    private void txt_id_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_reservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_reservaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose(); //AO PRECIOSAR O BOTAO FECHA O FORMULÁRIO
    }//GEN-LAST:event_btn_sairActionPerformed
    
    private void btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagarActionPerformed
        if(!txt_id_reserva.getText().equals("")){  //VERIFICA SE TEM INFOMMACÃO NO CAMPO
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir esse registro?", "Excluir", 2);
            if (confirmacao == 0){ //SOLICITA CONFIRMAÇAO
                Reservas dts = new Reservas(); //CRIA INSTANCIA APARTIR DE "Reservas" E ATRIBUI A VARIAVEL "dts"
                dts.setIdreserva(Integer.parseInt(txt_id_reserva.getText())); //RECUPERA O ID DA PESSOA
                controller.deletar(dts);//CHAMA A FUNÇAO DELETAR CONTIDA NO "reservasViewController" E REPASSA PARA O "dts"
                mostrar("");
                desativar();
            }
       }
    }//GEN-LAST:event_btn_apagarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        mostrar(txt_pesquisar.getText()); //REALIZA PESQUISA POR MEIO DE UM PARAMETRO ESPECIFICO FORNECIDO PELO USUÁRIO
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void TB_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_listaMouseClicked
        btn_salvar.setText("Editar"); //AO CLICAR EM UMA LINHA DA TABELA, RETORNA O REGISTRO PARA EDIÇÃO
        ativar(); //ATIVA OS CAMPOS
        btn_apagar.setEnabled(true); //DURANTE A EDIÇÃO NÃO É PERMITIDO DELETAR O REGISTRO
        acao="editar";
        int linha = TB_lista.rowAtPoint(evt.getPoint());

        //SE O USUARIO QUISER EDITAR, AS LINHAS ABAIXO DA TABELA RETORNAM
        txt_id_reserva.setText(TB_lista.getValueAt(linha, 0).toString());
        txt_id_quarto.setText(TB_lista.getValueAt(linha, 1).toString());
        txt_numero.setText(TB_lista.getValueAt(linha, 2).toString());
        txt_id_cliente.setText(TB_lista.getValueAt(linha, 3).toString());
        txt_cliente.setText(TB_lista.getValueAt(linha, 4).toString());
        txt_id_funcionario.setText(TB_lista.getValueAt(linha, 5).toString());
        txt_funcionario.setText(TB_lista.getValueAt(linha, 6).toString());
        CB_tipo.setSelectedItem(TB_lista.getValueAt(linha, 7).toString());
        txt_dt_reserva.setDate(Date.valueOf(TB_lista.getValueAt(linha, 8).toString()));
        txt_dt_entrada.setDate(Date.valueOf(TB_lista.getValueAt(linha, 9).toString()));
        txt_dt_saida.setDate(Date.valueOf(TB_lista.getValueAt(linha, 10).toString()));
        txt_valor.setText(TB_lista.getValueAt(linha, 11).toString());
        CB_estado.setSelectedItem(TB_lista.getValueAt(linha, 12).toString());

    }//GEN-LAST:event_TB_listaMouseClicked

    private void txt_id_quartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_quartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_quartoActionPerformed

    private void txt_id_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_clienteActionPerformed

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void txt_id_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_funcionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_funcionarioActionPerformed

    private void txt_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_funcionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_funcionarioActionPerformed

    private void txt_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorActionPerformed

    private void CB_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_estadoActionPerformed

    private void btn_busca_quartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busca_quartosActionPerformed
        buscarquartosView form = new buscarquartosView();
        form.toFront();
        //form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Set the default close operation

        form.setVisible(true);
    }//GEN-LAST:event_btn_busca_quartosActionPerformed

    private void btn_busca_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busca_clientesActionPerformed
        buscarclientesView form = new buscarclientesView();
        form.toFront();
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // AO CLICAR PARA FECHAR O FORMULARIO "busca_cliente" ELE NÃO FECHA O SISTEMA TODO. APENAS O FORMULÁRIO.
        form.setVisible(true);
    }//GEN-LAST:event_btn_busca_clientesActionPerformed

    private void txt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisarActionPerformed

    private void btn_pagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagamentosActionPerformed
        int linha = TB_lista.getSelectedRow();
        
        pagamentoView.id_reserva = TB_lista.getValueAt(linha, 0). toString();
        pagamentoView.cliente = TB_lista.getValueAt(linha, 4). toString();
        pagamentoView.total_reserva = Double.parseDouble(TB_lista.getValueAt(linha, 11). toString());
        
        pagamentoView.id_quarto = TB_lista.getValueAt(linha, 1). toString();
        pagamentoView.quarto = TB_lista.getValueAt(linha, 2). toString();

        pagamentoView form = new pagamentoView();
        menuView.menu.add(form);
        form.toFront();
        form.setVisible(true);
        
    }//GEN-LAST:event_btn_pagamentosActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(reservasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_estado;
    public static javax.swing.JComboBox<String> CB_tipo;
    private javax.swing.JLabel LB_registros;
    private javax.swing.JTable TB_lista;
    private javax.swing.JButton btn_apagar;
    private javax.swing.JButton btn_busca_clientes;
    private javax.swing.JButton btn_busca_quartos;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_pagamentos;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextField txt_cliente;
    public static com.toedter.calendar.JDateChooser txt_dt_entrada;
    public static com.toedter.calendar.JDateChooser txt_dt_reserva;
    public static com.toedter.calendar.JDateChooser txt_dt_saida;
    public static javax.swing.JTextField txt_funcionario;
    public static javax.swing.JTextField txt_id_cliente;
    public static javax.swing.JTextField txt_id_funcionario;
    public static javax.swing.JTextField txt_id_quarto;
    public static javax.swing.JTextField txt_id_reserva;
    public static javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
