package com.ejb;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBServiceIT {
    
    private static EJBContainer ejbContainer;
    private static Context context;
    
    @BeforeClass
    public static void startEJBContainer() throws IOException {
        final Map<Object, Object> properties = new HashMap<>();
		properties.put(EJBContainer.MODULES, new File("target/classes"));
        
        ejbContainer = EJBContainer.createEJBContainer(properties);
        context = ejbContainer.getContext();
    }
    
    @AfterClass
    public static void shutdownEJBContainer() {
        ejbContainer.close();
    }
    
    private DBService dBService;
    
    @Before
    public void init() throws NamingException {
        // get Local proxy
        final String LOCAL_JNDI_NAME = "java:global/classes/DBService!com.ejb.DBService";
        dBService = (DBService) context.lookup(LOCAL_JNDI_NAME);
    }
    
    @Test
    public void test() {
        assertNotNull(dBService);
        assertEquals("hallo welt", dBService.test("welt"));
    }
    
}
