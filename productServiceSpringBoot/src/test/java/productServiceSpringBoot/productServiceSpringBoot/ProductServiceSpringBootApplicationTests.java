package productServiceSpringBoot.productServiceSpringBoot;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import productServiceSpringBoot.productServiceSpringBoot.entity.Products;
import productServiceSpringBoot.productServiceSpringBoot.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataMongoTest
class ProductServiceSpringBootApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads(){

	}

	@Test
	public void should_store_a_product(){
		Products products = productRepository.save(new Products("20","Iphone11","Iphone 11 pro",122,"Electronic",3,"assets/img/img6.jpg"));
		assertThat(products).hasFieldOrPropertyWithValue("id","20");
	}

//	@Test
//	public void should_delete_a_userById(){
//		productRepository.deleteById("1");
//		Iterable<Products> products=productRepository.findAll();
//		assertThat(products).hasSize(6);
//	}

//	@Test
//	public void should_delete_all_product(){
//		productRepository.deleteAll();
//		assertThat(productRepository.findAll()).isEmpty();
//	}

	@Test
	public void should_find_no_user_if_repo_isEmpty(){
		Iterable<Products>users=productRepository.findAll();
		assertThat(users).isNotEmpty();
	}

	@Test
	public void should_return_empty_list_when_no_product_exist() {
		Iterable<Products> products = productRepository.findAll();
		assertThat(products).toString();
	}

	@Test
	public void should_asString() {
		Iterable<Products> products = productRepository.findAll();
		assertThat(products).asString();
	}

}
