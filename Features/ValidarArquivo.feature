Feature: Ler Arquivos
  Ler Arquivos

  Scenario Outline: Realizar Consulta
    Given Acesso a tela inicial do sistema
    And Seleciono somente o tipo de anuncio de carro usado
    And Seleciono as opcoes de marca<marca> modelo<modelo> e localizacao<localizacao>
    And Valido os dados com arquivo excel "C:\workspace-teste\src\test\resources\arquivoDados\Pasta1.xls"
    Examples:
      | marca     | modelo | localizacao|
      | Chevrolet | Prisma |TodoBrasil  |