###  集成swagger
访问方式  http://localhost:8080/swagger-ui.html

第一步：pom文件中引入两个依赖，	`springfox-swagger2`和`springfox-swagger-ui`

第二步：编写docket配置文件，通过apiInfo()属性配置具体的文档信息，再用docket 实例关联上 apiInfo()

第三步：构建Docket时通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
有以下几种扫描接口的方式：
1. any() // 扫描所有，项目中的所有接口都会被扫描到
2. none() // 不扫描接口
3. withMethodAnnotation(final Class<? extends Annotation> annotation)// 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
4. withClassAnnotation(final Class<? extends Annotation> annotation)// 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
5. basePackage(final String basePackage) // 根据包路径扫描接口

第四步： 还可以配置接口扫描过滤器,不扫描哪些包
// 配置如何通过path过滤,即这里只扫描请求以/Hello开头的接口
.paths(PathSelectors.ant("/Hello/**"))
// 可选的参数有
1. any() // 任何请求都扫描
2. none() // 任何请求都不扫描
3. regex(final String pathRegex) // 通过正则表达式控制
4. ant(final String antPattern) // 通过ant()控制

第五步： 配置swagger开关
通过enable()方法配置是否启用swagger，如果是false，swagger将不能在浏览器中访问了
.enable(false) //配置是否启用Swagger，如果是false，在浏览器将无法访问

第六步： 动态配置当项目处于test、dev环境时显示swagger，处于prod时不显示
// 设置要显示swagger的环境
   Profiles of = Profiles.of("dev", "test");
// 判断当前是否处于该环境
// 通过 enable() 接收此参数判断是否要显示
   boolean b = environment.acceptsProfiles(of);
   根据b标志位判断
.enable(b) //配置是否启用Swagger，如果是false，在浏览器将无法访问

第七步：配置API分组
1. 如果没有配置分组，默认是default  通过groupName()方法即可配置分组
 .groupName("hello") // 配置分组
2. 配置多个分组只需要配置多个docket即可

第八步：实体配置
@ApiModel为类添加注释
@ApiModelProperty为类属性添加注释