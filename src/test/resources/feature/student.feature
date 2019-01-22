Feature: Testing different request on the student application

  @Smoke
  Scenario: Check if student application can be accessed by user
    When User send a GET request to the list endpoint, they must get back a valid status code 200

    Scenario Outline: Create a new student and verify if the student is added
      When I Create a new student by providing the information firstName <firstName> lastName <lastName> email <email> programme <programme> course <course>
      Then I verify tht student is created

      Examples:
      | firstName | lastName | email            | programme       | course |
      | Test1 | Kr | nishantkr30@gmail.com | ComputerScience1 | Java1 |
      | Test2 | K2 | nishant.sit@gmail.com | ComputerSciences2 | C++ 2|

