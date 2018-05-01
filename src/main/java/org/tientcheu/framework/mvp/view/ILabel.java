package org.tientcheu.framework.mvp.view;

import org.tientcheu.framework.mvp.api.ILabelVisitor;
import org.tientcheu.framework.mvp.api.IViewControler;

public interface ILabel {

	void setPresenter(IViewControler presenter);
	void setBoundIdentifier(String identifier);
	String getBoundIdentifier();
	void refreshLabel();
	void refreshMask();
	void accept(ILabelVisitor cmpVisitor);
	IViewControler getPresenter();
	
}
