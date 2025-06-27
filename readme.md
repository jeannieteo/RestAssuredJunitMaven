
// To run tests:\
// mvn clean test\
// To generate Allure report:\
// allure serve target/allure-results\

/***********************
 * Modern RestAssured Test Framework (2025)
 * - JUnit 5
 * - Allure reporting
 * - Environment-configurable
 * - CSV-based data input
 **********************************/
How to execute tests:
mvn clean test
then
allure serve

How to put allure in your system
Download zip file https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/
Unzip into folder and copy pathname of bin.
add pathname to $Path environment variable.

JUnit 5 uses annotations and the maven-surefire-plugin in your pom.xml to automatically discover and run tests.\
As long as your test class:\
is named like *Test.java (e.g., UserApiTest.java)\
is annotated with @Test methods\
is in the src/test/java directory\
…it will run automatically with this Maven command:\
mvn clean test\
\
\

|--src----\
|--main----\
|--test----\
   |--**resources**-----\
       allure.properties\
       |--schema----\
        petSchema.json\
       |--testdata----\    
        pets.csv\
   |--**java**-----\
       |--base----\
        TestBase.java\
       |--endpoints----\
        Routes.java\
       |--model---- \
        Pet.java\
       |--tests---- \
        PetApiTest.java\
        SchemaValidationTest.java\
       |--utils---- \
        CSVDataProvider.java\
pom.xml
