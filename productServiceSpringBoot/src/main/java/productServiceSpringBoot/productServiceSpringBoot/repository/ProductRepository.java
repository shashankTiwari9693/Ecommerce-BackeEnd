package productServiceSpringBoot.productServiceSpringBoot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import productServiceSpringBoot.productServiceSpringBoot.entity.Products;
@CrossOrigin("http://localhost:64443")
@Repository
public interface ProductRepository extends MongoRepository<Products, String> {

}
