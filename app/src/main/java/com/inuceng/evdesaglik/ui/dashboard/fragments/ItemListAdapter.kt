package com.inuceng.evdesaglik.ui.dashboard.fragments
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inuceng.evdesaglik.R
import com.inuceng.evdesaglik.data.Appointment

class ItemListAdapter(val itemList: ArrayList<Appointment>) :
    RecyclerView.Adapter<ItemListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        return ItemListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_image_with_text,
                parent,
                false

            )
        )

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.bindItems(itemList[position])
    }
}
class ItemListViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){

    fun bindItems(itemModel : Appointment) {
        val doctor = itemView.findViewById(R.id.textView) as TextView
        val date = itemView.findViewById(R.id.textView2) as TextView
        val time = itemView.findViewById(R.id.textView3) as TextView
        val user = itemView.findViewById(R.id.textView4) as TextView

         doctor.text = itemModel.doctor
        date.text = itemModel.date
        time.text=itemModel.time
        user.text =itemModel.user


    }
}