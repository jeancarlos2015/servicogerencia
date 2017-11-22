Feature: eu, como gerente preciso ter um registro das notificacoes que são enviadas ao fornecedor

  Scenario: cadastro do notificacao
    Given I, jean, I need to send a product request
    When I want to make the operation register
    Then my operation should return true
