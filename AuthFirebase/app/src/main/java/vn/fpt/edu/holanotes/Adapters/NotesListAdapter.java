//path : app/src/main/java/vn/fpt/edu/holanotes/Adapters/NotesListAdapter.java
package vn.fpt.edu.holanotes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.fpt.edu.holanotes.Models.Notes;
import vn.fpt.edu.holanotes.NotesClickListener;
import vn.fpt.edu.holanotes.R;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.NotesViewHolder> {

    Context context;
    List<Notes> notesList;
    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> notesList, NotesClickListener listener) {
        this.context = context;
        this.notesList = notesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(
                LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        // Bind note data to views
        Notes note = notesList.get(position);

        holder.textView_title.setText(note.getTitle());
        holder.textView_title.setSelected(true); // For marquee effect if needed

        holder.textView_notes.setText(note.getNotes());
        holder.textView_date.setText(note.getDate());
        holder.textView_date.setSelected(true); // For marquee effect if needed

        // Show or hide the pinned icon
        if (note.isPinned()) {
            holder.imageView_pin.setVisibility(View.VISIBLE);
        } else {
            holder.imageView_pin.setVisibility(View.GONE);
        }

        // Set a fixed background color for the card (Change this color as needed)
        holder.notes_container.setCardBackgroundColor(
                holder.itemView.getResources().getColor(R.color.white, null)  // Fixed color
        );

        // Set click listeners for card actions
        holder.notes_container.setOnClickListener(v ->
                listener.onClick(notesList.get(holder.getAdapterPosition()))
        );

        holder.notes_container.setOnLongClickListener(v -> {
            listener.onLongClick(notesList.get(holder.getAdapterPosition()), holder.notes_container);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();  // Return the correct size of the notes list
    }

    // ViewHolder class
    public static class NotesViewHolder extends RecyclerView.ViewHolder {
        CardView notes_container;
        TextView textView_title, textView_notes, textView_date;
        ImageView imageView_pin;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            notes_container = itemView.findViewById(R.id.notes_container);
            textView_title = itemView.findViewById(R.id.textView_title);
            textView_notes = itemView.findViewById(R.id.textView_notes);
            textView_date = itemView.findViewById(R.id.textView_date);
            imageView_pin = itemView.findViewById(R.id.imageView_pin);
        }
    }
}
