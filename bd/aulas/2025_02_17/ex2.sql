set SERVEROUTPUT on;

DECLARE
    dolares NUMBER;
    reais NUMBER;
    cambio NUMBER;
BEGIN
    reais := &valor;
    cambio := 5.71;
    dolares := reais / cambio;
    dbms_output.put_line('cambio: US$' || dolares);
END;