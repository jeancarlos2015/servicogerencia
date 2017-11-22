Feature: eu, como cliente ou funcionario preciso registrar um login

  Scenario: Exclusao do registro do funcionario
    Given I have a funcionario with name jean and rg 43243243
    When I want to make the operation delete
    Then my operation should return true
