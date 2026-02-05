# TEST-DRIVEN-DEVELOPMENT (TDD)

Started **2003**, part of **Agile programming**

> "writing tests to drive the code"

---

## RED → GREEN → REFACTOR

### 1. RED

* Clearly defining what the code should do
* Example:

    * If I add `2 + 3` I should get `5`
    * But there is **no `add()` function yet**

### 2. GREEN

* Make the test pass as soon as possible

```python
def add(a, b):
    return a + b
```

### 3. REFACTOR

* Improve the **code quality / design** safely

---

This process **goes iteratively**.

---

## Testing Types

* **Unit Test**

    * Tests a single piece (**unit**) of logic or behavior

* **Integration Test**

    * Test covers the full process

---

## Project Structure

* `src/main` (blue)
* `src/test` (green)

## Library
* JUnit
