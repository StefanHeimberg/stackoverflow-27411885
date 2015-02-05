package bookstoreclient;

import com.ejb.DBServiceRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JavaSEClient {
    
    // before running this main method be sure to deploy the db-ejb project to glassfish
    public static void main(String[] args) throws NamingException {
        final String JNDI_NAME = "java:global/db-ejb/DBService!com.ejb.DBServiceRemote";
        final DBServiceRemote dBServiceRemote = lookup(JNDI_NAME, DBServiceRemote.class);
        
        System.out.println(dBServiceRemote.test("welt"));
    }
    
    public static <T> T lookup(final String jndiName, final Class<T> type) throws NamingException {
        final Context context = new InitialContext();
        return type.cast(context.lookup(jndiName));
    }
    
}
