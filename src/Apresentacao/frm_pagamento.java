/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Apresentacao;

import DAO.PagamentosDAOimpl;
import DAO.QuartosDAOimpl;
import DAO.ReservasDAOimpl;
import Model.Pagamentos;
import Model.Quartos;
import Model.Reservas;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafas
 */
public class frm_pagamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form frm_quartos
     */
    public frm_pagamento() {
        initComponents();
        desativar();
        mostrar(id_reserva);
        txt_id_reserva.setText(id_reserva);
        txt_cliente.setText(cliente);
        txt_quarto.setText(quarto);
        txt_id_quarto.setText(id_quarto);
        txt_total_reserva.setText(Double.toString(total_reserva));
    }
    
    private String acao = "salvar"; // DEIXAR AS COLUNAS OCULTAS, NÃO APARECENDO PARA O USUÁRIO
    public static String id_reserva;
    public static String cliente;
    public static String id_quarto;
    public static String quarto;
    public static Double total_reserva;


    void ocultar_coluna(){
        TB_lista.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(0).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        TB_lista.getColumnModel().getColumn(1).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(1).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
    
    void desativar(){ // DEIXA AS COLUNAS DESATIVADAS APENAS PARA VISUALIZAÇÃO DOS DADOS DO USUÁRIO
        txt_id_pagamento.setVisible(false);
        txt_id_reserva.setVisible(false);
        txt_id_quarto.setVisible(false);
        CB_tipo_comp.setVisible(false);
        txt_cliente.setEnabled(false);
        txt_total_pgto.setEnabled(false);
        txt_cliente.setEnabled(false);
        txt_total_reserva.setEnabled(false);
        txt_data_emissao.setEnabled(false);
        txt_data_pgto.setEnabled(false);
        txt_numero_comprovante.setEnabled(false);
        txt_taxa.setEnabled(false);
        txt_quarto.setEnabled(false);

        btn_salvar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        
        

    }
    
    void ativar(){ // DEIXA AS COLUNAS ATIVADAS PARA ATUALIZAÇÃO OU INSERÇÃO DE DADOS DO USUÁRIO
        txt_id_pagamento.setVisible(false);
        txt_id_reserva.setVisible(false);
        txt_id_quarto.setVisible(false);
        CB_tipo_comp.setVisible(true);
        txt_cliente.setEnabled(false);
        txt_total_pgto.setEnabled(false);
        txt_total_reserva.setEnabled(false);
        txt_data_emissao.setEnabled(true);
        txt_data_pgto.setEnabled(true);
        txt_numero_comprovante.setEnabled(true);
        txt_taxa.setEnabled(true);
        
        btn_salvar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        

    }
    
    void mostrar (String buscar){ // PUXA O METODO "mostrar" LINCADA A TABELA "modelo" NA CLASSE "fquartos"
        try{
            DefaultTableModel modelo;
            PagamentosDAOimpl func = new PagamentosDAOimpl();
            modelo = func.mostrar(buscar);
            TB_lista.setModel(modelo);
            ocultar_coluna();
            LB_registros.setText("Total Registros " + Integer.toString(func.totalregistros));
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
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
        txt_id_pagamento = new javax.swing.JTextField();
        txt_cliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_id_reserva = new javax.swing.JTextField();
        txt_id_quarto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_quarto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_novo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        CB_tipo_comp = new javax.swing.JComboBox<>();
        txt_total_pgto = new javax.swing.JTextField();
        txt_data_pgto = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_numero_comprovante = new javax.swing.JTextField();
        txt_data_emissao = new com.toedter.calendar.JDateChooser();
        txt_taxa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_total_reserva = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB_lista = new javax.swing.JTable();
        btn_apagar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        LB_registros = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Pagamento");

        jLabel3.setText("Cliente");

        txt_id_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_pagamentoActionPerformed(evt);
            }
        });

        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cadastro de Pagamento");

        txt_id_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_reservaActionPerformed(evt);
            }
        });

        txt_id_quarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_quartoActionPerformed(evt);
            }
        });

        jLabel4.setText("Quarto");

        txt_quarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quartoActionPerformed(evt);
            }
        });

        jLabel13.setText("Total Pagamento");

        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        jLabel6.setText("Taxa");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        CB_tipo_comp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOTA", "FATURA", "TICKET", "OUTRO" }));
        CB_tipo_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_tipo_compActionPerformed(evt);
            }
        });

        txt_total_pgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_pgtoActionPerformed(evt);
            }
        });

        jLabel5.setText("Num. Comprovante");

        jLabel14.setText("Data Emissão");

        btn_cancelar.setText("Limpar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo Comprovante");

        txt_numero_comprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_comprovanteActionPerformed(evt);
            }
        });

        txt_taxa.setText("0");

        jLabel15.setText("Data Pagamento");

        jLabel7.setText("Total Reserva");

        txt_total_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_reservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txt_id_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_id_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(18, 18, 18)
                            .addComponent(txt_data_pgto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_data_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(txt_total_pgto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_numero_comprovante))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(30, 30, 30)
                            .addComponent(txt_taxa, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_total_reserva)
                                .addComponent(CB_tipo_comp, 0, 107, Short.MAX_VALUE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_total_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_tipo_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_numero_comprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_taxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total_pgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_data_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_data_pgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_novo))
                .addContainerGap(44, Short.MAX_VALUE))
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
        jLabel12.setText("Lista de Pagamento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_registros)
                .addGap(80, 80, 80))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btn_apagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sair)
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel12)
                    .addContainerGap(346, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_apagar)
                    .addComponent(btn_sair))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LB_registros)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel12)
                    .addContainerGap(450, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        if(txt_cliente.getText().length() == 0){ // VERIFICA A QUANTIDADE DE CARACTERES NO CAMPO DE TEXTO. CASO SEJA 0 SIGNIFICA QUE NÃO TEM NADA
            JOptionPane.showMessageDialog(rootPane, "Insira o número do quarto.");
            txt_cliente.requestFocus();
            return;
            
        }
        
        
        Pagamentos dts = new Pagamentos();
        PagamentosDAOimpl func = new PagamentosDAOimpl();
        
        // PARAMETROS QUE O USUÁRIO DEVE INFORMAR
        dts.setIdreserva(Integer.parseInt(txt_id_reserva.getText()));
        dts.setNum_comprovante(txt_numero_comprovante.getText());
        dts.setTaxa(Double.parseDouble(txt_taxa.getText()));
        dts.setTotal_pagamento(Double.parseDouble(txt_total_pgto.getText()));
        
        Calendar cal;
        int d,m,a;
        
        cal=txt_data_pgto.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setData_pagamento(new Date (a,m,d));

        
        cal=txt_data_emissao.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setData_emissao(new Date (a,m,d));
        
        // PARAMETROS QUE O USUÁRIO DEVE INSERIR NO FORMULÁRIO
        int selecionado = CB_tipo_comp.getSelectedIndex();
        dts.setTipo_comprovate((String) CB_tipo_comp.getItemAt(selecionado));
        
        
        if(acao.equals("salvar")){
            if(func.inserir(dts)){
            JOptionPane.showMessageDialog(rootPane, "O registro de pagamento foi inserido com sucesso.");
            mostrar(id_reserva);
            desativar();
            
            // FUNÇÃO PARA DESOCUPAR O QUARTO
            QuartosDAOimpl func2 = new QuartosDAOimpl();
            Quartos dts2 = new Quartos();
            
            dts2.setIdquarto(Integer.parseInt(txt_id_quarto.getText()));
            func2.desocupar(dts2); // RECUPERA A INFORMAÇÃO DO CÓDIGO INSERIDA NA CLASSE 'fquartos'.
            
            // FUNÇÃO PARA VERIFICAR SE A RESERVA FOI CANCELADA OU PAGA
            ReservasDAOimpl func3 = new ReservasDAOimpl();
            Reservas dts3 = new Reservas();
            
            dts3.setIdreserva(Integer.parseInt(txt_id_reserva.getText()));
            func3.pago(dts3); // RECUPERA A INFORMAÇÃO DO CÓDIGO INSERIDA NA CLASSE 'freservas'.
            
            }
        } else if(acao.equals("editar")) {
        dts.setIdpagamento(Integer.parseInt(txt_id_pagamento.getText()));
        
        if(func.editar(dts)){
            JOptionPane.showMessageDialog(rootPane, "O registro de pagamento foi editado com sucesso.");
            mostrar(id_reserva);
            desativar();
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        ativar();
        btn_salvar.setText("Salvar");
        acao="salvar";
    }//GEN-LAST:event_btn_novoActionPerformed

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clienteActionPerformed
        txt_cliente.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void CB_tipo_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_tipo_compActionPerformed
        CB_tipo_comp.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_CB_tipo_compActionPerformed

    private void txt_id_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_pagamentoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagarActionPerformed
        if(!txt_id_pagamento.getText().equals("")){ // SE O CAMPO DE DESTO NÃO ESTIVER VAZIO, EU POSSUO UM REGISTRO DENTRO DO MESMO
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir esse registro?", "Excluir", 2);
            if (confirmacao == 0){
                PagamentosDAOimpl func = new PagamentosDAOimpl();
                Pagamentos dts = new Pagamentos();
                dts.setIdpagamento(Integer.parseInt(txt_id_pagamento.getText())); // CAMPO DO DATASET QUE CONTEM A CLASSE VQUARTOS, NO CASO O IDQUARTOS RECEBE O VALOR PASSADO NO CAMPO TXT_ID_QUARTOS
                func.deletar(dts);
                mostrar("");
                desativar();
            }
        }
    }//GEN-LAST:event_btn_apagarActionPerformed

    private void TB_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_listaMouseClicked
        btn_salvar.setText("Editar");
        ativar();
        btn_apagar.setEnabled(true);
        acao="editar";
        int linha =TB_lista.rowAtPoint(evt.getPoint());

        txt_id_pagamento.setText(TB_lista.getValueAt(linha, 0).toString());
        txt_id_reserva.setText(TB_lista.getValueAt(linha, 1).toString());
        CB_tipo_comp.setSelectedItem(TB_lista.getValueAt(linha, 2).toString());
        txt_numero_comprovante.setText(TB_lista.getValueAt(linha, 3).toString());
        txt_taxa.setText(TB_lista.getValueAt(linha, 4).toString());
        txt_total_pgto.setText(TB_lista.getValueAt(linha, 5).toString());
        txt_data_emissao.setDate(Date.valueOf(TB_lista.getValueAt(linha, 6).toString()));
        txt_data_pgto.setDate(Date.valueOf(TB_lista.getValueAt(linha, 7).toString()));

    }//GEN-LAST:event_TB_listaMouseClicked

    private void txt_id_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_reservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_reservaActionPerformed

    private void txt_id_quartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_quartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_quartoActionPerformed

    private void txt_quartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quartoActionPerformed

    private void txt_total_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_reservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_reservaActionPerformed

    private void txt_numero_comprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_comprovanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_comprovanteActionPerformed

    private void txt_total_pgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_pgtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_pgtoActionPerformed

    void limpar(){
    }
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
            java.util.logging.Logger.getLogger(frm_pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_pagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_tipo_comp;
    private javax.swing.JLabel LB_registros;
    private javax.swing.JTable TB_lista;
    private javax.swing.JButton btn_apagar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt_cliente;
    private com.toedter.calendar.JDateChooser txt_data_emissao;
    private com.toedter.calendar.JDateChooser txt_data_pgto;
    private javax.swing.JTextField txt_id_pagamento;
    private javax.swing.JTextField txt_id_quarto;
    private javax.swing.JTextField txt_id_reserva;
    private javax.swing.JTextField txt_numero_comprovante;
    private javax.swing.JTextField txt_quarto;
    private javax.swing.JTextField txt_taxa;
    private javax.swing.JTextField txt_total_pgto;
    private javax.swing.JTextField txt_total_reserva;
    // End of variables declaration//GEN-END:variables
}