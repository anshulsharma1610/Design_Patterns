package com.example.generalstore.Factory_Pattern;


import com.example.generalstore.Builder.BuilderAPI;

public abstract class AbstractFactory<T> {
	public abstract T getObject(BuilderAPI<T> builder);
}
