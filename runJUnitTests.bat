@echo OFF
echo Building Test classes...
javac -d bin/ -classpath "%CLASSPATH%;." test/TestRunner.java

echo Run tests and print results...
java -classpath "%CLASSPATH%;.;.\bin" test.TestRunner

echo Tests complete.
