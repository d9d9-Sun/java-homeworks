package mad;

import mad.config.ApplicationContextConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        Samsung samsung = (Samsung) context.getBean("samsung");
        samsung.outgoingCall();

    }
}
