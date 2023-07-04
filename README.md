# Introduction

Hello to anyone who will look through this guide!

My name is [Serhii Matiunin](https://linkedin.com/in/serhii-matiunin) and I'm glad to share with you this project that implements automation for steps which were described in a "[Preparation for QA Candidates.docx](https://docs.google.com/document/d/1nYdjMddDyipWqwU2T965mPGjDXx31NXn/edit?usp=drive_link&ouid=105646002999804056580&rtpof=true&sd=true)" provided to me by Kriselle.

Besides actually steps automation I've implemented some assertions that I believe could be useful, such as successful registration and login assertion, and behavior of some elements that could produce defects (check test classes to see implemented assertions).

## Test run pre-conditions

Since the framework has been written using Java and Maven build tool, [Java 11 SDK](https://www.oracle.com/ca-en/java/technologies/javase/jdk11-archive-downloads.html) and the latest version of [Maven](https://maven.apache.org/download.cgi) must be downloaded and installed in order to successfully execute tests.

You will also need an active email address that will be used in the test.

## Setting up the environment and test data

1. The browser to be used for test run can be modified in the [browser properties file](src/test/resources/browser.properties) (src/test/resources/browser.properties). Currently supported browsers are Chrome, Firefox, Edge.
2. You can modify pre-set test data for registration form filling in corresponding [json file](src/test/resources/userRegistrationInfo.json) (src/test/resources/userRegistrationInfo.json).
3. Some test data is declared as constants and can be found in _src/test/utility/data_ package

## How to run tests

Since there are manual actions that should be executed between tests (email confirmation), I've decided to separate this suite into two tests that should be run one after another. And I guess the best way to do it is to use Command Prompt or Terminal.

**IMPORTANT**

Please use **your valid email address** for the "email" parameter since a confirmation email will be sent to this email. The password you will be using in the "password" parameter **must have a minimum 8 characters and contain Lower case, Upper case, Numbers, and Special characters.**


**A proper way to run tests as following:**

1. Open the project folder in the terminal window and run the following command:

`mvn clean test -Dtest="RegistrationFormTest" -Demail="YourEmail" -Dpassword="YourNewSumoAccountPassword"`

This command will run the first test that will register a new user, passing email and password parameters into the test, and using other user registration data from the [json file](src/test/resources/userRegistrationInfo.json).

This test will also check if registration was successful and in case of failure an assertion error will be generated.

2. After the email address has been confirmed by following a confirmation link sent to your email you can execute a second test by running the following command in terminal:

`mvn clean test -Dtest="SetupBrandingPageTest" -Demail="YourEmail" -Dpassword="YourSumoAccountPassword"`

This test will sign in to the branding setup page and fill other fields required for brand registration. The data is taken from constants that can be found in _src/test/utility/data_ package.

There will be some assertions performed as well to check expected web-site behavior during user flow actions.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)