package com.kroraina.easyreader.modules.book.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.kroraina.easyreader.R;
import com.xincubate.lego.adapter.core.BaseItem;
import com.xincubate.lego.adapter.core.BaseViewHolder;
import com.xincubate.lego.annotation.LegoItem;

import java.util.ArrayList;
import java.util.List;



@LegoItem
public class PageStyleItem extends BaseItem {

    public static List<PageStyleItem> initFrom(Context context, List<Drawable> drawables){
        List<PageStyleItem> results = new ArrayList<>();
        for (Drawable drawable : drawables){
            results.add(new PageStyleItem(context,drawable));
        }
        return results;
    }

    public Drawable drawable;

    public PageStyleItem(Context context,Drawable drawable) {
        super(context);
        this.drawable = drawable;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_read_bg;
    }

    public void setChecked(@NonNull BaseViewHolder viewHolder){
        ImageView mIvChecked = viewHolder.findViewById(R.id.read_bg_iv_checked);
        mIvChecked.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder , int position) {
        View mReadBg = viewHolder.findViewById(R.id.read_bg_view);
        ImageView mIvChecked = viewHolder.findViewById(R.id.read_bg_iv_checked);

        mReadBg.setBackground(drawable);
        mIvChecked.setVisibility(View.GONE);
    }
}
