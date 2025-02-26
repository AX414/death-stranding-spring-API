-- Abrigos principais
INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Cidade de Capital Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Cidade de Capital Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Cidade de Lake Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Cidade de Lake Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Cidade de South Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Cidade de South Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Cidade de Port Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Cidade de Port Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Cidade de Mountain Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Cidade de Mountain Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Cidade de Edge Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Cidade de Edge Knot');

-- Centros de distribuição
INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Centro de Distribuição Oeste de Capital Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Centro de Distribuição Oeste de Capital Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Centro de Distribuição Sul de Lake Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Centro de Distribuição Sul de Lake Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Centro de Distribuição Norte de Mountain Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Centro de Distribuição Norte de Mountain Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Centro de Distribuição Sul de Mountain Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Centro de Distribuição Sul de Mountain Knot');

-- Estruturas e estações
INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Fazenda de Timefall'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Fazenda de Timefall');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Parque Eólico'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Parque Eólico');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Estação de Passagem ao Norte de Mountain Knot'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Estação de Passagem ao Norte de Mountain Knot');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Estação Meteorológica'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Estação Meteorológica');

-- Abrigos de NPCs
INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Diretor de Cinema'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Diretor de Cinema');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo da Cosplayer'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo da Cosplayer');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Sucateiro'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Sucateiro');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo da Artista Quiral'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo da Artista Quiral');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Ancião'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Ancião');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Primeiro Prepper'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Primeiro Prepper');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Filho do Novelista'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Filho do Novelista');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Paleontólogo'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Paleontólogo');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo da Espiritualista'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo da Espiritualista');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Porter Veterano'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Porter Veterano');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Colecionador'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Colecionador');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Engenheiro'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Engenheiro');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Artesão'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Artesão');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Geólogo'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Geólogo');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Médico'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Médico');

INSERT INTO abrigo (id, nome)
SELECT gen_random_uuid(), 'Abrigo do Botânico'
WHERE NOT EXISTS (SELECT 1 FROM abrigo WHERE nome = 'Abrigo do Botânico');
