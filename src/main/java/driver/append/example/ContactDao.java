package driver.append.example;

import com.datastax.oss.driver.api.mapper.annotations.*;

import java.util.Set;

@Dao
public interface ContactDao {

    @Select
    Contact findByName(String name);

    @Query("UPDATE keyspace1.contact SET phone_numbers = phone_numbers + :appended_phone_numbers WHERE name = :name")
    void save(String name, @CqlName("appended_phone_numbers") Set<String> appendedPhoneNumbers);
}
