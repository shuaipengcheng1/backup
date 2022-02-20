package comday9.payserviceconsumer.Controller;

import comday9.payserviceconsumer.Config.OpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {
    @Autowired
    OpenFeign openFeign;
    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id){
        return openFeign.pay(id);
    }
}
