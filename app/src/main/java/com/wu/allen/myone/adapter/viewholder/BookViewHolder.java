package com.wu.allen.myone.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.picasso.Picasso;
import com.wu.allen.myone.R;
import com.wu.allen.myone.model.Book;

/**
 * Created by allen on 2016/8/10.
 */

public class BookViewHolder extends MyBaseViewHolder<Book> {

    private static final String TAG = "BookViewHolder";
    private ImageView imgCover;
    private TextView tvTitle,tvAuthor,tvBookRate,tvRateNum;
    private Button btnBookIntr,btnWantRead;


    public BookViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_book_list);
        imgCover = $(R.id.img_cover);
        tvTitle = $(R.id.tv_title);
        tvAuthor = $(R.id.tv_author);
        tvBookRate = $(R.id.tv_book_rate);
        tvRateNum = $(R.id.tv_rate_num);
    }

    @Override
    public void setData(final Book book){
        Picasso.with(getContext())
            .load(book.getImgUrl())
            .noFade()
            .into(imgCover);
        tvTitle.setText(book.getBookTitle());
        tvAuthor.setText(book.getBookAuth());
        tvBookRate.setText(book.getBookRate()+getStringById(R.string.book_rate));
        tvRateNum.setText(book.getRateNum());
        imgCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(getContext())
                    .title(book.getBookTitle())
                    .content(book.getBookIntr())
                    .negativeText(getStringById(R.string.book_sure))
                    .show();
            }
        });
    }
}
