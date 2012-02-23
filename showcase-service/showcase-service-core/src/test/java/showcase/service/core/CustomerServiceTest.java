package showcase.service.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import showcase.service.api.CustomerService;
import showcase.service.api.dto.CustomerDto;
import showcase.service.core.config.ServiceConfig;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("junit")
@ContextConfiguration(classes = ServiceConfig.class, loader = AnnotationConfigContextLoader.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TestCustomerCreator customerCreator;

    @Test
    public void createCustomer() {
        CustomerDto customer = customerCreator.createCustomer();
        assertThat(customer.getId()).isNotNull();

        CustomerDto found = customerService.getById(customer.getId());

        assertThat(found).isNotNull();
        assertThat(found).isEqualTo(customer);
    }

}