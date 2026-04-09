package com.academia_cli;

import com.academia_cli.model.Aluno;
import com.academia_cli.service.AlunoService;

import java.time.LocalDate;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) {

        AlunoService service = new AlunoService();

        // =====================
        // CREATE
        // =====================
        Aluno novo = new Aluno();
        novo.setNome("Matheus Henrique");
        novo.setCpf("123.456.789-01");
        novo.setTel("(51) 99999-9999");
        novo.setEmail("matheus@email.com");
        novo.setCurso("Musculação");
        novo.setDataNascimento(LocalDate.of(2006, 5, 10));
        novo.setIdPlano(1L); // ⚠️ precisa existir no banco

        service.cadastrar(novo);

        // =====================
        // READ (LISTAR)
        // =====================
        System.out.println("=== LISTANDO ALUNOS ===");

        List<Aluno> alunos = service.listar();

        for (Aluno a : alunos) {
            System.out.println(
                "ID: " + a.getId() +
                " | Nome: " + a.getNome() +
                " | CPF: " + a.getCpf() +
                " | Tel: " + a.getTel() +
                " | Email: " + a.getEmail() +
                " | Curso: " + a.getCurso() +
                " | Nascimento: " + a.getDataNascimento() +
                " | Plano: " + a.getIdPlano()
            );
        }

        // =====================
        // UPDATE
        // =====================
        Aluno atualizar = new Aluno();
        atualizar.setId(1L); // ⚠️ ID existente
        atualizar.setNome("Matheus Atualizado");
        atualizar.setCpf("123.456.789-00");
        atualizar.setTel("(51) 98888-7777");
        atualizar.setEmail("novo@email.com");
        atualizar.setCurso("Crossfit");
        atualizar.setDataNascimento(LocalDate.of(2005, 1, 1));
        atualizar.setIdPlano(1L);

        service.atualizar(atualizar);

        System.out.println("\n=== APÓS UPDATE ===");
        service.listar().forEach(a ->
            System.out.println(a.getId() + " - " + a.getNome())
        );

        // =====================
        // DELETE
        // =====================
        service.deletar(1L); // ⚠️ cuidado: apaga do banco

        System.out.println("\nRegistro deletado.");

        System.out.println("\n=== FINAL ===");
        service.listar().forEach(a ->
            System.out.println(a.getId() + " - " + a.getNome())
        );
    }
}