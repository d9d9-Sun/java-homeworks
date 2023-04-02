package by.mad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Pie pie1 = (Pie) context.getBean("pie");
        Pie pie2 = (Pie) context.getBean("pie");
        pie1.run();
        pie2.run();

        Factory factory = (Factory) context.getBean("factory");
        factory.start();

    }
}
