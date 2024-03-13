Feature: String hashing 2

  Scenario: Text is hashed 2
    Given text is "hello"
    When it is hashed
    Then hash should be 99162322
