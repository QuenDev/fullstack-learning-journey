# Java Development Environment Setup

## Tools Installed
- **Oracle JDK** — 17.0.12
- **IntelliJ IDEA** — Community Edition

## Key Concepts

**The Acronyms:**
- **JDK** = Java Development Kit (JRE + JVM + Dev Tools) — everything you need to develop
- **JRE** = Java Runtime Environment — just runs Java (for end users)
- **JVM** = Java Virtual Machine — the engine that executes bytecode
- **JAR** = Java Archive — packaged, shareable Java application

**The Tools:**
- **javac** = compiler (turns .java into .class bytecode)
- **java** = runner (executes bytecode on the JVM)
- **Maven/Gradle** = build tools (manage dependencies and automate builds)

## The Flow

```
Write .java → javac compile → .class bytecode → java/JVM run → Output
```

## Key Commands

```bash
java -version      # Check Java runtime version
javac -version     # Check compiler version
```

## Edition Types

- **Java SE** = Standard Edition (what we use for most development)
- **Jakarta EE** = Enterprise Edition (built on top of SE, for large-scale apps)

## ⚠️ Important

IntelliJ must be configured to use JDK 17, not the bundled JDK that comes with IntelliJ.

## One-Liner Summary

> JDK lets you write, compile and run Java. IntelliJ makes you productive. JAR files let you share your app anywhere Java is installed.