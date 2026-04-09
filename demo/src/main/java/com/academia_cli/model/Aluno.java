package com.academia_cli.model;

import java.time.LocalDate;

public class Aluno {
    private Long id;
    private String nome;
    private String cpf;
    private String tel;
    private String email;
    private String curso;
    private LocalDate dataNascimento;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    private Long idPlano;
    
    public Long getIdPlano() {
        return idPlano;
    }
    public void setIdPlano(Long idPlano) {
        this.idPlano = idPlano;
    }

}
