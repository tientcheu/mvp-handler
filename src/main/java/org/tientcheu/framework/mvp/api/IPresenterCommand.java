package org.tientcheu.framework.mvp.api;

public interface IPresenterCommand extends ICommand {

	IPresenter getPresenter();
	String getIdentifier();

}
