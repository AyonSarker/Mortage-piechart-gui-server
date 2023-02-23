package edu.citytech.cst.finance.test.springjpa;

import static org.assertj.core.api.Assertions.assertThat;

import edu.citytech.cst.finance.repository.springjpa.PropertyRepository;
import edu.citytech.cst.finance.repository.springjpa.PropertySummaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class T1_QueryEntity {

	@Autowired
	private PropertyRepository repository;

	@Autowired
	private PropertySummaryRepository summaryRepository;
	
	@Test
	public void select() {				
		
		var list = repository.findAll();
		
		for (var currentRow : list) {
			System.out.println(currentRow.toString());
		}	
		
		int count = 163;
		assertThat(list).hasSize(count);
	}

	@Test
	public void selectPropertySummary() {

		var list = summaryRepository.findAll();

		for (var currentRow : list) {
			System.out.println(currentRow.toString());
		}

		int count = 5;
		assertThat(list).hasSize(count);
	}
	

}






