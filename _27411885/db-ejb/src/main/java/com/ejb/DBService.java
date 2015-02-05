package com.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class DBService implements DBServiceRemote {
    
    public static final Logger LOG = Logger.getLogger(DBService.class.getName());

    @Override
    public String test(String asd) {
        LOG.log(Level.SEVERE, "test() called with parameter asd={0}", asd);
        return "hallo " + asd;
    }
    
}
