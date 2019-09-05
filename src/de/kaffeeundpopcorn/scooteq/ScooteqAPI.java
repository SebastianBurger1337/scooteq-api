package de.kaffeeundpopcorn.scooteq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PreDestroy;
import javax.websocket.Session;

@SpringBootApplication
@EnableConfigurationProperties({

})
public class ScooteqAPI extends SpringBootServletInitializer
{

    public static void main(String[] args)
    {
        SpringApplication.run(ScooteqAPI.class, args);
    }

    @PreDestroy
    public void destroy()
    {
        try
        {
        }
        catch (Exception e)
        {
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(ScooteqAPI.class);
    }
}
