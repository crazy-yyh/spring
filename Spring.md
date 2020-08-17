# 第1章 Spring 概述

## 1.1 spring是什么

> Spring 是分层的 Java SE/EE 应用 full-stack 轻量级开源框架，以 IoC（Inverse Of Control：
> 反转控制）和 AOP（Aspect Oriented Programming：面向切面编程）为内核，提供了展现层 Spring
> MVC 和持久层 Spring JDBC 以及业务层事务管理等众多的企业级应用技术，还能整合开源世界众多
> 著名的第三方框架和类库，逐渐成为使用最多的 Java EE 企业应用开源框架。  

## 1.2 spring 的优势

* **方便解耦，简化开发**
  	通过 Spring 提供的 IoC 容器，可以将对象间的依赖关系交由 Spring 进行控制，避免硬编码所造
  成的过度程序耦合。用户也不必再为单例模式类、属性文件解析等这些很底层的需求编写代码，可
  以更专注于上层的应用。

* **AOP 编程的支持**
  	通过 Spring 的 AOP 功能，方便进行面向切面的编程，许多不容易用传统 OOP 实现的功能可以
  传智播客——专注于 Java、 .Net 和 Php、网页平面设计工程师的培训
  北京市昌平区建材城西路金燕龙办公楼一层 电话： 400-618-9090
  通过 AOP 轻松应付。

* **声明式事务的支持**
  	可以将我们从单调烦闷的事务管理代码中解脱出来，通过声明式方式灵活的进行事务的管理，
  提高开发效率和质量。

* **方便程序的测试**
  	可以用非容器依赖的编程方式进行几乎所有的测试工作，测试不再是昂贵的操作，而是随手可
  做的事情。

* **方便集成各种优秀框架**
  	Spring 可以降低各种框架的使用难度，提供了对各种优秀框架（ Struts、 Hibernate、 Hessian、 Quartz
  等）的直接支持。

* **降低 JavaEE API 的使用难度**
  	Spring 对 JavaEE API（如 JDBC、 JavaMail、远程调用等）进行了薄薄的封装层，使这些 API 的
  使用难度大为降低。

* **Java 源码是经典学习范例**
  	Spring 的源代码设计精妙、结构清晰、匠心独用，处处体现着大师对 Java 设计模式灵活运用以
  及对 Java 技术的高深造诣。它的源代码无意是 Java 技术的最佳实践的范例。  

## 1.3 spring的体系结构

![image-20200815090244175](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200815090244175.png)

# 第2章 IoC 的概念和作用

## 2.1 什么是程序的耦合

> 耦合性(Coupling)，也叫耦合度，是对模块间关联程度的度量。耦合的强弱取决于模块间接口的复杂性、调
> 用模块的方式以及通过界面传送数据的多少。模块间的耦合度是指模块之间的依赖关系，包括控制关系、调用关
> 系、数据传递关系。模块间联系越多，其耦合性越强，同时表明其独立性越差( 降低耦合性，可以提高其独立
> 性)。 耦合性存在于各个领域，而非软件设计中独有的，但是我们只讨论软件工程中的耦合。
>
> 在软件工程中， 耦合指的就是就是对象之间的依赖性。对象之间的耦合越高，维护成本越高。因此对象的设计
> 应使类和构件之间的耦合最小。 软件设计中通常用耦合度和内聚度作为衡量模块独立程度的标准。 划分模块的一个
> 准则就是==高内聚低耦合==。
> 它有如下分类：
> （1） 内容耦合。当一个模块直接修改或操作另一个模块的数据时，或一个模块不通过正常入口而转入另
> 一个模块时，这样的耦合被称为内容耦合。内容耦合是最高程度的耦合，应该避免使用之。
> （2） 公共耦合。两个或两个以上的模块共同引用一个全局数据项，这种耦合被称为公共耦合。在具有大
> 量公共耦合的结构中，确定究竟是哪个模块给全局变量赋了一个特定的值是十分困难的。
> （3） 外部耦合 。一组模块都访问同一全局简单变量而不是同一全局数据结构，而且不是通过参数表传
> 递该全局变量的信息，则称之为外部耦合。
> （4） 控制耦合 。一个模块通过接口向另一个模块传递一个控制信号，接受信号的模块根据信号值而进
> 行适当的动作，这种耦合被称为控制耦合。
> （5） 标记耦合 。若一个模块 A 通过接口向两个模块 B 和 C 传递一个公共参数，那么称模块 B 和 C 之间
> 存在一个标记耦合。
> （6） 数据耦合。模块之间通过参数来传递数据，那么被称为数据耦合。数据耦合是最低的一种耦合形
> 式，系统中一般都存在这种类型的耦合，因为为了完成一些有意义的功能，往往需要将某些模块的输出数据作为另
> 一些模块的输入数据。
> （7） 非直接耦合 。两个模块之间没有直接关系，它们之间的联系完全是通过主模块的控制和调用来实
> 现的。
> ==总结：==
> 	耦合是影响软件复杂程度和设计质量的一个重要因素，在设计上我们应采用以下原则：如果模块间必须
> 存在耦合，就尽量使用数据耦合，少用控制耦合，限制公共耦合的范围，尽量避免使用内容耦合。
>
> ==内聚与耦合==
> 	内聚标志一个模块内各个元素彼此结合的紧密程度，它是信息隐蔽和局部化概念的自然扩展。 内聚是从
> 功能角度来度量模块内的联系，一个好的内聚模块应当恰好做一件事。它描述的是模块内的功能联系。耦合是软件
> 结构中各模块之间相互连接的一种度量，耦合强弱取决于模块间接口的复杂程度、进入或访问一个模块的点以及通
> 过接口的数据。 程序讲究的是低耦合，高内聚。就是同一个模块内的各个元素之间要高度紧密，但是各个模块之
> 间的相互依存度却要不那么紧密。
>
> 内聚和耦合是密切相关的，同其他模块存在高耦合的模块意味着低内聚，而高内聚的模块意味着该模块同其他
> 模块之间是低耦合。在进行软件设计时，应力争做到高内聚，低耦合。  

## 2.2 控制反转-Inversion Of Control  

![image-20200815092726407](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200815092726407.png)

![image-20200815092738784](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200815092738784.png)

# 第3章 使用 spring 的 IOC 解决程序耦合

## 3.1 基于 XML 的配置（入门案例）

### 3.1.1 引入依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

### 3.1.2 创建业务层接口和实现类

```java
//接口
public interface IAccountDao{
    // 模拟保存账户
    void saveAccount();
}

//实现类
public class IAccountDaoImpl implements IAccountDao {
    @Override
    public  void saveAccount(){

        System.out.println("保存了账户");
    }
}
```

### 3.1.3 创建持久层接口和实现类

```java
//接口
public interface IAccountService {
	//模拟保存账户
    void saveAccount();
}

//实现类
public class IAccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public IAccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}

```

### 3.1.4 在类的根路径下创建一个任意名称的 xml 文件（不能是中文）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--把对象的创建交给spring来管理-->
    <bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl">
        <property name="accountDao" ref="accountDao"></property>
    </bean>
    
    <bean id="accountDao" class="com.yan01.dao.impl.IAccountDaoImpl"></bean>
</beans>
```

### 3.1.5 测试配置是否成功

```java
public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象,两种方式
        IAccountService as  = (IAccountService)ac.getBean("accountService");
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

//        System.out.println(as);
//        System.out.println(adao);
        as.saveAccount();

    }
}
```

## 3.2 Spring 基于 XML 的 IOC 细节[掌握]

### 3.2.1 spring 中工厂的类结构图

![image-20200815101847938](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200815101847938.png)

![image-20200815101901520](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200815101901520.png)

### 3.2.2 BeanFactory 和 ApplicationContext 的区别

> BeanFactory 才是 Spring 容器中的顶层接口。ApplicationContext 是它的子接口。
>
> BeanFactory 和 ApplicationContext 的区别：
> 创建对象的时间点不一样。
> 	ApplicationContext：只要一读取配置文件，默认情况下就会创建对象。
> 	BeanFactory：什么使用什么时候创建对象。  

### 3.2.3 ApplicationContext 接口的实现类

> ClassPathXmlApplicationContext：
>
> ​	它是从类的根路径下加载配置文件     **推荐使用这种**
>
> FileSystemXmlApplicationContext：
>
> ​	它是从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置。
>
> AnnotationConfigApplicationContext:
> 	当我们使用注解配置容器对象时，需要使用此类来创建 spring 容器。它用来读取注解。

### 3.2.4 IOC 中 bean 标签和管理对象细节

#### 3.2.4.1 bean 标签  

> **作用：**
> 	用于配置对象让 spring 来创建的。
> 	默认情况下它调用的是类中的无参构造函数。如果没有无参构造函数则不能创建成功。
>
> **属性：**
> **id：** 给对象在容器中提供一个唯一标识。用于获取对象。
>
> **class：** 指定类的全限定类名。用于反射创建对象。默认情况下调用无参构造函数。
>
> **scope**： 指定对象的作用范围。
>
> * **singleton** :默认值，单例的.
>
> * **prototype** :多例的.
>
> * **request** :WEB 项目中,Spring 创建一个 Bean 的对象,将对象存入到 request 域中.
>
> * **session** :WEB 项目中,Spring 创建一个 Bean 的对象,将对象存入到 session 域中.
>
> * **global session :**WEB 项目中,应用在 Portlet 环境.如果没有 Portlet 环境那么
>   globalSession 相当于 session.
>
> **init-method**： 指定类中的初始化方法名称。
> **destroy-method**： 指定类中销毁方法名称。  

#### 3.2.4.2 bean 的作用范围和生命周期  

* 单例对象： scope="singleton"
  	一个应用只有一个对象的实例。它的作用范围就是整个引用。
    	生命周期：
    		对象出生：当应用加载，创建容器时，对象就被创建了。
    		对象活着：只要容器在，对象一直活着。
    		对象死亡：当应用卸载，销毁容器时，对象就被销毁了。

* 多例对象： scope="prototype"
  	每次访问对象时，都会重新创建对象实例。
    	生命周期：
    		对象出生：当使用对象时，创建新的对象实例。
    		对象活着：只要对象在使用中，就一直活着。
    		对象死亡：当对象长时间不用时，被 java 的垃圾回收器回收了。  

#### 3.2.4.3 实例化 Bean 的三种方式

```xml
 第一种方式：使用默认构造函数创建。
        在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。
        采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。
<bean id="accountDao" class="com.yan01.dao.impl.IAccountDaoImpl"></bean>


 第二种方式： 使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）
    public class InstanceFactory {
        public IAccountService getAccountService(){
            return new AccountServiceImpl();
        }
    }
<bean id="instanceFactory" class="com.yan01.factory.InstanceFactory"></bean>
<bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"></bean>


 第三种方式：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器)
    public class StaticFactory {
        public static IAccountService getAccountService(){
            return new AccountServiceImpl();
        }
    }
 <bean id="accountService" class="com.yan01.factory.StaticFactory" factory-method="getAccountService"></bean>
```

#### 3.2.4.4 spring 的依赖注入

##### 3.2.4.4.1 依赖注入的概念  

> 依赖注入： Dependency Injection。 它是 spring 框架核心 ioc 的具体实现。
> 我们的程序在编写时， 通过控制反转， 把对象的创建交给了 spring，但是代码中不可能出现没有依赖的情况。
> ioc 解耦只是降低他们的依赖关系，但不会消除。 例如：我们的业务层仍会调用持久层的方法。
> 那这种业务层和持久层的依赖关系， 在使用 spring 之后， 就让 spring 来维护了。
> 简单的说，就是坐等框架把持久层对象传入业务层，而不用我们自己去获取。  

##### 3.2.4.4.2 构造函数注入  

```java
public class IAccountServiceImpl implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public IAccountServiceImpl(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。"+name+","+age+","+birthday);
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    
    <!--构造函数注入：
        使用的标签:constructor-arg
        标签出现的位置：bean标签的内部
        标签中的属性
            type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型
            index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始
            name：用于指定给构造函数中指定名称的参数赋值                                        常用的
            =============以上三个用于指定给构造函数中哪个参数赋值===============================
            value：用于提供基本类型和String类型的数据
            ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象

        优势：
            在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
        弊端：
            改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供。
    -->
     
    <bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl">
        <constructor-arg name="name" value="分公司特"></constructor-arg>
        <constructor-arg name="age" value="18"></constructor-arg>
        <constructor-arg name="birthday" ref="now"></constructor-arg>
    </bean>

    <!-- 配置一个日期对象 -->
    <bean id="now" class="java.util.Date"></bean>
</beans>
```

##### 3.2.4.4.3 set 方法注入  

```java
public class IAccountServiceImpl2 implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。"+name+","+age+","+birthday);
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
   

    <!-- set方法注入                更常用的方式
        涉及的标签：property
        出现的位置：bean标签的内部
        标签的属性
            name：用于指定注入时所调用的set方法名称
            value：用于提供基本类型和String类型的数据
            ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象
        优势：
            创建对象时没有明确的限制，可以直接使用默认构造函数
        弊端：
            如果有某个成员必须有值，则获取对象是有可能set方法没有执行。
    -->
    <bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl2">
        <property name="name" value="TEST" ></property>
        <property name="age" value="21"></property>
        <property name="birthday" ref="now"></property>
    </bean>
    
      <!-- 配置一个日期对象 -->
    <bean id="now" class="java.util.Date"></bean>
</beans>
```

##### 3.2.4.4.4 接口注入

```java
public class IAccountServiceImpl3 implements IAccountService {

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void  saveAccount(){
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }
    
}

```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
     
    <!-- 复杂类型的注入/集合类型的注入
        用于给List结构集合注入的标签：
            list array set
        用于个Map结构集合注入的标签:
            map  props
        结构相同，标签可以互换
    -->
    <bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl3">
            <property name="myList">
                <list>
                    <value>AAA</value>
                    <value>BBB</value>
                    <value>CCC</value>
                    <value>DDD</value>
                </list>
            </property>

            <property name="myStrs">
                <array>
                    <value>AAA</value>
                    <value>BBB</value>
                    <value>CCC</value>
                </array>
            </property>

            <property name="mySet">
                <set>
                    <value>AAA</value>
                    <value>BBB</value>
                </set>
            </property>

            <property name="myProps">
                <map>
                    <entry key="testa" value="aaa"></entry>
                    <entry key="testb">
                        <value>bbb</value>
                    </entry>
                </map>
            </property>

            <property name="myMap">
                <props>
                    <prop key="testc">cccc</prop>
                    <prop key="testd">ddd</prop>
                </props>
            </property>
        </bean>

</beans>
```

## 3.3 基于XML的Ioc的CRUD

#### 3.3.1 创建数据库和编写实体类并引入依赖

```SQL
CREATE DATABASE `account`;
USE ACCOUNT;
CREATE TABLE ACCOUNT(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(40),
	money FLOAT
)CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO ACCOUNT(NAME,money) VALUES('aaa',1000);
INSERT INTO ACCOUNT(NAME,money) VALUES('bbb',1000);
INSERT INTO ACCOUNT(NAME,money) VALUES('ccc',1000);
```

```JAVA
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}

```

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>commons-dbutils</groupId>
        <artifactId>commons-dbutils</artifactId>
        <version>1.4</version>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.6</version>
    </dependency>

    <dependency>
        <groupId>c3p0</groupId>
        <artifactId>c3p0</artifactId>
        <version>0.9.1.2</version>
    </dependency>

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
</dependencies>
```

#### 3.3.2 编写持久层代码

```JAVA
public interface IAccountDao {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);
}
```

```java
public class IAccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {
        try{
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            return runner.query("select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            runner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            runner.update("delete from account where id=?",accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```

#### 3.3.3 编写业务层代码

```java
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);

}

```

```java
public class IAccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }
}
```

#### 3.3.4 创建并编写配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- 配置Service -->
    <bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl">
        <!-- 注入dao -->
        <property name="accountDao" ref="accountDao"></property>
    </bean>

    <!--配置Dao对象-->
    <bean id="accountDao" class="com.yan01.dao.impl.IAccountDaoImpl">
        <!-- 注入QueryRunner -->
        <property name="runner" ref="runner"></property>
    </bean>

    <!--配置QueryRunner-->
    <bean id="runner" class="org.apache.commons.dbutils.QueryRunner" scope="prototype">
        <!--注入数据源-->
        <constructor-arg name="ds" ref="dataSource"></constructor-arg>
    </bean>

    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <!--连接数据库的必备信息-->
        <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/account"></property>
        <property name="user" value="root"></property>
        <property name="password" value="123456"></property>
    </bean>
</beans>
```

#### 3.3.5 测试类代码  

```java
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as  = (IAccountService)ac.getBean("accountService");

        List<Account> allAccount = as.findAllAccount();
        for(Account l : allAccount){
            System.out.println(l);
        }

    }
}

```

## 3.4 使用注解改造基于XML的配置（入门案例）

### 3.4.1 明确： 写在最前

> 学习基于注解的 IoC 配置，大家脑海里首先得有一个认知，即注解配置和 xml 配置要实现的功能都是一样的，都是要降低程序间的耦合。只是配置的形式不一样。
>
> 关于实际的开发中到底使用xml还是注解，每家公司有着不同的使用习惯。所以这两种配置方式我们都需要掌握。
>
> 我们在讲解注解配置时，采用上一章节的案例，把 spring 的 xml 配置内容改为使用注解逐步实现。  

### 3.4.2 业务层实现类

```java
//实现类
@Repository
public class IAccountDaoImpl implements IAccountDao {
    @Override
    public  void saveAccount(){

        System.out.println("保存了账户");
    }
}
```

### 3.4.3 持久层实现类

```java
//实现类
@Service("accountService")
public class IAccountServiceImpl implements IAccountService {
	
    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public IAccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
```

### 3.4.4 配置bean.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!--告知spring在创建容器时要扫描的包，配置所需要的标签不是在beans的约束中，而是一个名称为
    context名称空间和约束中-->
    <context:component-scan base-package="com.yan01"></context:component-scan>
</beans>
```

## 3.5 常用注解

### 3.5.1 用于创建对象的

#### @Component

* 作用：
  把资源让 spring 来管理。相当于在 xml 中配置一个 bean。

* 属性：
  value：指定 bean 的 id。如果不指定 value 属性，默认 bean 的 id 是当前类的类名。首字母小写。  

#### @Controller @Service @Repository

* 他们三个注解都是针对一个的衍生注解，他们的作用及属性都是一模一样的。
  他们只不过是提供了更加明确的语义化。
  @Controller： 一般用于表现层的注解。
  @Service： 一般用于业务层的注解。
  @Repository： 一般用于持久层的注解。
  细节：如果注解中有且只有一个属性要赋值时，且名称是 value， value 在赋值是可以不写。  

### 3.5.2 用于注入数据的

#### @Autowired

* 作用：
  自动按照类型注入。当使用注解注入属性时， **set 方法可以省略**。它只能注入其他 bean 类型。当有多个类型匹配时，使用要注入的对象变量名称作为 bean 的 id，在 spring 容器查找，找到了也可以注入成功。找不到就报错  

#### @Qualifier

* 作用：
  在自动按照类型注入的基础之上，再按照 Bean 的 id 注入。它在给字段注入时不能独立使用，必须和@Autowire 一起使用；但是给方法参数注入时，可以独立使用。

* 属性：
  value：指定 bean 的 id。  

#### @Resource

* 作用：

  直接按照bean的id注入。它可以独立使用

* 属性：

  name：用于指定bean的id。

以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
另外，**集合类型的注入只能通过XML来实现**。

####  @Value

Value
* 作用：

  用于注入基本类型和String类型的数据

* 属性：

  value：用于指定数据的值。它可以使用spring中SpEL(也就是spring的el表达式）

  SpEL的写法：${表达式}

### 3.5.3 用于改变作用范围的

#### @Scope

* 作用：
  指定 bean 的作用范围。

* 属性：
  value：指定范围的值。
  取值： singleton         prototype      request      session      globalsession  

### 3.5.4  和生命周期相关

#### @PostConstruct

* 作用：
  用于指定初始化方法。    

#### @PreDestroy

* 作用：
  用于指定销毁方法  

## 3.6 关于 Spring 注解和 XML 的选择问题  

![image-20200816100830616](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200816100830616.png)

## 3.7 使用注解改造基于XML的Ioc的CRUD

### 3.7.1 持久层实现类改造

```java
@Repository
public class IAccountDaoImpl implements IAccountDao {
	
    @Autowired
    private QueryRunner runner;

    //	注解可以将Set删除
//    public void setRunner(QueryRunner runner) {
//       this.runner = runner;
// }
	
    // 以下代码无变化，略

}
```

### 3.7.2 业务层实现类改造

```java
@Service("accountService")
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;
    
     // 以下代码无变化，略
}
```

### 3.7.3 改造配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!--告知spring在创建容器时要扫描的包，配置所需要的标签不是在beans的约束中，而是一个名称为
    context名称空间和约束中-->
    <context:component-scan base-package="com.yan01"></context:component-scan>
     <!--配置QueryRunner-->
    <bean id="runner" class="org.apache.commons.dbutils.QueryRunner" scope="prototype">
        <!--注入数据源-->
        <constructor-arg name="ds" ref="dataSource"></constructor-arg>
    </bean>

    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <!--连接数据库的必备信息-->
        <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/account"></property>
        <property name="user" value="root"></property>
        <property name="password" value="123456"></property>
    </bean>
</beans>
```

### 3.7.4 待改造的问题  

```xml
我们发现，之所以我们现在离不开 xml 配置文件，是因为我们有一句很关键的配置：
<!-- 告知spring框架在，读取配置文件，创建容器时，扫描注解，依据注解创建对象，并存入容器中 -->
<context:component-scan base-package="com.itheima"></context:component-scan>
如果他要也能用注解配置，那么我们就离脱离 xml 文件又进了一步。
另外，数据源和 JdbcTemplate 的配置也需要靠注解来实现。

<!-- 配置 dbAssit -->
<bean id="dbAssit" class="com.itheima.dbassit.DBAssit">
<property name="dataSource" ref="dataSource"></property>
</bean>

<!-- 配置数据源 -->
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
<property name="driverClass" value="com.mysql.jdbc.Driver"></property>
<property name="jdbcUrl" value="jdbc:mysql://localhost:3306/account"></property>
<property name="user" value="root"></property>
<property name="password" value="1234"></property>
</bean>
```

## 3.8 新注解

### @Configuration  

```
该类是一个配置类，它的作用和bean.xml是一样的
  作用：指定当前类是一个配置类
  细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
```

```java
@Configuration
public class SpringConfiguration {
}

//注意：
//        我们已经把配置文件用类来代替了， 但是如何配置创建容器时要扫描的包呢？
//        请看下一个注解。

```

### @ComponentScan

```
作用：用于通过注解指定spring在创建容器时要扫描的包
属性：
	value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
	我们使用此注解就等同于在xml中配置了:
	<context:component-scan base-package="com.itheima"></context:component-scan>
```

```java
@Configuration
@ComponentScan("com.yan01")
public class SpringConfiguration {
}

//注意：
//        我们已经配置好了要扫描的包，但是数据源和 JdbcTemplate 对象如何从配置文件中移除呢？
//        请看下一个注解。
```

### @Bean  

```
作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
      属性:
          name:用于指定bean的id。当不写时，默认值是当前方法的名称
      细节：
          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
          查找的方式和Autowired注解的作用是一样的
```

新建一个类JdbcConfig ,数据源的属性为了不写死，我们将新建一个属性文件

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/account
jdbc.username=root
jdbc.password=123456
```

```java
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name="runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("ds2") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name="ds2")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //注意：
	//此时我们已经有了两个配置类，但是他们还没有关系。如何建立他们的关系呢？
	//请看下一个注解。
    
}
```

### @Import

```
 作用：用于导入其他的配置类。在引入其他配置类时，可以不用再写@Configuration 注解。 当然，写上也没问题
 属性：
 	value：用于指定其他配置类的字节码。
	当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
```

```java
@Configuration
@ComponentScan("com.yan01")
@Import(JdbcConfig.class)
public class SpringConfiguration {


}
//注意：
//    properties文件还与配置没有联系，那怎么关联呢
//    请看下一个注解
```

### @PropertySource

```
作用：
	用于加载.properties 文件中的配置。例如我们配置数据源时，可以把连接数据库的信息写到properties 配置文件中，就可以使用此注解指定 properties 配置文件的位置。

属性：
	value[]：用于指定 properties 文件位置。如果是在类路径下，需要写上 classpath:
```

```JAVA
@Configuration
@ComponentScan("com.yan01")
@Import(JdbcConfig.class)
@PropertySource("classpath:Jdbc.properties")
public class SpringConfiguration {


}
//我们已经把要配置的都配置好了，但是新的问题产生了，由于没有配置文件了，如何获取容器呢？
//请看下一小节。
```

### 3.8.1 通过注解获取容器： 

```java
ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
```

# 第4章 Spring 整合 Junit[掌握]

## 4.1 问题

```
在测试类中，每个测试方法都有以下两行代码：
ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
IAccountService as = ac.getBean("accountService",IAccountService.class);
这两行代码的作用是获取容器，如果不写的话，直接会提示空指针异常。所以又不能轻易删掉
```

## 4.2 解决思路分析

> 针对上述问题，我们需要的是程序能自动帮我们创建容器。一旦程序能自动为我们创建 spring 容器，我们就
> 无须手动创建了，问题也就解决了。
> 我们都知道， junit 单元测试的原理（在 web 阶段课程中讲过），但显然， junit 是无法实现的，因为它自
> 己都无法知晓我们是否使用了 spring 框架，更不用说帮我们创建 spring 容器了。不过好在， junit 给我们暴露
> 了一个注解，可以让我们替换掉它的运行器。
> 这时，我们需要依靠 spring 框架，因为它提供了一个运行器，可以读取配置文件（或注解）来创建容器。我
> 们只需要告诉它配置文件在哪就行了。  

## 4.3 配置步骤

### 第一步：引入 junit 的坐标

**此处需要注意的是，导入 jar 包时，需要导入一个 spring 中 aop 的 jar 包和一个spring-test的坐标**  

```xml
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>5.0.2.RELEASE</version>
</dependency>

<dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-context</artifactId>
     <version>5.0.2.RELEASE</version>
</dependency>

 <dependency>
     <groupId>junit</groupId>
     <artifactId>junit</artifactId>
     <version>4.12</version>
</dependency>
```

### 第二步：使用@RunWith 注解替换原有运行器  

```java
//测试类
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {
}
```

### 第三步：使用@ContextConfiguration 指定 spring 配置文件的位置

```java
//测试类
@ContextConfiguration(classes = SpringConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {
}
```

```
@ContextConfiguration 注解：
locations 属性： 用于指定配置文件的位置。如果是类路径下，需要用 classpath:表明
	@ContextConfiguration(locations= {"classpath:bean.xml"})
classes 属性： 用于指定注解的类。当不使用 xml 配置时，需要用此属性指定注解类的位置。
	@ContextConfiguration(classes = SpringConfiguration.class)

当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
```

## 4.4 为什么不把测试类配到 xml 中

> 在解释这个问题之前，先解除大家的疑虑，配到 XML 中能不能用呢？
> 答案是肯定的，没问题，可以使用。
> 那么为什么不采用配置到 xml 中的方式呢？
> 这个原因是这样的：
> 第一：当我们在 xml 中配置了一个 bean， spring 加载配置文件创建容器时，就会创建对象。
> 第二：测试类只是我们在测试功能时使用，而在项目中它并不参与程序逻辑，也不会解决需求上的问题，所以创建完了，并没有使用。那么存在容器中就会造成资源的浪费。
> 所以，基于以上两点，我们不应该把测试配置到 xml 文件中  

# 第5章 AOP 的相关概念

## 5.1 什么是 AOP

![image-20200816135044453](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200816135044453.png)

## 5.2 AOP 的作用及优势

* 作用：
  在程序运行期间，不修改源码对已有方法进行增强。

* 优势：
  减少重复代码
  提高开发效率
  维护方便  

## 5.3 AOP 的实现方式  

>  使用动态代理技术  

## 5.4 动态代理的特点  

> 字节码随用随创建，随用随加载。
> 它与静态代理的区别也在于此。因为静态代理是字节码一上来就创建好，并完成加载。
> 装饰者模式就是静态代理的一种体现。  

## 5.5 动态代理常用的有两种方式

### 5.5.1 基于接口的动态代理

> ```
> *      涉及的类：Proxy
> *      提供者：JDK官方
> *  如何创建代理对象：
> *      使用Proxy类中的newProxyInstance方法
> *  创建代理对象的要求：
> *      被代理类最少实现一个接口，如果没有则不能使用
> *  newProxyInstance方法的参数：
> *      ClassLoader：类加载器
> *          它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法。
> *      Class[]：字节码数组
> *          它是用于让代理对象和被代理对象有相同方法。固定写法。
> *      InvocationHandler：用于提供增强的代码
> *          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
> *          此接口的实现类都是谁用谁写。
> ```

```java
//接口
public interface IProducer {
	// 销售
    public void saleProduct(float money);
	//售后
   	public void afterService(float money);
}

//实现类
public class Producer implements IProducer{

    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }

    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}

```

```java
public class Client {
    public static void main(String[] args) {
        final  Producer producer = new Producer();
        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;

                        //1.获取方法执行的参数
                        Float money = (Float)args[0];
                        //2.判断当前方法是不是销售
                        if("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money*0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(10000f);
    }
}
```

### 5.5.2 基于子类的动态代理  

```
*      涉及的类：Enhancer
*      提供者：第三方cglib库
*  如何创建代理对象：
*      使用Enhancer类中的create方法
*  创建代理对象的要求：
*      被代理类不能是最终类
*  create方法的参数：
*      Class：字节码
*          它是用于指定被代理对象的字节码。
*
*      Callback：用于提供增强的代码
*          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
*          此接口的实现类都是谁用谁写。
*          我们一般写的都是该接口的子接口实现类：MethodInterceptor
```

```java
public class Producer {

    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }

    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object returnValue = null;

                //1.获取方法执行的参数
                Float money = (Float)args[0];
                //2.判断当前方法是不是销售
                if("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money*0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(12000f);
    }
}
```

## 5.6 AOP 相关术语  

**Joinpoint(连接点):**
所谓连接点是指那些被拦截到的点。在 spring 中,这些点指的是方法,因为 spring 只支持方法类型的连接点。

**Pointcut(切入点):**
所谓切入点是指我们要对哪些 Joinpoint 进行拦截的定义。  

**Advice(通知/增强):**
所谓通知是指拦截到 Joinpoint 之后所要做的事情就是通知。
通知的类型： 前置通知,后置通知,异常通知,最终通知,环绕通知。

**Introduction(引介):**
引介是一种特殊的通知在不修改类代码的前提下, Introduction 可以在运行期为类动态地添加一些方法或 Field。

**Target(目标对象):**
代理的目标对象。

**Weaving(织入):**
是指把增强应用到目标对象来创建新的代理对象的过程。
spring 采用动态代理织入，而 AspectJ 采用编译期织入和类装载期织入。

**Proxy（代理） :**
一个类被 AOP 织入增强后，就产生一个结果代理类。

**Aspect(切面):**
是切入点和通知（引介）的结合。  

## 5.7 关于代理的选择  

> 在 spring 中，框架会根据目标类是否实现了接口来决定采用哪种动态代理的方式。  

# 第6章  AOP 的配置

## 6.1 基于 XML 的 AOP 配置  

### 6.1.1 引入依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.8.7</version>
    </dependency>
</dependencies>
```

### 6.1.2 新建业务层代码

```java
//接口
public interface IAccountService {

    void saveAccount();

    void updateAccount(int i);

    int  deleteAccount();
}

//实现类
public class IAccountServiceImpl implements IAccountService{

    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
//        int i=1/0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新"+i);

    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}

//通知类
public class Logger {

    /**
     * 前置通知
     */
    public  void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
    public  void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
    /**
     * 异常通知
     */
    public  void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
    public  void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

}

```

### 6.1.3 创建 spring 的配置文件并导入约束  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">
</beans>
```

### 6.1.4 配置步骤

####  配置 spring 的 ioc

```xml
<!-- 配置srping的Ioc,把service对象配置进来-->
<bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl"></bean>

 <!-- 配置Logger类 -->
 <bean id="logger" class="com.yan01.utils.Logger"></bean>
```

#### 使用 aop:config 声明 aop 配置

```xml
<!--配置AOP-->
<aop:config>

</aop:config>
```

#### 使用 aop:aspect 配置切面  

> ```
> id属性：是给切面提供一个唯一标识
> ref属性：是指定通知类bean的Id。
> ```

```xml
<!--配置AOP-->
<aop:config>
    <!--配置切面 -->
    <aop:aspect id="logAdvice" ref="logger">
        
    </aop:aspect>
    
</aop:config>
```

#### 使用 aop:xxx 配置对应的通知类型

```
method属性：用于指定Logger类中哪个方法是什么通知
pointcut属性：用于指定切入点表达式，该表达式的含义指的是对业务层中哪些方法增强
```

```xml
  <!--配置AOP-->
    <aop:config>
        <!--配置切面 -->
        <aop:aspect id="logAdvice" ref="logger">
            <!-- 配置通知的类型，并且建立通知方法和切入点方法的关联-->
            <aop:before method="beforePrintLog" pointcut="execution(* com.yan01.service.impl.*.*(..))"></aop:before>

            <!--配置后置通知：在切入点方法正常执行之后值。它和异常通知永远只能执行一个-->
           <aop:after-returning method="afterReturningPrintLog" pointcut="execution(* com.yan01.service.impl.*.*(..))"></aop:after-returning>


            <!--配置异常通知：在切入点方法执行产生异常之后执行。它和后置通知永远只能执行一个-->
            <aop:after-throwing method="afterThrowingPrintLog" pointcut="execution(* com.yan01.service.impl.*.*(..))"></aop:after-throwing>


            <!--配置最终通知：无论切入点方法是否正常执行它都会在其后面执行-->
            <aop:after method="afterPrintLog" pointcut="execution(* com.yan01.service.impl.*.*(..))"></aop:after>
        </aop:aspect>

    </aop:config>
```

```
<!--    切入点表达式的写法：
    关键字：execution(表达式)
    表达式：
    访问修饰符  返回值  包名.包名.包名...类名.方法名(参数列表)
    标准的表达式写法：
    public void com.yan01.service.impl.AccountServiceImpl.saveAccount()
    访问修饰符可以省略
    void com.yan01.service.impl.AccountServiceImpl.saveAccount()
    返回值可以使用通配符，表示任意返回值
    * com.yan01.service.impl.AccountServiceImpl.saveAccount()
    包名可以使用通配符，表示任意包。但是有几级包，就需要写几个*.
    * *.*.*.*.AccountServiceImpl.saveAccount())
    包名可以使用..表示当前包及其子包
    * *..AccountServiceImpl.saveAccount()
    类名和方法名都可以使用*来实现通配
    * *..*.*()
    参数列表：
    可以直接写数据类型：
    基本类型直接写名称           int
    引用类型写包名.类名的方式   java.lang.String
    可以使用通配符表示任意类型，但是必须有参数
    可以使用..表示有无参数均可，有参数可以是任意类型
    全通配写法：
    * *..*.*(..)

    实际开发中切入点表达式的通常写法：
    切到业务层实现类下的所有方法
    * com.yan01.service.impl.*.*(..)-->
```

#### 使用 aop:pointcut 配置切入点表达式

```xml
 <!--配置AOP-->
    <aop:config>
            <!-- 配置切入点表达式 id属性用于指定表达式的唯一标识。expression属性用于指定表达式内容
          此标签写在aop:aspect标签内部只能当前切面使用。
          它还可以写在aop:aspect外面，此时就变成了所有切面可用
     	 -->
		<aop:pointcut id="pt1" expression="execution(* com.yan01.service.impl.*.*(..))"></aop:pointcut>
        
        <!--配置切面 -->
        <aop:aspect id="logAdvice" ref="logger">
            <!-- 配置通知的类型，并且建立通知方法和切入点方法的关联-->
            <aop:before method="beforePrintLog" pointcut-ref="pt1"></aop:before>

            <!--配置后置通知：在切入点方法正常执行之后值。它和异常通知永远只能执行一个-->
           <aop:after-returning method="afterReturningPrintLog" pointcut-ref="pt1"></aop:after-returning>


            <!--配置异常通知：在切入点方法执行产生异常之后执行。它和后置通知永远只能执行一个-->
            <aop:after-throwing method="afterThrowingPrintLog" pointcut-ref="pt1"></aop:after-throwing>


            <!--配置最终通知：无论切入点方法是否正常执行它都会在其后面执行-->
            <aop:after method="afterPrintLog" pointcut-ref="pt1"></aop:after>
        </aop:aspect>

    </aop:config>
```

### 6.1.5 测试

```java
public class TestAop {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();
    }
}
```

### 6.1.6 环绕通知

```
/**
 * 环绕通知
 * 问题：
 *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
 * 分析：
 *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
 * 解决：
 *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
 *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
 *
 * spring中的环绕通知：
 *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
 */
```

```java
public class Logger {

    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");

            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }

}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 配置srping的Ioc,把service对象配置进来-->
    <bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl"></bean>

    <!-- 配置Logger类 -->
    <bean id="logger" class="com.yan01.utils.Logger"></bean>

    <!--配置AOP-->
    <aop:config>
        <!-- 配置切入点表达式 id属性用于指定表达式的唯一标识。expression属性用于指定表达式内容
              此标签写在aop:aspect标签内部只能当前切面使用。
              它还可以写在aop:aspect外面，此时就变成了所有切面可用
          -->
        <aop:pointcut id="pt1" expression="execution(* com.yan01.service.impl.*.*(..))"></aop:pointcut>
        <!--配置切面 -->
        <aop:aspect id="logAdvice" ref="logger">
            <!-- 配置环绕通知 详细的注释请看Logger类中-->
            <aop:around method="aroundPringLog" pointcut-ref="pt1"></aop:around>
        </aop:aspect>
    </aop:config>

</beans>
```

## 6.2 基于注解的 AOP 配置

改造基于XML的AOP配置中的代码

### 6.2.1 在配置文件中指定 spring 要扫描的包

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 配置spring创建容器时要扫描的包-->
    <context:component-scan base-package="com.yan01"></context:component-scan>
</beans>
```

### 6.2.2 把资源使用注解配置

```java
@Service("accountService")
public class IAccountServiceImpl implements IAccountService{
	......
}
```

### 6.2.3 把通知类也使用注解配置

```java
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {
	......
}
```

### 6.2.4 在增强的方法上使用注解配置通知

```java
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    @Before("execution(* com.yan01.service.impl.*.*(..))")
    public  void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    @AfterReturning("execution(* com.yan01.service.impl.*.*(..))")
    public  void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
 
    @AfterThrowing("execution(* com.yan01.service.impl.*.*(..))")
    public  void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    @After("execution(* com.yan01.service.impl.*.*(..))")
    public  void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }
}
```

### 6.2.5 在 spring 配置文件中开启 spring 对注解 AOP 的支持

```xml
  <!-- 配置spring创建容器时要扫描的包-->
    <context:component-scan base-package="com.yan01"></context:component-scan>

