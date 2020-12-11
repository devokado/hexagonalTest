Feature: Handling Error Response


  Scenario: name and name_en not be null
    Given create "category" with following detail
      |attribute   |value        |
      |name        |             |
      |name_en     |             |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |

    When the client calls POST "api/v1/categories/create" with the given detail
    Then the client receive status code of 405


  Scenario: name and name_en should be more than 3 characters
    Given create "category" with following detail
      |attribute   |value        |
      |name        |a            |
      |name_en     |a            |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |

    When the client calls POST "api/v1/categories/create" with the given detail
    Then the client receive status code of 405


  Scenario: name_en should be similar pattern [a-zA-Z]
    Given create "category" with following detail
      |attribute   |value        |
      |name        |تلفن          |
      |name_en     |تلفن          |
      |parent      |4            |
      |image       |image.png    |
      |kind        |2            |
      |priority    |2            |
      |visibility  |true         |

    When the client calls POST "api/v1/categories/create" with the given detail
    Then the client receive status code of 405








