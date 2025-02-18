set SERVEROUTPUT on;

DECLARE
    salario_minimo NUMBER;
BEGIN
    salario_minimo := 1518;
    dbms_output.put_line('o valor do novo salario minimo com 25% e: ' || salario_minimo * 1.25);
END;