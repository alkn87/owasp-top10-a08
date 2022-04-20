package at.aknapp.dev.deserialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class BadThing implements Serializable {
    Object tooGenericThing;
    String methodName;


    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        inputStream.defaultReadObject();
        try {
            // executing something from deserialized objects, without verifying the serialized data by e.g. signature
            // is also bad, but not specific scope of the demo.
        } catch (Exception ex) {
            // Not relevant: Error Handling
        }
    }
}
