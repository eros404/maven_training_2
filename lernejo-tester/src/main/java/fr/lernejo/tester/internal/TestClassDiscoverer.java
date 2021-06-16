package fr.lernejo.tester.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

public class TestClassDiscoverer {
    final String _pack;
    public TestClassDiscoverer(String pack) {
        _pack = pack;
    }

    public List<TestClassDescription> listTestClasses() {
        Reflections reflections = new Reflections(_pack, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);
        List<TestClassDescription> result = new ArrayList<>();
        for (Class<?> cl : allTypes) {
            var testClassDescription = new TestClassDescription(cl);
            if (testClassDescription.listTestMethods().size() > 0) {
                result.add(testClassDescription);
            }
        }
        return result;
    }
}

