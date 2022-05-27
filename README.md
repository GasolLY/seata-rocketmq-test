# 启动rocketmq
## 下载二进制文件

https://archive.apache.org/dist/rocketmq/4.9.0/rocketmq-all-4.9.0-bin-release.zip

## 配置环境变量
```bash
ROCKETMQ_HOME="D:\rocketmq"
NAMESRV_ADDR="localhost:9876"
```

## 启动nameserver和broker
```bash
./bin/mqnamesrv.cmd
./bin/mqbroker.cmd -n localhost:9876 autoCreateTopicEnable=true
```

## Install Seata RocketMQ分支代码到本地仓库

```bash
# 切换到seata-rocketmq分支
mvn clean install
```

## 启动producer和consumer

通过main方法启动

