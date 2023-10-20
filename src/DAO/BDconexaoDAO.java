/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rafas
 */
public class BDconexaoDAO { // CLASSE USADA PARA ARMAZENAR OS ITENS USADOS NA CONEXÃO DO BANCO DE DADOS DO SISTEMA

    public String db = "bancoreserva"; // VARIAVEL RESPONSÁVEL POR CARREGAR O BANCO DE DADOS
    public String url = "jdbc:mysql://127.0.0.1/" + db; // VARIAVEL RESPONSÁVEL POR BUSCAR A LOCALIZAÇÃO DO SERVIDOR LOCAL PADRÃO. O "bd" É RESPONSÁVEL POR CONECTAR COM O BANCO DENTRO DO SERVIDOR.
    public String user = "root"; // VARIAVEL RESPONSÁVEL POR DEFINIR O USUÁRIO DE ACESSO. 
    public String pass = ""; // VARIAVEL RESPONSÁVEL POR DEFINIR A SENHA DE ACESSO. *Ela é nula para que não seja exigida.

    public BDconexaoDAO() {

    }

    public Connection conectar() { // VARIAVEL RESPONSÁVEL POR PASSAR AS INFORMAÇÕES DO BANCO DE DADOS.
        Connection link = null; // CONEXAO USADA PARA ACESSAR O SERVIDOR ONLINE USANDO UM LINK. "null" POIS É DECLARADO NO BLOCO TRY.
        try { // CONECTA NO BANCO UTILIZANDO O DRIVE DE ACESSO.
            Class.forName("org.gjt.mm.mysql.Driver"); // NOME DO DESTINO ONDE SE ENCONTRA O DRIVER DE CONEXÃO.
            link = DriverManager.getConnection(this.url, this.user, this.pass); // REPASSA AS VARIAVEIS DEFINIDAS ANTERIORMENTE PARA CONECTAR NO BANCO DE DADOS.
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // EXCESSÃO USADA PARA TRATAR A EXCESSÃO CASO FALHE A TENTATIVA DE CONEXÃO AO BANCO.
        }
        return link; // RETORNA O LINK DE ACESSO AO BANCO DE DADOS.
    }
}
