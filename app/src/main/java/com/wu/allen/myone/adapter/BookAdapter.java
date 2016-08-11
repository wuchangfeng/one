package com.wu.allen.myone.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.myone.adapter.viewholder.BookViewHolder;
import com.wu.allen.myone.model.Book;

/**
 * Created by allen on 2016/8/10.
 */

public class BookAdapter extends RecyclerArrayAdapter<Book> {

    public BookAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookViewHolder(parent);
    }
}
