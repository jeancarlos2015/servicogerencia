Feature: eu, como gerente preciso excluir dados referentes a compra

  Scenario: Exclusao do registro do compra
    Given buy 3 juices from vendor Bobs brand with cnpj 4324324 for cust 20
    When I want to make the operation delete
    Then my operation should return true
