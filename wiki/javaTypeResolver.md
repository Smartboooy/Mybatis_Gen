## The Element

>The element is used to define properties of the Java Type Resolver. The Java Type Resolver is used to calculate Java types from database column information. The default Java Type Resolver attempts to make JDBC DECIMAL and NUMERIC types easier to use by substituting Integral types if possible (Long, Integer, Short, etc.) If this behavior is undesirable, set the property "forceBigDecimals" to "true". You can also substitute your own implementation if you want different behavior than the default. This element is an optional child element of the element.

`<javatyperesolver>`元素用于定义Java类型解析器(Java Type Resolver)的属性。 Java Type Resolver用于从数据库列信息中计算Java类型。 
如果可能的话，默认的Java Type Resolver通过替代整数类型（Long, Integer, Short, etc.）,试图使JDBC DECIMAL和NUMERIC类型更容易使用.
如果不希望出现此情况，请将属性`forceBigDecimals`设置为`true`。 如果您希望与默认行为不同，您还可以替换自己的实现。此元素是“context”元素的可选子元素。

### 必选属性
无

### 可选属性

>type - This can be used to specify a user provided Java Type Resolver. The class must implement the interface org.mybatis.generator.api.JavaTypeResolver, and must have a public default constructor. The attribute also accepts the special value DEFAULT in which case the default implementation will be used (this has the same effect as not specifying the type).

type - 可以用于指定用户提供的Java Type Resolver。 该类必须实现接口org.mybatis.generator.api.JavaTypeResolver，并且必须有一个公共的默认构造函数。 该属性还接受特殊值DEFAULT，在这种情况下将使用默认实现（这具有与不指定类型相同的效果）。

### 子元素
**支持的属性**

>This table lists the properties of the default Java type resolver that can be specified with the <property> child element

此表列出了可以使用`<property>`子元素指定的默认Java类型解析器的属性

>forceBigDecimals - This property is used to specify whether MyBatis Generator should force the use of java.math.BigDecimal for DECIMAL and NUMERIC fields, rather than substituting integral types when possible. The property supports these values: 

forceBigDecimals - 此属性用于指定MyBatis Generator是否应强制对DECIMAL和NUMERIC字段使用java.math.BigDecimal，而不是在可能时替换整数类型。 属性支持这些值：

>false This is the default value When the property is false or unspecified, 
the default Java type resolver will attempt to make JDBC DECIMAL and NUMERIC types easier to work with by substituting Integral types if possible. 
The substitution rules are as follows: 
>- If the scale is greater than zero, or the length is greater than 18, then the java.math.BigDecimal type will be used 
>- If the scale is zero, and the length is 10 through 18, then the Java type resolver will substitute a java.lang.Long. 
>- If the scale is zero, and the length is 5 through 9, then the Java type resolver will substitute a java.lang.Integer. 
>- If the scale is zero, and the length is less than 5, then the Java type resolver will substitute a java.lang.Short.

false - 这是默认值，当属性为false或未指定时，默认的java类型解析器尝试去通过替换整型,使JDBC DECIMAL 和 NUMERIC类型更好的使用, 替换规则如下:

- 如果`scale`大于零或`length`大于18，则将使用java.math.BigDecimal类型;
- 如果`scale`为零，`length`为10到18， 那么Java类型解析器将替代java.lang.Long;
- 如果`scale`为零，`length`为5到9，则Java类型解析器将替换java.lang.Integer；
- 如果`scale`为零，`length`小于5，则Java类型解析器将替换java.lang.Short。

>true When the property is true, the Java type resolver will always use java.math.BigDecimal if the database column is of type DECIMAL or NUMERIC. 

当属性是true,如果数据库列为DECIMAL 或者 NUMERIC,java类型解析器总会使用java.math.BigDecimal.