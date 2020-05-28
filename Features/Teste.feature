Feature: Acessar Tela Inicial
  Realizar busca na tela principal

  Scenario Outline: Realizar Consulta
    Given Acesso a tela inicial do sistema
    And Seleciono somente o tipo de anuncio de carro usado
    And Seleciono as opcoes de marca<marca> modelo<modelo> e localizacao<localizacao>
    And Valido os dados dos dois primeiros registros
    And Crio arquivo de dados com resultados da primeira pagina
    Examples:
      | marca     | modelo | localizacao|
      | Chevrolet | Prisma |TodoBrasil  |



#  2) Valide o modelo e o valor à vista do primeiro e do segundo carro da lista produzida pela consulta
#  3) O script deve ler a lista de resultados e criar um arquivo de dados contendo marca modelo, ano, km, cor, câmbio e valor à vista de cada veiculo retornado (apenas da primeira página de retorno)
#  4) Outro script deve ler a lista de carros criada na tabela anterior, buscar pelos veiculos e validar se os dados, especialmente o valor à vista continuam os mesmos.