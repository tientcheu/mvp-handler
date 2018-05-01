package org.tientcheu.framework.mvp.api;

/**
 * An ICommand refers to a flow of task or action which can be invoked 
 *  
 * @author Ben Tientcheu
 */
public interface ICommand {
	
    /**
     * execute/run the flow of task/action 
     * @throws		Exception
     */		
	public void execute() throws Exception;
}
