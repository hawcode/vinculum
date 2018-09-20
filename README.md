[![Build Status](https://travis-ci.org/hawcode/vinculum.svg?branch=master)](https://travis-ci.org/hawcode/vinculum)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.hawcode%3Avinculum&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.hawcode%3Avinculum)
[![License](https://img.shields.io/badge/License-GNU%20General%20Public%20License%203.0-brightgreen.svg)](http://www.gnu.org/licenses/gpl-3.0.txt)
[![Maven Central](https://img.shields.io/maven-central/v/com.hawcode/vinculum.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.hawcode%22%20AND%20a:%22vinculum%22)

![Alt text](https://www.hawcode.com/logo_vinculum.png "Vinculum")

# Vinculum
Vinculum is a dependency that allows connecting a Java application with a Headless CMS. It adds an abstraction layer in the development of applications when retrieving data from the Headless CMS DBs. The goal of Vinculum is to decouple web content creation tasks from the development tasks.

## Getting started

Vinculum is not an application, but a dependency whose purpose is to be added to your project dependencies so you are able to connect with your Headless CMS.

You can find Vinculum in the Maven Central. Examples of how to add this dependency both in Maven and Gradle can be found in the link: https://search.maven.org/artifact/com.hawcode/vinculum

### Steps:

- It is necessary to enable the Vinculum configuration. You can create a new Config class and apply the @EnableVinculum annotation or use it in an already existing one.
- Create a new entity that implements "FilterableByColumn". In this class you have to specify the different fields according to your Headless CMS database schema.
- In your controller you just need to Autowire the CMDService, so you will be able to retrieve a map with the desired information as a ContentManagedData.

For a real example, check at: https://hawcode.com/vinculum

## Built with

 * Spring framework
 * Hibernate
 * Maven
 
### Related tools

 * Sonar
 * Jacoco
 * Jenkins
 
## Authors

 * **Jose Lara** - *Hawcode co founder and developer* - [Email](jose.lara@hawcode.com) - [LinkedIn](https://es.linkedin.com/in/josecarloslaragomez)
 * **Benjamin Vega** - *Hawcode co founder and developer* - [Email](benjamin.vega@hawcode.com) - [LinkedIn](https://www.linkedin.com/in/benjaminvegadelpino)
