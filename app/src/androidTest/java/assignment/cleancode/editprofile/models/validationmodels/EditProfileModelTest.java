package assignment.cleancode.editprofile.models.validationmodels;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SmallTest
public class EditProfileModelTest {



    private EditProfileModel editProfileModelUnderTest;

    @Before
    public void setUp() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        editProfileModelUnderTest = new EditProfileModel(appContext);
    }


    @Test
    public void testValidate() {
        // Setup

        // Run the test
        editProfileModelUnderTest.validate();

        // Verify the results
    }

    @Test
    public void testValidatePassword() {
        // Setup

        // Run the test
        editProfileModelUnderTest.validatePassword();

        // Verify the results
    }

    @Test
    public void testValidateEmail() {
        // Setup

        // Run the test
        editProfileModelUnderTest.validateEmail();

        // Verify the results
    }

    @Test
    public void testGetNameErrorString() {
        // Setup
        final String expectedResult = null;

        // Run the test
        final String result = editProfileModelUnderTest.getNameErrorString();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetEmailErrorString() {
        // Setup
        final String expectedResult = null;

        // Run the test
        final String result = editProfileModelUnderTest.getEmailErrorString();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetPasswordErrorString() {
        // Setup
        final String expectedResult = null;

        // Run the test
        final String result = editProfileModelUnderTest.getPasswordErrorString();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetConfirmPasswordErrorString() {
        // Setup
        final String expectedResult = null;

        // Run the test
        final String result = editProfileModelUnderTest.getConfirmPasswordErrorString();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetPhoneNumberErrorString() {
        // Setup
        final String expectedResult = null;

        // Run the test
        final String result = editProfileModelUnderTest.getPhoneNumberErrorString();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
