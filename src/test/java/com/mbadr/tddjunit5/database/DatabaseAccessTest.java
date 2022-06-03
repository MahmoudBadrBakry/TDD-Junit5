package com.mbadr.tddjunit5.database;

import com.mbadr.tddjunit5.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DatabaseAccessTest {
    @Mock
    private Database database;

    private Credentials credentials = new Credentials("mbadr", "pass");

    @Test
    public void testUserSuccessfulLogin() {
        when(database.login(credentials)).thenReturn(true);
        assertTrue(database.login(new Credentials("mbadr", "pass")));
    }

    @Test
    public void testUserFailedLogin() {
        when(database.login(credentials)).thenReturn(true);
        Credentials sameCredentials = new Credentials("mbadr", "pass");
        Credentials otherCredentials = new Credentials("ohterMbadr", "otherPass");
        assertNotEquals(sameCredentials.getUsername(), otherCredentials.getUsername());
        assertNotEquals(sameCredentials.getPassword(), otherCredentials.getPassword());
        assertNotEquals(sameCredentials.hashCode(), otherCredentials.hashCode());
        assertFalse(database.login(otherCredentials));
    }
}
