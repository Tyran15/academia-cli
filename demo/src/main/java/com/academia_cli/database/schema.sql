-- =========================
-- TABELA PLANOS
-- =========================
CREATE TABLE planos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    tipo_plano VARCHAR(50) NOT NULL
);

-- =========================
-- TABELA ALUNOS
-- =========================
CREATE TABLE alunos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    curso VARCHAR(100),
    data_nascimento DATE,
    
    id_plano INTEGER NOT NULL,
    CONSTRAINT fk_aluno_plano
        FOREIGN KEY (id_plano)
        REFERENCES planos(id)
        ON DELETE RESTRICT
);

-- =========================
-- TABELA INSTRUTORES
-- =========================
CREATE TABLE instrutores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    endereco TEXT,
    data_nascimento DATE,
    telefone VARCHAR(20),
    email VARCHAR(100)
);

-- =========================
-- TABELA AULAS
-- =========================
CREATE TABLE aulas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_hora_aula TIMESTAMP NOT NULL,
    capacidade_alunos INTEGER NOT NULL CHECK (capacidade_alunos > 0),

    id_instrutor INTEGER NOT NULL,
    CONSTRAINT fk_aula_instrutor
        FOREIGN KEY (id_instrutor)
        REFERENCES instrutores(id)
        ON DELETE RESTRICT
);

-- =========================
-- TABELA FREQUENCIA
-- =========================
CREATE TABLE frequencia (
    id SERIAL PRIMARY KEY,
    id_aluno INTEGER NOT NULL,
    data_hora_checking TIMESTAMP NOT NULL,

    CONSTRAINT fk_frequencia_aluno
        FOREIGN KEY (id_aluno)
        REFERENCES alunos(id)
        ON DELETE CASCADE
);

-- =========================
-- TABELA ASSOCIATIVA (N:N)
-- ALUNOS x AULAS
-- =========================
CREATE TABLE alunos_aulas (
    id_aluno INTEGER NOT NULL,
    id_aula INTEGER NOT NULL,

    PRIMARY KEY (id_aluno, id_aula),

    CONSTRAINT fk_aluno
        FOREIGN KEY (id_aluno)
        REFERENCES alunos(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_aula
        FOREIGN KEY (id_aula)
        REFERENCES aulas(id)
        ON DELETE CASCADE
);