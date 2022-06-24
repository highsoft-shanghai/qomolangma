# QOMOLANGMA

## [English](./README.md) | [Chinese](./README.zh.md)

This repository contains all the materials you need to quickly build a new development environment.

## Environment preparation

### Environment dependencies

The development of this project relies on container technology and requires a Docker environment. If you have not
configured Docker environment, please configure Docker environment by yourself first. for Mac OS X and Windows, please
install Docker Desktop, for Linux system, please install Docker CE directly. the following information is for reference.

- Mac OS X: https://www.docker.com/products/docker-desktop
- Windows: https://www.docker.com/products/docker-desktop
- Ubuntu: https://docs.docker.com/engine/install/ubuntu/
- CentOS: https://docs.docker.com/engine/install/centos/

### Development Platform

This project uses a mix of Java and Kotlin development, heavily dependent on the Java ecosystem. Please install OpenJDK
17 first.

- OpenJDK 17 for Windows:

  https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_windows-x64_bin.zip
- OpenJDK 17 for Mac:

  https://download.java.net/java/GA/jdk18/43f95e8614114aeaa8e8a5fcf20a682d/36/GPL/openjdk-18_macos-x64_bin.tar.gz

- OpenJDK 17 for Linux:

  https://download.java.net/java/GA/jdk18/43f95e8614114aeaa8e8a5fcf20a682d/36/GPL/openjdk-18_linux-x64_bin.tar.gz

### Development Tools

For a better development experience and more efficient development, please use IntelliJ IDEA as the default development
tool: IntelliJ IDEA:

- IntelliJ IDEA: https://www.jetbrains.com/idea/

### Scripts

#### Dependency Services

All dependency services for this project can be built in an automated way. You will need to write your dependency
service deployment scripts. To build a completely new environment,
execute the following command in the project root directory.

```shell
sh ./scripts/setup-local
```

#### Install all frontend dependencies

```shell script
./gradlew npm_install
```

#### Code check before commit and push

In order to maintain the quality baseline and provide the necessary foundation for continuous integration, the project
provides the necessary infrastructure, one of which is the quality gatekeeper.

The quality gatekeeper provides various quality checks such as static code checks, unit tests, integration tests, test
coverage, front-end tests, etc.
**Developers must perform quality gatekeeper checks locally before each code push to the code repository**, and the
build server will also trigger quality gatekeeper after the code is pushed to the code repository. Execute quality
checks locally by directly executing the following commands.

```shell script
sh ./scripts/check-all
```

#### Run main project

```shell script
./gradlew bootRun
```

#### Build frontend dependencies

```shell script
./gradlew :qomolangma.webui:yarn_build
```

#### Listen to frontend tests

```shell script
./gradlew :qomolangma.webui:yarn_test
```

#### Build a docker image

```shell script
sh ./scripts/build-all
```

## Technical Architecture

We use 
