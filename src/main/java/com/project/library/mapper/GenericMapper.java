package com.project.library.mapper;

public interface GenericMapper<T1, T2>{

    public T1 mapToClass (T2 t2);
    public T2 mapToDto (T1 t1);

}
