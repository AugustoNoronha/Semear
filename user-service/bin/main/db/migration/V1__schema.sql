-- Criação inicial das tabelas do Semear
-- Banco de dados alvo: PostgreSQL v15+

CREATE SEQUENCE IF NOT EXISTS usuarios_seq START 1;
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT PRIMARY KEY DEFAULT nextval('usuarios_seq'),
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    senha_hash VARCHAR(255) NOT NULL,
    cidade VARCHAR(100),
    estado VARCHAR(2),
    tipo_usuario VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE SEQUENCE IF NOT EXISTS animais_seq START 1;
CREATE TABLE IF NOT EXISTS animais (
    id BIGINT PRIMARY KEY DEFAULT nextval('animais_seq'),
    usuario_id BIGINT NOT NULL,
    especie VARCHAR(20) NOT NULL CHECK (especie IN ('CAVALO', 'BOI')),
    nome VARCHAR(255) NOT NULL,
    sexo VARCHAR(20) NOT NULL,
    raca VARCHAR(100),
    data_nascimento DATE,
    cor VARCHAR(50),
    peso NUMERIC(10,2),
    registro_genealogico VARCHAR(100),
    finalidade VARCHAR(255),
    material_genetico_disponivel BOOLEAN NOT NULL DEFAULT FALSE,
    descricao TEXT,
    valor NUMERIC(15,2),
    status_anuncio VARCHAR(50) NOT NULL,
    cidade VARCHAR(100),
    estado VARCHAR(2),
    data_cadastro TIMESTAMP NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_animais_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS cavalos (
    animal_id BIGINT PRIMARY KEY,
    andar VARCHAR(100),
    altura NUMERIC(5,2),
    modalidade VARCHAR(100),
    temperamento VARCHAR(100),
    CONSTRAINT fk_cavalos_animal FOREIGN KEY (animal_id) REFERENCES animais (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS bois (
    animal_id BIGINT PRIMARY KEY,
    tipo_criacao VARCHAR(100),
    confinado BOOLEAN NOT NULL DEFAULT FALSE,
    producao_media_leite NUMERIC(10,2),
    ganho_peso_medio NUMERIC(10,2),
    CONSTRAINT fk_bois_animal FOREIGN KEY (animal_id) REFERENCES animais (id) ON DELETE CASCADE
);

CREATE SEQUENCE IF NOT EXISTS genetica_seq START 1;
CREATE TABLE IF NOT EXISTS animais_genetica (
    id BIGINT PRIMARY KEY DEFAULT nextval('genetica_seq'),
    animal_id BIGINT NOT NULL UNIQUE,
    linhagem_pai VARCHAR(255),
    linhagem_mae VARCHAR(255),
    indice_genetico VARCHAR(255),
    historico_premiacoes TEXT,
    aptidao_reprodutiva TEXT,
    exames_sanitarios TEXT,
    observacoes TEXT,
    CONSTRAINT fk_genetica_animal FOREIGN KEY (animal_id) REFERENCES animais (id) ON DELETE CASCADE
);

CREATE SEQUENCE IF NOT EXISTS foto_seq START 1;
CREATE TABLE IF NOT EXISTS animais_fotos (
    id BIGINT PRIMARY KEY DEFAULT nextval('foto_seq'),
    animal_id BIGINT NOT NULL,
    url_foto TEXT NOT NULL,
    ordem INTEGER NOT NULL DEFAULT 0,
    principal BOOLEAN NOT NULL DEFAULT FALSE,
    data_upload TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_foto_animal FOREIGN KEY (animal_id) REFERENCES animais (id) ON DELETE CASCADE
);

CREATE SEQUENCE IF NOT EXISTS conversas_seq START 1;
CREATE TABLE IF NOT EXISTS conversas (
    id BIGINT PRIMARY KEY DEFAULT nextval('conversas_seq'),
    animal_id BIGINT NOT NULL,
    comprador_id BIGINT NOT NULL,
    vendedor_id BIGINT NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
    ultima_interacao_em TIMESTAMP NOT NULL DEFAULT NOW(),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_conversas_animal FOREIGN KEY (animal_id) REFERENCES animais (id) ON DELETE CASCADE,
    CONSTRAINT fk_conversas_comprador FOREIGN KEY (comprador_id) REFERENCES usuarios (id) ON DELETE CASCADE,
    CONSTRAINT fk_conversas_vendedor FOREIGN KEY (vendedor_id) REFERENCES usuarios (id) ON DELETE CASCADE
);

CREATE SEQUENCE IF NOT EXISTS mensagens_seq START 1;
CREATE TABLE IF NOT EXISTS mensagens (
    id BIGINT PRIMARY KEY DEFAULT nextval('mensagens_seq'),
    conversa_id BIGINT NOT NULL,
    remetente_id BIGINT NOT NULL,
    texto TEXT NOT NULL,
    lida BOOLEAN NOT NULL DEFAULT FALSE,
    data_envio TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_mensagens_conversa FOREIGN KEY (conversa_id) REFERENCES conversas (id) ON DELETE CASCADE,
    CONSTRAINT fk_mensagens_remetente FOREIGN KEY (remetente_id) REFERENCES usuarios (id) ON DELETE CASCADE
);

CREATE SEQUENCE IF NOT EXISTS notificacoes_seq START 1;
CREATE TABLE IF NOT EXISTS notificacoes (
    id BIGINT PRIMARY KEY DEFAULT nextval('notificacoes_seq'),
    usuario_id BIGINT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    referencia_id BIGINT,
    lida BOOLEAN NOT NULL DEFAULT FALSE,
    data_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_notificacoes_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios (id) ON DELETE CASCADE
);
