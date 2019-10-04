package com.example.batmobilapp.ui.fragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Category;
import com.example.batmobilapp.ui.adapter.CategoryAdapter;
import java.util.ArrayList;
import java.util.List;

public class CategoryListFragment extends Fragment {

    RecyclerView rvCategory;
    List<Category> categoryList;
    CategoryAdapter categoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Anasayfa");
        rvCategory = view.findViewById(R.id.rvCategory);
        categoryList = new ArrayList<>();
        Resources res = getResources();
        Drawable alp = res.getDrawable(R.drawable.ic_launcher_background);
        Drawable sel = res.getDrawable(R.drawable.ic_dashboard_black_24dp);
        Drawable sena = res.getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        Drawable burcu = res.getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        Drawable prt = res.getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        Drawable ali = res.getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        Drawable nesli = res.getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        Drawable aliye = res.getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        Drawable kirac = res.getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        Drawable sumeyye = res.getDrawable(R.drawable.common_google_signin_btn_icon_dark);
        categoryList.add(new Category(1,"Ulaşım",prt,"810 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(1,"Üniversite Hazırlık",aliye,"160 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(1,"Evcil Hayvan Bakımı",ali,"110 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(1,"Sağlık",kirac,"110 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(1,"İş Hayatı",nesli,"410 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(1,"Sosyal Yaşam",sumeyye,"110 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(1,"Spor",alp,"400 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(2,"Eğitim",sel,"560 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(3,"Siyaset",sena,"900 kişi bu konu hakkında konuşuyor."));
        categoryList.add(new Category(4,"Yazılım",burcu,"40 kişi bu konu hakkında konuşuyor."));
        categoryAdapter = new CategoryAdapter(categoryList,getFragmentManager().beginTransaction());
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategory.setAdapter(categoryAdapter);
    }

}
