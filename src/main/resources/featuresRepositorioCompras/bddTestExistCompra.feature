Feature: eu, como gernete preciso verificar se as compras existem

  Scenario: O compra existe?
    Given buy 3 juices from vendor Bobs brand with cnpj 4324324 for cust 20
    When I want to make the operation consult
    Then my operation should return true
