# Selenide_2023
# Run tests with TestNG and Allure
mvn clean test -DsuiteXmlFile=allure.xml
allure generate allure-results --clean
allure open
