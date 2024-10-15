    package com.example.listmenu;

    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.ImageView;
    import android.widget.TextView;

    public class CustomBaseAdapter extends BaseAdapter {
        Context context;
        String listFood[];
        int listImages[];
        LayoutInflater inflater;
        String foodPrices[];
        String tag[];
        public CustomBaseAdapter(Context ctx, String[] foodList, int[] images, String[] tag,String[] foodPrices) {
            this.context = ctx;
            this.listFood = foodList;
            this.listImages = images;
            this.tag =tag;
            this.foodPrices = foodPrices;
            inflater = LayoutInflater.from(ctx);
        }

        @Override
        public int getCount() {
            return listFood.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
            TextView txtView = convertView.findViewById(R.id.textView);
            TextView tagName = convertView.findViewById(R.id.nametag);
            TextView foodPrice = convertView.findViewById(R.id.textViewFoodPrice);
            ImageView foodImg = (ImageView) convertView.findViewById(R.id.imageIcom);

            txtView.setText(listFood[position]);
            foodImg.setImageResource(listImages[position]);
            tagName.setText(tag[position]);
            foodPrice.setText(foodPrices[position]);
            return convertView;


        }
    }
