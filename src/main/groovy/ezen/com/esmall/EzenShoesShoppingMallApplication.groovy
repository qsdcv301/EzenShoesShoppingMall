package ezen.com.esmall

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class EzenShoesShoppingMallApplication {

	static void main(String[] args) {
		SpringApplication.run(EzenShoesShoppingMallApplication, args)
	}

}
