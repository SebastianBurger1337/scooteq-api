package de.kaffeeundpopcorn.scooteq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@EnableConfigurationProperties({

})
public class ScooteqAPI extends SpringBootServletInitializer
{
    public static final Logger LOGGER = LoggerFactory.getLogger(ScooteqAPI.class);

    public static void main(String[] args)
    {

        LOGGER.info("Booting Application");
        SpringApplication.run(ScooteqAPI.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {

        return builder.sources(ScooteqAPI.class);
    }
}
