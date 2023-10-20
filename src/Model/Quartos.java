/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafas
 */
public class Quartos { // CLASSE RESPONSÁVEL PELA CRIAÇÃO DAS VARIAVEIS QUE COMPÕE/DEFINEM OS QUARTOS NO SISTEMA
    private int idquarto; // DECLARA O ID DO QUARTO. *Definido como alto increment
    private String numero; // DECLARA O NÚMERO DO QUARTO
    private String andar; // DECLARA O ANDAR EM QUE O QUARTO SE ENCONTRA CASO SEJA UM PRÉDIO
    private String descricao; // DECLARA A DESCRIÇÃO DO QUARTO
    private String caracteristicas; // DECLARA AS CARACTERISTICAS DO QUARTO
    private Double valordiaria; // DECLARA O VALOR DA DIÁRIA DO QUARTO
    private String estado; // DECLARA O ESTADO EM QUE O QUARTO SE ENCONTRA
    private String tipoquarto; // DECLARA O TIPO DE QUARTO.

    // INICIA O MÉTODO CONSTRUTOR
    public Quartos(int idquarto, String numero, String andar, String descricao, String caracteristicas, Double valordiaria, String estado, String tipoquarto) {
        this.idquarto = idquarto;
        this.numero = numero;
        this.andar = andar;
        this.descricao = descricao;
        this.caracteristicas = caracteristicas;
        this.valordiaria = valordiaria;
        this.estado = estado;
        this.tipoquarto = tipoquarto;
    }

    // INICIA UM MÉTODO CONSTRUTOR VAZIO
    public Quartos() {
        
    }

    // INICIA OS MÉTODO GET´s | SET´s
    public int getIdquarto() {
        return idquarto;
    }

    public void setIdquarto(int idquarto) {
        this.idquarto = idquarto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getValordiaria() {
        return valordiaria;
    }

    public void setValordiaria(Double valordiaria) {
        this.valordiaria = valordiaria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoquarto() {
        return tipoquarto;
    }

    public void setTipoquarto(String tipoquarto) {
        this.tipoquarto = tipoquarto;
    }
    
}
