/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author cauea
 */
public class Tarefa {
    private String titulo;
    private String descricao;
    private int dataConclusao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(int dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
    
}
