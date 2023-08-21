package org.doit;

public class Main {
    public static void main(String[] args) {
        MessageProvider provider = MessageFactory.getProvider();
        MessageRenderer renderer = MessageFactory.getRenderer();
        renderer.render();
    }
}