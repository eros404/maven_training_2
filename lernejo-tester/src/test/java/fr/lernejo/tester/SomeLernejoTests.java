package fr.lernejo.tester;

import fr.lernejo.tester.api.TestMethod;

public class SomeLernejoTests {
    @TestMethod
    public void ok() {

    }

    @TestMethod
    public void ko() throws IllegalStateException {
        throw new IllegalStateException();
    }

    public void none() {

    }
}
