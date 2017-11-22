Feature: eu, como cliente ou funcionario preciso registrar um login

  Scenario: cadastro do fornecedor
    Given I have a fornecedor with name sadia and cnpj 1234123412
    When I want to make the operation register
    Then my operation should return true
