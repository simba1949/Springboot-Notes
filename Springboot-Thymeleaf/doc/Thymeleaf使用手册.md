# Thymeleaf使用手册

## Thymeleaf基础模板

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>

  </body>
</html>
```

## 标准表达式

- 简单表达：
  - 变量表达式： `${...}`
  - 选择变量表达式： `*{...}`
  - 消息表达式： `#{...}`
  - 链接网址表达式： `@{...}`
  - 片段表达式： `~{...}`
- 字面
  - 文本文字：`'one text'`，`'Another one!'`，...
  - 号码文字：`0`，`34`，`3.0`，`12.3`，...
  - 布尔文字：`true`，`false`
  - 空字面： `null`
  - 文字标记：`one`，`sometext`，`main`，...
- 文字操作：
  - 字符串连接： `+`
  - 文字替换： `|The name is ${name}|`
- 算术运算：
  - 二元运算符：`+`，`-`，`*`，`/`，`%`
  - 减号（一元运算符）： `-`
- 布尔运算：
  - 二元运算符：`and`，`or`
  - 布尔否定（一元运算符）： `!`，`not`
- 比较和平等：
  - 比较：`>`，`<`，`>=`，`<=`（`gt`，`lt`，`ge`，`le`）
  - 平等运营商：`==`，`!=`（`eq`，`ne`）
- 有条件的运营商：
  - IF-THEN： `(if) ? (then)`
  - IF-THEN-ELSE： `(if) ? (then) : (else)`
  - 默认： `(value) ?: (defaultvalue)`
- 特殊代币：
  - 无操作： `_`