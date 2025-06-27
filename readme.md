
// To run tests:
// mvn clean test
// To generate Allure report:
// allure serve target/allure-results
/*
 * Modern RestAssured Test Framework (2025)
 * - JUnit 5
 * - Allure reporting
 * - Environment-configurable
 * - CSV-based data input
 */
How to execute tests:
mvn clean test
then
allure serve

How to put allure in your system
Download zip file https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/
Unzip into folder and copy pathname of bin.
add pathname to $Path environment variable.
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
