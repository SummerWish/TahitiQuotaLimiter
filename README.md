# TahitiQuotaLimiter

一个简单的配额限制库。

- 支持速率限流（基于 QPS, Query Per Second）

- 支持基于计数限流（Capacity）

## 下载

### Maven

您可以使用 Maven 下载这个库到您的项目中：

添加:

```
<dependency>
  <groupId>com.google.guava</groupId>
  <artifactId>guava</artifactId>
  <version>19.0</version>
</dependency>
```

### 手工下载

TahitiThroughoutLimiter 依赖于 [guava](https://github.com/google/guava/wiki/Release19).



## 示例

### 限制到每秒 5 次请求

```
ThroughoutLimiter tl = new ThroughoutLimiter(5);

if(tl.tryAcquire()){
	//continue to do sth.
}else{
	//cease
} 
```

### 限制至多 10 次请求

```
CapacityLimiter cl = new CapacitytLimiter(10);

if(cl.tryAcquire()){
	//continue to do sth.
}else{
	//cease
} 
```
