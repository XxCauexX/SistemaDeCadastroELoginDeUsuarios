/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Statement;
import java.sql.PreparedStatement;//
import java.sql.Connection;//
import java.sql.DriverManager;//
import java.sql.SQLException;//
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cauea
 */
public class ConexaoDAO {
    
    public String sqlErro;
    Connection conn;
    Statement st;
    PreparedStatement stt;//para consulta com select retornando dados
    
    ResultSet rs;
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info_db", "root", "");
            st = conn.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean salvar(Usuario usuarioX) {
        String inserir;
        inserir = "INSERT INTO usuariocadastro (nome,email,senha) values ('"+usuarioX.getNome()+"','"+usuarioX.getEmail()+"','"+usuarioX.getSenha()+"')";
        try {
            st.execute(inserir);
            return true;
        } catch (SQLException ex) {
            sqlErro = ex.toString();
            System.out.println(ex);
            return false;
        }
    }
    
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {

        }
    }
    
    public Usuario logar(String nome) {
        Usuario usuario = new Usuario();
        try {
            stt = conn.prepareStatement("SELECT nome,senha FROM usuarioCadastro where nome = ?");
            stt.setString(1, nome);
            rs=stt.executeQuery();
            if (rs.next()) {
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            } else {
                return null;
            }
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
