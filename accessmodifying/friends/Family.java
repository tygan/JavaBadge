package org.familysearch.test.accessmodifying.friends;

/**
 * Created by tyganshelton on 5/8/2015.
 */
public class Family {
    private String[] familyOjects;
    protected String[] friendObjects;
    public String[] publicObjects;

    public Family(){
        familyOjects = new String[2];
        familyOjects[0] = "Dad's cake";
        familyOjects[1] = "Brother's toothbrush";

        friendObjects = new String[2];
        friendObjects[0] = "Couch";
        friendObjects[1] = "Xbox";

        publicObjects = new String[2];
        publicObjects[0] = "Flour";
        publicObjects[1] = "Rake";
    }

    public String shareAddress(){
        return "shareAddress: 123 Kentucky Way, Springfield\n";
    }

    protected String shareRecipe(){
        return "shareRecipe: Best cookie salad recipe\n";
    }

    private String shareSistersJournal(){
        return "shareSistersJournal: Jeremy looked at me today! I think he likes me.\n";
    }

    public String[] borrowObjects(){
        String[] borrowedObjects = new String[familyOjects.length + friendObjects.length + publicObjects.length];
        for(int i=0; i<familyOjects.length; i++){
            borrowedObjects[i] = familyOjects[i];
        }
        for(int i=familyOjects.length; i<(familyOjects.length + friendObjects.length); i++){
            borrowedObjects[i] = friendObjects[i - familyOjects.length];
        }
        for(int i=(familyOjects.length + friendObjects.length); i<(familyOjects.length + friendObjects.length + publicObjects.length); i++){
            borrowedObjects[i] = publicObjects[i - familyOjects.length - friendObjects.length];
        }
        return borrowedObjects;
    }

    public String borrowMethods(){
        return shareSistersJournal() + shareRecipe() + shareAddress();
    }
}
