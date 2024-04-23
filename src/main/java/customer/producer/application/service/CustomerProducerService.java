package customer.producer.application.service;

import customer.producer.application.model.CustomerProducer;
import customer.producer.application.repository.CustomerProducerRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CustomerProducerService {
    @Autowired
    CustomerProducerRepository customerProducerRepository;
    private static final String FILE_PATH = "C:\\E2E\\application\\";

    public void uploadCustomer(MultipartFile file) throws IOException, CsvException, NumberFormatException {
        CSVReader reader = new CSVReader(new FileReader(FILE_PATH + file.getOriginalFilename()));
        reader.skip(1);
        List<String[]> rows = reader.readAll();
        for (String[] row : rows){
            CustomerProducer customer = new CustomerProducer();
            customer.setCity(row[0]);
            customer.setCreatedOn(Instant.parse(row[1]));
            customer.setCustomerId(Integer.valueOf(row[2]));
            customer.setCustomerName(row[3]);
            if (row[4].isEmpty()){
                customer.setNoOfVehicle(null);
            }else{
                customer.setNoOfVehicle(Integer.valueOf(row[4]));
            }

            customer.setUpdatedOn(Instant.parse(row[5]));
            customerProducerRepository.save(customer);
        }
    }
    public List<CustomerProducer> fetchAllCustomers(){
        return customerProducerRepository.findAll();
    }
    public CustomerProducer CreateCustomer(CustomerProducer customer){
        return customerProducerRepository.save(customer);
    }
}
