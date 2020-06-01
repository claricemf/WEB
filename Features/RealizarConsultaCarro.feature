Feature: Realizar consulta e gerar arquivo com os dados da primeira pagina
  Realizar consulta e gerar arquivo com resultado

  Scenario Outline: Realizar consulta e gerar arquivo com resultado
    Given Acesso a tela inicial do sistema
    And Seleciono somente o tipo de anuncio de carro usado
    And Seleciono as opcoes de marca<marca> modelo<modelo> e localizacao<localizacao>
    And Valido os dados dos dois primeiros registros
    And Crio arquivo de dados com resultados da primeira pagina
    Examples:
      | marca     | modelo | localizacao |
      | Chevrolet | Prisma | TodoBrasil  |

  Scenario Outline: Ler arquivo de dados e validar com a consulta
    Given Acesso a tela inicial do sistema
    And Seleciono somente o tipo de anuncio de carro usado
    And Seleciono as opcoes de marca<marca> modelo<modelo> e localizacao<localizacao>
    And Leio o arquivo de resultados e valido os dados com a consulta
    Examples:
      | marca     | modelo | localizacao |
      | Chevrolet | Prisma | TodoBrasil  |