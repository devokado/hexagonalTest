Feature: Crud on category
  Background:
    Given create "category" with following detail
      |attribute   |value        |
      |name        |phone        |
      |name_en     |phone        |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |

    When the client calls POST "api/v1/categories/create" with the given detail



  Scenario: Create category
    Then the client receive status code of 201
    And the response has the following attribute
      |attribute   |value        |
      |name        |phone        |
      |name_en     |phone        |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |


  Scenario: retrieve the category with category id
    When the client calls GET "api/v1/categories/{id}" with id
    Then the client receive status code of 200
    And the response has the following attribute
      |attribute   |value        |
      |name        |phone        |
      |name_en     |phone        |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |


  Scenario: delete the category with category id
    When the client calls DELETE "api/v1/categories/{id}" with id
    Then the client receive status code of 204


  Scenario: Full update the category with category id
    When the client calls PUT "api/v1/categories/{id}" with id and following detail
      |attribute   |value        |
      |medicine    |medicine     |
      |name_en     |phone        |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |
    Then the client receive status code of 200
    And the response has the following attribute
      |attribute   |value        |
      |medicine    |medicine     |
      |name_en     |phone        |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |





