# Week 1 - Java Basics

## Creating Your First Java App

**Core Concepts:**
- `IDE` (IntelliJ) + `JDK` cooperation
- **Platform independence** — Write Once, Run Anywhere (WORA)
- Statements end with semicolons
- Whitespace doesn't matter
- Comments: `//`, `/* */`, `/** */`
- **Packages** — reverse domain naming (e.g., `com.quenedy.basics`)

## Variables, Data Types & Math Operators

**Primitive Types:**
```java
byte, short, int, long          // integers
float, double                    // decimals
char                             // single character
boolean                          // true/false
```

**Key Rules:**
- Java is **strongly typed**
- `final` — constant (cannot change)
- **Type conversion** — widening (automatic) vs narrowing (explicit cast)

**Math Operators:**
```java
+  -  *  /  %                   // basic
++  --                           // increment/decrement
+=  -=  *=  /=  %=              // compound assignment
```

**Operator Precedence:**
Postfix → Prefix → Multiply/Divide → Add/Subtract

## Conditional Logic & Block Statements

**Ternary:**
```java
condition ? valueIfTrue : valueIfFalse
```

**If-Else:**
```java
if (condition) { }
else if (condition) { }
else { }
```

**Relational Operators:**
```java
>  <  >=  <=  ==  !=
```

**Logical Operators:**
```java
&&  ||  // short circuit (smart evaluation)
&   |   // always check both sides
```

**Switch:**
```java
switch (value) {
    case 1: ...; break;
    default: ...;
}
```

**Variable Scope:**
- Variables live only inside their block `{}`

## Looping and Arrays

**While Loop:**
```java
while (condition) { }  // check first, then execute
```

**Do-While Loop:**
```java
do { } while (condition);  // execute first, then check
```

**For Loop:**
```java
for (init; condition; update) { }
```

**Arrays:**
```java
int[] numbers = {1, 2, 3};
numbers[0]              // first element (zero-based indexing)
numbers.length          // array size
```

**For-Each Loop:**
```java
for (int num : numbers) { }
```

**Nested Loops:**
```java
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) { }
}
```

## Understanding Methods

**Method Structure:**
```java
static returnType methodName(params) {
    return value;
}
```

**Key Concepts:**
- Parameters passed **by value** (copy sent)
- Variable scope = method only
- Parameters are **positional** (order matters)
- `void` — no return value
- Command line args — `String[] args` (one-based indexing)

## Working with Strings

**Key Facts:**
- `String` is a **reference type** (not primitive)
- Strings are **immutable** (cannot change)
- Always use `.equals()` to compare (not `==`)

**Common Methods:**
- `length()` — get string length
- `toUpperCase()` / `toLowerCase()` — change case
- `contains()` — check if substring exists
- `replace()` — replace characters
- `substring()` — extract portion
- `charAt()` — get character at index
- `split()` — split into array
- `trim()` — remove whitespace

**StringBuilder:**
```java
StringBuilder sb = new StringBuilder();
sb.append("text");
String result = sb.toString();
```

## String Formatting

**Format Specifiers:**
- `%s` — String
- `%d` — integer
- `%f` — float/double
- `%c` — char
- `%b` — boolean
- `%n` — newline

**Precision & Width:**
```java
%.2f          // 2 decimal places
%10s          // 10 chars wide (right aligned)
%-10s         // left aligned
%05d          // leading zeros
%,d           // comma separator
%+d           // show + sign
%1$s %2$s     // reuse arguments (one-based indexing)
```

## More About Data Types

**Date/Time Types:**
- `Instant` — UTC timestamp
- `LocalDate` — date only
- `LocalTime` — time only
- `LocalDateTime` — date + time (no timezone)
- `ZonedDateTime` — date + time + timezone

**DateTimeFormatter:**
```java
DateTimeFormatter.ofPattern("MMM dd, yyyy")
```

**Primitive Wrappers:**
- `int` → `Integer`
- `double` → `Double`
- `boolean` → `Boolean`
- `char` → `Character`

**Why Use Wrappers:**
- Can be `null`
- Utility methods (`.parseInt()`, `.MAX_VALUE`)
- Required for Collections