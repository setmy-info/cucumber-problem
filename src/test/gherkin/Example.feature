Feature: String hashing

  Scenario: Text is hashed
    Given text is "hello"
    When it is hashed
    Then hash should be 99162322
