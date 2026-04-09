package com.academia_cli.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.academia_cli.model.Aluno;
import com.academia_cli.util.ConnectionFactory;

public class AlunoRepository {

    // CREATE
    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, cpf, telefone, email, curso, data_nascimento, id_plano) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTel());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCurso());
            stmt.setDate(6, java.sql.Date.valueOf(aluno.getDataNascimento())); 
            stmt.setLong(7, aluno.getIdPlano());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // READ (listar todos)
    public List<Aluno> listar() {
        String sql = "SELECT * FROM alunos";
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setTel(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
                a.setCurso(rs.getString("curso"));

                if (rs.getDate("data_nascimento") != null) {
                    a.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                }

                a.setIdPlano(rs.getLong("id_plano"));

                alunos.add(a);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }

    // READ (por id)
    public Aluno buscarPorId(Long id) {
        String sql = "SELECT * FROM alunos WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setTel(rs.getString("telefone"));
                a.setEmail(rs.getString("email"));
                a.setCurso(rs.getString("curso"));

                if (rs.getDate("data_nascimento") != null) {
                    a.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                }

                a.setIdPlano(rs.getLong("id_plano"));

                return a;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    // UPDATE
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, cpf = ?, telefone = ?, email = ?, curso = ?, data_nascimento = ?, id_plano = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTel());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCurso());
            stmt.setDate(6, java.sql.Date.valueOf(aluno.getDataNascimento()));
            stmt.setLong(7, aluno.getIdPlano());
            stmt.setLong(8, aluno.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE
    public void deletar(Long id) {
        String sql = "DELETE FROM alunos WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}