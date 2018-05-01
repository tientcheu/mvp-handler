package org.tientcheu.framework.mvp.api;

public interface IModelAttribute<T> extends IAttribute<T> {

	T get();

	void set(T value);

	IModel getModel();

	void setModel(IModel model);

	String getPropertyName();

}