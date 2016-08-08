package com.wu.allen.myone.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.webkit.WebView;
import com.wu.allen.myone.R;

/**
 * Created by allen on 2016/8/2.
 */

public class ShareUtil {

    /**
     * 分享文本
     * @param context
     * @param text
     */
    public static void shareText(Context context,String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        context.startActivity(Intent.createChooser(intent,context.getResources().getString(R.string.share_article)));
    }

    /**
     * 分享图片
     * @param context
     * @param uri
     */
    public static void shareImage(Context context, Uri uri){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/jpeg");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        context.startActivity(Intent.createChooser(intent,context.getResources().getString(R.string.share_img)));
    }

    /**
     * 复制到剪贴板
     * @param context
     * @param url
     * @param webView
     */
    public static void copyToClipboard(Context context, String url, WebView webView){
        ClipboardManager cm = (ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);
        cm.setPrimaryClip(ClipData.newPlainText("url",url));
        Snackbar.make(webView,context.getResources().getString(R.string.share_link),Snackbar.LENGTH_SHORT).show();
    }
}
