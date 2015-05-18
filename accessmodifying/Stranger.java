package org.familysearch.test.accessmodifying;

import org.familysearch.test.accessmodifying.friends.Family;

/**
 * Created by tyganshelton on 5/8/2015.
 */
public class Stranger {

    Family family;

    public Stranger(){
        family = new Family();
    }

    public String[] borrowObjects(){
        return family.publicObjects;
    }

    public String borrowMethods(){
        return family.shareAddress();
    }
}
