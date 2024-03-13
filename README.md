# Problem

Maven has two plugins for separating unit and integration tests (maven-surefire-plugin and maven-failsafe-plugin).
However, activating both plugins results in Cucumber tests being executed twice. CucumberIT should be handled by
maven-failsafe-plugin, not by maven-surefire-plugin.

Command to execute:

```shell
.\mvnw clean install && .\mvnw --version && .\mvnw dependency:tree 
```

Result:

```
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< com.example:cucumber-problem >--------------------
[INFO] Building cucumber-problem 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.2.0:clean (default-clean) @ cucumber-problem ---
[INFO] Deleting C:\sources\cucumber-problem\target
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ cucumber-problem ---
[INFO] skip non existing resourceDirectory C:\sources\cucumber-problem\src\main\resources
[INFO]
[INFO] --- compiler:3.11.0:compile (default-compile) @ cucumber-problem ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 1 source file with javac [debug target 1.8] to target\classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[WARNING] source value 8 is obsolete and will be removed in a future release
[WARNING] target value 8 is obsolete and will be removed in a future release
[WARNING] To suppress warnings about obsolete options, use -Xlint:-options.
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ cucumber-problem ---
[INFO] Copying 1 resource from src\test\resources to target\test-classes
[INFO]
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ cucumber-problem ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 7 source files with javac [debug target 1.8] to target\test-classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[WARNING] source value 8 is obsolete and will be removed in a future release
[WARNING] target value 8 is obsolete and will be removed in a future release
[WARNING] To suppress warnings about obsolete options, use -Xlint:-options.
[INFO] /C:/sources/cucumber-problem/src/test/java/com/example/CucumberIT.java: C:\sources\cucumber-problem\src\test\java\com\example\CucumberIT.java uses or overrides a deprecated API.
[INFO] /C:/sources/cucumber-problem/src/test/java/com/example/CucumberIT.java: Recompile with -Xlint:deprecation for details.
[INFO]
[INFO] --- surefire:3.2.5:test (default-test) @ cucumber-problem ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
m├ñrts 13, 2024 6:06:58 PM io.cucumber.junit.platform.engine.DiscoverySelectorResolver warnWhenCucumberFeaturesPropertyIsUsed
WARNING: Discovering tests using the cucumber.features property. Other discovery selectors are ignored!
Please request/upvote/sponsor/ect better support for JUnit 5 discovery selectors.
See: https://github.com/cucumber/cucumber-jvm/pull/2498
[INFO] Running com.example.ExampleTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.041 s -- in com.example.ExampleTest
[INFO] Running com.example.VintageExampleTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.014 s -- in com.example.VintageExampleTest

Scenario: Text is hashed       # src/test/gherkin/Example.feature:3
  Given text is "hello"        # com.example.ExampleDefinitions.textIs(java.lang.String)
  When it is hashed            # com.example.ExampleDefinitions.itIsHashed()
  Then hash should be 99162322 # com.example.ExampleDefinitions.the_hash_should_be(int)

1 Scenarios (1 passed)
3 Steps (3 passed)
0m0,214s


[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- jar:3.3.0:jar (default-jar) @ cucumber-problem ---
[INFO] Building jar: C:\sources\cucumber-problem\target\cucumber-problem-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- failsafe:3.2.5:integration-test (default) @ cucumber-problem ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
m├ñrts 13, 2024 6:07:01 PM io.cucumber.junit.platform.engine.DiscoverySelectorResolver warnWhenCucumberFeaturesPropertyIsUsed
WARNING: Discovering tests using the cucumber.features property. Other discovery selectors are ignored!
Please request/upvote/sponsor/ect better support for JUnit 5 discovery selectors.
See: https://github.com/cucumber/cucumber-jvm/pull/2498
[INFO] Running com.example.ExampleIT
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.038 s -- in com.example.ExampleIT
[INFO] Running com.example.VintageExampleIT
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.008 s -- in com.example.VintageExampleIT

Scenario: Text is hashed       # src/test/gherkin/Example.feature:3
  Given text is "hello"        # com.example.ExampleDefinitions.textIs(java.lang.String)
  When it is hashed            # com.example.ExampleDefinitions.itIsHashed()
  Then hash should be 99162322 # com.example.ExampleDefinitions.the_hash_should_be(int)

1 Scenarios (1 passed)
3 Steps (3 passed)
0m0,213s


[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- failsafe:3.2.5:verify (default) @ cucumber-problem ---
[INFO]
[INFO] --- install:3.1.1:install (default-install) @ cucumber-problem ---
[INFO] Installing C:\sources\cucumber-problem\pom.xml to C:\Users\xyz\.m2\repository\com\example\cucumber-problem\1.0-SNAPSHOT\cucumber-problem-1.0-SNAPSHOT.pom
[INFO] Installing C:\sources\cucumber-problem\target\cucumber-problem-1.0-SNAPSHOT.jar to C:\Users\xyz\.m2\repository\com\example\cucumber-problem\1.0-SNAPSHOT\cucumber-problem-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.922 s
[INFO] Finished at: 2024-03-13T18:07:02+02:00
[INFO] ------------------------------------------------------------------------
Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: C:\Users\xyz\.m2\wrapper\dists\apache-maven-3.9.6-bin\3311e1d4\apache-maven-3.9.6
Java version: 21.0.2, vendor: Oracle Corporation, runtime: C:\pub\jdk-21.0.2
Default locale: et_EE, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< com.example:cucumber-problem >--------------------
[INFO] Building cucumber-problem 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- dependency:3.6.1:tree (default-cli) @ cucumber-problem ---
[INFO] com.example:cucumber-problem:jar:1.0-SNAPSHOT
[INFO] +- org.junit.jupiter:junit-jupiter-engine:jar:5.10.2:test
[INFO] |  \- org.apiguardian:apiguardian-api:jar:1.1.2:test
[INFO] +- org.junit.jupiter:junit-jupiter-api:jar:5.10.2:test
[INFO] |  +- org.opentest4j:opentest4j:jar:1.3.0:test
[INFO] |  \- org.junit.platform:junit-platform-commons:jar:1.10.2:test
[INFO] +- org.junit.jupiter:junit-jupiter-params:jar:5.10.2:test
[INFO] +- org.junit.platform:junit-platform-launcher:jar:1.10.2:test
[INFO] +- org.junit.platform:junit-platform-engine:jar:1.10.2:test
[INFO] +- org.junit.platform:junit-platform-suite-api:jar:1.10.2:test
[INFO] +- junit:junit:jar:4.13.2:test
[INFO] |  \- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] +- org.junit.vintage:junit-vintage-engine:jar:5.10.2:test
[INFO] +- org.assertj:assertj-core:jar:3.25.3:test
[INFO] |  \- net.bytebuddy:byte-buddy:jar:1.14.11:test
[INFO] +- io.cucumber:cucumber-java:jar:7.15.0:test
[INFO] |  \- io.cucumber:cucumber-core:jar:7.15.0:test
[INFO] |     +- io.cucumber:cucumber-gherkin:jar:7.15.0:test
[INFO] |     +- io.cucumber:cucumber-gherkin-messages:jar:7.15.0:test
[INFO] |     |  \- io.cucumber:gherkin:jar:26.2.0:test
[INFO] |     +- io.cucumber:messages:jar:22.0.0:test
[INFO] |     +- io.cucumber:tag-expressions:jar:6.0.0:test
[INFO] |     +- io.cucumber:cucumber-expressions:jar:17.0.1:test
[INFO] |     +- io.cucumber:datatable:jar:7.15.0:test
[INFO] |     +- io.cucumber:cucumber-plugin:jar:7.15.0:test
[INFO] |     +- io.cucumber:docstring:jar:7.15.0:test
[INFO] |     +- io.cucumber:html-formatter:jar:20.4.0:test
[INFO] |     +- io.cucumber:junit-xml-formatter:jar:0.2.0:test
[INFO] |     \- io.cucumber:ci-environment:jar:10.0.0:test
[INFO] +- io.cucumber:cucumber-junit:jar:7.15.0:test
[INFO] \- io.cucumber:cucumber-junit-platform-engine:jar:7.15.0:test
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.453 s
[INFO] Finished at: 2024-03-13T18:07:10+02:00
[INFO] ------------------------------------------------------------------------
```
