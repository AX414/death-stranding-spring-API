-- Responsáveis pelas cidades principais
INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Deadman', id
FROM abrigo WHERE nome = 'Cidade de Capital Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Deadman'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Fragile', id
FROM abrigo WHERE nome = 'Cidade de Lake Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Fragile'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Mama', id
FROM abrigo WHERE nome = 'Cidade de South Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Mama'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Higgs', id
FROM abrigo WHERE nome = 'Cidade de Port Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Higgs'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Lockne', id
FROM abrigo WHERE nome = 'Cidade de Mountain Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Lockne'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Clifford Unger', id
FROM abrigo WHERE nome = 'Cidade de Edge Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Clifford Unger'
);

-- Centros de distribuição
INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Heartman', id
FROM abrigo WHERE nome = 'Centro de Distribuição Oeste de Capital Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Heartman'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Thomas Sutherland', id
FROM abrigo WHERE nome = 'Centro de Distribuição Sul de Lake Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Thomas Sutherland'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Aaron Hill', id
FROM abrigo WHERE nome = 'Centro de Distribuição Norte de Mountain Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Aaron Hill'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Jake Wind', id
FROM abrigo WHERE nome = 'Centro de Distribuição Sul de Mountain Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Jake Wind'
);

-- Estruturas e estações
INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Fazendeiro de Timefall', id
FROM abrigo WHERE nome = 'Fazenda de Timefall'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Fazendeiro de Timefall'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Engenheiro da Estação Eólica', id
FROM abrigo WHERE nome = 'Parque Eólico'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Engenheiro da Estação Eólica'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Técnico da Estação de Passagem', id
FROM abrigo WHERE nome = 'Estação de Passagem ao Norte de Mountain Knot'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Técnico da Estação de Passagem'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Meteorologista', id
FROM abrigo WHERE nome = 'Estação Meteorológica'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Meteorologista'
);

-- Abrigos de NPCs
INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Diretor de Cinema', id
FROM abrigo WHERE nome = 'Abrigo do Diretor de Cinema'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Diretor de Cinema'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Cosplayer', id
FROM abrigo WHERE nome = 'Abrigo da Cosplayer'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Cosplayer'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Sucateiro', id
FROM abrigo WHERE nome = 'Abrigo do Sucateiro'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Sucateiro'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Artista Quiral', id
FROM abrigo WHERE nome = 'Abrigo da Artista Quiral'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Artista Quiral'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Ancião', id
FROM abrigo WHERE nome = 'Abrigo do Ancião'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Ancião'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Primeiro Prepper', id
FROM abrigo WHERE nome = 'Abrigo do Primeiro Prepper'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Primeiro Prepper'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Filho do Novelista', id
FROM abrigo WHERE nome = 'Abrigo do Filho do Novelista'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Filho do Novelista'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Paleontólogo', id
FROM abrigo WHERE nome = 'Abrigo do Paleontólogo'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Paleontólogo'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Espiritualista', id
FROM abrigo WHERE nome = 'Abrigo da Espiritualista'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Espiritualista'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Porter Veterano', id
FROM abrigo WHERE nome = 'Abrigo do Porter Veterano'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Porter Veterano'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Colecionador', id
FROM abrigo WHERE nome = 'Abrigo do Colecionador'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Colecionador'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Engenheiro', id
FROM abrigo WHERE nome = 'Abrigo do Engenheiro'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Engenheiro'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Artesão', id
FROM abrigo WHERE nome = 'Abrigo do Artesão'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Artesão'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Geólogo', id
FROM abrigo WHERE nome = 'Abrigo do Geólogo'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Geólogo'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Médico', id
FROM abrigo WHERE nome = 'Abrigo do Médico'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Médico'
);

INSERT INTO pessoa (id, nome, abrigo_id)
SELECT gen_random_uuid(), 'Botânico', id
FROM abrigo WHERE nome = 'Abrigo do Botânico'
AND NOT EXISTS (
    SELECT 1 FROM pessoa WHERE nome = 'Botânico'
);
