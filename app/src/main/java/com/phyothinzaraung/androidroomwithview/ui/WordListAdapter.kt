package com.phyothinzaraung.androidroomwithview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.phyothinzaraung.androidroomwithview.R
import com.phyothinzaraung.androidroomwithview.data.Word

class WordListAdapter: ListAdapter<Word, WordViewHolder> (WordsComparator()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }
}

class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val wordTextView: TextView = itemView.findViewById(R.id.textView)

    fun bind(text: String?){
        wordTextView.text = text
    }

    companion object{
        fun create(parent: ViewGroup): WordViewHolder{
            val view:View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
            return WordViewHolder(view)
        }
    }

}

class WordsComparator: DiffUtil.ItemCallback<Word>(){
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.word == newItem.word
    }

}