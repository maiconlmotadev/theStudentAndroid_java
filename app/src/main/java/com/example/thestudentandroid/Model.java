package com.example.thestudentandroid;

public class Model {

    private int id;
    private String nomeAluno;
    private String moradaAluno;
    private String telefoneAluno;
    private String emailAluno;
    // Gerar constructor

    public Model(int id, String nomeAluno, String moradaAluno, String telefoneAluno, String emailAluno) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.moradaAluno = moradaAluno;
        this.telefoneAluno = telefoneAluno;
        this.emailAluno = emailAluno;

    }
    // Gerar getter e setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMoradaAluno() {
        return moradaAluno;
    }

    public void setMoradaAluno(String moradaAluno) {
        this.moradaAluno = moradaAluno;
    }

    public String getTelefoneAluno() {
        return telefoneAluno;
    }

    public void setTelefoneAluno(String telefoneAluno) {
        this.telefoneAluno = telefoneAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }
}
