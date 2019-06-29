---
typora-root-url: images
---

# Neo4j #

> author : yanglulu
>
> date : 2019-06-29

## 1. 简介

### 与RDBMS对比

简单地说，我们可以说图数据库主要用于存储更多的连接数据。

如果我们使用RDBMS数据库来存储更多连接的数据，那么它们不能提供用于遍历大量数据的适当性能。 在这些情况下，Graph Database提高了应用程序性能。<!-- RDB与GDB的对比实验 -->

### Neo4j的特点

- SQL就像简单的查询语言Neo4j CQL
- 它遵循属性图数据模型
- 它通过使用Apache Lucence支持索引
- 它支持UNIQUE约束
- 它它包含一个用于执行CQL命令的UI：Neo4j数据浏览器
- 它支持完整的ACID（原子性，一致性，隔离性和持久性）规则
- 它采用原生图形库与本地GPE（图形处理引擎）
- 它支持查询的数据导出到JSON和XLS格式
- 它提供了REST API，可以被任何编程语言（如Java，Spring，Scala等）访问
- 它提供了可以通过任何UI MVC框架（如Node JS）访问的Java脚本
- 它支持两种Java API：Cypher API和Native Java API来开发Java应用程序

### Neo4j的优点

- 它很容易表示连接的数据
- 检索/遍历/导航更多的连接数据是非常容易和快速的
- 它非常容易地表示半结构化数据
- Neo4j CQL查询语言命令是人性化的可读格式，非常容易学习
- 它使用简单而强大的数据模型
- 它不需要复杂的连接来检索连接的/相关的数据，因为它很容易检索它的相邻节点或关系细节没有连接或索引

### Neo4j数据模型

属性图模型规则

- 表示节点，关系和属性中的数据
- 节点和关系都包含属性
- 关系连接节点
- 属性是键值对
- 节点用圆圈表示，关系用方向键表示。
- 关系具有方向：单向和双向。
- 每个关系包含“开始节点”或“从节点”和“到节点”或“结束节点”

图形数据库数据模型的主要构建块是：

- 节点
- 关系
- 属性

### Neo4j Windows安装

> https://www.w3cschool.cn/neo4j/neo4j_zip_environment_setup.html

### Neo4j构建模块

> https://www.w3cschool.cn/neo4j/neo4j_building_blocks.html

------

### Neo4j学习资料

学习教程：https://www.w3cschool.cn/neo4j/

*官网：https://neo4j.com/*

*neo4j中文社区：http://neo4j.com.cn/*

*书籍推荐：《Neo4j权威指南》*

## 2. Cypher语句

### CQL简介

CQL代表Cypher查询语言。 像Oracle数据库具有查询语言SQL，Neo4j具有CQL作为查询语言。

**Neo4j CQL -**

- 它是Neo4j图形数据库的查询语言。
- 它是一种声明性模式匹配语言
- 它遵循SQL语法。
- 它的语法是非常简单且人性化、可读的格式。

**如Oracle SQL -**

- Neo4j CQL 已命令来执行数据库操作。
- Neo4j CQL 支持多个子句像在哪里，顺序等，以非常简单的方式编写非常复杂的查询。
- NNeo4j CQL 支持一些功能，如字符串，Aggregation.In 加入他们，它还支持一些关系功能。

#### Neo4j CQL常用命令

常用的Neo4j CQL命令如下：

| S.No. | CQL命令/条      | 用法                         |
| ----- | --------------- | ---------------------------- |
| 1。   | CREATE 创建     | 创建节点，关系和属性         |
| 2。   | MATCH 匹配      | 检索有关节点，关系和属性数据 |
| 3。   | RETURN 返回     | 返回查询结果                 |
| 4。   | WHERE 哪里      | 提供条件过滤检索数据         |
| 5。   | DELETE 删除     | 删除节点和关系               |
| 6。   | REMOVE 移除     | 删除节点和关系的属性         |
| 7。   | ORDER BY以…排序 | 排序检索数据                 |
| 8。   | SET 组          | 添加或更新标签               |

#### Neo4j CQL 函数

以下是常用的Neo4j CQL函数：

| S.No. | 定制列表功能      | 用法                                             |
| ----- | ----------------- | ------------------------------------------------ |
| 1。   | String 字符串     | 它们用于使用String字面量。                       |
| 2。   | Aggregation 聚合  | 它们用于对CQL查询结果执行一些聚合操作。          |
| 3。   | Relationship 关系 | 他们用于获取关系的细节，如startnode，endnode等。 |

我们将在后面的章节中详细讨论所有Neo4j CQL命令，子句和函数语法，用法和示例。

#### Neo4j CQL数据类型

这些数据类型与Java语言类似。 它们用于定义节点或关系的属性

Neo4j CQL支持以下数据类型：

| S.No. | CQL数据类型 | 用法                            |
| ----- | ----------- | ------------------------------- |
| 1.    | boolean     | 用于表示布尔文字：true，false。 |
| 2.    | byte        | 用于表示8位整数。               |
| 3.    | short       | 用于表示16位整数。              |
| 4.    | int         | 用于表示32位整数。              |
| 5.    | long        | 用于表示64位整数。              |
| 6.    | float       | I用于表示32位浮点数。           |
| 7.    | double      | 用于表示64位浮点数。            |
| 8.    | char        | 用于表示16位字符。              |
| 9.    | String      | 用于表示字符串。                |

## 3. JDBC

### Cypher API

### Native Java API (REST API)

## 4. 高级

### 分布式



