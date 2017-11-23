package edu.camt;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class HelloWorldApp  {
	



   @RequestMapping("/")
   String hello() {
       return "Hello World!";
   }

   public static void main(String[] args) throws Exception {
       //This one Static Method allows our “App” 
       // to be deployed to a Servlet Container that
       // has already been created and run by Spring
       SpringApplication.run(HelloWorldApp.class, args);
   }
   
	
}
