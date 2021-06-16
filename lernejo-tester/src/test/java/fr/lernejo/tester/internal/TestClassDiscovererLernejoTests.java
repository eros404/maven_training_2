package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

public class TestClassDiscovererLernejoTests {
    @TestMethod
    public static void test() throws Exception {
        var testClassDiscover = new TestClassDiscoverer("fr.lernejo.tester");
        var testClasses = testClassDiscover.listTestClasses();
        int test = 0;
        for (var cl : testClasses) {
            if (cl.GetToDoClass().getName().equals("fr.lernejo.tester.SomeLernejoTests")) {
                test += 1;
            }
            if (cl.GetToDoClass().getName().equals("fr.lernejo.tester.internal.TestClassDescriptionLernejoTests")) {
                test += 50;
            }
            if (cl.GetToDoClass().getName().equals("fr.lernejo.tester.internal.TestClassDiscovererLernejoTests")) {
                test += 900;
            }
        }
        if (test != 951) {
            throw new Exception();
        }
    }
}
