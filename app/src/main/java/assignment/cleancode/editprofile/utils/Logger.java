package assignment.cleancode.editprofile.utils;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import assignment.cleancode.editprofile.BuildConfig;


public class Logger {

    public static boolean isDebugable = BuildConfig.DEBUG;

    public static void e(final String tag, final String message) {
        if (isDebugable) {
            Log.e(tag, message + "");
        }
    }

    public static void d(final String tag, final String message) {
        if (isDebugable) {
            Log.d(tag, message);
        }
    }

    public static void i(final String tag, final String message) {
        if (isDebugable) {
            Log.i(tag, message);
        }
    }

    public static void v(final String tag, final String message) {
        if (isDebugable) {
            Log.v(tag, message);
        }
    }

    /*
     * To log non fatal event on crashlytics
     * */
    public static void logCrashlyticsException(Throwable throwable) {
        Crashlytics.logException(throwable);
    }
}
