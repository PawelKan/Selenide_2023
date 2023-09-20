# Selenide_2023
# Run tests with TestNG and Allure
mvn clean test -DsuiteXmlFile=allure

allure generate allure-results --clean

allure open

mvn clean test ; allure generate allure-results --clean ; allure open

mvn clean test -DsuiteXmlFile=testng
