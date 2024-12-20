package sahilproject.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/portfolio/**")
                .allowedOrigins("http://localhost:3000", "https://portfolio-website-git-main-sahil-kumars-projects-e8fdf4c2.vercel.app/")
                .allowedMethods("POST", "GET", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
