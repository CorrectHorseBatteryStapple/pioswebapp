package hr.tvz.car.parts.shop.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "hr.tvz.car.parts.shop" })
@EnableJpaRepositories(basePackages = { "hr.tvz.car.parts.shop.repository" })
@EntityScan(basePackages = {"hr.tvz.car.parts.shop.model"})
public class CarPartsShopApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CarPartsShopApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CarPartsShopApplication.class);
    }
}
