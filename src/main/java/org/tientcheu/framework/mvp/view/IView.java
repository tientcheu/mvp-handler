package org.tientcheu.framework.mvp.view;

import org.tientcheu.framework.mvp.api.IPresenter;

/**
 * An IView is a tag to reference an UI container of high level
 * 
 * @author Ben Tientcheu
 */
public interface IView {
    /**
     * Set the presenter use to manage/handle view's message/request
     *
     * @param 	presenter		the presenter to set
     */	
	void setPresenter(IPresenter presenter);
	
    /**
     * Detach the view from it actual controller/presenter 
     *
     */	
	void unsetPresenter();
}
