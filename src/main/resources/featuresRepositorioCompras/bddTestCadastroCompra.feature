Feature: eu, como gerente preciso registrar as compras do estabelecimento

  Scenario: cadastro do compra
    Given buy 3 juices from vendor Bobs brand with cnpj 4324324 for cust 20
    When I want to make the operation register
    Then my operation should return true
