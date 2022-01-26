package com.apigw;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack()
    {
        System.out.println("okokokok");
        return Mono.just("Oder Service May Be Down");
    }

    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentServiceFallBack()
    {  System.out.println("okokokok2");
        return Mono.just("Payment Service May Be Down");
    }
}
