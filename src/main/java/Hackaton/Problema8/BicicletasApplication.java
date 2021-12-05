package Hackaton.Problema8;

import Hackaton.Problema8.mongoRepositories.MRepositoryBike;
import Hackaton.Problema8.mongoRepositories.MRepositoryComments;
import Hackaton.Problema8.mongoRepositories.MRepositoryMovements;
import Hackaton.Problema8.mongoRepositories.MRepositoryUser;
import Hackaton.Problema8.mongoRepositories.MRepository_calificationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MRepository_calificationUser.class)
public class BicicletasApplication  implements CommandLineRunner{
    
    @Autowired
    private MRepository_calificationUser repositoryCalification;
    @Autowired
    private MRepositoryBike repositoryBike;
    @Autowired
    private MRepositoryComments repositoryComments;
    @Autowired
    private MRepositoryMovements repositoryMovements;
    @Autowired
    private MRepositoryUser repositoryUser;
	public static void main(String[] args) {
		SpringApplication.run(BicicletasApplication.class, args);
	}

          @Override
    public void run(String... args) throws Exception {
        repositoryUser.deleteAll();
        repositoryBike.deleteAll();
        repositoryComments.deleteAll();
        repositoryMovements.deleteAll();
        repositoryCalification.deleteAll();
        
    }

}


