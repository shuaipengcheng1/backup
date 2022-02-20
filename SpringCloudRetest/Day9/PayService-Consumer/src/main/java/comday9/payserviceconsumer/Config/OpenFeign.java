package comday9.payserviceconsumer.Config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PAY",fallback = OpenFeignImpl.class)
@Component
public interface OpenFeign {
    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id);
}
