/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author rafas
 */

public class Pagamentos { // CLASSE RESPONSÁVEL PELA CRIAÇÃO DAS VARIAVEIS QUE COMPÕE/DEFINEM OS PAGAMENTOS NO SISTEMA
    private int idpagamento; // DECLARA O ID DO PAGAMENTO. *Definido como alto increment
    private int idreserva; // DECLARA O ID DA RESERVA. *Definido como alto increment
    private String tipo_comprovante; // DECLARA O TIPO DE COMPROVANTE
    private String  num_comprovante; // DECLARA O NÚMERO NUMERO DO COMPROVANTE
    private Double total_pagamento; // DECLARA O TOTAL DO PAGAMENTO
    private Date data_emissao; // DECLARA A DATA DA EMISSÃO
    private Date data_pagamento; // DECLARA A DATA DE PAGEMENTO
 
    // INICIA UM MÉTODO CONSTRUTOR VAZIO
    public Pagamentos() {
    }

    // INICIA O MÉTODO CONSTRUTOR
    public Pagamentos(int idpagamento, int idreserva, String tipo_comprovante, String num_comprovante, Double total_pagamento, Date data_emissao, Date data_pagamento) {
        this.idpagamento = idpagamento;
        this.idreserva = idreserva;
        this.tipo_comprovante = tipo_comprovante;
        this.num_comprovante = num_comprovante;
        this.total_pagamento = total_pagamento;
        this.data_emissao = data_emissao;
        this.data_pagamento = data_pagamento;
    }

    // INICIA OS MÉTODO GET´s | SET´s
    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipo_comprovante() {
        return tipo_comprovante;
    }

    public void setTipo_comprovante(String tipo_comprovante) {
        this.tipo_comprovante = tipo_comprovante;
    }

    public String getNum_comprovante() {
        return num_comprovante;
    }

    public void setNum_comprovante(String num_comprovante) {
        this.num_comprovante = num_comprovante;
    }

    public Double getTotal_pagamento() {
        return total_pagamento;
    }

    public void setTotal_pagamento(Double total_pagamento) {
        this.total_pagamento = total_pagamento;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
    
    
            
            
    
}
