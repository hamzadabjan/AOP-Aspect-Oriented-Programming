package com.hamza.spring.training.aop;

import com.hamza.spring.training.aop.dao.AccountDAO;
import com.hamza.spring.training.aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner  commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner-> {
			demoTheBeforeAdvice(accountDAO,membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {

		Account tempAccount = new Account("Hamza","Manager");
		accountDAO.addAccount(tempAccount,true);
		membershipDAO.addAccount();

	}

}


