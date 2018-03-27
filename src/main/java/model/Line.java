package model;

import java.util.Map;
import java.util.Set;

/**
 * Created by Adelya on 27.03.2018.
 */
public class Line extends Thread {
    private Set<AbstractDevice> devices;
    private boolean isActive;
    private AbstractDevice controller;
    private Map<Integer, Message> messages;

    public Line(Set<AbstractDevice> devices, boolean isActive, AbstractDevice controller) {
        this.devices = devices;
        this.isActive = isActive;
        this.controller = controller;

    }

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

    public Map<Integer, Message> getMessages() {
        return messages;
    }

    public void setMessages(Map<Integer, Message> messages) {
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

        }
    }

}
