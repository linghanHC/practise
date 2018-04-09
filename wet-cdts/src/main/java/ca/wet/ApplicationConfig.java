package ca.wet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ca.wet.stsm.web.conversion.DateFormatter;
import ca.wet.stsm.web.conversion.VarietyFormatter;

/**
 * Application Config.
 * 
 * @author Andrew Pitt
 * @since 1.0.0
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, H2ConsoleAutoConfiguration.class })
public class ApplicationConfig {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            <code>String[]</code>
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}
	
	// Registering a Custom Formatter
    @Configuration
    static class MyConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(varietyFormatter());
            registry.addFormatter(dateFormatter());
        }

        @Bean
        public VarietyFormatter varietyFormatter() {
            return new VarietyFormatter();
        }

        @Bean
        public DateFormatter dateFormatter() {
            return new DateFormatter();
        }
    }

}
