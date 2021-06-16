package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

public class TestClassDiscovererLernejoTests {
    @TestMethod
    public static void main(String[] args) {
        var testClassDiscover = new TestClassDiscoverer("fr.lernejo.tester");
        var testClasses = testClassDiscover.listTestClasses();
        int test = 0;
        for (var cl : testClasses) {
            if (cl.toDoClass.getName().equals("fr.lernejo.tester.SomeLernejoTests")) {
                test += 1;
            }
            if (cl.toDoClass.getName().equals("fr.lernejo.tester.TestClassDescriptionLernejoTests")) {
                test += 50;
            }
            if (cl.toDoClass.getName().equals("fr.lernejo.tester.TestClassDiscovererLernejoTests")) {
                test += 900;
            }
        }
        if (test == 951) {
            System.out.println("Test passed (TestClassDiscovererLernejoTests)");
        }
        else {
            System.out.println("Test failed (TestClassDiscovererLernejoTests)");
        }
    }
}
