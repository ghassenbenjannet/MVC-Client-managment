package fc.Application.MVC.Views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import fc.Application.MVC.Controllers.ListClientsController;
import fc.Application.MVC.Controllers.ListCommandesController;


public class UpdateClientView extends Dialog {

	protected Object result;
	protected Shell shlUpdate;
	
	public RunController m_Infrastructure;
	
	protected Integer getViewModel()
	{
		if (m_Infrastructure != null)
			return (Integer)m_Infrastructure.m_ViewModel;
		else
			return -1;
	}

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UpdateClientView(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlUpdate.open();
		shlUpdate.layout();
		Display display = getParent().getDisplay();
		while (!shlUpdate.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		//creation du shell
		shlUpdate = new Shell(SWT.CLOSE | SWT.MIN | SWT.RESIZE);
		shlUpdate.setSize(470, 262);
		shlUpdate.setText("Mise a jour");
		
		//creation du label
		Label lblABient = new Label(shlUpdate, SWT.NONE);
		lblABient.setText("Mise a jour reussite");
		lblABient.setBounds(130, 68, 160, 35);
		
		//creation boutton
		Button btnRevenirLC = new Button(shlUpdate, SWT.NONE);
		//action a faire en cliquant sur le boutton
		btnRevenirLC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(shlUpdate, ListClientsController.class);
			}
		});
		
		btnRevenirLC.setBounds(100, 105, 230, 35);
		btnRevenirLC.setText("Revenir \u00E0 la liste des Clients");
		
		Button btnRevenirLCM = new Button(shlUpdate, SWT.NONE);
		btnRevenirLCM.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(shlUpdate, ListCommandesController.class);
			}
		});
		btnRevenirLCM.setBounds(80, 150, 280, 35);
		btnRevenirLCM.setText("Revenir \u00E0 la liste des Commandes");


	}

}
