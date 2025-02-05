@FeatureOrder
Feature: Ordenes

  @CreacionOrder
  Scenario Outline: Creación de Order
    When el usuario crea una orden con los siguientes detalles:
      | id  | petId | quantity | shipDate                 | status  | complete |
      | <id>| <petId>| <quantity>| <shipDate>             | <status>| <complete>|
    Then valido el codigo de respuesta sea 200
    And el cuerpo de la respuesta debe contener los siguientes valores:
      | key       | value       |
      | id        | <id>        |
      | petId     | <petId>     |
      | quantity  | <quantity>  |
      | shipDate  | <shipDate>  |
      | status    | <status>    |
      | complete  | <complete>  |
    Examples:
      | id  | petId | quantity | shipDate                  | status  | complete |
      | 120 | 0     | 2        | 2025-01-04T23:52:17.292Z | placed  | true     |
      | 121 | 0     | 2        | 2025-01-04T23:52:17.292Z | placed  | true     |


  @ConsultaOrder
  Scenario Outline: Consulta de Order
    When consulto la orden con el <id>
    Then Valido el codigo de respuesta 200
    And cuerpo de la respuesta debe contener los siguientes valores:
      | key       | value       |
      | id        | <id>        |
      | petId     | <petId>     |
      | quantity  | <quantity>  |
      | shipDate  | <shipDate>  |
      | status    | <status>    |
      | complete  | <complete>  |
    Examples:
      | id  | petId | quantity | shipDate                  | status  | complete |
      | 120 | 0     | 2        | 2025-01-04T23:52:17.292Z | placed  | true     |
      | 121 | 0     | 2        | 2025-01-04T23:52:17.292Z | placed  | true     |
