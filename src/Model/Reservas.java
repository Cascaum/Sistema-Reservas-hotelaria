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
public class Reservas { // CLASSE RESPONSÁVEL PELA CRIAÇÃO DAS VARIAVEIS QUE COMPÕE/DEFINEM AS INFORMAÇÕES DAS RESERVAS NO SISTEMA
    private int idreserva; // DECLARA O ID DA RESERVA. *Definido como alto increment
    private int idquarto; // USA O ID DO QUARTO.
    private int idcliente; // USA O ID DO CLIENTE.
    private int idfuncionario; // USA O ID DO FUNCIONARIO.
    private String tipo_reserva; // DECLARA O TIPO DA RESERVA.
    private Date data_reserva; // DECLARA A DATA QUE FOI FEITO A RESERVA.
    private Date data_entrada; // DECLARA A DATA DE ENTRADA.
    private Date data_saida; // DECLARA A DATA DE SAIDA.
    private Double valor_quarto; // DECLARA O VALOR DO QUARTO.
    private String estado; // DECLARA O ESTADO DA RESERVA.

    // INICIA O MÉTODO CONSTRUTOR VAZIO
    public Reservas() {
    }

    // INICIA O MÉTODO CONSTRUTOR
    public Reservas(int idreserva, int idquarto, int idcliente, int idfuncionario, String tipo_reserva, Date data_reserva, Date data_entrada, Date data_saida, Double valor_quarto, String estado) {
        this.idreserva = idreserva;
        this.idquarto = idquarto;
        this.idcliente = idcliente;
        this.idfuncionario = idfuncionario;
        this.tipo_reserva = tipo_reserva;
        this.data_reserva = data_reserva;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.valor_quarto = valor_quarto;
        this.estado = estado;
    }

    // INICIA OS MÉTODO GET´s | SET´s
    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdquarto() {
        return idquarto;
    }

    public void setIdquarto(int idquartos) {
        this.idquarto = idquartos;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public Date getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Double getValor_quarto() {
        return valor_quarto;
    }

    public void setValor_quarto(Double valor_quarto) {
        this.valor_quarto = valor_quarto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
