# Spring In Action catalog:
## 第2章 装配Bean
### 2.1 Spring配置的可选方案
#### 当描述bean如何进行装配时，Spring具有非常大的灵活性，它提供了三种主要的装配机制：
#### 在XML中进行显式配置。
#### 在Java中进行显式配置。
#### 隐式的bean发现机制和自动装配。
### 2.2 自动化装配bean
#### Spring从两个角度来实现自动化装配：
#### 组件扫描（component scanning）：Spring会自动发现应用上下文中所创建的bean 。
#### 自动装配（autowiring）：Spring自动满足bean之间的依赖。
#### 2.2.1 创建可被发现的 bean
##### 类使用了 @Component 注解。这个注解表明该类会作为组件类，并告知 Spring 要为这个类创建 bean。
##### 组件扫描默认是不启用的。还需要显式配置一下Spring ，从而命令它去寻找带有 @Component 注解的类，并为其创建 bean 。
##### 类使用了 @ComponentScan 注解，这个注解能够在 Spring 中启用组件扫描。例如：
##### @Configuration
##### @ComponentScan
##### public class CDPlayerConfig{
##### }
##### 使用 XML 来启用组件扫描的话，那么可以使用 Spring context 命名空间的 <context:component-scan base-package="..."/> 元素。
#### 2.2.2 为组件扫描的 bean 命名
##### Spring会根据类名为其指定一个ID，将类名的第一个字母小写。
##### @Component("...")
##### @Named("...")
#### 2.2.3 设置组件扫描的基础包
##### @ComponentScan("...")
##### @ComponentScan(basePackages="...","...")
##### @ComponentScan(basePackageClasses{CDPlayer.class,DVDPlayer.class})
#### 2.2.4 通过为 bean 添加注解实现自动装配
##### 构造器上添加了 @Autowired 注解，这表明当 Spring 创建 bean 的时候，会通过这个构造器来进行实例化。
##### @Autowired 注解不仅能够用在构造器上，还能用在属性的 Setter 方法上。
##### @Autowired 注解可以用在类的任何方法上。
##### @Autowired(required=false) 如果没有匹配的 bean ，那么在应用上下文创建的时候， Spring 会抛出一个异常。为了避免异常的出现，你可以将 @Autowired 的 required 属性设置为 false。
### 2.3 通过 Java 代码装配 bean
#### 2.3.1 创建配置类
##### @Configuration 注解表明这个类是一个配置类，该类应该包含在 Spring 应用上下文中如何创建 bean 的细节。
#### 2.3.2 声明简单的 bean
##### @Bean 注解会告诉 Spring 这个方法将会返回一个对象，该对象要注册为 Spring 应用上下文中的 bean 。
##### @Bean(name="...") 设置bean的ID
### 2.4 通过 XML 装配 bean
#### 2.4.1 创建 XML 
##### 创建一个 XML 文件，并且要以 <beans> 元素为根。
#### 2.4.2 声明一个简单的 <bean>
##### <bean id="..." class="...."/>
#### 2.4.3 借助构造器注入初始化 bean
##### 构造器注入 bean 引用
##### <bean id="..." class="....">
#####    <constructor-arg ref="..."/>
##### </bean>
##### 将字面量注入到构造器中
##### <bean id="..." class="....">
#####    <constructor-arg value="..."/>
#####    <constructor-arg value="..."/>
##### </bean>
##### 装配集合
##### <bean id="..." class="....">
#####    <constructor-arg value="..."/>
#####    <constructor-arg value="..."/>
#####    <constructor-arg><null/></constructor-arg>
##### </bean>
##### 
##### <bean id="..." class="....">
#####    <constructor-arg value="..."/>
#####    <constructor-arg value="..."/>
#####    <constructor-arg>
#####       <list>
#####          <value>...</value>
#####          <value>...</value>
#####       </list>
#####    </constructor-arg>
##### </bean>
##### 
##### <bean id="..." class="....">
#####    <constructor-arg value="..."/>
#####    <constructor-arg value="..."/>
#####    <constructor-arg>
#####       <list>
#####          <ref bean="..."/>
#####          <ref bean="..."/>
#####       </list>
#####    </constructor-arg>
##### </bean>
#### 2.4.4 设置属性(类必须有默认构造函数)
##### <bean id="..." class="...">
#####    <property name="..." ref="..."/>
##### </bean>
##### 将字面量注入到属性中
##### <bean id="..." class="....">
#####    <property name="..." value="..."/>
#####    <property name="..." value="..."/>
#####    <property name="...">
#####       <list>
#####          <value>...</value>
#####          <value>...</value>
#####       </list>
#####    </property>
##### </bean>
##### 
##### <bean id="..." class="....">
#####    <property name="..." value="..."/>
#####    <property name="..." value="..."/>
#####    <util:list id="...">
#####       <value>...</value>
#####       <value>...</value>
#####    </util:list>
##### </bean>
### 2.5 导入和混合配置
#### 2.5.1 在 JavaConfig 中引用 XML 配置
##### @Import(class)
##### @ImportResource("classpath:---.xml")
##### <import resource="---.xml" />
## 第3章 高级装配
### 3.1 环境与 profile
#### 3.1.1 配置 profile bean
##### @Profile 注解指定某个 bean 属于哪一个 profile
##### <beans profile="..."></beans>
#### 3.1.2 激活 profile
##### 使用 DispatcherServlet 的参数将 spring.profiles.default 设置为开发环境的 profile
##### <context-param>
#####    <param-name>contextConfigLocation</param-name>
#####    <param-value>/WEB-INF/spring/root-context.xml</param-value>
##### </context-param>
##### <context-param>
#####    <param-name>spring.profiles.default</param-name>
#####    <param-value>dev</param-value>
##### </context-param>
##### <listener>
#####    <listener-class>
#####        org.springframework.web.context.ContextLoaderListener
#####    </listener-class>
##### </listener>
##### <servlet>
#####    <servlet-name>appServlet</servlet-name>
#####    <servlet-class>
#####       org.springframework.web.servlet.DispatcherServlet
#####    </servlet-class>
#####    <init-param>
#####       <param-name>spring.profiles.default</param-name>
#####       <param-value>dev</param-value>
#####    </init-param>
#####    <load-on-startup>1</load-on-startup>
##### </servlet>
##### <servlet-mapping>
#####    <servlet-name>appServlet</servlet-name>
#####    <url-pattern>/</url-pattern>
##### </servlet-mapping>
#####  @ActiveProfiles 注解,指定运行测试时要激活哪个 profile 
### 3.2 条件化的 bean
#### @Conditional 注解,用到带有 @Bean 注解的方法上。如果给定的条件计算结果为 true ，就会创建这个 bean ，否则的话，这个 bean 会被忽略。
#### 设置给 @Conditional 的类可以是任意实现了 Condition 接口的类型。可以看出来，这个接口实现起来很简单直接，只需提供 matches() 方法的实现即可。
#### 如果 matches() 方法返回 true ，那么就会创建带有 @Conditional 注解的 bean 。如果 matches() 方法返回 false ，将不会创建这些 bean 。
### 3.3 处理自动装配的歧义性
#### 3.3.1 标示首选的 bean
##### @Primary注解，将bean设置为首选
##### @Component
##### @Primary
##### public class IceCream implements Dessert { ... }
##### 
##### @Bean
##### @Primary
##### public Dessert iceCream() {
#####    return new IceCream();
##### }
##### <bean id="iceCream" class="com.desserteater.IceCream" primary="true" />
#### 3.3.2 限定自动装配的 bean
##### @Qualifier 注解,将可选方案的范围限定到唯一一个无歧义性的选项中。
##### @Autowired
##### @Qualifier("iceCream")
##### public void setDessert(Dessert dessert) {
#####    this.dessert = dessert;
##### }
##### 创建自定义的限定符
##### @Component
##### @Qualifier("cold")
##### public class IceCream implements Dessert { ... }
##### 
##### @Autowired
##### @Qualifier("cold")
##### public void setDessert(Dessert dessert) {
#####    this.dessert = dessert;
##### }
##### 
##### @Bean
##### @Qualifier("cold")
##### public Dessert iceCream() {
#####    return new IceCream();
##### }
##### 使用自定义的限定符注解
##### @Target({ElementType.CONSTRUCTOR, ElementType.FIELD,
#####          ElementType.METHOD, ElementType.TYPE})
##### @Retention(RetentionPolicy.RUNTIME)
##### @Qualifier
##### public @interface Cold { }
##### 
##### @Target({ElementType.CONSTRUCTOR, ElementType.FIELD,
#####          ElementType.METHOD, ElementType.TYPE})
##### @Retention(RetentionPolicy.RUNTIME)
##### @Qualifier
##### public @interface Creamy { }
##### 
##### @Component
##### @Cold
##### @Creamy
##### public class IceCream implements Dessert { ... }
##### 
##### @Autowired
##### @Cold
##### @Creamy
##### public void setDessert(Dessert dessert) {
#####    this.dessert = dessert;
##### }
##### 
### 3.4 bean 的作用域
#### 单例（ Singleton ）：在整个应用中，只创建 bean 的一个实例。
#### 原型（ Prototype ）：每次注入或者通过 Spring 应用上下文获取的时候，都会创建一个新的 bean 实例。
#### 会话（ Session ）：在 Web 应用中，为每个会话创建一个 bean 实例。
#### 请求（ Rquest ）：在 Web 应用中，为每个请求创建一个 bean 实例。
#### @Scope 注解，它可以与 @Component 或 @Bean 一起使用。
#### @Component
#### @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
#### public class Notepad { ... }
#### 
#### @Bean
#### @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
#### public Notepad notepad() {
####    return new Notepad();
#### }
#### 
#### <bean id="notepad" class="com.myapp.Notepad" scope="prototype" />
#### 
#### 3.4.1 使用会话和请求作用域
##### @Component
##### @Scope(
#####    value=WebApplicationContext.SCOPE_SESSION,
#####    proxyMode=ScopedProxyMode.INTERFACES)
##### public ShoppingCart cart() { ... }
##### proxyMode 属性被设置成了 ScopedProxyMode.INTERFACES ，这表明这个代理要实现 ShoppingCart 接口，并将调用委托给实现 bean 。
##### 如果 bean 类型是具体类的话，我们必须要将 proxyMode 属性设置为 ScopedProxyMode.TARGET_CLASS ，以此来表明要以生成目标类扩展的方式创建代理。
##### 
#### 3.4.2 在 XML 中声明作用域代理
##### <bean id="cart" class="com.myapp.ShoppingCart" scope="session">
#####    <aop:scoped-proxy proxy-target-class="false"/>
##### </bean>
### 3.5 运行时值注入
#### 属性占位符（ Property placeholder ）。
#### Spring 表达式语言（ SpEL ）。
##### 3.5.1 注入外部的值
##### @PropertySource 引用了类路径中一个名为 app.properties 的文件。
##### @PropertySource("classpath:/com/soundsystem/app.properties")
##### @Autowired
##### Environment env;
##### @Bean
##### public BlankDisc disc() {
#####    return new BlankDisc(env.getProperty("disc.title"), env.getProperty("disc.artist"));
##### }
##### 在 Spring 装配中，占位符的形式为使用 “${... }” 包装的属性名称。
##### <bean id="sgtPeppers" class="soundsystem.BlankDisc" c:_title="${disc.title}" c:_artist="${disc.artist}" />
##### public BlankDisc(
#####    @Value("${disc.title}") String title,
#####    @Value("${disc.artist}") String artist) {
#####    this.title = title;
#####    this.artist = artist;
##### }
##### 为了使用占位符，我们必须要配置一个 PropertyPlaceholderConfigurer bean 或 PropertySourcesPlaceholderConfigurer bean 。
##### @Bean
##### public PropertySourcesPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
#####    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
#####    ClassPathResource classPathResource = new ClassPathResource("com/lyn0801/app.properties");
#####    propertySourcesPlaceholderConfigurer.setLocations(classPathResource);
#####    propertySourcesPlaceholderConfigurer.setLocalOverride(true);
#####    return propertySourcesPlaceholderConfigurer;
##### }
##### 使用 XML 配置<context:property-placeholder location="..."/>
##### 3.5.2 使用 Spring 表达式语言进行装配
##### SpEL 表达式要放到 “#{ ... }”
##### #{T(System).currentTimeMillis()}  T() 表达式会将 java.lang.System 视为 Java 中对应的类型，因此可以调用其 static 修饰的 currentTimeMillis() 方法。
##### public BlankDisc(
#####    @Value("#{systemProperties['disc.title']}") String title,
#####    @Value("#{systemProperties['disc.artist']}") String artist) {
#####    this.title = title;
#####    this.artist = artist;
##### }
##### 
##### <bean id="sgtPeppers" class="soundsystem.BlankDisc" c:_title="#{systemProperties['disc.title']}" c:_artist="#{systemProperties['disc.artist']}" />
##### 
##### #{3.14159} 
##### #{'Hello'} 
##### #{false} 
##### #{sgtPeppers} 
##### #{sgtPeppers.artist} 
##### #{artistSelector.selectArtist()} 
##### #{artistSelector.selectArtist().toUpperCase()}
##### #{artistSelector.selectArtist()?.toUpperCase()}
##### T(java.lang.Math)
##### T(java.lang.Math).PI
##### T(java.lang.Math).random()
##### #{2 * T(java.lang.Math).PI * circle.radius}
##### #{disc.title + ' by ' + disc.artist}
##### #{counter.total == 100} or #{counter.total eq 100}
##### #{scoreboard.score > 1000 ? "Winner!" : "Loser"}
##### #{disc.title ?: 'Rattle and Hum'}
##### #{admin.email matches '[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com'}
##### #{jukebox.songs[4].title}
##### #{'This is a test'[3]}
##### 查询运算符（ .?[] ），它会用来对集合进行过滤，得到集合的一个子集。#{jukebox.songs.?[artist eq 'Aerosmith']}
##### #{jukebox.songs.^[artist eq 'Aerosmith']}  “.^[]” 和 “.$[]” ，它们分别用来在集合中查询第一个匹配项和最后一个匹配项。
##### #{jukebox.songs.![title]} 投影运算符（ .![] ），它会从集合的每个成员中选择特定的属性放到另外一个集合中。
## 第4章　面向切面的 Spring
### 4.1 什么是面向切面编程
#### 4.1.1 定义 AOP 术语
##### Spring 切面可以应用 5 种类型的通知：
#####    前置通知（ Before ）：在目标方法被调用之前调用通知功能；
#####    后置通知（ After ）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么；
#####    返回通知（ After-returning ）：在目标方法成功执行之后调用通知；
#####    异常通知（ After-throwing ）：在目标方法抛出异常后调用通知；
#####    环绕通知（ Around ）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为。
### 4.2 通过切点来选择连接点
#### 4.2.1 编写切点
##### 使用 execution() 指示器选择 Performance 的 perform() 方法。方法表达式以 “*” 号开始，表明了我们不关心方法返回值的类型。然
##### 后，我们指定了全限定类名和方法名。对于方法参数列表，我们使用两个点号（ .. ）表明切点要选择任意的 perform() 方法，无论该方法的
##### 入参是什么。
##### execution(* com.lyn0801.Performance.perform(..))
##### 仅匹配 com.lyn0801 包
##### execution(* com.lyn0801.Performance.perform(..)) && within(com.lyn0801.*))
##### 使用了 “&&” 操作符把 execution() 和 within() 指示器连接在一起形成与（ and ）关系（切点必须匹配所有的指示器）。类似
##### 地，我们可以使用 “||” 操作符来标识或（ or ）关系，而使用 “!” 操作符来标识非（ not ）操作。
##### 因为 “&” 在 XML 中有特殊含义，所以在 Spring 的 XML 配置里面描述切点时，我们可以使用 and 来代替 “&&” 。同样， or 和 not 可以分别用来代
##### 替 “||” 和 “!” 。
#### 4.2.2 在切点中选择 bean
##### execution(* com.lyn0801.Performance.perform()) and bean('woodstock')
### 4.3 使用注解创建切面
#### 4.3.1 定义切面
##### @Aspect注解表明 Audience 不仅仅是一个 POJO ，还是一个切面。
##### @After 通知方法会在目标方法返回或抛出异常后调用
##### @AfterReturning 通知方法会在目标方法返回后调用
##### @AfterThrowing 通知方法会在目标方法抛出异常后调用
##### @Around 通知方法会将目标方法封装起来
##### @Before 通知方法会在目标方法调用之前执行
##### @Pointcut 注解能够在一个 @Aspect 切面内定义可重用的切点。
##### @EnableAspectJAutoProxy 注解启用自动代理功能。
##### <aop:aspectj-autoproxy />
#### 4.3.2 创建环绕通知
##### @Around 注解
#### 4.3.3 处理通知中的参数
##### execution(* com.lyn0801.annotation.CompactDisc.playTrack(int)) && args(trackNumber)
#### 4.3.4 通过注解引入新功能
##### @DeclareParents 注解，将 Encoreable 接口引入到 Performance bean 中。
##### @DeclareParents(value="com.lyn0801.Performance+", defaultImpl=DefaultEncoreable.class)
##### public static Encoreable encoreable;
##### value 属性指定了哪种类型的 bean 要引入该接口。在本例中，也就是所有实现 Performance 的类型。（标记符后面的加号表示是 Performance 的所有子类型，而不是 Performance 本身。）
##### defaultImpl 属性指定了为引入功能提供实现的类。在这里，我们指定的是 DefaultEncoreable 提供实现。
##### @DeclareParents 注解所标注的静态属性指明了要引入了接口。在这里，我们所引入的是 Encoreable 接口。
### 4.4 在 XML 中声明切面
#### 把 bean 声明为一个切面时，我们总是从 <aop:config> 元素开始配置的。
#### <aop:aspect> 元素声明了一个简单的切面。 ref 元素引用了一个 POJO bean ，该 bean 实现了切面的功能 —— 在这里就是 audience 。
#### <aop:before> 元素定义了匹配切点的方法执行之前调用前置通知方法
#### <aop:after-returning> 元素定义了一个返回 after-returning ）通知，在切点所匹配的方法调用之后再调用 applaud() 方法。
#### <aop:after-throwing> 元素定义了异常（ after-throwing ）通知，如果所匹配的方法执行时抛出任何的异常，都将会调用 demandRefund() 方法。
#### <aop:pointcut> 元素定义切点。用 pointcut-ref 属性来引用切点
#### <aop:around> 环绕通知