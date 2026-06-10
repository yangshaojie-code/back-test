# Java 语法综合题考核文档

## 一、题目名称

博客文章筛选与统计器

## 二、题目背景

现在有一批博客文章数据，每篇文章包含作者、标题、正文、状态、发布时间、浏览量等信息。

请使用 Java 实现一个“文章筛选与统计器”。本题不要求连接数据库，也不要求编写后端接口，只需要在内存中完成数据解析、筛选、排序和统计。

本题重点考察 Java 语法和基础 API 的综合运用能力，包括类与对象、封装、枚举、异常处理、集合、泛型、排序、字符串解析和时间处理。

## 三、文章数据格式

每篇文章使用一行字符串表示，格式如下：

```text
id|authorId|title|content|status|createdAt|views
```

示例：

```text
1|1001|Java基础总结|今天复习了集合和异常|PUBLISHED|2025-01-01 10:00:00|120
2|1002|Spring入门|第一次学习Spring Boot|DRAFT|2025-01-02 09:30:00|35
3|1001|集合源码阅读|ArrayList和HashMap的区别|PUBLISHED|2025-01-03 20:10:00|260
```

字段说明：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| id | long | 文章 ID |
| authorId | long | 作者 ID |
| title | String | 文章标题 |
| content | String | 文章正文 |
| status | enum | 文章状态 |
| createdAt | LocalDateTime | 发布时间 |
| views | int | 浏览量 |

文章状态只能是以下三种：

```text
DRAFT
PUBLISHED
DELETED
```

时间格式固定为：

```text
yyyy-MM-dd HH:mm:ss
```

## 四、实现要求

### 1. 定义文章状态枚举

请定义枚举 `ArticleStatus`，包含以下状态：

```java
public enum ArticleStatus {
    DRAFT,
    PUBLISHED,
    DELETED
}
```

### 2. 定义文章类

请定义文章类 `Article`。

建议字段如下：

```java
private Long id;
private Long authorId;
private String title;
private String content;
private ArticleStatus status;
private LocalDateTime createdAt;
private Integer views;
```

要求：

- 字段必须私有化。
- 提供构造方法。
- 提供必要的 getter 方法。
- 重写 `toString()` 方法。
- 不允许在外部直接修改文章字段。

### 3. 定义自定义异常

请定义自定义异常类：

```java
InvalidArticleException
```

当文章数据格式不正确时，需要抛出该异常。

以下情况都属于格式错误：

- 字段数量不是 7 个。
- `id`、`authorId`、`views` 不能转换成数字。
- `status` 不是合法的文章状态。
- `createdAt` 时间格式不正确。
- 标题为空。
- 正文为空。
- `views` 小于 0。

### 4. 实现文章解析方法

请实现方法：

```java
public static Article parseArticle(String line) throws InvalidArticleException
```

要求：

- 将一行字符串解析成 `Article` 对象。
- 解析失败时抛出 `InvalidArticleException`。
- 异常信息需要清楚说明错误原因。

### 5. 实现批量解析方法

请实现方法：

```java
public static List<Article> parseArticles(List<String> lines)
```

要求：

- 遍历所有原始字符串。
- 合法数据转换成 `Article` 对象，并加入结果列表。
- 非法数据不要加入结果列表。
- 非法数据需要打印错误原因。

错误信息格式示例：

```text
第5行数据错误：正文不能为空
```

### 6. 实现文章筛选方法

请实现方法：

```java
public static List<Article> filterArticles(
        List<Article> articles,
        Long authorId,
        ArticleStatus status,
        String keyword,
        Integer minViews
)
```

筛选规则：

- `authorId` 不为 `null` 时，只保留该作者的文章。
- `status` 不为 `null` 时，只保留该状态的文章。
- `keyword` 不为 `null` 且不为空字符串时，标题或正文包含该关键字即可。
- `minViews` 不为 `null` 时，只保留浏览量大于等于 `minViews` 的文章。
- 多个条件同时存在时，文章必须满足全部条件。

### 7. 实现文章排序方法

请实现方法：

```java
public static List<Article> sortArticles(List<Article> articles)
```

排序规则：

1. 浏览量高的排在前面。
2. 浏览量相同，发布时间晚的排在前面。
3. 浏览量和发布时间都相同，文章 ID 小的排在前面。

要求：

