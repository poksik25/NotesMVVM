package com.poklad.notesmvvm.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poklad.notesmvvm.databinding.NoteItemBinding
import com.poklad.notesmvvm.model.AppNote

class MainNoteAdapter() : RecyclerView.Adapter<MainNoteAdapter.MainNoteHolder>() {
    private var mListNotes = emptyList<AppNote>()
    private lateinit var binding: NoteItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainNoteHolder {
        binding =
            NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainNoteHolder(binding.root)
    }

    override fun getItemCount(): Int = mListNotes.size

    override fun onBindViewHolder(holder: MainNoteHolder, position: Int) {
        holder.bind(mListNotes[position])
    }

    fun setList(list: List<AppNote>) {
        this.mListNotes = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MainNoteHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainNoteHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    inner class MainNoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(appNote: AppNote) {
            binding.tvItemNoteName.text = appNote.name
            binding.tvItemNoteText.text = appNote.text
        }

    }
}