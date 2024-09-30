package fes.aragon.inicio;
import fes.aragon.modelo.Persona;
import fes.aragon.modelo.Servicio;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto=
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml", "bean-servicio.xml"});
        /* final Resource resource = new ClassPathResource("bean-configuration.xml");
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        final XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        */
        Persona per=(Persona)contexto.getBean("persona");
        System.out.println(per);
        System.out.println(contexto.isSingleton("persona"));
        System.out.println(contexto.getBean("persona") instanceof Persona);
        System.out.println(contexto.isTypeMatch("persona", Persona.class));
        System.out.println(contexto.getAliases("persona").length>0);
        Servicio serv=(Servicio) contexto.getBean("servicio");
        serv.getPersona().setNombre("Miguel");
        System.out.println(serv.getPersona().getNombre());
    }
}
