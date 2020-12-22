package com.bytessystem.databasenews;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;

public class PostAdapter extends ArrayAdapter {

    ArrayList<Post> postlist;
    Context context;
    TextView sub,date,counter,pid,desc;

    public PostAdapter(@NonNull Context context, ArrayList<Post> objects) {
        super(context , R.layout.news_post,objects);
        this.context=context;
        postlist=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.news_post,null);
                      }
            sub = convertView.findViewById(R.id.sub);
            date = convertView.findViewById(R.id.date);
            counter = convertView.findViewById(R.id.counter);

            sub.setText(postlist.get(position).getSub());
            date.setText(postlist.get(position).getDate());
            counter.setText(postlist.get(position).getCounter());
            return convertView;
    }
}
