package com.ismart.samahncrm.crmhome.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ismart.samahncrm.R;
import com.ismart.samahncrm.UtilityHelper;
import com.ismart.samahncrm.crmhome.interfacecomm.OnItemClickListener;
import com.ismart.samahncrm.crmhome.interfacecomm.TaskStatus;
import com.ismart.samahncrm.crmhome.models.WaitingModuleAdapter;
import com.ismart.samahncrm.databinding.ItemMyTaskWaitingBinding;

import java.util.ArrayList;
import java.util.List;

public class WaitingAdapter extends RecyclerView.Adapter<WaitingAdapter.MyAdvViewHolder> {
    private LayoutInflater inflater;
    private List<WaitingModuleAdapter> moduleClassList =new ArrayList<>();
    private OnItemClickListener onItemClickedListener;
    private TaskStatus onButtonClickListener;
    public WaitingAdapter(OnItemClickListener onItemClickedListener, TaskStatus onButtonClickListener   ) {
        this.onItemClickedListener = onItemClickedListener;
        this.onButtonClickListener=onButtonClickListener;

    }

    @NonNull
    @Override
    public WaitingAdapter.MyAdvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());

        }
        return  new WaitingAdapter.MyAdvViewHolder(ItemMyTaskWaitingBinding.inflate(inflater,parent,false));

    }

    @BindingAdapter("modelImage")
    public static void setModelImage(ImageView modelImage, String imageUrl) {
        Glide.with(modelImage)
                .load(UtilityHelper.URLSERVER+imageUrl)
                .placeholder(R.drawable.ic_item_flage)
                .into(modelImage);
    }

    public void setModelsList(List<WaitingModuleAdapter> moduleClassList) {
         this.moduleClassList = moduleClassList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdvViewHolder holder, int position) {


        holder.setModuleClassList(moduleClassList.get(position));
        holder.setOnButtonClicked(onButtonClickListener);
        holder.setOnItemClicked(onItemClickedListener);



    }


    @Override
    public int getItemCount() {

        if(moduleClassList==null){

            return 0;}
        return moduleClassList.size();
    }


    class MyAdvViewHolder extends RecyclerView.ViewHolder{
        private ItemMyTaskWaitingBinding itemAdvertiseBinding;

        public MyAdvViewHolder(@NonNull ItemMyTaskWaitingBinding itemView) {
            super(itemView.getRoot());
            this.itemAdvertiseBinding=itemView;

        }

        void  setModuleClassList(WaitingModuleAdapter advertiseModuleClass){
            this.itemAdvertiseBinding.setWaitingModel(advertiseModuleClass);

        }


        public  void setOnButtonClicked(TaskStatus oitemClicked){
            this.itemAdvertiseBinding.setOnButton(oitemClicked);

        }

        public  void  setOnItemClicked(OnItemClickListener onItemClickedListener1){

            this.itemAdvertiseBinding.setOnItemClicked(onItemClickedListener1);
        }
    }


}
