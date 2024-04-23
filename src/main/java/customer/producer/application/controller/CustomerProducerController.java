package customer.producer.application.controller;

import com.opencsv.exceptions.CsvException;
import customer.producer.application.model.CustomerProducer;
import customer.producer.application.service.CustomerProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class CustomerProducerController {
    @Autowired
    CustomerProducerService customerProducerService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/customer_producer/upload_customers", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadCsv(@RequestParam MultipartFile file) throws IOException, CsvException, NumberFormatException {
        customerProducerService.uploadCustomer(file);
    }

    @GetMapping("/customer_producers")
    public List<CustomerProducer> fetchAllCustomer(){
        return customerProducerService.fetchAllCustomers();
    }

    @PostMapping("/customer_producer")
    public ResponseEntity<CustomerProducer> createCustomer(@RequestBody CustomerProducer customerProducer){
        try{
            return new ResponseEntity<CustomerProducer>(
                    customerProducerService.CreateCustomer(customerProducer), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
