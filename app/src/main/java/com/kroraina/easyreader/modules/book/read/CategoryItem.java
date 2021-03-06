package com.kroraina.easyreader.modules.book.read;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.kroraina.easyreader.R;
import com.kroraina.easyreader.ui.widget.page.TxtChapter;
import com.kroraina.easyreader.utils.BookManager;
import com.xincubate.lego.adapter.bean.BaseBeanItem;
import com.xincubate.lego.adapter.core.BaseItem;
import com.xincubate.lego.adapter.core.BaseViewHolder;
import com.xincubate.lego.annotation.LegoItem;

import java.util.ArrayList;
import java.util.List;


@LegoItem
public class CategoryItem extends BaseBeanItem<TxtChapter> {

    public CategoryItem(Context context, TxtChapter bean) {
        super(context, bean);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_category;
    }

    public void setSelectedChapter(@NonNull BaseViewHolder viewHolder){
        TextView mTvChapter = viewHolder.findViewById(R.id.category_tv_chapter);
        mTvChapter.setTextColor(ContextCompat.getColor(context,R.color.light_red));
        mTvChapter.setSelected(true);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder , int position) {
        TextView mTvChapter = viewHolder.findViewById(R.id.category_tv_chapter);

        Drawable drawable = null;

        //TODO:目录显示设计的有点不好，需要靠成员变量是否为null来判断。
        //如果没有链接地址表示是本地文件
        if (bean.getLink() == null){
            drawable = ContextCompat.getDrawable(mTvChapter.getContext(),R.drawable.selector_category_load);
        }
        else {
            if (bean.getBookId() != null
                    && BookManager
                    .isChapterCached(bean.getBookId(),bean.getTitle())){
                drawable = ContextCompat.getDrawable(mTvChapter.getContext(),R.drawable.selector_category_load);
            }
            else {
                drawable = ContextCompat.getDrawable(mTvChapter.getContext(), R.drawable.selector_category_unload);
            }
        }

        mTvChapter.setSelected(false);
        mTvChapter.setTextColor(ContextCompat.getColor(mTvChapter.getContext(),R.color.nb_text_default));
        mTvChapter.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
        mTvChapter.setText(bean.getTitle());
    }
}
