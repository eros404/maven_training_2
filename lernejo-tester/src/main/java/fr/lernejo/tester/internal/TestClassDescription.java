package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    private final Class<?> toDoClass;

    public TestClassDescription(Class<?> cl) {
        toDoClass = cl;
    }

    public List<Method> listTestMethods() {
        List<Method> list = new ArrayList<>();
        for (Method method: toDoClass.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterCount() == 0 && method.isAnnotationPresent(TestMethod.class)) {
                list.add(method);
            }
        }
        return list;
    }

    public Class<?> GetToDoClass() {
        return toDoClass;
    }
}
