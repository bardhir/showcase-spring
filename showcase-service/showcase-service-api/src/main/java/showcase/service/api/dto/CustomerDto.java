package showcase.service.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;

import showcase.service.api.type.CustomerType;
import showcase.service.api.type.DispatchType;
import showcase.service.api.validation.CreateGroup;
import showcase.service.api.validation.InEnum;

@XmlRootElement
public class CustomerDto implements Serializable {

    @Null(groups = CreateGroup.class)
    private Long id;

    @NotNull
    private Long cooperationPartnerId;

    @NotNull
    @Past
    private Date registrationDate;

    @NotNull
    @InEnum(CustomerType.class)
    private String customerType;

    @NotNull
    @InEnum(DispatchType.class)
    private String dispatchType;

    @NotNull
    private Map<String, String> properties = new HashMap<String, String>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCooperationPartnerId() {
        return cooperationPartnerId;
    }

    public void setCooperationPartnerId(Long cooperationPartnerId) {
        this.cooperationPartnerId = cooperationPartnerId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(String dispatchType) {
        this.dispatchType = dispatchType;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDto that = (CustomerDto) o;

        if (cooperationPartnerId != null ? !cooperationPartnerId.equals(that.cooperationPartnerId) : that.cooperationPartnerId != null)
            return false;
        if (customerType != that.customerType) return false;
        if (dispatchType != that.dispatchType) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cooperationPartnerId != null ? cooperationPartnerId.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (customerType != null ? customerType.hashCode() : 0);
        result = 31 * result + (dispatchType != null ? dispatchType.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CustomerDto");
        sb.append("{id=").append(id);
        sb.append(", cooperationPartnerId=").append(cooperationPartnerId);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", customerType=").append(customerType);
        sb.append(", dispatchType=").append(dispatchType);
        sb.append(", properties=").append(properties);
        sb.append('}');
        return sb.toString();
    }
}
