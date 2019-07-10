package assignment.cleancode.editprofile.utils;

import android.util.Patterns;

import java.util.regex.Pattern;

public class StringUtils {
    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean isValidPhoneNumber(String phone) {
        Pattern PHONE_PATTERN = Pattern.compile(Patterns.PHONE.pattern());
        return PHONE_PATTERN.matcher(phone).matches();
    }


    public static boolean isValidPhoneNumberWholeNumber(String phone) {
        phone = phone.replaceAll("-", "");
        Pattern PHONE_PATTERN = Pattern.compile(AppConstants.PHONE_PATTERN);
        return PHONE_PATTERN.matcher(phone).matches();
    }
}
