Feature: Crud on category
  Background:
      Given create category with following detail
      |phone   |phone  |4      |image.png  |2    |2      |true       |
      When the client calls POST "api/v1/categories/create" with the given detail


      Scenario: Create category
        Then the client receive status code of 201
        And the response contains name "phone"

      Scenario: retrieve the category with category id
        When the client calls GET "api/v1/categories/{id}" with category id
        Then the client receives status code 302
        And the response contains name "phone"

      Scenario:  retrieve all categories
        When the client calls GET "api/v1/categories"
        Then the client receives status code of 302
        And the response by length 1

      Scenario: delete the category with category id
        When the client calls DELETE "api/v1/categories/{id}" with category id
        Then the client receives status code of 204


      Scenario: Full update the category with category id
         When the client calls PUT "api/v1/categories/{id}" with category id and following detail
         |medicine  |medicine |۵      |image.png  |2    |2      |true       |
         Then the client receives status code of 200
         And the response contains name "medicine"






