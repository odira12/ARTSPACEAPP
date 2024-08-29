// ArtworkDetailActivity.kt
// ArtworkAdapter.kt
package com.example.artspaceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artspace.Artwork

class ArtworkAdapter(
    private val artworks: List<Artwork>,
    private val onClick: (Artwork) -> Unit
) : RecyclerView.Adapter<ArtworkAdapter.ArtworkViewHolder>() {

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_artwork, parent, false)
        return ArtworkViewHolder(view)
    }

    fun onBindViewHolder(holder: ArtworkViewHolder, position: Int) {
        val artwork = artworks[position]
        holder.bind(artwork)
        holder.itemView.setOnClickListener { onClick(artwork) }
    }

    fun getItemCount(): Int = artworks.size

    class ArtworkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val artworkImageView: ImageView = itemView.findViewById(R.id.artworkImageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val artistTextView: TextView = itemView.findViewById(R.id.artistTextView)

        fun bind(artwork: Artwork) {
            artworkImageView.setImageResource(artwork.imageResId)
            titleTextView.text = artwork.title
            artistTextView.text = artwork.artist
        }
    }
}
