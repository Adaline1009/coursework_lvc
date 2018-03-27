package model;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Adelya on 27.03.2018.
 */
public abstract class AbstractDevice {

    private int port;

    /**
     * Слушает на своем порту команды от ЛПИ
     */
    private ServerSocket serverSocket;

    /**
     * Текущее соединение с ЛПИ
     */
    private Socket connection;

    public AbstractDevice() {
        this.port = PortDistributor.getPort();
        createAndListen();
    }

    /**
     * Логика обработки пришедших команд
     */
    abstract void processCommand(@NotNull String command);

    public int getPortNumber() {
        return port;
    }

    private void createAndListen() {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                connection = serverSocket.accept();
                l("Line has been connected");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String command = null;
                while (true) {
                    command = in.readLine();
                    processCommand(command);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    protected void l(@NotNull String s) {
        System.out.println("[" + port + "] " + s);
    }

}