    <!-- 配置spring开启注解AOP的支持 -->
    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
```

### 6.2.6 注意

使用该方式在底层调用是涉及一个调用顺序的问题

![image-20200817091046658](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200817091046658.png)

### 6.2.7 切入点表达式注解  

```java
	@Pointcut("execution(* com.yan01.service.impl.*.*(..))")
	private void pt1(){}
 	/**
     * 前置通知
     */
    @Before("pt1()")
    public  void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public  void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public  void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public  void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }
```

### 6.2.8 环绕通知的配置

```java
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.yan01.service.impl.*.*(..))")
    private void pt1(){}

    @Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");

            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }
}
```

结果正常，建议使用这种

![image-20200817092022363](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200817092022363.png)

### 6.2.9 不使用 XML 的配置方式  

```java
@Configuration
@ComponentScan(basePackages = "com.yan01")
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
```

测试使用

```java
public class TestAop {
    public static void main(String[] args) {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();
    }
}
```

# 第7章 Spring 中的 JdbcTemplate  

## 7.1 JdbcTemplate 概述  

> 它是 spring 框架中提供的一个对象，是对原始 Jdbc API 对象的简单封装。 spring 框架为我们提供了很多的操作模板类。
>
> 操作关系型数据的：
> JdbcTemplate
> HibernateTemplate
>
> 操作 nosql 数据库的：
> RedisTemplate
>
> 操作消息队列的：
> JmsTemplate

## 7.2 配置数据源

默认已引入依赖

### 配置 C3P0 数据源  

```xml
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
    <property name="jdbcUrl" value="jdbc:mysql:///spring_day02"></property>
    <property name="user" value="root"></property>
    <property name="password" value="123456"></property>
