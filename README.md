# mid-ware-use

## this is the project which is describe  the mid of software use

# nacos-config  
- ware-auth-client
  server:
  port: 9106  
  security:
  oauth2:
  client:
  clientId: auth-client
  clientSecret: yichengming
  accessTokenUri: http://ms.ai-xinxin.cn/auth-server/oauth/token
  userAuthorizationUri: http://ms.ai-xinxin.cn/auth-server/oauth/authorize
  scope: FOO
  resource:
  jwt:
  key-value: |
  -----BEGIN PUBLIC KEY-----
  MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwR84LFHwnK5GXErnwkmD
  mPOJl4CSTtYXCqmCtlbF+5qVOosu0YsM2DsrC9O2gun6wVFKkWYiMoBSjsNMSI3Z
  w5JYgh+ldHvA+MIex2QXfOZx920M1fPUiuUPgmnTFS+Z3lmK3/T6jJnmciUPY1pe
  h4MXL6YzeI0q4W9xNBBeKT6FDGpduc0FC3OlXHfLbVOThKmAUpAWFDwf9/uUA//l
  3PLchmV6VwTcUaaHp5W8Af/GU4lPGZbTAqOxzB9ukisPFuO1DikacPhrOQgdxtqk
  LciRTa884uQnkFwSguOEUYf3ni8GNRJauIuW0rVXhMOs78pKvCKmo53M0tqeC6ul
  +QIDAQAB
  -----END PUBLIC KEY-----

spring:
application:
name: ware-auth-client
thymeleaf:
cache: false

cloud:
nacos:
discovery:
server-addr: 127.0.0.1:8848

zipkin:
sender:
type: web
base-url: http://localhost:9411/
service:
name: ware-auth-client
discovery-client-enabled: false
sleuth:
sampler:
probability: 1
management:
endpoints:
web:
exposure:
include: "*"
endpoint:
prometheus:
enabled: true      
metrics:
tags:
application: ${spring.application.name}
export:
prometheus:
enabled: true
  
- ware-auth-server
  server:
  port: 9105

spring:
application:
name: ware-auth-server
cloud:
nacos:
discovery:
server-addr: 127.0.0.1:8848
zipkin:
sender:
type: web
base-url: http://localhost:9411/
service:
name: ware-auth-server
discovery-client-enabled: false
sleuth:
sampler:
probability: 1
datasource:
# 数据库访问配置, 使用druid数据源(默认数据源是HikariDataSource)
type: com.alibaba.druid.pool.DruidDataSource
#链接池配置
druid:
driver-class-name: com.mysql.cj.jdbc.Driver
url: jdbc:mysql://127.0.0.1:3306/cm?useUnicode=true&characterEncoding=UTF-8&useSSL=false&&allowPublicKeyRetrieval=true
username: root
password: "0729cm..."
# 连接池配置：大小，最小，最大
initial-size: 5
min-idle: 5
max-active: 20
# 连接等待超时时间
max-wait: 30000
select-limit: 10000
# 配置检测可以关闭的空闲连接，间隔时间
time-between-eviction-runs-millis: 60000
# 配置连接在池中的最小生存时间
min-evictable-idle-time-millis: 300000
# 检测连接是否有，有效得select语句
validation-query: select '1' from dual
# 申请连接的时候检测，如果空闲时间大于time-between-eviction-runs-millis，执行validationQuery检测连接是否有效，建议配置为true，不影响性能，并且保证安全性。
test-while-idle: true
# 申请连接时执行validationQuery检测连接是否有效，建议设置为false，不然会会降低性能
test-on-borrow: false
# 归还连接时执行validationQuery检测连接是否有效，建议设置为false，不然会会降低性能
test-on-return: false
# 是否缓存preparedStatement，也就是PSCache  官方建议MySQL下建议关闭   个人建议如果想用SQL防火墙 建议打开
# 打开PSCache，并且指定每个连接上PSCache的大小
pool-prepared-statements: true
max-open-prepared-statements: 20
max-pool-prepared-statement-per-connection-size: 20
# 配置监控统计拦截的filters, 去掉后监控界面sql无法统计, 'wall'用于防火墙防御sql注入，stat监控统计,logback日志
filters: stat,wall
# Spring监控AOP切入点，如x.y.z.service.*,配置多个英文逗号分隔
#aop-patterns: com.springboot.servie.*
# lowSqlMillis用来配置SQL慢的标准，执行时间超过slowSqlMillis的就是慢
connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
# WebStatFilter监控配置
web-stat-filter:
enabled: true
# 添加过滤规则：那些访问拦截统计
url-pattern: /*
# 忽略过滤的格式：哪些不拦截，不统计
exclusions: '*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*'
# StatViewServlet配置（Druid监控后台的Servlet映射配置，因为SpringBoot项目没有web.xml所在在这里使用配置文件设置）
stat-view-servlet:
enabled: true
# 配置Servlet的访问路径：访问路径为/druid/**时，跳转到StatViewServlet，会自动转到Druid监控后台
url-pattern: /druid/*
# 是否能够重置数据
reset-enable: false
# 设置监控后台的访问账户及密码
login-username: xsge
login-password: xsge
# IP白名单：允许哪些主机访问，默认为“”任何主机
# allow: 127.0.0.1
# IP黑名单：禁止IP访问，（共同存在时，deny优先于allow）
# deny: 192.168.1.218
# 配置StatFilter
filter:
stat:
log-slow-sql: true        
rocketmq:
name-server: 127.0.0.1:9876
producer:
group: cm-rocket-group
kafka:
bootstrap-servers: 127.0.0.1:9092
producer:
# 消息重发的次数。
retries: 0
#一个批次可以使用的内存大小
batch-size: 16384
# 设置生产者内存缓冲区的大小。
buffer-memory: 33554432
# 键的序列化方式
key-serializer: org.apache.kafka.common.serialization.StringSerializer
# 值的序列化方式
value-serializer: org.apache.kafka.common.serialization.StringSerializer
acks: all
consumer:
# 自动提交的时间间隔 在spring boot 2.X 版本是值的类型为Duration 需要符合特定的格式，如1S,1M,2H,5D
auto-commit-interval: 1S
# 该属性指定了消费者在读取一个没有偏移量的分区或者偏移量无效的情况下该作何处理：
auto-offset-reset: earliest
# 是否自动提交偏移量，默认值是true,为了避免出现重复数据和数据丢失，可以把它设置为false,然后手动提交偏移量
enable-auto-commit: false
# 键的反序列化方式
key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
# 值的反序列化方式
value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
listener:
# 手工ack，调用ack后立刻提交offset
ack-mode: manual_immediate
# 容器运行的线程数
concurrency: 4
# 避免出现主题未创建报错
missing-topics-fatal: false
mybatis-plus:
mapper-locations: classpath*:/mapper/*.xml
type-aliases-package: com.chengming.entity
global-config:
db-config:
id-type: auto
configuration:
cache-enabled: true
redis:
host: 127.0.0.1
port: 6379
password: chengming
management:
endpoints:
web:
exposure:
include: "*"
endpoint:
prometheus:
enabled: true      
metrics:
tags:
application: ${spring.application.name}
export:
prometheus:
enabled: true 