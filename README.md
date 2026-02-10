JUnit-5:

@BeforeAll(static) 2tests -> 1logs
@BeforeEach(non-static) 2tests -> 2logs
@DisplayName - naming a test
@Disabled - ignore this
@AfterAll(static) 2tests -> 1log
@AfterEach(non-static)  2tests -> 2log

assumtions -> 'run this test if the condition is met'
assertThrows -> testing for exceptions
@Suite(SelectPackages,SelectClasses,ExcludePackages,ExcludeClasses)
@TestFactory - producing dynamic tests