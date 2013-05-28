package com.mogoweb.chrome.impl;

import org.chromium.android_webview.JsPromptResultReceiver;

import com.mogoweb.chrome.JsPromptResult;
import com.mogoweb.chrome.JsResult;

/**
 * Proxies from android_webkit's JsResultReceiver to JsPromptResult.
 *
 * @hide
 */
public class ChromeJsPromptResultProxy implements JsResult.ResultReceiver {

    /** The proxy target. */
    private JsPromptResultReceiver mTarget;

    public ChromeJsPromptResultProxy(JsPromptResultReceiver target) {
      mTarget = target;
    }

    @Override
    public void onJsResultComplete(JsResult result) {
      JsPromptResult promptResult = (JsPromptResult)result;
      if (result.getResult()) {
        mTarget.confirm(promptResult.getStringResult());
      } else {
        mTarget.cancel();
      }
    }
}
