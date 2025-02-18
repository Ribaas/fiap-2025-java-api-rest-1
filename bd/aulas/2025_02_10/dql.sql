SELECT 
    pais.nome_pais,
    COUNT(DISTINCT estado.nome_estado)
FROM t_a01_pais pais
INNER JOIN t_a01_estado estado ON pais.id_pais = estado.id_pais
group by pais.nome_pais
having COUNT(DISTINCT estado.nome_estado) > 5