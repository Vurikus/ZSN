package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.mail.MessagingException;
import javax.net.ssl.SSLSocketFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("web")
@EnableWebMvc
//@PropertySource("/resources/config.properties")
public class SpringConfig implements WebMvcConfigurer {
    //Field
    private final ApplicationContext applicationContext;

    //Constructor
    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(1000000);
        return resolver;
    }

    @Bean
    public XmlViewResolver xmlViewResolver() {
        XmlViewResolver resolver = new XmlViewResolver();
        resolver.setOrder(0);
        return resolver;
    }

    @Bean
    public DriverManagerDataSource managerDataSource(){
        DriverManagerDataSource manager = new DriverManagerDataSource();
        manager.setDriverClassName("org.postgresql.Driver");
        manager.setUrl("jdbc:postgresql://localhost:5432/postgres");
        manager.setUsername("postgres");
        manager.setPassword("123");
        return manager;
    }
//
//    @Bean
//    public JavaMailSenderImpl mailSender(){
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setUsername("centrzan23@gmail.com");
//        mailSender.setPassword("1234Qwer!");
//        mailSender.setPort(465);
//        mailSender.setHost("smtp.gmail.com");
//        Properties properties = new Properties();
//        properties.setProperty("mail.smtp.auth", String.valueOf(true));
//        properties.setProperty("mail.smtp.starttls.enable", String.valueOf(true));
//        properties.setProperty("mail.smtp.starttls.required", String.valueOf(true));
//        properties.setProperty("mail.smtp.socketFactory.class", new SSLSocketFactory());
//        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//        mailSender.setJavaMailProperties();
//        return mailSender();
//    }
}