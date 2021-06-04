package caso1;

import caso1.actores.Actor1;

public final class RunActores {

    private RunActores() {}

    public static void main(String[] args) {
        akka.Main.main(new String[]{Actor1.class.getName()});
    }
}