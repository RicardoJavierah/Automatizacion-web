@FeatureOrder
Feature: Ordenes

  @CreacionOrder
  Scenario Outline: Creación de Order
    When el usuario crea una orden con los siguientes detalles:
      | <id>| <petId> | <quantity>  | <shipDate>| <status>  | <complete> |

    Examples:
      | id  | petId   | quantity    | shipDate                  | status    | complete  |
      | 105   | 0       | 2           | "2025-01-04T23:52:17.292Z"| "placed"  | true      |