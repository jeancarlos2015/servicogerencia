Feature: eu, como cliente ou gerente preciso registrar um login

  Scenario: cadastro do gerente
    Given I have a gerente with name joao and rg 890890
    When I want to make the operation register
    Then my operation should return true
