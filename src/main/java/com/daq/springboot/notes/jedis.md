## 说明
- SpringBoot 操作数据的有：`spring-data jpa `,`jdbc` ,`mongodb` ,`redis`！
- 在 `SpringBoot2.x` 之后，原来使用的`jedis` 被替换为了 `lettuce`
- `jedis :` 底层采用的直连，如果多个线程操作的话是不安全的，如果想要避免不安全的，使用 `jedis pool` 连接池，这就更像 `BIO` 模式。
- `lettuce :` 采用`netty`，实例可以再多个线程中进行共享，不存在线程不安全的情况！可以减少线程数据了，更像 `NIO `模式

## 整合SpringBoot
1. 导入依赖`spring-boot-starter-data-redis`
2. 在`application.yml`中配置连接
3. 默认的序列化方式是JDK序列化，我们会使用json来序列化，关于对象的保存：所有的对象，都需要序列化
4. 自己定义了一个 RedisTemplate,用的时候就用自己定义的模版就好了，不用担心对象序列化的问题了