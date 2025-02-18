set SERVEROUTPUT on;

DECLARE
    qtd_parcelas NUMBER;
    juros NUMBER;
    valor NUMBER;
    valor_final NUMBER;
    valor_parcela NUMBER;
BEGIN
    qtd_parcelas := 10;
    juros := 0.03;

    valor := &valor;

    valor_final := valor * (1 + juros);
    valor_parcela := valor_final / qtd_parcelas;

    dbms_output.put_line('valor da parcela: R$' || valor_parcela);
END;