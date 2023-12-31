/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.quartosViewController;
import Model.BDconexaoDAO;
import Model.QuartosDAOimpl;
import Model.Quartos;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rafas
 */
public class quartosView extends javax.swing.JInternalFrame {

    /**
     * CRIAÇAO DO FORMULARIO DE QUARTOS
     */
    private quartosViewController controller; //DECLARAÇÃO DA VARIAVEL

    public quartosView() {
        controller = new quartosViewController(); //INICIALIZAÇAO DA VARIÁVEL
        initComponents();
        initComponents();
        desativar();
        // BUSCAR "VAZIO" USADO PARA QUE TODAS AS INFORMAÇÕES JÁ ESTEJAM VISIVEIS AO ACESSAR A TABELA.
        // CASO QUEIRA QUE APARESSA APENAS AS PESQUISADAS, MUDAR PARA "null".
        mostrar("");
    }

    private String acao = "salvar"; // DEIXAR AS COLUNAS OCULTAS, NÃO APARECENDO PARA O USUÁRIO

    void ocultar_coluna() {
        TB_lista.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(0).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void desativar() { // DEIXA AS COLUNAS DESATIVADAS APENAS PARA VISUALIZAÇÃO DOS DADOS DO USUÁRIO
        txt_id_quarto.setVisible(false);
        CB_andar.setEnabled(false);
        txt_numero.setEnabled(false);
        txt_valor_diaria.setEnabled(false);
        txt_descricao.setEnabled(false);
        txt_caracteristica.setEnabled(false);
        CB_estado.setEnabled(false);
        CB_tipo.setEnabled(false);

        btn_salvar.setEnabled(false);
        btn_cancelar.setEnabled(false);

        txt_id_quarto.setText("");
        txt_valor_diaria.setText("");
        txt_descricao.setText("");
        txt_caracteristica.setText("");
        txt_numero.setText("");

    }

    void ativar() { // DEIXA AS COLUNAS ATIVADAS PARA ATUALIZAÇÃO OU INSERÇÃO DE DADOS DO USUÁRIO
        txt_id_quarto.setVisible(false);
        CB_andar.setEnabled(true);
        txt_numero.setEnabled(true);
        txt_valor_diaria.setEnabled(true);
        txt_descricao.setEnabled(true);
        txt_caracteristica.setEnabled(true);
        CB_estado.setEnabled(true);
        CB_tipo.setEnabled(true);

        btn_salvar.setEnabled(true);
        btn_novo.setEnabled(true);
        btn_cancelar.setEnabled(true);

        txt_id_quarto.setText("");
        txt_valor_diaria.setText("");
        txt_descricao.setText("");
        txt_caracteristica.setText("");
        txt_numero.setText("");

    }

    //EXIBE A TABELA COM SUAS RESPECTIVAS INFORMAÇÕES
    void mostrar(String buscar) { // PUXA O METODO "mostrar" LINCADA A TABELA "modelo" NA CLASSE "quartosDAOimpl"
        try { //BLOCO TRY RESPONSÁVEL POR CUIDAR DE EXCESSÕES QUE PODEM VIR A OCORRER
            DefaultTableModel modelo = new DefaultTableModel(); //CRIA E DECLARA INSTÂNCIA 'DefaultTableModel' 

            TB_lista.setModel(controller.mostrar(buscar, modelo)); //CHAMA O MÉTODO "mostrar" DO "quartosViewController" PARA BUSCAR E MOSTRAR A TABELA/LISTA
            ocultar_coluna();
            LB_registros.setText("Total Registros " + Integer.toString(controller.getQtdRegistros())); // BUSCA E INFORMA A QUANTIDADE DE REGISTROS ENCONTRADOS
        } catch (Exception e) { //TRATA DA EXCESSÃO CASO DE PROBLEMA NA EXECUÇÃO DA CONSULTA 
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id_quarto = new javax.swing.JTextField();
        CB_andar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_caracteristica = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descricao = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txt_valor_diaria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CB_estado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        CB_tipo = new javax.swing.JComboBox<>();
        btn_salvar = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_numero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        btn_relatorio = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Quartos");

        jLabel3.setText("Número");

        jLabel4.setText("Andar");

        jLabel5.setText("Características");

        jLabel6.setText("Descrição");

        txt_id_quarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_quartoActionPerformed(evt);
            }
        });

