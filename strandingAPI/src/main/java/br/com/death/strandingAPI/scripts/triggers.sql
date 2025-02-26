-- Trigger para criar afinidades a cada entregador criado
CREATE OR REPLACE FUNCTION criar_afinidades()
RETURNS TRIGGER AS $$
DECLARE
    abrigo RECORD;
BEGIN
    FOR abrigo IN
        SELECT id FROM abrigo
    LOOP
        INSERT INTO afinidade (id, entregador_id, abrigo_id, nivel, experiencia)
        VALUES (
            gen_random_uuid(),
            NEW.id,
            abrigo.id,
            0,
            0
        );
    END LOOP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_insert_entregador
AFTER INSERT ON entregador
FOR EACH ROW
EXECUTE FUNCTION criar_afinidades();
