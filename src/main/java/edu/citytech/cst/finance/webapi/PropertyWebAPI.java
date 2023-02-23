package edu.citytech.cst.finance.webapi;


import edu.citytech.cst.finance.model.MortgageSummary;
import edu.citytech.cst.finance.model.Payment;
import edu.citytech.cst.finance.repository.jdbc.PropertyDAO;
import edu.citytech.cst.finance.repository.springjpa.PropertyRepository;
import edu.citytech.cst.finance.repository.springjpa.PropertySummaryRepository;
import edu.citytech.cst.finance.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PropertyWebAPI {

    @Autowired
    private PropertyRepository repository;

    @Autowired
    private PropertySummaryRepository propertySummaryRepository;
    PropertyDAO propertyDAO = new PropertyDAO();

    //http://localhost:8080/mortgage?loanAmount=100000&year=30&interest=.05
    //http://localhost:8080/mortgage

    @GetMapping("/properties")
    public Map<String,Object> getProperties(
            ){



        Map<String,Object> map = new HashMap<>();

        var list = propertyDAO.findAll();
        map.put("developer", "Sarker,Ayon");
        map.put("properties",list);

        return map;
    }

    @GetMapping("/jpa/properties")
    public Map<String,Object> getJPAProperties(
            @RequestParam (value="state", defaultValue = "*") String state
    ){
        Map<String,Object> map = new HashMap<>();
        var list =   state.equals("*") ?
                                      repository.findAll()
                                      : repository.findByState(state);
        map.put("developer", "Sarker,Ayon");
        map.put("properties",list);

        return map;
    }

    @GetMapping("/jpa/properties/netIncome")
    public Map<String,Object> getByNetIncome(
            @RequestParam (value="start", defaultValue = "0") float start
            ,@RequestParam (value="end", defaultValue = "1000000") float end
    ){
        Map<String,Object> map = new HashMap<>();
        var list =  repository.findByNetIncomeBetween(start,end);
        var size=list.size();
        map.put("developer", "Sarker,Ayon");
        map.put("properties",list);
        map.put("size",size);

        return map;
    }

    @GetMapping("/jpa/propertySummary")
    public Map<String,Object> getPropertySummary(

    ){
        Map<String,Object> map = new HashMap<>();
        var list =  propertySummaryRepository.findAll();

        map.put("developer", "Sarker,Ayon");
        map.put("properties",list);


        return map;
    }
}
