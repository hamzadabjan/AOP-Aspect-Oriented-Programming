package com.hamza.spring.training.aop;

import com.hamza.spring.training.aop.dao.AccountDAO;
import com.hamza.spring.training.aop.dao.MembershipDAO;
import com.hamza.spring.training.aop.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner  commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService theTrafficFortuneService) {
		return runner-> {
			//demoTheBeforeAdvice(accountDAO,membershipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
			demoTheAroundAdvice(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n Main program: demoTheAroundAdvice");
		System.out.println("\n Calling getFortune");
		String data= theTrafficFortuneService.getFortune();
		System.out.println("\n My fortune is: " +data);
		System.out.println("Finished");

	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> theAccounts = accountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\n Main program: demoTheAfterReturningAdvice");
		System.out.println("------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {

		// call the business method
		Account myAccount = new Account("Hamza","Height Level");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}


