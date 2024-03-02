package hello.realestateadmin.respository;

import hello.realestateadmin.domain.entity.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, String> {

}

