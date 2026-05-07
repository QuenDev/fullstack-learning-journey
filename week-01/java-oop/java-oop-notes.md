📚 FULL OOP MODULE SUMMARY

🔤 Key Vocabulary First

| Term | Simple Meaning |
|---|---|
| Class | Blueprint/template for creating objects |
| Object | An instance created from a class |
| Instance | A specific object created from a class |
| Field | Variable that belongs to a class |
| Method | Function that belongs to a class |
| Constructor | Special method that creates an object |
| Inheritance | Child class reuses parent class code |
| Polymorphism | Same method, different behavior per object |
| Encapsulation | Hide data, control access through methods |
| Abstraction | Hide complexity, show only what's needed |
| Interface | Contract that forces classes to implement methods |
| Abstract Class | Blueprint that cannot be instantiated directly |
| Override | Child replaces parent's method |
| super | Access parent class constructor or method |
| this | Refers to current object's own fields |
| private | Only accessible within same class |
| public | Accessible from anywhere |
| protected | Accessible within class and subclasses |
| final | Cannot be changed/extended/overridden |
| static | Belongs to class not to individual objects |
| HAS-A | Aggregation - one class contains another |
| IS-A | Inheritance - one class extends another |
| CAN-DO | Interface - class implements a contract |

1️⃣ What Is Object Orientation?
The Design Process:
Requirements → Use Cases → Conceptual Classes 
→ Relationships → Software Classes → Test
Two Types of Relationships:

```java
// HAS-A (Aggregation) - contains another object
class Enrollment {
    Student student;  // Enrollment HAS-A Student
    Course course;    // Enrollment HAS-A Course
}

// IS-A (Inheritance) - special version of
class Student extends Person { } // Student IS-A Person
class Teacher extends Person { } // Teacher IS-A Person
```

Static vs Non-Static:

```java
// Static - belongs to CLASS, no object needed
static int add(int a, int b) { return a + b; }
MathHelper.add(5, 10); // call directly on class

// Non-static - belongs to OBJECT
void displayInfo() { }
student.displayInfo(); // need object first
```

## 2️⃣ Encapsulation & Abstraction

**Encapsulation:**

```java
class BankAccount {
    private double balance; // hidden!
    
    // Controlled access
    public void deposit(double amount) {
        if (amount > 0) balance += amount; // validated!
    }
    
    public double getBalance() { return balance; }
}
```

**Key Rules:**
- private fields    → hide data ✅
- public methods    → controlled access ✅
- validation        → protect data integrity ✅
- getters/setters   → doorways to private data ✅

**Defensive Copying:**

```java
// Return copy not original!
public int[] getScores() {
    return scores.clone(); // safe! ✅
}
```

**Immutability:**

```java
final class Student {
    private final String name; // set once, never changes
}
```

**Abstraction:**

Hide HOW something works  
Show WHAT it does

Like a TV remote:
Press volume up → don't care how it works
Just know it increases volume ✅

**Single Responsibility Principle (S):**
- Each class = ONE job
- Each method = ONE responsibility

- BankAccount → manages account data only
- EmailService → sends emails only
- Database → saves data only

## 3️⃣ Inheritance & Polymorphism

**Inheritance:**

```java
class Person {           // Parent
    String name;
    void introduce() { }
}

class Student extends Person { // Child
    int studentId;       // adds own fields
    // inherits name and introduce()
}
```

**Method Overriding:**

```java
@Override
void introduce() {
    super.introduce();   // call parent first (optional)
    System.out.println("Student ID: " + studentId); // add more
}
```

**Polymorphism:**

```java
// Same reference, different behavior
Employee[] employees = {
    new FullTimeEmployee(...),
    new PartTimeEmployee(...),
    new Freelancer(...)
};

for (Employee emp : employees) {
    emp.calculateSalary(); // each behaves differently! ✅
}
```

**Abstract Classes:**

```java
abstract class Shape {
    abstract double calculateArea(); // MUST implement!
    void display() { } // shared implementation
}

// Cannot do:
new Shape(); // ❌ abstract = concept only!

// Must do:
new Circle(); // ✅ concrete class
```

**Liskov Substitution (L):**
- Child must work wherever parent works
- If it breaks parent behavior = LSP violation!

**Open-Closed Principle (O):**
- Open for EXTENSION ✅
- Closed for MODIFICATION ✅

- Add new behavior by extending
- Never touch existing working code

## 4️⃣ Interfaces, Composition & Design

**Interface:**

```java
interface Payable {
    double calculateSalary(); // contract!
}

// CAN-DO relationship
class Developer implements Payable {
    public double calculateSalary() {
        return salary; // must implement! ✅
    }
}

// Multiple interfaces allowed!
class Developer implements Payable, Reportable, Trackable { }
```

**Interface vs Abstract Class:**
- Abstract Class → IS-A → extend ONE only
- Interface      → CAN-DO → implement MANY

**Decorator Pattern:**

Add features DYNAMICALLY without changing class

Coffee → add Milk → add Sugar → add Whip
- Each decorator WRAPS the previous one

**Strategy Pattern:**

Swap algorithms at RUNTIME

- GradeCalculator uses StandardGrade
- GradeCalculator switches to CurvedGrade
- Same calculator, different strategy!

**Interface Segregation (I):**

Don't force classes to implement unused methods!

- ❌ One fat interface with 10 methods
- ✅ Many small focused interfaces

**Dependency Inversion (D):**

Depend on ABSTRACTIONS not concrete classes

- ❌ class PayrollSystem { FullTimeEmployee emp; }
- ✅ class PayrollSystem { Payable emp; }

**Cohesion & Coupling:**

- High Cohesion  = class focused on ONE thing ✅
- Low Coupling   = classes independent of each other ✅

**DRY - Don't Repeat Yourself:**

- Never write same code twice
- Put shared code in parent class or utility

## 📋 SOLID Principles — Complete

| Letter | Principle | Meaning |
|---|---|---|
| S | Single Responsibility | One class, one job |
| O | Open-Closed | Extend don't modify |
| L | Liskov Substitution | Child works where parent works |
| I | Interface Segregation | No unused methods forced |
| D | Dependency Inversion | Depend on abstractions |

## 📋 Design Patterns

| Pattern | Meaning | Real Example |
|---|---|---|
| Decorator | Add features dynamically | Coffee + Milk + Sugar |
| Strategy | Swap algorithms at runtime | Standard vs Curved grading |