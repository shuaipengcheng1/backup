package comday9.payserviceconsumer.Config;

import org.springframework.stereotype.Component;

@Component
public class OpenFeignImpl implements OpenFeign {
    @Override
    public String pay(int id) {
        return "消费者error";
    }
}
