package fr.lernejo.tester;

import fr.lernejo.tester.internal.TestClassDiscoverer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) {
        int launchedTests = 0;
        int nbKo = 0;
        long startRunner = System.nanoTime();
        for (String arg : args) {
            var testClasses = new TestClassDiscoverer(arg).listTestClasses();
            for (var testClassDescription : testClasses) {
                var methods = testClassDescription.listTestMethods();
                try {
                    Object testInstance = testClassDescription.GetToDoClass().getConstructor().newInstance();
                    for (Method method : methods) {
                        launchedTests++;
                        String status = "OK";
                        long startTime = System.nanoTime();
                        try {
                            method.invoke(testInstance);
                        } catch (InvocationTargetException e) {
                            status = "KO";
                            nbKo++;
                        }
                        long timer = (System.nanoTime() - startTime) / 1000000;
                        System.out.println(testInstance.getClass().getName() + "#" + method.getName() + " " + status + " " + timer + " ms");
                    }
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        long totalTimer = (System.nanoTime() - startRunner) / 1000000;
        System.out.println();
        System.out.println(launchedTests + " launched tests | " + nbKo + " failed | " + totalTimer + " ms");
    }
}
