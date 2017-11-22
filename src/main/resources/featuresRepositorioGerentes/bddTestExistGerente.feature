Feature: eu, como cliente ou gerente preciso registrar um login

  Scenario: O gerente existe?
    Given I have a gerente with name carlos and rg 32323232
    When I want to make the operation consult
    Then my operation should return true
