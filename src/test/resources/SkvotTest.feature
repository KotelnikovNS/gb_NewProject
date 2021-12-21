Feature: Catalog filtering

  Background:
    Given SelectCity page is loaded

  Scenario Outline:
    When User select city
    And select category and subcategory in catalog
    And input "<priceFromRub>" and "<priceToRub>"
    Then filter can be checked "<priceFromRub>" and "<priceToRub>"


    Examples:
      | priceFromRub | priceToRub |
      | 59999        | 109999     |
      | 58999        | 109990     |