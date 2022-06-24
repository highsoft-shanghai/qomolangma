# QOMOLANGMA

## [英文](./README.md) | [中文](./README.zh.md)

本仓库包含开发全部所需材料，使用这些材料即可快速构建一个全新的开发环境。

## 准备环境

### 容器技术

本项目的开发依赖容器技术，需要开发环境有Docker环境。如您尚未配置Docker环境，请先自行配置Docker环境。Mac OS X和Windows请安装Docker Desktop，Linux系统直接安装Docker
CE.以下信息供参考：

- Mac OS X: https://www.docker.com/products/docker-desktop
- Windows: https://www.docker.com/products/docker-desktop
- Ubuntu: https://docs.docker.com/engine/install/ubuntu/
- CentOS: https://docs.docker.com/engine/install/centos/

### 开发平台

这个项目采用了Java和Kotlin的混合开发模式，严重依赖Java生态系统。请先安装OpenJDK
17先安装。

- OpenJDK 17 for Windows:

  https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_windows-x64_bin.zip
- OpenJDK 17 for Mac:

  https://download.java.net/java/GA/jdk18/43f95e8614114aeaa8e8a5fcf20a682d/36/GPL/openjdk-18_macos-x64_bin.tar.gz

- OpenJDK 17 for Linux:

  https://download.java.net/java/GA/jdk18/43f95e8614114aeaa8e8a5fcf20a682d/36/GPL/openjdk-18_linux-x64_bin.tar.gz

### 开发工具

为了更好的开发体验以及更高的开发效率，请使用IntelliJ IDEA作为默认开发工具：

- IntelliJ IDEA: https://www.jetbrains.com/idea/

### 依赖服务

这个项目的所有依赖性服务都可以以自动化的方式建立。你将需要编写你的依赖性
服务部署脚本。要建立一个全新的环境。
在项目根目录下执行以下命令：

```shell
sh ./scripts/setup-local
```

### 脚本

#### 安装前端依赖

```shell script
./gradlew npm_install
```

#### 提交前代码检查

```shell script
sh ./scripts/check-all
```

#### 运行主项目

```shell script
./gradlew bootRun
```

#### 安装前端依赖

```shell script
./gradlew :qomolangma.webui:yarn_build
```

#### 监听前端测试

```shell script
./gradlew :qomolangma.webui:yarn_test
```

#### 构建docker镜像

```shell script
sh ./scripts/build-all
```

## 技术架构

We use 
