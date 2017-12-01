package ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@RestController
public class DispatcherController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment")
    public String getResource(Principal principal) {
        this.loadBalancerClient.choose("payment-service");
        return restTemplate.getForObject("http://payment-service/payment/1", String.class);
    }


    @GetMapping("/ribbon")
    public String ribbon() {
        return restTemplate.getForObject("http://payment-service/payment/1", String.class);
    }


}
