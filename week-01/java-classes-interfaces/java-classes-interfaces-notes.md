🔤 Key Vocabulary First

| Term | Simple Meaning |
|------|---|
| Class | Blueprint/template for creating objects |
| Object | Instance created from a class |
| Instance | A specific object in memory |
| Reference type | Variable holds address not actual value |
| Field | Variable that belongs to a class |
| Method | Function that belongs to a class |
| Constructor | Special method that runs on object creation |
| this | Refers to current object instance |
| null | Variable pointing to no object |
| Getter | Method that retrieves field value |
| Setter | Method that modifies field value |
| Access modifier | Controls visibility of class members |
| static | Belongs to class not individual objects |
| final class | Cannot be extended |
| final method | Cannot be overridden |
| abstract class | Cannot be instantiated directly |
| abstract method | No body, child must implement |
| interface | Contract defining required methods |
| enum | Type with fixed set of valid values |
| nested class | Class declared inside another class |
| anonymous class | Nameless class declared inline |
| super | Access parent constructor or methods |
| instanceof | Check if object is instance of class |
| @Override | Marks method as overriding parent |
| default method | Interface method with body |
| varargs | Variable length parameter list (...) |
| overloading | Same method name, different signature |

1️⃣ Understanding Classes & Objects
Core Concept:
Class  = blueprint (Student class)
Object = instance  (ken = new Student())
Three Class Members:
```java
class Student {
    String name;        // FIELD - stores state
    void study() { }   // METHOD - executable code
    Student() { }      // CONSTRUCTOR - runs on creation
}
```
Reference Types:
```java
Student ken = new Student();
Student ref = ken; // both point to SAME object!
ref.name = "Modified"; // ken.name also changes!
```
Null Reference:
```java
Student nobody = null; // points to nothing
if (nobody != null) {  // always check before using!
    nobody.introduce(); // prevents NullPointerException
}
```
Access Modifiers:
private   → only THIS class
public    → EVERYONE
protected → this class + subclasses
(default) → same package only
Getters & Setters:
```java
public String getName() { return name; }     // getter
public void setName(String name) {           // setter
    if (name != null) this.name = name;      // with validation!
}
public boolean isActive() { return active; } // boolean = "is"
```

2️⃣ Constructors & Initializers
Default Field Values:
int     → 0
double  → 0.0
String  → null
boolean → false
Field Initializers:
```java
class Student {
    int age = 18;                              // simple
    double fee = 1000.0 * 1.12;               // equation
    String date = LocalDate.now().toString();  // method call
}
```
Multiple Constructors:
```java
class Student {
    Student() { }                          // default
    Student(String name) { }              // one param
    Student(String name, int age) { }    // two params
    // Java picks based on arguments!
}
```
Constructor Chaining:
```java
// this() calls another constructor
Student() {
    this("Unknown", 0); // calls two-param constructor
}
// Must be FIRST line!
```
Initialization Block:
```java
{
    // Runs on EVERY object creation
    // Regardless of which constructor used
    createdAt = LocalDate.now().toString();
}
```
Execution Order:
1. Default field values
2. Field initializers
3. Initialization block
4. Constructor

3️⃣ Static Members
Static Field:
```java
static int totalStudents = 0; // shared by ALL instances
```
Static Method:
```java
static int add(int a, int b) { return a + b; }
MathUtils.add(5, 10); // no object needed!

// Static methods can ONLY access static members!
```
Static Import:
```java
import static java.lang.Math.*;
sqrt(16); // no Math. prefix needed! ✅
```
Static Init Block:
```java
static {
    // Runs ONCE before first class use
    host = "localhost";
    port = 3306;
}
```
Static vs Instance:
Static   = shared whiteboard 📋 (everyone sees same)
Instance = personal notebook 📓 (each object owns)

4️⃣ Methods Deep Dive
Pass Objects by Reference:
```java
void addBonus(Student s, int bonus) {
    s.score += bonus;      // modifies ORIGINAL ✅
    s = new Student();     // only changes LOCAL ref ❌
}
```
Method Overloading:
```java
// Same name, different signature!
int add(int a, int b) { }
int add(int a, int b, int c) { }
double add(double a, double b) { }
```
Method Signature:
name + number of params + param types
return type is NOT part of signature!
Varargs:
```java
static int sum(int... numbers) {
    // received as array!
    for (int n : numbers) total += n;
}
sum();           // 0 args ✅
sum(1, 2, 3);    // 3 args ✅
sum(1,2,3,4,5);  // 5 args ✅
// Only LAST param can be varargs!
```

