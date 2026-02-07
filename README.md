# Stubs

**Stub** – a fake helper that **returns a fixed answer**.

Real dependencies (databases, APIs, other classes, time, randomness) make tests:

* slow
* hard to set up
* unpredictable

A stub replaces those dependencies so the test can focus on the logic being tested.

---

### Key idea

* A **stub controls the input** to the code under test
* It does **not** verify how it is used

---

### In short

* **Simple snapshot of a dependency**
* **Returns predefined (fixed) values**
* Makes tests **fast, simple, and deterministic**

---

### What a stub does NOT do

* Does not check whether it was called
* Does not count calls
* Does not fail tests on its own

(Those are responsibilities of **mocks**)
