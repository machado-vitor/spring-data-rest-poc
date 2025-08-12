package demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    config.setBasePath("/api");
    config.exposeIdsFor(Book.class);
    cors.addMapping("/api/**").allowedOrigins("*").allowedMethods("GET","POST","PUT","PATCH","DELETE");
  }
}

