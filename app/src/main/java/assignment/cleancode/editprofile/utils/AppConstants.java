package assignment.cleancode.editprofile.utils;

public class AppConstants {
    public static final String PHONE_PATTERN = "(?:\\+971|\\+ 971|00971|971|0)[- ]{0,}(?:2|3|4|5|6|7|9|04|50|52|54|55|56)[- ]{0,}[0-9]{2,4}[- ]{0,}[0-9]{2,4}[- ]{0,}[0-9]{2,4}|(?:\\+971|\\+ 971|00971|971|0)[- ]{0,}[(][0-9][)]{0,}[- ]{0,}(?:2|3|4|5|6|7|9|04|50|52|54|55|56)[- ]{0,}[0-9]{2,4}[- ]{0,}[0-9]{2,4}[- ]{0,}[0-9]{2,4}|(\\[redacted phone number])";
    public static final String PATTERN_EMAIL_ADDRESS = "[A-z0-9][\\w.-]*@[A-z0-9][\\w\\-\\.]+\\.[A-z0-9]{2,3}|(\\[redacted email address])";
}
