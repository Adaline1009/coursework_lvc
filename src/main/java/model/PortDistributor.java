package model;

/**
 * Выдает уникальные номера портов по порядку с {@link #PORT}
 */
public class PortDistributor {

    private static int PORT = 1337;

    public static int getPort() {
        return PORT++;
    }

}
