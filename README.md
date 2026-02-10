## JUnit 5 Overview

### Lifecycle Annotations

* **`@BeforeAll`** *(static)*
  Executed **once before all tests** in the test class
  → 2 tests → **1 execution**

* **`@BeforeEach`** *(non-static)*
  Executed **before each test method**
  → 2 tests → **2 executions**

* **`@AfterEach`** *(non-static)*
  Executed **after each test method**
  → 2 tests → **2 executions**

* **`@AfterAll`** *(static)*
  Executed **once after all tests** in the test class
  → 2 tests → **1 execution**

---

### Test Configuration & Control

* **`@DisplayName`**
  Assigns a **human-readable name** to a test or test class

* **`@Disabled`**
  **Disables** a test or test class (ignored during execution)

---

### Assertions & Assumptions

* **Assumptions** (`assumeTrue`, `assumeFalse`, `assumingThat`)
  Executes a test **only if a specified condition is met**

* **`assertThrows`**
  Verifies that a **specific exception is thrown** during test execution

---

### Test Suites

* **`@Suite`**
  Groups multiple tests into a suite using selectors:

    * `@SelectPackages`
    * `@SelectClasses`
    * `@ExcludePackages`
    * `@ExcludeClasses`

---

### Dynamic Tests

* **`@TestFactory`**
  Generates **dynamic tests at runtime** instead of using static `@Test` methods
