package org.doit;

public class SimpleMessageRenderer implements MessageRenderer {

    private final MessageProvider provider;

    public SimpleMessageRenderer(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void render() {
        System.out.println(provider.getMessage());
    }
}
