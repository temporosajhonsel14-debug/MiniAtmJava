package ATMPROJECT.Login;

import ATMPROJECT.Account.useraccount;

public class userlogin {

    private useraccount user1;
    private useraccount user2;

    public userlogin() {
        // User 1: Jhonsel Temporosa
        user1 = new useraccount("jhonsel", "Jhonsel Temporosa", "1234", 10000.00);
        
        // User 2: Mark Lorence Camacho
        user2 = new useraccount("mark", "Mark Lorence Camacho", "5678", 5000.00);
    }

    // Authenticates credentials against the two pre-configured user objects
    public useraccount authenticate(String username, String pin) {
        if (username == null || pin == null) {
            return null;
        }

        String formattedUser = username.trim().toLowerCase();
        String formattedPin = pin.trim();

        // Check User 1 (Jhonsel)
        if (user1.getUsername().equals(formattedUser) && user1.getPin().equals(formattedPin)) {
            return user1;
        }

        // Check User 2 (Mark)
        if (user2.getUsername().equals(formattedUser) && user2.getPin().equals(formattedPin)) {
            return user2;
        }

        return null;
    }
}