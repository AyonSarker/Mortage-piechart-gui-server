package edu.citytech.cst.finance.repository.springjpa;

import edu.citytech.cst.finance.model.Property;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepository extends CrudRepository <Property,String>{
    List<Property> findByState(String state);
    List<Property>findByNetIncomeBetween(float start, float end);
}
