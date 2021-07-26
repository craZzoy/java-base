package com.serialize;

/**
 * 系列化接口
 */
public interface Serializer {

    /**
     * 系列化
     * @param obj
     * @param <T>
     * @return
     */
    <T> byte[] serialize(T obj);

    /**
     * 反系列化
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deSerialize(byte[] bytes, Class<T> tClass);

}