</bean>
```

### 配置 DBCP 数据源  

```xml
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
    <property name="url" value="jdbc:mysql:// /spring_day02"></property>
    <property name="username" value="root"></property>
    <property name="password" value="1234"></property>
</bean>
```

### 配置 spring 内置数据源  

```xml
<!-- 配置数据源-->
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
    <property name="url" value="jdbc:mysql://localhost:3306/account"></property>
    <property name="username" value="root"></property>
    <property name="password" value="123456"></property>
</bean>
```

## 7.3 JdbcTemplate的两种使用方法

### 引入依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.6</version>
    </dependency>
</dependencies>
```

### 准备实体类

```java
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
```

### 接口

```java
public interface IAccountDao {

    /**
     * 根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */java
    void updateAccount(Account account);
}
```

### 第一种：在 dao 中定义 JdbcTemplate

```java
public class IAccountDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
}

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?,money=? whjavaere id=?",account.getName(),account.getMoney(),account.getId());
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 配置账户的持久层-->
    <bean id="accountDao" class="com.yan01.dao.impl.IAccountDaoImpl">
        <property name="jdbcTemplate" ref="jdbcTemplate"></property>
    </bean>

	<!-- 配置JdbcTemplate-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!-- 配置数据源-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/account"></property>
        <property name="username" value="root"></property>
        <property name="password" value="123456"></property>
    </bean>
</beans>
```

测试

```java
public class jdbctest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        //3.执行操作
        System.out.println(accountDao.findAccountById(2));
    }
}
```

### 第二种：让 dao 继承 JdbcDaoSupport

