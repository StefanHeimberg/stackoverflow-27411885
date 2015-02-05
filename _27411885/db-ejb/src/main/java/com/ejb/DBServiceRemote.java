package com.ejb;

import javax.ejb.Remote;

@Remote
public interface DBServiceRemote {
    
    public String test(String asd);
    
}
