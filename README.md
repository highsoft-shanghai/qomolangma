# Kotlin CI Scaffold

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

### Dependency Services

All dependency services for this project can be built in an automated way. You will need to write your dependency
service deployment scripts. To build a completely new environment,
execute the following command in the project root directory.

```shell
. /scripts/setup-local
```

## Install all frontend dependencies

```shell script
./gradlew npm_install
```

## Run document objects

```shell script
./gradlew :documents:npm_start
```

## Code check before commit and push

```shell script
sh ./scripts/check-all
```

## Run main project

```shell script
./gradlew bootRun
```

## Run frontend tests

```shell script
./gradlew :scaffold.webui:npm_start
```

## Listen to frontend tests

```shell script
./gradlew :scaffold.webui:npmWatchTest
```

## Build a docker image and push it to the image repository

```shell script
./gradlew clean npm_install build push
```
