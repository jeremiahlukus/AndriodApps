package com.jparrack.morepermissions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView wv1;
    EditText etURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv1 = (WebView) findViewById(R.id.wv1);
        wv1.setWebViewClient(new myWebView());
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //wv1.getSettings().setDomStorageEnabled(true);
        etURL = (EditText) findViewById(R.id.etURL);
        wv1.loadUrl("http://www.jparrack.com");
    }

    public void buGo(View view) {
        LoadURL(etURL.getText().toString());
    }

    String url;

    void LoadURL(String url) {
        this.url = url;
        wv1.loadUrl(url);
    }

    public void buForward(View view) {
        wv1.goForward();
    }

    public void buBack(View view) {
        wv1.goBack();
    }


    private class myWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
        }
    }
}
