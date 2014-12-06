package hofsa.grandmaslittlehelper.core;

import android.app.Activity;

/**
 * Created by Sam on 06.12.14.
 */
public class Logic {
    private static Logic logic = new Logic();
    private Activity mCurrentActivity;

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(Activity currentActivity) {
        mCurrentActivity = currentActivity;
    }

    private Logic(){

    }
    public static Logic getInstance(){
        return logic;
    }
}
