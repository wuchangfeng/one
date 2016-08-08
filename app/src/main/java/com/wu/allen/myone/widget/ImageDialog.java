package com.wu.allen.myone.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wu.allen.myone.R;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * fragmentDialog 来实现类悬浮窗的效果
 * Created by allen on 2016/8/3.
 */

public class ImageDialog extends android.support.v4.app.DialogFragment{

    private String url;
    PhotoViewAttacher mAttacher;

    public ImageDialog(String url) {
        this.url = url;
    }

    public ImageDialog() {
    }

    @Override
    public void onStart() {
        super.onStart();
        // safety check
        if (getDialog() == null) {
            return;
        }
        // set the animations to use on showing and hiding the dialog
        getDialog().getWindow().setWindowAnimations(
            R.style.DialogAnimation);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_img_dialog,null);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        ImageView mImageView = (ImageView) view.findViewById(R.id.code);
        Glide.with(getActivity())
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .into(mImageView);
        mAttacher = new PhotoViewAttacher(mImageView);
        return view;
    }
}
