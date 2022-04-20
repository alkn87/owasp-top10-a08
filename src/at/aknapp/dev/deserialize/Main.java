package at.aknapp.dev.deserialize;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    /**
     * OWASP Top 10 - 2021
     * A08: Software and Data Integrity Failure
     * Demo of
     * */
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        BadThing badThing = new BadThing();

        // An [AttackObject] which does bad things gets injected somewhere in the code.
        // [AttackObject] could also come from unverified deserialized object itself.
        // Could be hidden deep in the classpath by use of unsecure, unverified packages from e.g. maven repo:
        badThing.tooGenericThing = new AttackObject();

        // If an attacker is capable of injecting malicious data into serialized input data.
        // For instance by using InputStream, ObjectInputStream etc.:
        String someDownloadedDeserializedData = "methodTriggersAttack";

        // Malicious data is not verified (signature check, etc.) and processed (e.g. for use with reflection):
        badThing.methodName = someDownloadedDeserializedData;

        // The use of reflection with annotations can "hide" things to the developers.
        // This could lead to unwanted execution of malicious code.
        Method method = badThing.tooGenericThing.getClass().getMethod(badThing.methodName);
        method.invoke(badThing.methodName);
    }
}
