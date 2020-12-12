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
      |name        |(phone)                                                                          |
      |name_en     |(phone)                                                                          |
      |parent      |(4)                                                                              |
      |image       |(image.png)                                                                      |
      |kind        |(2)                                                                              |
      |priority    |(2)                                                                              |
      |cdt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |udt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |visibility  |(true)                                                                           |






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
      |name        |(phone)                                                                          |
      |name_en     |(phone)                                                                          |
      |parent      |(4)                                                                              |
      |image       |(image.png)                                                                      |
      |kind        |(2)                                                                              |
      |priority    |(2)                                                                              |
      |cdt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |udt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |visibility  |(true)                                                                           |



  Scenario: Full update the category with category id
    When the client calls PUT "api/v1/categories/{id}" with id and following detail
      |attribute   |value        |
      |name        |medicine     |
      |name_en     |medicine     |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |
    Then the client receive status code of 200
    And the response has the following attribute
      |attribute   |value        |
      |name        |medicine     |
      |name_en     |medicine     |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |
    And the check response value type
      |attribute   |type                                                                             |
      |id          |[0-9]{1,9}                                                                       |
      |name        |(medicine)                                                                       |
      |name_en     |(medicine)                                                                      |
      |parent      |(4)                                                                              |
      |image       |(image.png)                                                                      |
      |kind        |(2)                                                                              |
      |priority    |(2)                                                                              |
      |cdt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |udt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |visibility  |(true)                                                                           |

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
      |name        |(phone1)                                                                         |
      |name_en     |(phone)                                                                          |
      |parent      |(4)                                                                              |
      |image       |(image.png)                                                                      |
      |kind        |(2)                                                                              |
      |priority    |(2)                                                                              |
      |cdt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |udt         |[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}[.][0-9]{1,3}   |
      |visibility  |(true)                                                                           |

  Scenario: delete the category with category id
    When the client calls DELETE "api/v1/categories/{id}" with id
    Then the client receive status code of 204
    When the client calls GET "api/v1/categories/{id}" with id
    Then the client receive status code of 404






