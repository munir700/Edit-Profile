package assignment.cleancode.editprofile.models.validationmodels;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.Bindable;

import java.util.regex.Pattern;

import assignment.cleancode.editprofile.BR;
import assignment.cleancode.editprofile.R;
import assignment.cleancode.editprofile.utils.AppConstants;
import assignment.cleancode.editprofile.utils.StringUtils;

public class EditProfileModel extends BaseValidationModel implements Parcelable {
    public static final String KEY = "registerModel";
    private Context context;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;

    protected EditProfileModel(Parcel in) {
        name = in.readString();
        email = in.readString();
        password = in.readString();
        confirmPassword = in.readString();
        phoneNumber = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(confirmPassword);
        dest.writeString(phoneNumber);
    }

    @SuppressWarnings("unused")
    public static final Creator<EditProfileModel> CREATOR = new Creator<EditProfileModel>() {
        @Override
        public EditProfileModel createFromParcel(Parcel in) {
            return new EditProfileModel(in);
        }

        @Override
        public EditProfileModel[] newArray(int size) {
            return new EditProfileModel[size];
        }
    };

    @Override
    public void validate() {
        super.validate();
        validateNameErrorString();
        validateEmailErrorString();
        validatePasswordErrorString();
        validateConfirmPasswordErrorString();
        validatePhoneNumberErrorString();
    }

    public EditProfileModel(Context context) {
        this.context = context;
    }

    @Bindable
    public String getNameErrorString() {
        if (name != null && name.isEmpty()) {
            validationMap.put("name", false);
            return context.getString(R.string.STR_NAME_REQUIRED);
        } else {
            validationMap.put("name", true);
            return null;
        }
    }

    private void validateNameErrorString() {
        if (name == null) {
            setName("");
        }
        this.notifyPropertyChanged(BR.nameErrorString);
    }

    @Bindable
    public String getEmailErrorString() {
        if (email != null && email.isEmpty()) {
            validationMap.put("email", false);
            return context.getString(R.string.STR_VALID_EMAIL_REQUIRED);
        } else if (email != null && !StringUtils.isValidEmail(email)) {
            validationMap.put("email", false);
            return context.getString(R.string.ERROR_INVALID_EMAIL_REGISTER);
        } else {
            validationMap.put("email", true);
            return null;
        }
    }

    private void validateEmailErrorString() {
        if (email == null) {
            setEmail("");
        }
        this.notifyPropertyChanged(BR.emailErrorString);
    }

    @Bindable
    public String getPasswordErrorString() {
        if (password != null && password.isEmpty()) {
            validationMap.put("password", false);
            return context.getString(R.string.STR_PASSWORD_REQUIRED);
        } else if (password != null && password.length() < 3) {
            validationMap.put("password", false);
            return context.getString(R.string.ERROR_PASSWORD_LENGTH);
        } else if (password != null && confirmPassword != null && !password.equals(confirmPassword)) {
            validationMap.put("password", false);
            return context.getString(R.string.ERROR_PASSWORD_MISMATCH);
        } else {
            validationMap.put("password", true);
            return null;
        }
    }

    private void validatePasswordErrorString() {
        if (password == null) {
            setPassword("");
        }
        this.notifyPropertyChanged(BR.passwordErrorString);
    }

    @Bindable
    public String getConfirmPasswordErrorString() {
        if (confirmPassword != null && confirmPassword.isEmpty()) {
            validationMap.put("confirmPassword", false);
            return context.getString(R.string.ERROR_PASSWORD_MISMATCH);
        }  else if (confirmPassword != null && password != null && !confirmPassword.equals(password)) {
            validationMap.put("confirmPassword", false);
            return context.getString(R.string.ERROR_PASSWORD_MISMATCH);
        } else {
            validationMap.put("confirmPassword", true);
            return null;
        }
    }

    private void validateConfirmPasswordErrorString() {
        if (confirmPassword == null) {
            setConfirmPassword("");
        }
        this.notifyPropertyChanged(BR.confirmPasswordErrorString);
    }

    @Bindable
    public String getPhoneNumberErrorString() {
        Pattern PHONE_PATTERN = Pattern.compile(AppConstants.PHONE_PATTERN);
        if (phoneNumber != null && phoneNumber.isEmpty()) {
            validationMap.put("phoneNumber", false);
            return context.getString(R.string.STR_MOBILE_REQUIRED);
        } else if (phoneNumber != null && !PHONE_PATTERN.matcher(phoneNumber).matches()) {
            validationMap.put("phoneNumber", false);
            return context.getString(R.string.STR_ERROR_INVALID_PHONE);
        } else {
            validationMap.put("phoneNumber", true);
            return null;
        }
    }

    private void validatePhoneNumberErrorString() {
        if (phoneNumber == null) {
            setPhoneNumber("");
        }
        this.notifyPropertyChanged(BR.phoneNumberErrorString);
    }


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bindable
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
