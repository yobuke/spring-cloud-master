package nickzxing.eureka.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author NickZxing
 * @date 2018/12/24 10:02
 * Eureka客户端事件监听器
 */
@Component
public class EurekaClientEventListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(EurekaClientEventListener.class);

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        if (null != event && null != event.getInstanceInfo()) {
            LOGGER.info("------------------------------");
            LOGGER.info("服务名[{}]", event.getInstanceInfo().getAppName());
            LOGGER.info("服务实例[{}]", event.getInstanceInfo().getInstanceId());
            LOGGER.info("状态变更[已注册]");
            LOGGER.info("------------------------------");
        }
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        if (null != event) {
            LOGGER.info("------------------------------");
            LOGGER.info("服务名[{}]", event.getAppName());
            LOGGER.info("服务实例[{}]", event.getServerId());
            LOGGER.info("状态变更[已注销]");
            LOGGER.info("------------------------------");
        }
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        if (null != event && null != event.getInstanceInfo()) {
            LOGGER.info("------------------------------");
            LOGGER.info("服务名[{}]", event.getInstanceInfo().getAppName());
            LOGGER.info("服务实例[{}]", event.getInstanceInfo().getInstanceId());
            LOGGER.info("状态变更[已续约]");
            LOGGER.info("------------------------------");
        }
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        LOGGER.info("Eureka server started");
    }
}
