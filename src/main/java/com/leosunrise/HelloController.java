package com.leosunrise;

import com.netflix.discovery.EurekaClient;
import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xuzichao on 2017/6/28.
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String home(){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host" + instance.getHost()+",service_id:"+instance.getServiceId());
        return "Hello World";
    }
}
