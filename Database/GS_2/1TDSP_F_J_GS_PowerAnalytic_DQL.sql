-- Thiago Thomaz Sales Conceição RM:557992 Turma:1TDSPJ 
-- Pedro Henrique Jorge de Paula RM:558833 Turma:1TDSPJ 
-- João Lopes Coelho Neto RM:556865 Turma:1TDSPF 

--Professor 1TDSPF: Eder Sousa: profeder.sousa@fiap.com.br 
--Professor 1TDSPJ: William Maximiano: profwilliam.junior@fiap.com.br
SELECT * FROM PF0645.tipo_fontes;

SELECT * FROM PF0645.regioes_sustentaveis;

select * from PF0645.emissoes_carbono;

-- Consulta 1: Exibir o nome do tipo de fonte e a quantidade de projetos por tipo de fonte
SELECT 
    tf.NOME AS Tipo_Fonte,
    COUNT(ps.ID_PROJETO) AS Quantidade_Projetos
FROM 
    PF0645.tipo_fontes tf
JOIN 
    PF0645.projetos_sustentaveis ps ON tf.ID_TIPO_FONTE = ps.ID_TIPO_FONTE
GROUP BY 
    tf.NOME
HAVING 
    COUNT(ps.ID_PROJETO) > 2
ORDER BY 
    tf.NOME;

-- Consulta 2: Exibir projetos que utilizam fontes de energia solar ou eólica
SELECT 
    ps.ID_PROJETO,
    ps.DESCRICAO,
    ps.CUSTO
FROM 
    PF0645.projetos_sustentaveis ps
JOIN 
    PF0645.tipo_fontes tf ON ps.ID_TIPO_FONTE = tf.ID_TIPO_FONTE
WHERE 
    tf.NOME IN ('Solar', 'Eólica')
ORDER BY 
    ps.DESCRICAO;

-- Consulta 3: Exibir projetos com custo superior a R$500.000,00 e status "Em andamento"
SELECT 
    ps.ID_PROJETO,
    ps.DESCRICAO,
    ps.STATUS
FROM 
    PF0645.projetos_sustentaveis ps
WHERE 
    ps.CUSTO > 500000.00
    AND ps.STATUS = 'Em andamento'
ORDER BY 
    ps.ID_PROJETO;

-- Consulta 4: Exibir a média do custo dos projetos por região
SELECT 
    rs.NOME AS Regiao,
    ROUND(AVG(ps.CUSTO), 2) AS Media_Custo
FROM 
    PF0645.regioes_sustentaveis rs
JOIN 
    PF0645.projetos_sustentaveis ps ON rs.ID_REGIAO = ps.ID_REGIAO
GROUP BY 
    rs.NOME
ORDER BY 
    Media_Custo DESC;

-- Consulta 5: Exibir o nome da região, tipo de fonte, quantidade de projetos e média das emissões de carbono
SELECT 
    rs.NOME AS Regiao,
    tf.NOME AS Tipo_Fonte,
    COUNT(ps.ID_PROJETO) AS Total_Projetos,
    ROUND(AVG(ec.EMISSAO), 2) AS Media_Emissao_Carbono
FROM 
    PF0645.regioes_sustentaveis rs
JOIN 
    PF0645.projetos_sustentaveis ps ON rs.ID_REGIAO = ps.ID_REGIAO
JOIN 
    PF0645.tipo_fontes tf ON ps.ID_TIPO_FONTE = tf.ID_TIPO_FONTE
JOIN 
    PF0645.emissoes_carbono ec ON tf.ID_TIPO_FONTE = ec.ID_TIPO_FONTE
GROUP BY 
    rs.NOME, tf.NOME
HAVING 
    AVG(ec.EMISSAO) > 5000
ORDER BY 
    Regiao, Tipo_Fonte;
