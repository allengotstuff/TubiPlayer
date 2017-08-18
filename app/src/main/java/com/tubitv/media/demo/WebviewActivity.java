package com.tubitv.media.demo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.webkit.WebView;
import android.util.Log;
import android.view.View;

import com.tubitv.demo.R;
import com.tubitv.media.demo.vpaid.TubiVPAID;

/**
 * Created by allensun on 8/9/17.
 * on Tubitv.com, allengotstuff@gmail.com
 */
public class WebviewActivity extends Activity {

    private TubiVPAID tubiVPAID;

    private Handler myHandler;

    private WebView webView;

    private static final String VPAID_URL = "https://s3-us-west-1.amazonaws.com/tubi-vpaid/index.html";

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = (WebView) findViewById(R.id.vpaidWebView);
        myHandler = new Handler();

        initVpaidWebview(webView, myHandler);
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private void initVpaidWebview(WebView view, Handler handler) {
        tubiVPAID = new TubiVPAID(view, handler);

        tubiVPAID.init();

        webView.setVisibility(View.VISIBLE);
        webView.bringToFront();
        webView.invalidate();

        webView.addJavascriptInterface(tubiVPAID, "TubiNativeJSInterface");
        webView.loadUrl(VPAID_URL);
    }

}