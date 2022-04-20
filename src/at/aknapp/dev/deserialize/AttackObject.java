package at.aknapp.dev.deserialize;

import java.io.Serializable;

public class AttackObject implements Serializable {
    public static void methodTriggersAttack() {
        System.out.println("oh shooot, it's hacked");
    }
}