        CB_andar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        CB_andar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_andarActionPerformed(evt);
            }
        });

        txt_caracteristica.setColumns(20);
        txt_caracteristica.setRows(5);
        jScrollPane1.setViewportView(txt_caracteristica);

        txt_descricao.setColumns(20);
        txt_descricao.setRows(5);
        jScrollPane2.setViewportView(txt_descricao);

        jLabel7.setText("Valor Diária");

        txt_valor_diaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valor_diariaActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado");

        CB_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponível", "Ocupado", "Manutenção" }));
        CB_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_estadoActionPerformed(evt);
            }
        });

        jLabel9.setText("Tipo do quarto");

        CB_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Familiar", "Presidencial", " " }));
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
        jLabel2.setText("Lista de Quartos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(22, 22, 22)
                            .addComponent(txt_valor_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CB_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_id_quarto)
                                .addComponent(CB_andar, 0, 91, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_novo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cancelar))
                            .addComponent(CB_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(CB_andar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txt_valor_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CB_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_novo))
                .addGap(19, 19, 19))
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
        jLabel12.setText("Lista de Quartos");

        btn_relatorio.setText("Relatório");
        btn_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LB_registros)
                        .addGap(80, 80, 80))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_apagar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_sair)))
                        .addContainerGap(21, Short.MAX_VALUE))))
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
                    .addComponent(jLabel10)
                    .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_apagar)
                    .addComponent(btn_sair)
                    .addComponent(btn_buscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LB_registros)
                    .addComponent(btn_relatorio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel12)
                    .addContainerGap(397, Short.MAX_VALUE)))
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
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CB_andarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_andarActionPerformed
        CB_andar.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_CB_andarActionPerformed

    private void CB_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_tipoActionPerformed
        CB_tipo.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_CB_tipoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        if (txt_numero.getText().length() == 0) { //CHECA PELA QUANITDADE SE EXISTEM CARACTERES NO CAMPO
            JOptionPane.showMessageDialog(rootPane, "Insira o número do quarto.");
            txt_numero.requestFocus();
            return;

        }
        if (txt_descricao.getText().length() == 0) { //CHECA PELA QUANITDADE SE EXISTEM CARACTERES NO CAMPO
            JOptionPane.showMessageDialog(rootPane, "Insira uma descrição para o quarto.");
            txt_descricao.requestFocus();
            return;

        }
        if (txt_caracteristica.getText().length() == 0) { //CHECA PELA QUANITDADE SE EXISTEM CARACTERES NO CAMPO
            JOptionPane.showMessageDialog(rootPane, "Insira as caracteristicas do quarto.");
            txt_caracteristica.requestFocus();
            return;

        }
        if (txt_valor_diaria.getText().length() == 0) { //CHECA PELA QUANITDADE SE EXISTEM CARACTERES NO CAMPO
            JOptionPane.showMessageDialog(rootPane, "Insira o valor da diária do quarto.");
            txt_valor_diaria.requestFocus();
            return;

        }

        Quartos dts = new Quartos(); //CRIA INSTANCIA APARTIR DE "Quartos" E ATRIBUI A VARIAVEL "dts"

        // CHAMA OS METODOS E REFERENCIA NO "dts"
        dts.setNumero(txt_numero.getText());
        dts.setValordiaria(Double.parseDouble(txt_valor_diaria.getText()));
        dts.setDescricao(txt_descricao.getText());
        dts.setCaracteristicas(txt_caracteristica.getText());

        int selecionado = CB_andar.getSelectedIndex();
        dts.setAndar((String) CB_andar.getItemAt(selecionado));

        selecionado = CB_estado.getSelectedIndex();
        dts.setEstado((String) CB_estado.getItemAt(selecionado));

        selecionado = CB_tipo.getSelectedIndex();
        dts.setTipoquarto((String) CB_tipo.getItemAt(selecionado));

        // VERIFICA SE A AÇÃO DO USUÁRIO
        if (acao.equals("salvar")) { //SE FOR SALVAR
            if (controller.inserir(dts)) { //CHAMA A FUNÇAO INSERIR CONTIDA NO "quartosViewController" E REPASSA PARA O "dts"
                JOptionPane.showMessageDialog(rootPane, "O registro de quarto foi inserido com sucesso.");
                mostrar("");
                desativar();
            }
        } else if (acao.equals("editar")) { //SE FOR EDITAR
            dts.setIdquarto(Integer.parseInt(txt_id_quarto.getText())); //REALIZA EDIÇÃO USANDO O ID 
            if (controller.editar(dts)) { //CHAMA A FUNÇAO EDITAR  CONTIDA NO "quartosViewController" E REPASSA PARA O "dts"
                JOptionPane.showMessageDialog(rootPane, "O registro de quarto foi editado com sucesso.");
                mostrar("");
                desativar();
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    public double obterValorDiaria() {
        if (txt_valor_diaria.getText().isEmpty()) {
            return 0;
        }
        return Double.parseDouble(txt_valor_diaria.getText());
    }

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        ativar(); //AO PRECIONAR O BOTÃO, ATIVA TODOS OS CAMPOS PARA INSERIR INFORMAÇÕES
        btn_salvar.setText("Salvar");
        acao = "salvar";
    }//GEN-LAST:event_btn_novoActionPerformed

    private void txt_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroActionPerformed
        txt_numero.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_txt_numeroActionPerformed

    private void txt_valor_diariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valor_diariaActionPerformed
        txt_valor_diaria.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_txt_valor_diariaActionPerformed

    private void CB_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_estadoActionPerformed
        CB_estado.transferFocus(); // AO PRESIONAR A TECLA ENTER, O USUÁRIO PASSA PARA OUTRO CAMPO DE INSERÇÃO
    }//GEN-LAST:event_CB_estadoActionPerformed

    private void txt_id_quartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_quartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_quartoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagarActionPerformed
        if (!txt_id_quarto.getText().equals("")) { //VERIFICA SE TEM INFOMMACÃO NO CAMPO
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir esse registro?", "Excluir", 2);
            if (confirmacao == 0) { //SOLICITA CONFIRMAÇAO
                Quartos dts = new Quartos(); //CRIA INSTANCIA APARTIR DE "Quartos" E ATRIBUI A VARIAVEL "dts"
                dts.setIdquarto(Integer.parseInt(txt_id_quarto.getText())); //RECUPERA O ID DO QUARTO
                controller.deletar(dts); //CHAMA A FUNÇAO DELETAR CONTIDA NO "quartosViewController" E REPASSA PARA O "dts"
                mostrar("");
                desativar();
            }
        }
    }//GEN-LAST:event_btn_apagarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        mostrar(txt_pesquisar.getText()); //REALIZA PESQUISA POR MEIO DE UM PARAMETRO ESPECIFICO FORNECIDO PELO USUÁRIO
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void TB_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_listaMouseClicked
        btn_salvar.setText("Editar");
        ativar();
        btn_apagar.setEnabled(true);
        acao = "editar";
        int linha = TB_lista.rowAtPoint(evt.getPoint());

        txt_id_quarto.setText(TB_lista.getValueAt(linha, 0).toString());
        txt_numero.setText(TB_lista.getValueAt(linha, 1).toString());
        CB_andar.setSelectedItem(TB_lista.getValueAt(linha, 2).toString());
        txt_descricao.setText(TB_lista.getValueAt(linha, 3).toString());
        txt_caracteristica.setText(TB_lista.getValueAt(linha, 4).toString());
        txt_valor_diaria.setText(TB_lista.getValueAt(linha, 5).toString());
        CB_estado.setSelectedItem(TB_lista.getValueAt(linha, 6).toString());
        CB_tipo.setSelectedItem(TB_lista.getValueAt(linha, 7).toString());
    }//GEN-LAST:event_TB_listaMouseClicked

    private Connection connection = (Connection) new BDconexaoDAO().conectar();

    private void btn_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relatorioActionPerformed
        Map p = new HashMap();
        JasperReport relatorio;
        JasperPrint impressao;

        try {
            relatorio = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/View/relatorio_quartos.jrxml");
            impressao = JasperFillManager.fillReport(relatorio, p, connection);
            JasperViewer view = new JasperViewer(impressao, false);
            view.setTitle("Relatório: Quartos");
            view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_relatorioActionPerformed

    void limpar() {
        txt_id_quarto.setText("");
        txt_valor_diaria.setText("");
        txt_descricao.setText("");
        txt_caracteristica.setText("");
        txt_numero.setText("");
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
            java.util.logging.Logger.getLogger(quartosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quartosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quartosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quartosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quartosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_andar;
    public static javax.swing.JComboBox<String> CB_estado;
    private javax.swing.JComboBox<String> CB_tipo;
    private javax.swing.JLabel LB_registros;
    private javax.swing.JTable TB_lista;
    private javax.swing.JButton btn_apagar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_relatorio;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txt_caracteristica;
    private javax.swing.JTextArea txt_descricao;
    private javax.swing.JTextField txt_id_quarto;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_valor_diaria;
    // End of variables declaration//GEN-END:variables
}
