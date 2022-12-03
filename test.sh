#! /usr/bin/bash
mvn clean test -Dcucumber=" --tags @test_scenario" allure:serve

