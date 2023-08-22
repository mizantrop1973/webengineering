package org.doit;

import org.springframework.stereotype.Component;

@Component  // Add annotation
public class SimpleMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
