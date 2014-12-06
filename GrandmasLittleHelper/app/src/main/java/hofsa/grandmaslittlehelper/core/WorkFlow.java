package hofsa.grandmaslittlehelper.core;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import hofsa.grandmaslittlehelper.R;
import hofsa.grandmaslittlehelper.ui.StartFragment;

/**
 * Created by Sam on 06.12.14.
 */
public class WorkFlow {
    public static void showStartFragment(){
        FragmentManager fragmentManager = (Logic.getInstance().getCurrentActivity()).getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.MainActivity_ContentFragment, new StartFragment());
        fragmentTransaction.commit();
    }
}
