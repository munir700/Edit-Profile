package assignment.cleancode.editprofile.models.validationmodels;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@SmallTest
public class BaseValidationModelTest {

    private BaseValidationModel baseValidationModelUnderTest;

    @Before
    public void setUp() {
        baseValidationModelUnderTest = new BaseValidationModel();
    }

    @Test
    public void testValidate() {
        // Setup

        // Run the test
        baseValidationModelUnderTest.validate();

        // Verify the results
    }

    @Test
    public void testIsValid() {
        // Setup

        // Run the test
        final boolean result = baseValidationModelUnderTest.isValid();

        // Verify the results
        assertTrue(result);
    }
}
