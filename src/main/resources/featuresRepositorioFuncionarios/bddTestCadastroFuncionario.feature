Feature: eu, como cliente ou funcionario preciso registrar um login

  Scenario: cadastro do funcionario
    Given I have a funcionario with name jean and rg 67687867
    When I want to make the operation register
    Then my operation should return true
