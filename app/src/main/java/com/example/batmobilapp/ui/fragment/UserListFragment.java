package com.example.batmobilapp.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import com.example.batmobilapp.R;

public class UserListFragment extends Fragment {
    private int id;
    private String title;
    private Drawable icon;
    private String description;

    public UserListFragment() {
    }

    public UserListFragment(int id, String title, Drawable icon, String description)
    {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Drawable getIcon()
    {
        return icon;
    }

    public void setIcon(Drawable icon)
    {
        this.icon = icon;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }}







