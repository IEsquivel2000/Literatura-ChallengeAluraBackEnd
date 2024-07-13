package com.literlaura.alura_challenge.service;

public interface DataConverterImpl {
    public <T> T dataConvert(String json, Class<T> tClass);
}