```java
public class IAccountDaoImpl2 extends JdbcDaoSupport implements IAccountDao {

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 配置账户的持久层-->
    <bean id="accountDao2" class="com.yan01.dao.impl.IAccountDaoImpl2">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!-- 配置数据源-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/account"></property>
        <property name="username" value="root"></property>
        <property name="password" value="123456"></property>
    </bean>
</beans>
```

测试

```java
public class jdbctest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao2", IAccountDao.class);
        //3.执行操作
        System.out.println(accountDao.findAccountById(1));
    }
}
```

#### jdbcDaoSupport源码

```java
public abstract class JdbcDaoSupport extends DaoSupport {
    //定义对象
    @Nullable
    private JdbcTemplate jdbcTemplate;

    public JdbcDaoSupport() {
    }
    //set 方法注入数据源，判断是否注入了，注入了就创建 JdbcTemplate
    public final void setDataSource(DataSource dataSource) {
        if (this.jdbcTemplate == null || dataSource != this.jdbcTemplate.getDataSource()) {
            //set 方法注入数据源，判断是否注入了，注入了就创建 JdbcTemplate
            this.jdbcTemplate = this.createJdbcTemplate(dataSource);
            this.initTemplateConfig();
        }

    }

    protected JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    .......
}
```

### 两种方法的区别

> 第一种在 Dao 类中定义 JdbcTemplate 的方式，适用于所有配置方式（ xml 和注解都可以）。
> 第二种让 Dao 继承 JdbcDaoSupport 的方式，只能用于基于 XML 的方式，注解用不了。  

# 第8章  事务控制

## 8.1 Spring 中事务控制的 API 介绍  

### PlatformTransactionManager

此接口是 spring 的事务管理器，它里面提供了我们常用的操作事务的方法，如下图：  

> PlatformTransactionManager接口提供事务操作的方法,包含有3个具体的操作
>
> 获取事务状态信息
> Transaction Status getTransaction(Transaction Definition definition)
>
> 提交事务
> void commit(Transaction Status status)
>
> 回滚事务
> void rollback(Transaction Statusstatus)
>
> 真正管理事务的对象
> org.springframework.jdbc.datasource.DataSourceTransactionManager 使用 Spring
> JDBC 或 iBatis进行持久化教据时使用
> org.springframework.orm.hibernate5.HibernateTransactionManager使用
> Hibernate 版本进行持久化数据时使用

### TransactionDefinition

它是事务的定义信息对象，里面有如下方法：  

* 获取事务对象名称
  String getName()

* 获取事务隔离级
  int getlsolationLevel()

* 获取事务传播行为
  int getPropagationBehavior()

* 获取事务超时时间
  int setTimeout()

* 获取事务是否只读
  boolean isReadOnly()

#### 事务的隔离级别  

事务隔离级反映事务提交并发访问时的处理态度

* ISOLATION_DEFAULT
  * 默认级别,归属下列某一种

* ISOLATION_READ_UNCOMMITTED
  * 可以读取未提交数据

* ISOLATION_READ_COMMITTED
  * 只能读取已提交数据,解决脏读问题( Oracle默认级别)

* ISOLATION_REPEATABLE_READ
  * 是否读取其他事务提交修改后的数据,解决不可重复读问题( MySQL默认级别

* ISOLATION_SERIALIZABLE
  * 是否读取其他事务提交添加后的数据,解决幻影读问题

#### 事务的传播行为  

* REQUIRED:如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。一般的选择（默认值）

* SUPPORTS:支持当前事务，如果当前没有事务，就以非事务方式执行（没有事务）

* MANDATORY：使用当前的事务，如果当前没有事务，就抛出异常

* REQUERS_NEW:新建事务，如果当前在事务中，把当前事务挂起。

* NOT_SUPPORTED:以非事务方式执行操作，如果当前存在事务，就把当前事务挂起

* NEVER:以非事务方式运行，如果当前存在事务，抛出异常

* NESTED:如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行 REQUIRED 类似的操作。  

#### 超时时间  

默认值是-1，没有超时限制。如果有，以秒为单位进行设置。  

#### 是否是只读事务  

建议查询时设置为只读。  

### TransactionStatus  

此接口提供的是事务具体的运行状态，方法介绍如下图：  

Transaction Status接口描述了某个时间点上事务对象的状态信息,包含有6个具体的操作

* 刷新事务
  * void flush()

* 获取是否是否存在存储点
  * boolean hasSavepoint()

* 获取事务是否完成
  * boolean isCompleted()

* 获取事务是否为新的事务
  * boolean isNew Transaction()

* 获取事务是否回滚
  * boolean isRollbackOnly()
* 设置事务回滚
  * void setRollbackOnly()

## 8.2 基于 XML 的声明式事务控制（配置方式）重点

### 8.2.1 搭建环境

####  第一步：引入依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>commons-dbutils</groupId>
        <artifactId>commons-dbutils</artifactId>
        <version>1.4</version>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.6</version>
    </dependency>

    <dependency>
        <groupId>c3p0</groupId>
        <artifactId>c3p0</artifactId>
        <version>0.9.1.2</version>
    </dependency>

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.8.7</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>
    <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-jdbc</artifactId>
         <version>5.0.2.RELEASE</version>
     </dependency>
</dependencies>
```

####  第二步：创建 spring 的配置文件并导入约束

```xml
<!--此处需要导入 aop 和 tx 两个名称空间-->
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:aop="http://www.springframework.org/schema/aop"
xmlns:tx="http://www.springframework.org/schema/tx"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/tx
http://www.springframework.org/schema/tx/spring-tx.xsd
http://www.springframework.org/schema/aop
http://www.springframework.org/schema/aop/spring-aop.xsd">
</beans>
```

#### 第三步：准备实体类

```java
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
```

#### 第四步：编写 Dao 接口和实现类

```JAVA
//接口
public interface IAccountDao {

    //根据Id查询账户
    Account findAccountById(Integer accountId);

	// 根据名称查询账户
    Account findAccountByName(String accountName);

    // 更新账户
    void updateAccount(Account account);
}

//实现类
public class IAccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}

```

#### 第五步：编写业务层接口和实现类

```java
//接口
public interface IAccountService {
    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName    转成账户名称
     * @param targetName    转入账户名称
     * @param money         转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}

//实现类
public class IAccountServiceImpl implements IAccountService{

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
        int i=1/0;
        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}

```

#### 第六步：在配置文件中配置业务层和持久层

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 配置业务层-->
    <bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl">
        <property name="accountDao" ref="accountDao"></property>
    </bean>

    <!-- 配置账户的持久层-->
    <bean id="accountDao" class="com.yan01.dao.impl.IAccountDaoImpl">
        <property name="dataSource" ref="dataSource"></property>
    </bean>


    <!-- 配置数据源-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/eesy"></property>
        <property name="username" value="root"></property>
        <property name="password" value="1234"></property>
    </bean>
</beans>
```

### 8.2.2 配置步骤

#### 第一步： 配置事务管理器

```xml
<!-- 配置事务管理器 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"></property>
</bean>
```

#### 第二步：配置事务的通知引用事务管理器

