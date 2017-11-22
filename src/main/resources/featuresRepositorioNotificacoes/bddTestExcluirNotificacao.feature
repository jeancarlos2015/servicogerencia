Feature: eu, como gerente preciso excluir notificacoes

  Scenario: Exclusao do registro do notificacao
    Given I, jean, I need to send a product request
    When I want to make the operation delete
    Then my operation should return true
