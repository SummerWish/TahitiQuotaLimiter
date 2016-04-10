# TahitiQuotaLimiter

[![Build Status](https://travis-ci.org/SummerWish/TahitiQuotaLimiter.svg?branch=master)](https://travis-ci.org/SummerWish/TahitiQuotaLimiter)
[![Coverage Status](https://coveralls.io/repos/github/SummerWish/TahitiQuotaLimiter/badge.svg?branch=master)](https://coveralls.io/github/SummerWish/TahitiQuotaLimiter?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/5709196ffcd19a005185517c/badge.svg)](https://www.versioneye.com/user/projects/5709196ffcd19a005185517c)

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
            <id>tahiti-nexus-snapshots</id>
            <name>Tahiti NEXUS</name>
            <url>http://sse.tongji.edu.cn/tahiti/nexus/content/groups/public</url>
            <releases><enabled>false</enabled></releases>
            <snapshots><enabled>true</enabled></snapshots>
        </repository>
    </repositories>

    <dependencies>
        <!-- 此处可以有其他内容，已省略 -->
        <dependency>
            <groupId>octoteam.tahiti</groupId>
            <artifactId>tahiti-quota</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

</project>
```

### 手工下载

- [tahiti-quota](http://sse.tongji.edu.cn/tahiti/nexus/service/local/repositories/public/content/octoteam/tahiti/tahiti-quota/1.0-SNAPSHOT/tahiti-quota-1.0-20160410.135120-2.jar)

除了这个库本身以外，TahitiQuotaLimiter 还依赖于 [guava](https://github.com/google/guava/wiki/Release19)，因此您还需要将以下 jar 下载下来添加到项目中：

- [guava](http://central.maven.org/maven2/com/google/guava/guava/19.0/guava-19.0.jar)

## 示例

### 限制至多 3 次请求

当请求次数超过 3 次后，后续的请求将全部失败：

```java
QuotaLimiter limiter = new CapacitytLimiter(3);

limiter.tryAcquire(); // true
limiter.tryAcquire(); // true
limiter.tryAcquire(); // true
limiter.tryAcquire(); // false
limiter.tryAcquire(); // false
// ...
```

### 限制每秒至多 5 次请求

超出 5 次/s 频率的请求将失败：

```java
QuotaLimiter limiter = new ThroughputLimiter(5);

// .....

if (limiter.tryAcquire()) {
	// 没有超出限额，继续
} else {
	// 超出了限额，提示错误或忽略
} 
```
