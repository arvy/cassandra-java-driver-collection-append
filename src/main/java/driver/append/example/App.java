/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package driver.append.example;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;

import java.net.InetSocketAddress;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {

        System.out.println(new App().getGreeting());

        try ( CqlSession session = CqlSession
                .builder()
                .addContactPoint(new InetSocketAddress("10.101.35.240", 9042))
                .withLocalDatacenter("Solr").build() ) {

            ContactMapper contactMapper = new driver.append.example.ContactMapperBuilder(session).build();

            ContactDao dao = contactMapper.contactDao(CqlIdentifier.fromCql("keyspace1"));
            //        dao.save( new Contact("Arvydas Jonusonis", Sets.newHashSet("xxxxxxxxxx")));
            Contact me = dao.findByName("Arvydas Jonusonis");

            me.appendPhoneNumber("5555555555");
            dao.save(me.getName(), me.getAppendedPhoneNumbers());
            System.out.println(me);
        }

    }
}
