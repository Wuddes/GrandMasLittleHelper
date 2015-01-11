package hofsa.grandmaslittlehelper.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;

import hofsa.grandmaslittlehelper.R;
import hofsa.grandmaslittlehelper.core.WorkFlow;
import hofsa.grandmaslittlehelper.core.QrLogic;

import static hofsa.grandmaslittlehelper.core.QrLogic.*;

/**
 * Created by Sam on 06.12.14.
 */
public class StartFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        super.onCreateView(inflater, container, savedInstanceState);
        final View startFragment = inflater.inflate(R.layout.fragment_startfragment,container,false);

      //  TextView textView = (TextView)startFragment.findViewById(R.id.StartFragment_WillkommenText);
        final Button startButton = (Button)startFragment.findViewById(R.id.StartFragment_Knopf);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkFlow.showMedFragment();
            }
        });
        final Button scanButton = (Button)startFragment.findViewById(R.id.StartFragment_ScanKnopf);
        final ImageView bild = (ImageView)startFragment.findViewById(R.id.StartFragment_bmp);
        scanButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bild.setImageBitmap(QrLogic.encodeToQrCode("hallo",100,100));
            }
        });
        final Activity currentActivity;
        currentActivity = this.getActivity();
        final Button scan = (Button)startFragment.findViewById(R.id.StartFragment_Scan);
        scan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                IntentIntegrator integrator = new IntentIntegrator(currentActivity);
                integrator.initiateScan();
            }
        });
        return startFragment;
    }


}