此时我们需要导入事务的约束 tx名称空间和约束，同时也需要aop的

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 配置业务层-->
    <bean id="accountService" class="com.yan01.service.impl.IAccountServiceImpl">
        <property name="accountDao" ref="accountDao"></property>
    </bean>

    <!-- 配置账户的持久层-->
    <bean id="accountDao" class="com.yan01.dao.impl.IAccountDaoImpl">
        <property name="dataSource" ref="dataSource"></property>
    </bean>


    <!-- 配置数据源-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/eesy"></property>
        <property name="username" value="root"></property>
        <property name="password" value="1234"></property>
    </bean>

    <!-- 配置事务管理器 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!-- 事务的配置 -->
    <!-- 使用tx:advice标签配置事务通知
    属性：
    id：给事务通知起一个唯一标识
    transaction-manager：给事务通知提供一个事务管理器引用-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
    </tx:advice>


</beans>
```

#### 第三步：配置事务的属性  

```xml
<!-- 使用tx:advice标签配置事务通知
 属性：
 id：给事务通知起一个唯一标识
 transaction-manager：给事务通知提供一个事务管理器引用-->
 <tx:advice id="txAdvice" transaction-manager="transactionManager">
     <!-- 配置事务的属性
             isolation：用于指定事务的隔离级别。默认值是DEFAULT，表示使用数据库的默认隔离级别。
             propagation：用于指定事务的传播行为。默认值是REQUIRED，表示一定会有事务，增删改的选择。查询方法可以选择SUPPORTS。
             read-only：用于指定事务是否只读。只有查询方法才能设置为true。默认值是false，表示读写。
             timeout：用于指定事务的超时时间，默认值是-1，表示永不超时。如果指定了数值，以秒为单位。
             rollback-for：用于指定一个异常，当产生该异常时，事务回滚，产生其他异常时，事务不回滚。没有默认值。表示任何异常都回滚。
             no-rollback-for：用于指定一个异常，当产生该异常时，事务不回滚，产生其他异常时事务回滚。没有默认值。表示任何异常都回滚。
     -->
     <tx:attributes>
         <tx:method name="*" propagation="REQUIRED" read-only="false"/>
         <tx:method name="find*" propagation="SUPPORTS" read-only="true"></tx:method>
     </tx:attributes>
 </tx:advice>
```

#### 第四步：配置 AOP 切入点表达式  

```xml
<!-- 配置aop-->
<aop:config>
    <!-- 配置切入点表达式-->
    <aop:pointcut id="pt1" expression="execution(* com.yan01.service.impl.*.*(..))"></aop:pointcut>
</aop:config>
```

#### 第五步：配置切入点表达式和事务通知的对应关系  

```xml
 <!-- 配置aop-->
    <aop:config>
        <!-- 配置切入点表达式-->
        <aop:pointcut id="pt1" expression="execution(* com.yan01.service.impl.*.*(..))"></aop:pointcut>
        <!--建立切入点表达式和事务通知的对应关系 -->
        <aop:advisor advice-ref="txAdvice" pointcut-ref="pt1"></aop:advisor>
    </aop:config>
```

### 8.2.3 测试结果

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public  void testTransfer(){
        as.transfer("aaa","bbb",100f);

    }

}
```

## 8.3 基于注解的配置方式

### 8.3.1 搭建环境

#### 第一步： 引入依赖

同基于XML配置一致

#### 第二步：创建 spring 的配置文件导入约束并配置扫描的包

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:aop="http://www.springframework.org/schema/aop"
xmlns:tx="http://www.springframework.org/schema/tx"
xmlns:context="http://www.springframework.org/schema/context"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="
http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/aop
http://www.springframework.org/schema/aop/spring-aop.xsd
http://www.springframework.org/schema/tx
http://www.springframework.org/schema/tx/spring-tx.xsd
http://www.springframework.org/schema/context
http://www.springframework.org/schema/context/spring-context.xsd">
 <!-- 配置spring创建容器时要扫描的包-->
    <context:component-scan base-package="com.yan01"></context:component-scan>
</beans>
```

#### 第三步：创建数据库表和实体类  

> 和基于 xml 的配置相同。略  

#### 第四步：创建业务层接口和实现类并使用注解让 spring 管理  

```java
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private IAccountDao accountDao;
	//其余代码和基于 XML 的配置相同
}
```

#### 第五步：创建 Dao 接口和实现类并使用注解让 spring 管理  

```java
@Repository("accountDao")
public class IAccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}

```

#### 第六步：在配置文件中配置业务层和持久层

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 配置spring创建容器时要扫描的包-->
    <context:component-scan base-package="com.yan01"></context:component-scan>

    <!-- 配置JdbcTemplate-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!-- 配置数据源-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/eesy"></property>
        <property name="username" value="root"></property>
        <property name="password" value="1234"></property>
    </bean>
</beans>
```

### 8.3.2 配置步骤

#### 第一步：配置事务管理器并注入数据源  

```xml
<!-- 配置事务管理器 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"></property>
</bean>
```

#### 第二步：在业务层使用@Transactional 注解  

```java
@Service("accountService")
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)//只读型事务的配置
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);

    }

    //需要的是读写型事务配置
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        ......
    }
```

> 该注解的属性和 xml 中的属性含义一致。该注解可以出现在接口上，类上和方法上。
> 出现接口上，表示该接口的所有实现类都有事务支持。
> 出现在类上，表示类中所有方法有事务支持
> 出现在方法上，表示方法有事务支持。
> 以上三个位置的优先级：方法>类>接口  

#### 第三步：在配置文件中开启 spring 对注解事务的支持  

```xml
<!-- 开启spring对注解事务的支持-->
<tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
```

完整配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 配置spring创建容器时要扫描的包-->
    <context:component-scan base-package="com.yan01"></context:component-scan>

    <!-- 配置JdbcTemplate-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!-- 配置数据源-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/eesy"></property>
        <property name="username" value="root"></property>
        <property name="password" value="1234"></property>
    </bean>

    <!-- spring中基于注解 的声明式事务控制配置步骤
        1、配置事务管理器
        2、开启spring对注解事务的支持
        3、在需要事务支持的地方使用@Transactional注解
     -->
    <!-- 配置事务管理器 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!-- 开启spring对注解事务的支持-->
    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>

</beans>
```

### 8.3.3 测试结果

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public  void testTransfer(){
        as.transfer("aaa","bbb",100f);

    }

}
```

### 8.3.4 不使用 xml 的配置方式

#### 属性文件jdbc.properties

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/account
jdbc.username=root
jdbc.password=123456
```

#### JdbcConfig类

```java
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean(name="ds2")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Bean(name="runner")
    @Scope("prototype")
    public JdbcTemplate createJdbcTemplate(@Qualifier("ds2") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
}
```

#### TransactionConfig类

```java
public class TransactionConfig {

    /**
     * 用于创建事务管理器对象
     * @param dataSource
     * @return
     */
    @Bean(name="transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
```

SpringTxConfiguration类

```java
@Configuration
@ComponentScan(basePackages = "com.yan01")
@EnableTransactionManagement
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringTxConfiguration {

}
```

#### 测试

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTxConfiguration.class)
public class AccountServiceTest {


    @Autowired
    private  IAccountService as;

    @Test
    public  void testTransfer(){
        as.transfer("aaa","bbb",100f);

    }
}
```