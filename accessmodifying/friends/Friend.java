package org.familysearch.test.accessmodifying.friends;

/**
 * Created by tyganshelton on 5/8/2015.
 */
public class Friend {

    Family family;

    public Friend(){
        family = new Family();
    }

    public String[] borrowObjects(){
        String[] borrowedObjects = new String[family.friendObjects.length + family.publicObjects.length];
        for(int i=0; i<family.friendObjects.length; i++){
            borrowedObjects[i] = family.friendObjects[i];
        }
        for(int i=family.friendObjects.length; i<(family.friendObjects.length + family.publicObjects.length); i++){
            borrowedObjects[i] = family.publicObjects[i-family.friendObjects.length];
        }
        return borrowedObjects;
    }

    public String borrowMethods(){
        return family.shareRecipe() + family.shareAddress();
    }
}
