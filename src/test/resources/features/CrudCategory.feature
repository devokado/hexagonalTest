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
    And the check response value type
      |attribute   |type                                                                             |
      |id          |[0-9]{1,9}                                                                       |
      |name        |[a-zA-Z1-9]{4,}+                                                                 |
      |name_en     |[a-zA-Z]{4,}+                                                                    |
      |parent      |[0-9]{1,9}                                                                       |
      |image       |[a-zA-Z0-9]+[.][a-zA-Z0-9]+                                                      |
      |kind        |[0-9a-zA-Z]                                                                      |
      |priority    |[0-9]{1,9}                                                                       |
      |cdt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |udt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |visibility  |(false\|true\|0\|1)                                                              |






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
    And the check response value type
      |attribute   |type                                                                             |
      |id          |[0-9]{1,9}                                                                       |
      |name        |[a-zA-Z1-9]{4,}+                                                                 |
      |name_en     |[a-zA-Z]{4,}+                                                                    |
      |parent      |[0-9]{1,9}                                                                       |
      |image       |[a-zA-Z0-9]+[.][a-zA-Z0-9]+                                                      |
      |kind        |[0-9a-zA-Z]                                                                      |
      |priority    |[0-9]{1,9}                                                                       |
      |cdt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |udt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |visibility  |(false\|true\|0\|1)                                                              |



  Scenario: Full update the category with category id
    When the client calls PUT "api/v1/categories/{id}" with id and following detail
      |attribute   |value        |
      |name        |medicine     |
      |name_en     |phone        |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |
    Then the client receive status code of 200
    And the response has the following attribute
      |attribute   |value        |
      |name        |medicine     |
      |name_en     |phone        |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |
    And the check response value type
      |attribute   |type                                                                             |
      |id          |[0-9]{1,9}                                                                       |
      |name        |[a-zA-Z1-9]{4,}+                                                                 |
      |name_en     |[a-zA-Z]{4,}+                                                                    |
      |parent      |[0-9]{1,9}                                                                       |
      |image       |[a-zA-Z0-9]+[.][a-zA-Z0-9]+                                                      |
      |kind        |[0-9a-zA-Z]                                                                      |
      |priority    |[0-9]{1,9}                                                                       |
      |cdt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |udt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |visibility  |(false\|true\|0\|1)                                                              |

  Scenario: Partial update the the category with category id
    When the client calls PATCH "api/v1/categories/{id}" with id and  "name" "phone1"
    Then the client receive status code of 200
    And the response has the following attribute
      |attribute   |value        |
      |name        |phone1       |
      |name_en     |phone        |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |
    And the check response value type
      |attribute   |type                                                                             |
      |id          |[0-9]{1,9}                                                                       |
      |name        |[a-zA-Z1-9]{4,}+                                                                 |
      |name_en     |[a-zA-Z]{4,}+                                                                    |
      |parent      |[0-9]{1,9}                                                                       |
      |image       |[a-zA-Z0-9]+[.][a-zA-Z0-9]+                                                      |
      |kind        |[0-9a-zA-Z]                                                                      |
      |priority    |[0-9]{1,9}                                                                       |
      |cdt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |udt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |visibility  |(false\|true\|0\|1)                                                              |

  Scenario: delete the category with category id
    When the client calls DELETE "api/v1/categories/{id}" with id
    Then the client receive status code of 204
    When the client calls GET "api/v1/categories/{id}" with id
    Then the client receive status code of 404






