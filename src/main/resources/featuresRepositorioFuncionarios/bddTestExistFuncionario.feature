Feature: eu, como cliente ou funcionario preciso registrar um login

  Scenario: O funcionario existe?
    Given I have a funcionario with name carlos and rg 32323232
    When I want to make the operation consult
    Then my operation should return true
