package com.android.zhhr.ui.adapter;

import android.content.Context;

import com.android.zhhr.R;
import com.android.zhhr.data.entity.db.DBDownloadItems;
import com.android.zhhr.data.entity.db.DownInfo;
import com.android.zhhr.net.download.HttpDownOnNextListener;
import com.android.zhhr.ui.adapter.base.BaseRecyclerAdapter;
import com.android.zhhr.ui.adapter.base.BaseRecyclerHolder;
import com.android.zhhr.utils.LogUtil;

import java.util.List;

/**
 * Created by 张皓然 on 2018/2/1.
 */

public class DownloadChapterlistAdapter extends BaseRecyclerAdapter<DBDownloadItems> {

    public DownloadChapterlistAdapter(Context context, int itemLayoutId) {
        super(context, itemLayoutId);
    }

    public List<DBDownloadItems> getLists(){
        return list;
    }

    @Override
    public void convert(final BaseRecyclerHolder holder, final DBDownloadItems item, final int position) {
        holder.setText(R.id.tv_title,item.getChapters_title());
        holder.setProgress(R.id.pg_download,item.getNum(),item.getCurrent_num());
        switch (item.getState()){
            case NONE:
                /*起始状态*/
                holder.setText(R.id.tv_progress,"点击下载");
                break;
            case START:
                /*起始状态*/
                holder.setText(R.id.tv_progress,"解析下载地址");
                break;
            case PAUSE:
                holder.setText(R.id.tv_progress,"下载暂停");
                break;
            case DOWN:
                holder.setText(R.id.tv_progress,"正在下载:"+item.getCurrent_num()+"/"+item.getNum());
                break;
            case STOP:
                holder.setText(R.id.tv_progress,"下载停止");
                break;
            case ERROR:
                holder.setText(R.id.tv_progress,"下载错误");
                break;
            case FINISH:
                holder.setText(R.id.tv_progress,"下载完成");
                break;
        }
    }
}