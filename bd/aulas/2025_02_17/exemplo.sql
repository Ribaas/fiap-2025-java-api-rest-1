set SERVEROUTPUT on;

DECLARE
    variavel01 NUMBER;
    nome VARCHAR2(30) := 'Teste';
    nome2 nome%type;
BEGIN
    variavel01 := 10;
    dbms_output.put_line('o valor digitado e: ' || variavel01);
    dbms_output.put_line('o nome digitado e: ' || nome);
END;