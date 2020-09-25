package driver.append.example;

import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.NamingStrategy;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.entity.naming.NamingConvention;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

@Entity(defaultKeyspace = "keyspace1")
@NamingStrategy(convention = NamingConvention.SNAKE_CASE_INSENSITIVE)
public class Contact {

    @PartitionKey
    private String name;

    private Set<String> phoneNumbers;

    private Set<String> appendedPhoneNumbers;

    public Contact() {
        this.appendedPhoneNumbers = new HashSet<>();
    }

    public Contact(String name, Set<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.appendedPhoneNumbers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void appendPhoneNumber(String phoneNumber){
        appendedPhoneNumbers.add(phoneNumber);
    }

    public Set<String> getAppendedPhoneNumbers() {
        return appendedPhoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + Sets.union(phoneNumbers, appendedPhoneNumbers) +
                '}';
    }
}
