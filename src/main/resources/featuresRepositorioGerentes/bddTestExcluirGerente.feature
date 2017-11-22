Feature: eu, como cliente ou gerente preciso registrar um login

  Scenario: Exclusao do registro do gerente
    Given I have a gerente with name joao and rg 8908908
    When I want to make the operation delete
    Then my operation should return true
