package customer.producer.application.repository;

import customer.producer.application.model.CustomerProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProducerRepository extends JpaRepository<CustomerProducer, Integer> {
}
