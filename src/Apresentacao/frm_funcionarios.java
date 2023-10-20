/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Apresentacao;

import Model.Funcionarios;
import DAO.FuncionariosDAOimpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author rafas
 */
public class frm_funcionarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form frm_clientes
     */
    public frm_funcionarios() {
        initComponents();
        desativar();
        mostrar("");
    }
    
    private String acao = "salvar"; // DEIXAR AS COLUNAS OCULTAS, NÃO APARECENDO PARA O USUÁRIO
    void ocultar_coluna(){
        TB_lista.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(0).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    void desativar(){ // DEIXA AS COLUNAS DESATIVADAS APENAS PARA VISUALIZAÇÃO DOS DADOS DO USUÁRIO
        txt_id_pessoa.setVisible(false);
        CB_tipo.setEnabled(false);
        txt_nome.setEnabled(false);
        txt_num_doc.setEnabled(false);
        txt_telefone.setEnabled(false);
        txt_email.setEnabled(false);
        txt_endereco.setEnabled(false);
        //txt_codigo_cliente.setEnabled(false);
        txt_salario.setEnabled(false);
        txt_senha.setEnabled(false);
        txt_login.setEnabled(false);
        CB_estado.setEnabled(false);
        CB_acesso.setEnabled(false);
        
        btn_salvar.setEnabled(false);
        btn_cancelar.setEnabled(false);
        
        txt_num_doc.setText("");
        txt_telefone.setText("");
        txt_email.setText("");
        txt_endereco.setText("");
        txt_nome.setText("");
        //txt_codigo_cliente.setText("");
        txt_salario.setText("");
        txt_senha.setText("");
        txt_login.setText("");

    }
    
    void ativar(){ // DEIXA AS COLUNAS ATIVADAS PARA ATUALIZAÇÃO OU INSERÇÃO DE DADOS DO USUÁRIO
        txt_id_pessoa.setVisible(false);
        CB_tipo.setEnabled(true);
        txt_nome.setEnabled(true);
        txt_num_doc.setEnabled(true);
        txt_telefone.setEnabled(true);
        txt_email.setEnabled(true);
        txt_endereco.setEnabled(true);
        //txt_codigo_cliente.setEnabled(true);
        txt_salario.setEnabled(true);
        txt_senha.setEnabled(true);
        txt_login.setEnabled(true);
        CB_estado.setEnabled(true);
        CB_acesso.setEnabled(true);
        
        btn_salvar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        
        txt_num_doc.setText("");
        txt_telefone.setText("");
        txt_email.setText("");
        txt_endereco.setText("");
        txt_nome.setText("");
        //txt_codigo_cliente.setText("");
        txt_salario.setText("");
        txt_senha.setText("");
        txt_login.setText("");

    }
    
    void mostrar (String buscar){ // PUXA O METODO "mostrar" LINCADA A TABELA "modelo" NA CLASSE "fquartos"
        try{
            DefaultTableModel modelo;
            FuncionariosDAOimpl func = new FuncionariosDAOimpl();
            modelo = func.mostrar(buscar);
            TB_lista.setModel(modelo);
            ocultar_coluna();
            LB_registros.setText("Total Registros " + Integer.toString(func.totalregistros));
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    void limpar(){
        txt_num_doc.setText("");
        txt_telefone.setText("");
        txt_email.setText("");
        txt_endereco.setText("");
        txt_nome.setText("");
        //txt_codigo_cliente.setText("");
        txt_salario.setText("");
        txt_senha.setText("");
        txt_login.setText("");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CB_tipo = new javax.swing.JComboBox<>();
        txt_id_pessoa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        txt_email = new javax.swing.JTextField();
        btn_novo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_endereco = new javax.swing.JTextArea();
        txt_nome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_telefone = new javax.swing.JTextField();
        txt_num_doc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_salario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CB_acesso = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CB_estado = new javax.swing.JComboBox<>();
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

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Funcionários");

        jLabel4.setText("E-mail");

        jLabel5.setText("Documento");

        jLabel3.setText("Nome");

        CB_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RG", "CPF", "CNH", "Passaporte" }));

        txt_id_pessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_pessoaActionPerformed(evt);
            }
        });

        jLabel6.setText("Número");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        jLabel7.setText("Endereço");

        btn_cancelar.setText("Limpar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        txt_endereco.setColumns(20);
        txt_endereco.setRows(5);
        jScrollPane1.setViewportView(txt_endereco);

        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefone");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cadastro de Funcionários");

        txt_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefoneActionPerformed(evt);
            }
        });

        txt_num_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_num_docActionPerformed(evt);
            }
        });

        jLabel13.setText("Salário");

        txt_salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salarioActionPerformed(evt);
            }
        });

        jLabel14.setText("Acesso");

        CB_acesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "PADRÃO", " " }));
        CB_acesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_acessoActionPerformed(evt);
            }
        });

        jLabel15.setText("Login");

        txt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loginActionPerformed(evt);
            }
        });

        jLabel16.setText("Senha");

        txt_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_senhaActionPerformed(evt);
            }
        });

        jLabel17.setText("Estado");

        CB_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "D" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_num_doc)
                                            .addComponent(txt_telefone)))
                                    .addComponent(txt_nome)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_id_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CB_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CB_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(CB_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addGap(187, 187, 187)
                        .addComponent(jLabel16)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btn_novo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cancelar))
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txt_num_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(CB_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(CB_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_novo))
                .addContainerGap(29, Short.MAX_VALUE))
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
        jLabel12.setText("Lista de Funcionários");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_registros)
                .addGap(47, 47, 47))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_apagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel12)
                    .addContainerGap(552, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_apagar)
                    .addComponent(btn_sair)
                    .addComponent(btn_buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LB_registros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel12)
                    .addContainerGap(311, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txt_id_pessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_pessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_pessoaActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        if(txt_nome.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Insira o nome do funcionário.");
            txt_nome.requestFocus();
            return;

        }

        Funcionarios dts = new Funcionarios();
        FuncionariosDAOimpl func = new FuncionariosDAOimpl();

        dts.setNome(txt_nome.getText());
        dts.setNum_documento(txt_num_doc.getText());
        dts.setEndereco(txt_endereco.getText());
        dts.setEmail(txt_email.getText());
        dts.setTelefone(txt_telefone.getText());
        
        dts.setSalario(Double.parseDouble(txt_salario.getText()));
        dts.setLogin(txt_login.getText());
        dts.setSenha(txt_senha.getText());
        
        

        int selecionado = CB_tipo.getSelectedIndex();
        dts.setTipo_documento((String) CB_tipo.getItemAt(selecionado));
        
        selecionado = CB_acesso.getSelectedIndex();
        dts.setAcesso((String) CB_acesso.getItemAt(selecionado));;
        
        selecionado = CB_estado.getSelectedIndex();
        dts.setEstado((String) CB_estado.getItemAt(selecionado));
        
        if(acao.equals("salvar")){
            if(func.inserir(dts)){
                JOptionPane.showMessageDialog(rootPane, "O registro de funcionario foi inserido com sucesso.");
                mostrar("");
                desativar();
            }
        } else if(acao.equals("editar")) {
            dts.setId_pessoa(Integer.parseInt(txt_id_pessoa.getText()));

            if(func.editar(dts)){
                JOptionPane.showMessageDialog(rootPane, "O registro de funcionario foi editado com sucesso.");
                mostrar("");
                desativar();
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        ativar();
        btn_salvar.setText("Salvar");
        acao="salvar";
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        txt_nome.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefoneActionPerformed

    private void txt_num_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_num_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_num_docActionPerformed

    private void TB_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_listaMouseClicked
        btn_salvar.setText("Editar");
        ativar();
        btn_apagar.setEnabled(true);
        acao="editar";
        int linha =TB_lista.rowAtPoint(evt.getPoint());

        txt_id_pessoa.setText(TB_lista.getValueAt(linha, 0).toString());
        txt_nome.setText(TB_lista.getValueAt(linha, 1).toString());
        CB_tipo.setSelectedItem(TB_lista.getValueAt(linha, 2).toString());
        txt_num_doc.setText(TB_lista.getValueAt(linha, 3).toString());
        txt_endereco.setText(TB_lista.getValueAt(linha, 4).toString());
        txt_telefone.setText(TB_lista.getValueAt(linha, 5).toString());
        txt_email.setText(TB_lista.getValueAt(linha, 6).toString());
        txt_salario.setText(TB_lista.getValueAt(linha, 7).toString());
        CB_acesso.setSelectedItem(TB_lista.getValueAt(linha, 8).toString());
        txt_login.setText(TB_lista.getValueAt(linha, 9).toString());
        txt_senha.setText(TB_lista.getValueAt(linha, 10).toString());
        CB_estado.setSelectedItem(TB_lista.getValueAt(linha, 11).toString());


    }//GEN-LAST:event_TB_listaMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        mostrar(txt_pesquisar.getText());
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagarActionPerformed
        if(!txt_id_pessoa.getText().equals("")){ // SE O CAMPO DE DESTO NÃO ESTIVER VAZIO, EU POSSUO UM REGISTRO DENTRO DO MESMO
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir esse registro?", "Excluir", 2);
            if (confirmacao == 0){
                FuncionariosDAOimpl func = new FuncionariosDAOimpl();
                Funcionarios dts = new Funcionarios();
                dts.setId_pessoa(Integer.parseInt(txt_id_pessoa.getText())); // CAMPO DO DATASET QUE CONTEM A CLASSE VQUARTOS, NO CASO O IDQUARTOS RECEBE O VALOR PASSADO NO CAMPO TXT_ID_QUARTOS
                func.deletar(dts);
                mostrar("");
                desativar();
            }
        }
    }//GEN-LAST:event_btn_apagarActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void txt_salarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salarioActionPerformed

    private void txt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loginActionPerformed

    private void txt_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_senhaActionPerformed

    private void CB_acessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_acessoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_acessoActionPerformed

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
            java.util.logging.Logger.getLogger(frm_funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_funcionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_acesso;
    private javax.swing.JComboBox<String> CB_estado;
    private javax.swing.JComboBox<String> CB_tipo;
    private javax.swing.JLabel LB_registros;
    private javax.swing.JTable TB_lista;
    private javax.swing.JButton btn_apagar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextArea txt_endereco;
    public static javax.swing.JTextField txt_id_pessoa;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_num_doc;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_salario;
    private javax.swing.JTextField txt_senha;
    private javax.swing.JTextField txt_telefone;
    // End of variables declaration//GEN-END:variables
}
