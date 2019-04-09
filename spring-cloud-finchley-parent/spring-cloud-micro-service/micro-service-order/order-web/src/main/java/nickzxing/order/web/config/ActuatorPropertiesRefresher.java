package nickzxing.order.web.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ActuatorPropertiesRefresher implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ActuatorPropertiesRefresher.class);

    private ApplicationContext applicationContext;

//    @Autowired
//    private RouteLocator routeLocator;

    @ApolloConfigChangeListener(value = "application.yml", interestedKeyPrefixes = {"management"})
    public void onManagementChange(ConfigChangeEvent changeEvent) {
        refreshActuatorProperties(changeEvent);
    }

    private void refreshActuatorProperties(ConfigChangeEvent changeEvent) {
        logger.info("Refreshing zuul properties!");

        /**
         * rebind configuration beans, e.g. ZuulProperties
         * @see org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder#onApplicationEvent
         */
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));

        /**
         * refresh routes
         * @see org.springframework.cloud.netflix.zuul.ZuulServerAutoConfiguration.ZuulRefreshListener#onApplicationEvent
         */
//        this.applicationContext.publishEvent(new RoutesRefreshedEvent(routeLocator));

        logger.info("Zuul properties refreshed!");
//        this.applicationContext.publishEvent();
//        this.applicationContext.publishEvent(new ContextRefreshedEvent(applicationContext));
//        this.applicationContext.publishEvent();
//        this.refresh(applicationContext);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    protected void refresh(ApplicationContext applicationContext) {
        Assert.isInstanceOf(AbstractApplicationContext.class, applicationContext);
        ((AbstractApplicationContext) applicationContext).refresh();
    }
}
