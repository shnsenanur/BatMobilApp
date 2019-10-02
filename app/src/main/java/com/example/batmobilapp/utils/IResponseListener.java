package com.example.batmobilapp.utils;

public interface IResponseListener<T> {
    void OnResponse(T response);
    void OnError(String error);
}