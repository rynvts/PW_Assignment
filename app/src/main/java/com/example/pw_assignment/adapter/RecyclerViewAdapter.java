package com.example.pw_assignment.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pw_assignment.R;
import com.example.pw_assignment.Student;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StudentHolder> {

    private Context context;
    List<Student> students;

    public RecyclerViewAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new StudentHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        Student student=students.get(position);
        holder.name.setText(student.getName());
        String Subs="";
        String qualifications="";
        List<String> sub=student.getSubjects();
        List<String> qual=student.getQualifications();
        if(sub!=null){
            for(String s:sub){
                Subs+="\n"+s;
            }
            holder.subjects.setText(Subs);
        }
        if(qual!=null){
            for(String q:qual) qualifications+="\n"+q;
            holder.qualifications.setText(qualifications);
        }

        Picasso.get()
                .load(student.getProfileLink())
                .into(holder.profileImage);



    }

    @Override
    public int getItemCount() {
        return students.size();
    }


    public class StudentHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView subjects;
        public TextView qualifications;
        public ImageView profileImage;


        public StudentHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.Name_PW);
            subjects = itemView.findViewById(R.id.Subjects);
            qualifications = itemView.findViewById(R.id.Qualifications);
            profileImage = itemView.findViewById(R.id.ProfilePicture);
        }
    }
}
