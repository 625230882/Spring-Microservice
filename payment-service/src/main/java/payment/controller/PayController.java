package payment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/payment")
public class PayController {

    @RequestMapping(value="/1", method= RequestMethod.GET)
    public String getInfo() {
        return "payment server 1";
    }
}