5️⃣ Class Inheritance
IS-A Relationship:
```java
class Animal { }
class Dog extends Animal { } // Dog IS-AN Animal
```
Base Class Reference:
```java
Animal a = new Dog(); // ✅ Dog IS-AN Animal
a.makeSound();        // calls Dog's version!
a.fetch();            // ❌ Animal doesn't know fetch()
```
@Override:
```java
@Override
void makeSound() {
    super.makeSound(); // call parent first (optional)
    System.out.println("Woof!"); // add own behavior
}
```
Object Class:
Root of ALL Java classes!
Every class extends Object automatically

Common overrides:
toString()  → string representation
equals()    → compare contents
hashCode()  → hash value
equals() Override:
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;         // same reference
    if (obj == null) return false;        // null check
    if (!(obj instanceof Student)) return false; // type check
    Student other = (Student) obj;
    return this.id == other.id;           // content check
}
```
toString() Override:
```java
@Override
public String toString() {
    return "Student{name='" + name + "', id=" + id + "}";
}
// Without: Student@1b6d3586
// With:    Student{name='Ken', id=1001}
```

6️⃣ More Inheritance
super Reference:
```java
super()              // calls parent CONSTRUCTOR
super.displayInfo()  // calls parent METHOD
```
final keyword:
```java
final class String { }      // cannot extend
final void deductFee() { }  // cannot override
```
Abstract:
```java
abstract class Shape {
    abstract double calculateArea(); // no body, must implement!
    void display() { }               // concrete, shared
}
// new Shape() ❌ cannot instantiate!
// new Circle() ✅ concrete class
```
Constructor Chain:
```
new Dog("Rex", "Labrador")
    → Dog constructor
    → super("Rex") called
    → Animal constructor runs FIRST
    → Dog constructor continues
```

7️⃣ Enums
Basic Enum:
```java
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY }
Day today = Day.MONDAY; // type safe! ✅
```
Enum Methods:
```java
Day.MONDAY.name()     // "MONDAY"
Day.MONDAY.ordinal()  // 0 (zero-based position)
Day.values()          // all values as array
Day.valueOf("FRIDAY") // String → enum
```
Enum with Fields:
```java
enum Level {
    JUNIOR("Junior Dev", 25000.0),
    SENIOR("Senior Dev", 75000.0);

    private final String title;
    private final double salary;

    Level(String title, double salary) {
        this.title = title;
        this.salary = salary;
    }
}
```
Enum Ordering:
```java
myLevel.compareTo(targetLevel)
// negative = myLevel < targetLevel
// zero     = same level
// positive = myLevel > targetLevel
```

8️⃣ Interfaces
Interface = Contract:
```java
interface Payable {
    double calculateSalary(); // WHAT not HOW
}

class Developer implements Payable {
    public double calculateSalary() {
        return salary; // HOW
    }
}
```
Multiple Interfaces:
```java
class Developer implements Payable, Trackable, Reportable { }
// No limit on how many! ✅
```
Default Method:
```java
interface Printable {
    void print();
    
    default void printFormatted() { // has body!
        System.out.println("===");
        print();
        System.out.println("===");
    }
}
// Exists so adding new methods doesn't break old classes!
```
Interface Fields:
```java
interface Constants {
    double PI = 3.14; // automatically public static final!
}
```
Interface vs Abstract:
Interface      = CAN-DO, implement MANY, no constructor
Abstract Class = IS-A, extend ONE, can have constructor

9️⃣ Nested Types & Anonymous Classes
Static Nested Class:
```java
class Passenger {
    static class RewardProgram { } // just for naming scope
}
// Access: Passenger.RewardProgram reward = new Passenger.RewardProgram()
```
Inner Class:
```java
class BankAccount {
    class Transaction {
        void process() {
            balance += amount; // accesses outer private field! ✅
        }
    }
}
// Access: account.new Transaction()
```
Anonymous Class:
```java
// Declare AND create at same time!
Greeting formal = new Greeting() {
    @Override
    public void greet(String name) {
        System.out.println("Good day, " + name);
    }
};
// Used once, no name needed!
```

📋 SOLID Principles Quick Reference
S = Single Responsibility → one class, one job
O = Open-Closed          → extend don't modify
L = Liskov Substitution  → child works where parent works
I = Interface Segregation → small focused interfaces
D = Dependency Inversion  → depend on abstractions

🔑 Key Rules To Remember
1. Always null check before using reference types
2. Use private fields with public getters/setters
3. Always @Override when overriding methods
4. Use equals() not == for object comparison
5. Abstract class = concept, concrete class = implementation
6. Interface = CAN-DO, Abstract = IS-A
7. Constructors not inherited - define your own!
8. Static methods can only access static members
9. final = cannot change (class/method/field)
10. enum = type safe fixed values