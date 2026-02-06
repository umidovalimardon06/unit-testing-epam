## Testing for exceptions

```java
@Test(expected = NumberFormatException.class)
public void []{
    My implementation throws an exception called = NumberFormatException.class
}
```

**Example:**

```java
public boolean isValid(String isbn) {
    if (isbn.length() != 10) {
        throw new NumberFormatException();
    }
}
```

---

## Refactoring

Improving quality of code (logic, behavior) and performance **after GREEN (minimum pass)**.

* add → final reusable constants

---

## Best Practices

1. Test **one item of functionality only**
2. Test the **business logic**, not the method

   > If the method name you use for the test matches the production method name, then you are doing something wrong — you are not testing the business logic.
3. Tests must be **consistent**

**Example of an unreliable test:**

```java
@Test
public void notAReliableTest() {
    Date today = new Date();
    BookStore store = new BookStore();
    assertTrue(store.isOpen(today));
}
```

> `today` is not consistent (it varies).

---

## Other Assert Methods

1. `assertEquals()`
2. `assertNull()`
3. `assertNotNull()`
4. `assertThat()`
