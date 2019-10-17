package com.ismart.samahncrm.crmhome.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ismart.samahncrm.crmhome.interfacecomm.OnItemClickListener;
import com.ismart.samahncrm.crmhome.interfacecomm.TaskStatus;
import com.ismart.samahncrm.crmhome.models.WaitingModuleAdapter;
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
        return  new WaitingAdapter.MyAdvViewHolder(ItemAdvertiseBinding.inflate(inflater,parent,false));

    }

    @BindingAdapter("modelImage")
    public static void setModelImage(ImageView modelImage, String imageUrl) {
        Glide.with(modelImage)
                .load(UtilityHelper.URLSERVER+imageUrl)
                .centerCrop()
                .placeholder(R.drawable.empty_user)
                .into(modelImage);
    }

    public void setModelsList(List<ModuleShowAqarDetails.ModuleShowAqarData> moduleClassList) {
         this.moduleClassList = moduleClassList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdvertisteAdapter.MyAdvViewHolder holder, int position) {


        holder.setModuleClassList(moduleClassList.get(position));
        holder.setOitemClicked(onItemClickedListener);
        holder.setOnItemClicked(onItemClickedListener1);



    }


    @Override
    public int getItemCount() {

        if(moduleClassList==null){

            return 0;}
        return moduleClassList.size();
    }


    class MyAdvViewHolder extends RecyclerView.ViewHolder{
        private ItemAdvertiseBinding itemAdvertiseBinding;

        public MyAdvViewHolder(@NonNull ItemAdvertiseBinding itemView) {
            super(itemView.getRoot());
            this.itemAdvertiseBinding=itemView;

        }

        void  setModuleClassList(ModuleShowAqarDetails.ModuleShowAqarData advertiseModuleClass){
            this.itemAdvertiseBinding.setShowaqar(advertiseModuleClass);

        }


        public  void setOitemClicked(MyadvertiseCallback oitemClicked){
            this.itemAdvertiseBinding.setOnclickedItem(oitemClicked);

        }

        public  void  setOnItemClicked(OnItemClickedListener1 onItemClickedListener1){

            this.itemAdvertiseBinding.setOnItemClickListener(onItemClickedListener1);
        }
    }


}
