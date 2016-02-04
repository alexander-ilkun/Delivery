package com.ilkun.delivery.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author alexander-ilkun
 */
@Component
public class DeliveryListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent e) {
        System.out.println(e.getMessage());
    }
    
}
