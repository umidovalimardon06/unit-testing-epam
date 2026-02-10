## AssertJ: *(stating confidently that something is correct)*

* 99% of assertions start with `assertThat(...)`

* **1. `isEqualTo()`**

    * compares object references

* **2. `isEqualToCompareFieldByFieldRecursively()`**

    * compares by fields

* **3. `isTrue()` / `isFalse()`**

    * truth checking

* **4. Collection / Character assertions**

* **5. Class assertions**

    * main methods:

        * `isPublic()`
        * `isFinal()`
        * `isInterface()`
        * `hasSimpleName()`
        * `hasPackage()`

* **6. File assertions**

    * main methods:

        * `exists()`
        * `isFile()`
        * `isDirectory()`
        * `canRead()`
        * `canWrite()`
        * `hasName()`

* **7. Numeric assertions**

    * comparing by precision

* **8. InputStream assertions**

    * comparing file content via streams
    * example:

      ```java
      InputStream given = File.newInputStream(...);
      InputStream expected = File.newInputStream(...);
  
      assertThat(given).hasSomeContentAs(expected);
      ```

* **9. Map assertions**

* **10. Throwable assertions**

    * inspecting exception messages
    * stack traces
    * causes

* **11. Custom descriptions**

    * `.as("...")`
    * written before checking
