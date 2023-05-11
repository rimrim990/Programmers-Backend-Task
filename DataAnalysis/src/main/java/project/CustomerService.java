package project;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import project.dto.CustomerDto;
import project.dto.Status;
import project.utils.JsonMapperUtils;
import project.utils.FileUtils;

public class CustomerService {

    private static final String FILE_PATH = "data/input/customer.json";

    private final List<CustomerDto> customerRepository;

    public CustomerService() throws IOException {
        String json = FileUtils.readFileAsString(FILE_PATH);
        this.customerRepository = JsonMapperUtils.convertToList(json, CustomerDto.class);
    }

    public int getTotalCustomerCount() {
        return customerRepository.size();
    }

    public List<Integer> getDormantCustomerIds() {
        return customerRepository.stream()
                .filter(c -> c.getStatus() == Status.DORMANT)
                .mapToInt(c -> c.getCustomerId())
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }
}
