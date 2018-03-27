package model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Adelya on 27.03.2018.
 */
public class Line extends Thread {
    private Set<AbstractDevice> devices;
    private boolean isActive;

    private AbstractDevice controller;
    private TreeMap<Integer, Message> messages;

    ///НУЖЕН ЛИ СЕРВЕРСОКЕТ
    private ServerSocket serverSocket;

    public Line(Set<AbstractDevice> devices, boolean isActive, AbstractDevice controller, ServerSocket serverSocket) {
        this.devices = devices;
        this.isActive = isActive;
        this.controller = controller;
        this.serverSocket = serverSocket;

    }
//METHOD INITIALOZER DEVICES THREAD!!!!!!!
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<AbstractDevice> getDevices() {
        return devices;
    }

    public void setDevices(Set<AbstractDevice> devices) {
        this.devices = devices;
    }

    public AbstractDevice getController() {
        return controller;
    }

    public void setController(AbstractDevice controller) {
        this.controller = controller;
    }

    public TreeMap<Integer, Message> getMessages() {
        return messages;
    }

    public void setMessages(TreeMap<Integer, Message> messages) {
        this.messages = messages;
    }

    public void run() {
        while (true) {
            if (!isActive) {
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!messages.isEmpty()) {
                try {
                for (Map.Entry<Integer, Message> entry : messages.entrySet()) {

                    //int key = entry.getKey();
                    Message message = entry.getValue();

                    for (AbstractDevice device : devices) {
                         Socket client = null;//чтоб закомитить без ошибки
                      //  Socket client = device.getSocket();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
                        objectOutputStream.writeObject(message);
                        objectOutputStream.flush();


                    }
                    // ...
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
