package customerServiceSpringBoot.customerServiceSpringBoot;

import customerServiceSpringBoot.customerServiceSpringBoot.entity.User;
import customerServiceSpringBoot.customerServiceSpringBoot.repository.UserRepository;


import customerServiceSpringBoot.customerServiceSpringBoot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest

class CustomerServiceSpringBootApplicationTests {
	@Autowired
	UserRepository userRepository;

//	@Autowired
//	UserService userService;

//	@Test
//	public void should_find_all_user(){
//		User user= new User(1l,"user2","tiwarishashank153@gmail.com","7480070218","shashank098","123456");
//		List<User>users=new ArrayList<>();
//		 users = userRepository.findAll();
//		Iterator<User> itr=users.iterator();
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		assertThat(users).hasSize(1).contains(user);
//	}

	@Test
	public void should_store_a_user(){
		User user = userRepository.save(new User(2l,"shashank","shashank@gmail.com","9693802399","shashank098","123456"));
		assertThat(user).hasFieldOrPropertyWithValue("username","shashank");
	}

	@Test
	public void should_delete_a_userById(){
		userRepository.deleteById(1l);
		Iterable<User> users=userRepository.findAll();
		assertThat(users).hasSize(0);
	}
	@Test
	public void should_delete_all_user(){
		userRepository.deleteAll();
		assertThat(userRepository.findAll()).isEmpty();
	}

	@Test
	public void should_find_no_user_if_repo_isEmpty(){
		Iterable<User>users=userRepository.findAll();
		assertThat(users).isNotEmpty();
	}

	@Test
	public void should_return_empty_list_when_no_customers_exist() {
		Iterable<User> customers = userRepository.findAll();
		assertThat(customers).toString();
	}


	@Test
	public void should_return_empty_list_when_no_customers_no_null() {
		Iterable<User> customers = userRepository.findAll();
		assertThat(customers).doesNotContainNull();
	}
}
