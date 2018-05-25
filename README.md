[![Build Status](https://travis-ci.org/hawcode/vinculum.svg?branch=master)](https://travis-ci.org/hawcode/vinculum)
[![Quality Gate](https://sonarcloud.io/api/badges/gate?key=com.hawcode:vinculum)](https://sonarcloud.io/dashboard?id=com.hawcode%3Avinculum)
[![License](https://img.shields.io/badge/License-GNU%20General%20Public%20License%203.0-brightgreen.svg)](http://www.gnu.org/licenses/gpl-3.0.txt)

# Vinculum
Dependency to connect a Java project with a Headless CMS.

Vinculum is available in the MavenRepository. That means you can include it in your project without downloading any file. Just add the dependency in your POM!

Steps:

- It is necessary to enable the Vinculum configuration. You can create a new Config class and apply the @EnableVinculum annotation or use it in an already existing one.
- Create a new entity that implements "FilterableByColumn". In this class you have to specify the different fields according to your Headless CMS database schema.
- In your controller you just need to Autowire the CMDService, so you will be able to retrieve a map with the desired information as a ContentManagedData.

For a real example, check in: http://hawcode.com/vinculum