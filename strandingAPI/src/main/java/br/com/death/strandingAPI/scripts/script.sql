SELECT * FROM entregador;
SELECT * FROM abrigo;
SELECT * FROM entrega;

SELECT a.nivel AS "Nível", a.experiencia AS "Experiência",
abr.nome AS "Abrigo", e.nome AS "Entregador"
FROM afinidade a
JOIN abrigo abr ON abr.id = a.abrigo_id
JOIN entregador e ON e.id = a.entregador_id;

SELECT * FROM pessoa;

-- Inserindo um entregador
INSERT INTO entregador VALUES(
gen_random_uuid(),
1,
'sam@hotmail.com',
'BRIDGES',
0,
'https://static1.srcdn.com/wordpress/wp-content/uploads/2024/12/sam-porter-bridges-in-the-trailer-for-death-stranding-2-with-longer-hair-in-a-custom-suit.png',
0,
'Sam Porter Bridges',
0,
'123');



