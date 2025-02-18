set SERVEROUTPUT on;

DECLARE
    pct_entrada NUMBER;
    valor_carro NUMBER;
    
    juros_a NUMBER;
    juros_b NUMBER;
    juros_c NUMBER;
    qtd_parcelas_a NUMBER;
    qtd_parcelas_b NUMBER;
    qtd_parcelas_c NUMBER;

    entrada NUMBER;

    valor_final_a NUMBER;
    valor_final_b NUMBER;
    valor_final_c NUMBER;
    valor_parcela_a NUMBER;
    valor_parcela_b NUMBER;
    valor_parcela_c NUMBER;
BEGIN
    pct_entrada := 0.2;
    valor_carro := 10000;

    juros_a := 0.1;
    juros_b := 0.15;
    juros_c := 0.2;
    qtd_parcelas_a := 6;
    qtd_parcelas_b := 12;
    qtd_parcelas_c := 18;

    entrada := valor_carro * pct_entrada;

    valor_final_a := (valor_carro - entrada) * (1 + juros_a);
    valor_final_b := (valor_carro - entrada) * (1 + juros_b);
    valor_final_c := (valor_carro - entrada) * (1 + juros_c);
    valor_parcela_a := valor_final_a / qtd_parcelas_a;
    valor_parcela_b := valor_final_b / qtd_parcelas_b;
    valor_parcela_c := valor_final_c / qtd_parcelas_c;

    dbms_output.put_line('valor da parcela no modelo A: R$' || valor_parcela_a);
    dbms_output.put_line('valor da parcela no modelo B: R$' || valor_parcela_b);
    dbms_output.put_line('valor da parcela no modelo C: R$' || valor_parcela_a);


END;