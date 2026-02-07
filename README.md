# Mocks (Test Doubles)

* **Mocks verify interactions/behaviors, not data/state.**
* Think: *“Did my code call the right collaborator methods with the right params and the right number of times?”*

## Key idea

A **mock** is a test double that lets you:

1. **Stub** behavior (control return values / exceptions)
2. **Verify** interactions (method calls)

---

## Create a mock

```java
Foo foo = mock(Foo.class); // dummy double
```

---

## Stubbing (arrange)

```java
when(foo.method(args)).thenReturn(value);
// or
when(foo.method(args)).thenThrow(new RuntimeException());
```

Notes:

* `when(...).thenReturn(...)` defines what the mock should return when a method is called.
* Use stubbing to isolate the unit under test from dependencies.

---

## Verification (assert interactions)

```java
verify(foo).myMethod(params);
verify(foo, times(n)).myMethod(params);
```

### `times(...)` / count options

```java
verify(foo, times(0)).myMethod(params);   // called 0 times
verify(foo, times(1)).myMethod(params);   // called exactly once
verify(foo, atLeast(2)).myMethod(params); // called >= 2 times
verify(foo, atLeast(7)).myMethod(params); // called >= 7 times
verify(foo, never()).myMethod(params);    // same as times(0)
```

*(Common also: `atMost(n)` for "<= n".)*

---

## Mental model

A mock-based test is basically a **double test** that verifies the test’s expectations by checking:

* **what was called**
* **with which arguments**
* **how many times**

If the expected calls don’t happen, verification fails.
