package org.tientcheu.framework.mvp.factories;

import org.tientcheu.framework.mvp.PresenterAttribute;
import org.tientcheu.framework.mvp.api.IComponentVisitor;
import org.tientcheu.framework.mvp.view.IBindableComponent;

public class ComponentVisitorFactory {

	private static final ComponentVisitorFactory INSTANCE = new ComponentVisitorFactory();
	
	private ComponentVisitorFactory(){
		
	}
	
	public static ComponentVisitorFactory getInstance() {
		return INSTANCE;
	}

	public IComponentVisitor get(PresenterAttribute presenterAttribute) {
		return new IComponentVisitor(){

			@Override
			public void visit(IBindableComponent cmp) {
				
			}
			
		};
	}

}
