package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

import java.io.Writer;
import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests {
    @TestMethod
    public static void main(String[] args) {
        TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
        List<Method> testMethods = testClassDescription.listTestMethods();
        try {
            if (testMethods.size() == 2 && testMethods.contains(SomeLernejoTests.class.getMethod("ok")) && testMethods.contains(SomeLernejoTests.class.getMethod("ko"))) {
                System.out.println("Test passed (TestClassDescriptionLernejoTests)");
            }
            else {
                System.out.println("Test failed (TestClassDescriptionLernejoTests)");
            }
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }
}
