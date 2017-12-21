package com.addd.measurements.adapters

import android.content.Context
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.addd.measurements.R
import com.addd.measurements.modelAPI.Measurement
import java.util.*


/**
 * Created by addd on 07.12.2017.
 */

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private val listener : CustomAdapterCallback
    private var mNotesList: List<Measurement> = ArrayList()

    constructor(notesList: List<Measurement>, listener : CustomAdapterCallback) {
        mNotesList = notesList
        this.listener = listener
    }

    /**
     * Создание новых View и ViewHolder элемента списка, которые впоследствии могут переиспользоваться.
     */
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item_measurement, viewGroup, false)
        return ViewHolder(v, listener)
    }

    /**
     * Заполнение виджетов View данными из элемента списка с номером i
     */
    override
    fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        var measurement = mNotesList[i]
        val id = measurement.id
        viewHolder.deal.text = String.format("%05d", measurement.deal)
        viewHolder.address.text = measurement.address
        viewHolder.time.text = measurement.time

        if (measurement.workerName == null) {
            viewHolder.workerName.text = "Не распределено"
        } else {
            viewHolder.workerName.text = measurement.workerName.toString()
        }
        setColorResponsible(measurement?.color ?: 0, viewHolder)

        viewHolder.symbol.text = measurement.company?.symbol

        if (viewHolder.symbol.text.length == 1) {
            viewHolder.symbol.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30F)
        }
        setColorCompany(measurement.company?.id ?: 0, viewHolder)



    }

    override fun getItemCount(): Int {
        return mNotesList.size
    }

    private fun setColorResponsible(color: Int, viewHolder: ViewHolder) {
        when (color) {
            1 -> selectColorVersion(viewHolder.workerName, R.color.red, viewHolder.itemView.context)
            2 -> selectColorVersion(viewHolder.workerName, R.color.green, viewHolder.itemView.context)
            3 -> selectColorVersion(viewHolder.workerName, R.color.blue, viewHolder.itemView.context)
        }
    }

    private fun setColorCompany(color: Int, viewHolder: ViewHolder) {
        when (color) {
            1 -> selectColorVersion(viewHolder.symbol, R.color.green, viewHolder.itemView.context)
            2 -> selectColorVersion(viewHolder.symbol, R.color.orange, viewHolder.itemView.context)
            3 -> selectColorVersion(viewHolder.symbol, R.color.blue, viewHolder.itemView.context)
        }
    }

    private fun selectColorVersion(item: TextView, color: Int, context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            item.setTextColor(context.resources.getColor(color, context.theme))
        } else {
            item.setTextColor(context.resources.getColor(color))
        }
    }

    /**
     * Реализация класса ViewHolder, хранящего ссылки на виджеты.
     */

    class ViewHolder : RecyclerView.ViewHolder, View.OnClickListener, View.OnLongClickListener{
        override fun onLongClick(v: View?): Boolean {
            listener.onItemLongClick(adapterPosition)
            return true
        }

        private val listener: CustomAdapterCallback
        override fun onClick(v: View?) {
            listener.onItemClick(adapterPosition)
        }

        var symbol: TextView
        var deal: TextView
        var address: TextView
        var time: TextView
        var workerName: TextView

        constructor(itemView: View, listener : CustomAdapterCallback) : super(itemView) {
            deal = itemView.findViewById(R.id.deal)
            address = itemView.findViewById(R.id.address)
            time = itemView.findViewById(R.id.time)
            workerName = itemView.findViewById(R.id.worker_name)
            symbol = itemView.findViewById(R.id.symbol)
            this.listener = listener
            this.itemView.setOnClickListener(this)
            this.itemView.setOnLongClickListener(this)
        }

    }

    interface CustomAdapterCallback {
        fun onItemClick(pos: Int)
        fun onItemLongClick(pos: Int)
    }
}