package fc.Application.MVC.Views;

import org.eclipse.swt.widgets.Shell;

public class RunController
{
	public Object m_ViewModel;
	public Class<?> m_Class;
	public Object[] m_Args;
	public int m_a ;
	
	//déclaration du runcontroller, lors d'un event on fait appel pour redirection/action
	public void runController(Shell shellToClose, Class<?> c, Object ... args)
	{
		if (shellToClose != null)
			shellToClose.close(); // or dispose()
		m_Class = c;
		m_Args = args;
	}
	
	public void runController(Shell shellToClose, Class<?> c)
	{
		if (shellToClose != null)
			shellToClose.close(); 
		m_Class = c;
		
	}
	public void runController(int a) {
		m_a = a ;
		
	}
}