package bdyb.fitpalmobile.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by BDyb on 2017-06-27.
 */

public class SaveSharedPreferences {
    public static final String PREF_USER_NAME = "username";

    static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setUserName(Context context, String username) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_USER_NAME, username);
        editor.commit();
    }

    public static String getUserName(Context context) {
        return getSharedPreferences(context).getString(PREF_USER_NAME, "");
    }
}
