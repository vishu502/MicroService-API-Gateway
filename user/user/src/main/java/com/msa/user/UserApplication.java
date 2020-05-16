package com.msa.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.msa.user.entity.UserDetailEntity;
import com.msa.user.repo.UserManagementRepo;

@SpringBootApplication(scanBasePackages={"com.msa.user"})
@ComponentScan({"com.msa.user"})
@EntityScan(basePackageClasses = UserDetailEntity.class)
@EnableJpaRepositories (basePackageClasses = UserManagementRepo.class)
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
