Feature: eu, como cliente ou funcionario preciso registrar um login

  Scenario: O fornecedor existe?
    Given I have a fornecedor with name sadia and cnpj 1234123412
    When I want to make the operation consult
    Then my operation should return true
