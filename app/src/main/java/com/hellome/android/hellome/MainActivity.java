package com.hellome.android.hellome;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void telepon(String nomor){
        intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+nomor));
        startActivity(intent);
    }
    private void sms(String nomor){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", nomor, null)));
    }
    private void sendSMSDirect(String nomor){
        Uri uri = Uri.parse("smsto:"+nomor);
        intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "Selemat malam kami dari kepolisian sedang mencari seseorang yang benama ");
        startActivity(intent);
    }

    public void telpPacar(View view) {

    }

    public void telpRumah(View view) {
        telepon("089602608573");
    }


    public void smsRumah(View view) {
        sms("089602608573");
    }

    public void smsWithBody(View view) {
        sendSMSDirect("089602608573");
    }
}
