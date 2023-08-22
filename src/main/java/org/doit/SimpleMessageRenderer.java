package org.doit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //add annotation
public class SimpleMessageRenderer implements MessageRenderer {

    private final MessageProvider provider;

    @Autowired  //ad annotation
    public SimpleMessageRenderer(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void render() {
        System.out.println(provider.getMessage());
    }
}
