# TahitiQuotaLimiter

[![Build Status](https://travis-ci.org/SummerWish/TahitiQuotaLimiter.svg?branch=master)](https://travis-ci.org/SummerWish/TahitiQuotaLimiter) [![Coverage Status](https://coveralls.io/repos/github/SummerWish/TahitiQuotaLimiter/badge.svg?branch=master)](https://coveralls.io/github/SummerWish/TahitiQuotaLimiter?branch=master)

一个简单的配额限制库。

- 支持基于速率限流（Query Per Second）

- 支持基于计数限流（Capacity）

## 下载

### Maven

您可以使用 Maven 下载这个库到您的项目中。请在 pom.xml 中添加我们的 repository 和这个项目：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <!-- 此处可以有其他内容，已省略 -->
    
    <repositories>
        <repository>
            <id>tahiti</id>
            <url>http://10.60.40.241:8888/repository/internal/</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

    <dependencies>
        <!-- 此处可以有其他内容，已省略 -->
        <dependency>
            <groupId>octoteam.tahiti</groupId>
            <artifactId>quota</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

</project>
```

### 手工下载

TahitiQuotaLimiter 依赖于 [guava 18](https://github.com/google/guava/wiki/Release18)。您需要将以下 jar 全部下载下来添加到项目中：

- [guava-18.0.jar](http://10.60.40.241:8888/repository/internal/com/google/guava/guava/18.0/guava-18.0.jar)

- [quota-1.0-20160409.081452-1.jar](http://10.60.40.241:8888/repository/snapshots/octoteam/tahiti/quota/1.0-SNAPSHOT/quota-1.0-20160409.081452-1.jar)


## 示例

### 限制到每秒 5 次请求

超出 5 次/s 频率的请求将失败：

```java
ThroughoutLimiter limiter = new ThroughoutLimiter(5);

if (limiter.tryAcquire()) {
	// 没有超出限额，继续
} else {
	// 超出了限额，提示错误或忽略
} 
```

### 限制至多 10 次请求

当请求次数超过 10 次后，后续的请求将全部失败：

```java
CapacityLimiter limiter = new CapacitytLimiter(10);

if (limiter.tryAcquire()) {
	// 没有超出限额，继续
} else {
	// 超出了限额，提示错误或忽略
} 
```
