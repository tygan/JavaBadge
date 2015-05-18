package org.familysearch.test.accessmodifying.friends;

import org.familysearch.test.accessmodifying.Stranger;

/**
 * Created by tyganshelton on 5/8/2015.
 * This code exemplifies how access modifiers work.
 */
public class AccessModifierExample {

    public static void main(String[] args){
        Family family = new Family();
        Friend friend = new Friend();
        Stranger stranger = new Stranger();

        String[] strangerObjects = stranger.borrowObjects();
        String strangerObjectString = "";
        for(String s: strangerObjects){
            strangerObjectString += s + "\n";
        }
        System.out.println("Stranger is a class outside of the Family's package. It can only access these public objects:\n" + strangerObjectString +
                "and these public methods: \n" + stranger.borrowMethods());

        String[] friendObjects = friend.borrowObjects();
        String friendObjectString = "";
        for(String s: friendObjects){
            friendObjectString += s + "\n";
        }
        System.out.println("Friend is a class within the Family's package. It can access these protected and public objects:\n" + friendObjectString +
                "and these protected and public methods: \n" + friend.borrowMethods());

        String[] familyObjects = family.borrowObjects();
        String familyObjectString = "";
        for(String s: familyObjects){
            familyObjectString += s + "\n";
        }
        System.out.println("Anything in the Family class can access these private, protected, and public objects:\n" + familyObjectString +
                "and these private, protected, and public methods: \n" + family.borrowMethods());
    }
}
