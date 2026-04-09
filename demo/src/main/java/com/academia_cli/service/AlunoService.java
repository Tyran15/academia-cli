package com.academia_cli.service;

import java.util.List;

import com.academia_cli.model.Aluno;
import com.academia_cli.repository.AlunoRepository;

public class AlunoService {

    private AlunoRepository repository = new AlunoRepository();

    public void cadastrar(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        if (aluno.getCpf() == null) {
            throw new IllegalArgumentException("CPF obrigatório");
        }

        repository.salvar(aluno);
    }

    public List<Aluno> listar() {
        return repository.listar();
    }

    public void atualizar(Aluno aluno) {
        if (aluno.getId() == null) {
            throw new IllegalArgumentException("ID obrigatório");
        }

        repository.atualizar(aluno);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}
