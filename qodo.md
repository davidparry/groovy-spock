# Repository Tour

## 🎯 What This Repository Does

**Getting Groovy with Spock** is an educational project designed to teach the Spock testing framework for Java and Groovy applications. It provides sample Java classes with various patterns (interfaces, services, validation, exception handling) that serve as practice targets for learning Spock's expressive testing capabilities.

**Key responsibilities:**
- Demonstrate interface-based design patterns for testing
- Provide sample business logic for Spock test implementation
- Showcase dependency injection and mocking scenarios
- Illustrate custom exception handling patterns

---

## 🏗️ Architecture Overview

### System Context
```
[Student/Developer] → [Sample Java Classes] → [Spock Test Framework]
                           ↓
                    [Learning Exercises]
```

### Key Components
- **OddEvenCamp Interface** - Contract for odd/even number validation with exception handling
- **ProviderOfCrazyWords Service** - Demonstrates dependency injection and random string generation
- **Validation Framework** - Generic validator interface with custom exception hierarchy
- **Utility Classes** - Supporting logic for business operations

### Data Flow
1. **Interface Definition** - Contracts define expected behavior for implementations
2. **Service Layer** - Business logic classes demonstrate real-world patterns
3. **Validation Layer** - Input validation with custom exception handling
4. **Test Implementation** - Students write Spock tests to verify behavior

---

## 📁 Project Structure [Partial Directory Tree]

```
groovy-spock/
├── src/
│   ├── main/java/                    # Main application code (Java)
│   │   └── com/davidparry/spock/     # Core package structure
│   │       ├── util/                 # Utility classes
│   │       └── validation/           # Validation framework
│   └── test/groovy/                  # Spock test files
│       └── com/davidparry/spock/     # Test package structure
├── build/                            # Gradle build artifacts
├── gradle/                           # Gradle wrapper files
├── build.gradle                      # Build configuration and dependencies
├── gradle.properties                 # Project metadata
├── settings.gradle                   # Gradle settings
├── LICENSE                           # Apache License 2.0
└── README.md                         # Project documentation and learning objectives
```

### Key Files to Know

| File | Purpose | When You'd Touch It |
|------|---------|---------------------|
| `src/main/java/com/davidparry/spock/OddEvenCamp.java` | Interface for odd/even validation | Understanding contract-based testing |
| `src/main/java/com/davidparry/spock/OddEvenCampImpl.java` | Implementation of OddEvenCamp interface | Learning implementation testing patterns |
| `src/main/java/com/davidparry/spock/ProviderOfCrazyWords.java` | Service demonstrating dependency injection | Learning mocking and interaction testing |
| `src/main/java/com/davidparry/spock/util/RandomLogic.java` | Utility for random string generation | Testing utility methods and randomness |
| `src/main/java/com/davidparry/spock/validation/Validator.java` | Generic validation interface | Understanding generic type testing |
| `src/main/java/com/davidparry/spock/validation/IntegerValidator.java` | Concrete validator implementation | Testing validation logic |
| `src/main/java/com/davidparry/spock/NegativeNumberException.java` | Custom exception for validation | Testing exception scenarios |
| `src/test/groovy/com/davidparry/spock/OddEvenCampSpec.groovy` | Comprehensive Spock specification example | Learning Spock syntax and patterns |
| `build.gradle` | Build configuration | Adding dependencies or changing build settings |

---

## 🔧 Technology Stack

### Core Technologies
- **Language:** Java 21 - Modern Java features with strong typing for clear contracts
- **Testing Language:** Groovy 4.0.27 - Expressive syntax for readable test specifications
- **Testing Framework:** Spock Framework 2.3 - BDD-style testing with powerful mocking capabilities
- **Build Tool:** Gradle 8.12.1 - Modern build automation with dependency management

### Key Libraries
- **Spock Core** - Main testing framework providing specifications, mocks, and assertions
- **Groovy** - Dynamic language runtime for expressive test syntax
- **Byte Buddy 1.15.10** - Runtime code generation for advanced mocking scenarios
- **JaCoCo** - Code coverage analysis for test effectiveness measurement

### Development Tools
- **Gradle Wrapper** - Ensures consistent build environment across machines
- **JaCoCo Plugin** - Generates code coverage reports for test quality assessment
- **IntelliJ IDEA Support** - IDE integration for seamless development experience

---

## 🔄 Common Workflows

### Learning Workflow: Implementing Spock Tests
1. **Study the Java classes** - Understand the contracts and business logic
2. **Create Spock specifications** - Write test classes in `src/test/groovy/`
3. **Implement test methods** - Use Spock's given-when-then syntax
4. **Run tests** - Execute via `./gradlew test` to verify implementations
5. **Check coverage** - Use `./gradlew jacocoTestReport` to assess test completeness

**Code path:** `Java Classes` → `Spock Specifications` → `Test Execution` → `Coverage Analysis`

### Development Workflow: Adding New Examples
1. **Create new Java class** - Add business logic to demonstrate testing concepts
2. **Define clear contracts** - Use interfaces and documentation for expected behavior
3. **Add dependencies** - Update `build.gradle` if new libraries are needed
4. **Document learning objectives** - Update README with new concepts covered

**Code path:** `New Java Class` → `Interface Definition` → `Documentation` → `Test Implementation`

---

## 📈 Performance & Scale

### Performance Considerations
- **Test Execution Speed** - Spock tests run efficiently with JUnit platform integration
- **Build Performance** - Gradle incremental compilation reduces build times
- **Memory Usage** - Lightweight sample classes minimize resource requirements

### Monitoring
- **Test Results** - Gradle provides detailed test execution reports
- **Coverage Metrics** - JaCoCo generates comprehensive coverage analysis
- **Build Status** - Gradle build reports show compilation and test success

---

## 🚨 Things to Be Careful About

### 🔒 Security Considerations
- **Random Number Generation** - `RandomLogic` uses `java.util.Random` (not cryptographically secure)
- **Input Validation** - Custom exceptions demonstrate proper error handling patterns
- **Dependency Injection** - Constructor injection patterns show secure object creation

### 📚 Learning Considerations
- **Test Directory Structure** - Maintain Groovy tests in `src/test/groovy/` following package conventions
- **Spock Syntax** - Follow given-when-then or setup-stimulus-response-cleanup patterns
- **Mock vs Spy** - Understand the difference between Spock mocks and spies for different testing scenarios
- **Exception Testing** - Use Spock's `thrown()` method for testing expected exceptions
- **Data-Driven Testing** - Leverage Spock's `@Unroll` and `where:` blocks for parameterized tests

*Updated at: 2025-01-27 UTC*