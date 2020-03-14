# Ng-SpringBoot Gradle Plugin

Gradle plugin that builds angular module and attaches it as static resource to Spring Boot application 

## Usage

Apply and configure plugin in build.gradle. As project directory put your Angular module directory.
```
apply plugin: 'com.github.tomek39856.ngspringbootplugin'

ngspringbootplugin {
    projectDirectory = 'angular-app-directory'
}
```
Configure task dependency (plugin should do it's job before processing resources)
```
processResources.dependsOn(copyFrontendToResources)
```

## Tasks

Plugin defines 3 tasks and configures dependencies between them
1. NpmInstallTask - executes npm install on Angular app
2. NpmBuild - executes npm build. Task is incremental so if package.json or sources didn't change will used previous output from cache
3. CopyFrontendToResources - copies built application into Spring Boot static resources

## Prerequisites

```
Spring Boot webapp
Angular 8 app
Npm
Gradle > 5.6
```

## Plugin repository
https://plugins.gradle.org/plugin/com.github.tomek39856.ngspringbootplugin

## Tests

```
gradle test
```

## Built With

* [Gradle](https://gradle.org/) 

## Author

* **Tomasz Tokarczyk** (https://github.com/tomek39856)