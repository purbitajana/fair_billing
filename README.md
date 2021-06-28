# fair_billing: Execution Steps

Please follow the below steps to build and execute:

1. Please execute the below command for compilation from within fair_billing directory:
  
        javac -d .\bin src\main\com\bt\asmt\constant\*.java src\main\com\bt\asmt\enums\*.java src\main\com\bt\asmt\exception\*.java src\main\com\bt\asmt\model\*.java src\main\com\bt\asmt\util\*.java  src\main\com\bt\asmt\service\*.java src\main\com\bt\asmt\*.java

2. Please execute the below command for execution with fair_billing log file:
                
        java -cp bin main.com.bt.asmt.FairBilling  fair_billing.log

3. To execute the JUnit test cases please follow the below steps:
  3.1. Please execute the below command for compilation:
  
       javac -d .\bin -cp bin;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar;. src\test\com\bt\asmt\FairBillingTests.java
  
  3.2. Please execute the below command to run the test cases:
   Windows:
       
       java -cp bin;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore test.com.bt.asmt.FairBillingTests
       
   Linux:
   
      java -cp bin:lib\junit-4.13.2.jar:lib\hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore test.com.bt.asmt.FairBillingTests