- 不能修改传入的原列表。
- 必须返回一个新的列表。
- 可以使用 `Comparator` 实现排序。

### 8. 实现发布文章统计方法

请实现方法：

```java
public static Map<Long, Integer> countPublishedByAuthor(List<Article> articles)
```

要求：

- 只统计 `PUBLISHED` 状态的文章。
- 返回每个作者已发布文章的数量。
- `Map` 的 key 是 `authorId`。
- `Map` 的 value 是该作者已发布文章数量。

示例：

```text
{1001=2, 1002=1}
```

## 五、测试数据

请在 `main` 方法中使用以下数据进行测试：

```java
List<String> lines = Arrays.asList(
    "1|1001|Java基础总结|今天复习了集合和异常|PUBLISHED|2025-01-01 10:00:00|120",
    "2|1002|Spring入门|第一次学习Spring Boot|DRAFT|2025-01-02 09:30:00|35",
    "3|1001|集合源码阅读|ArrayList和HashMap的区别|PUBLISHED|2025-01-03 20:10:00|260",
    "4|1003|数据库笔记|MySQL索引和事务|PUBLISHED|2025-01-04 08:00:00|180",
    "5|1002|无效文章||PUBLISHED|2025-01-05 12:00:00|99",
    "6|1001|异常处理|try catch finally执行顺序|PUBLISHED|wrong-time|80",
    "7|1004|旧文章|这篇文章已经删除|DELETED|2025-01-06 11:00:00|300",
    "8|1001|HashMap总结|HashMap扩容机制|PUBLISHED|2025-01-07 13:20:00|260"
);
```

## 六、最终执行要求

请在 `main` 方法中完成以下操作：

1. 解析所有文章数据。
2. 打印成功解析的文章数量。
3. 筛选出满足以下条件的文章：
   - 作者 ID 为 `1001`
   - 状态为 `PUBLISHED`
   - 标题或正文包含 `"HashMap"` 或 `"集合"`
   - 浏览量不少于 `100`
4. 对筛选结果进行排序。
5. 打印排序后的文章列表。
6. 打印每个作者已发布文章数量。

输出格式可以自行设计，但必须能清楚看出以下内容：

- 哪些数据解析失败。
- 成功解析了多少篇文章。
- 筛选并排序后的文章结果。
- 每个作者已发布文章数量。

## 七、限制要求

- 不允许使用数据库。
- 不允许使用 Spring、MyBatis 等框架。
- 只能使用 Java 标准库。
- 可以使用 Stream，也可以不使用。
- 必须使用 `enum`。
- 必须使用自定义异常。
- 必须使用 `List`。
- 必须使用 `Map`。
- 必须使用 `Comparator` 或等价的排序方式。
- 代码需要有基本的类划分，不能全部堆在 `main` 方法中。

## 八、考察点

本题主要考察以下 Java 基础能力：

- 类与对象
- 封装
- 构造方法
- 枚举
- 自定义异常
- 异常捕获与处理
- 字符串分割与解析
- `LocalDateTime` 和 `DateTimeFormatter`
- `List`、`Map` 等集合使用
- 泛型
- `Comparator` 排序
- 条件筛选
- 方法拆分
- 基础代码组织能力

## 九、评分标准

总分 100 分。

| 评分项 | 分值 |
| --- | --- |
| `Article` 类设计合理，字段封装正确 | 10 |
| 正确使用 `enum` 表示文章状态 | 10 |
| 能正确解析合法数据 | 15 |
| 能识别并处理非法数据 | 15 |
| 自定义异常使用合理 | 10 |
| 筛选逻辑正确 | 15 |
| 排序逻辑正确 | 10 |
| 统计逻辑正确 | 10 |
| 代码结构清晰、命名规范 | 5 |

## 十、加分项

以下内容不强制要求，完成较好可以酌情加分：

- 使用泛型接口抽象筛选规则。
- 使用 Stream API 实现筛选、排序或统计。
- 错误信息清晰，便于定位问题。
- 对空集合、空字符串、`null` 参数处理合理。
- 输出格式清晰美观。

## 十一、提交要求

提交一个 Java 项目或一个 `.java` 文件均可。

提交内容至少包括：

- `ArticleStatus`
- `Article`
- `InvalidArticleException`
- 包含 `main` 方法的测试类

程序需要能够直接运行，并在控制台输出测试结果。
