package fc.Application.MVC.Views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import fc.Application.MVC.ViewModels.MovieViewModel;


import fc.Application.MVC.Controllers.UpdateClientController;
import fc.Application.MVC.Controllers.ListClientsController;
import fc.Application.MVC.Model.Client;

public class EditClientView extends Dialog {

	protected Object result;
	protected Shell shlEditClient;
	private Text txtNom;
	private Text txtPrenom;
	private Text txtEmail; 
	
	public RunController m_Infrastructure;
	protected MovieViewModel getViewModel()
	{
		return (MovieViewModel)m_Infrastructure.m_ViewModel;
	}

	
	
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public EditClientView(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlEditClient.open();
		shlEditClient.layout();
		Display display = getParent().getDisplay();
		while (!shlEditClient.isDisposed()) {
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
		shlEditClient = new Shell(SWT.CLOSE | SWT.MIN | SWT.RESIZE);
		shlEditClient.setSize(520, 350);
		shlEditClient.setText("Détail du Client");
		
		//creation du bouton
		Button btnMAJ = new Button(shlEditClient, SWT.NONE);
		btnMAJ.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//<onclick="/Update/Client/<id>?nouveauNom,nouveauPrenom,nouveauEmail">
				//la mise à jour dans le tableau des listes des clients
				String nouveauNom = txtNom.getText();
				String nouveauPrenom = txtPrenom.getText();
				String nouveauEmail = txtEmail.getText();
				m_Infrastructure.runController(shlEditClient, UpdateClientController.class, getViewModel().m_Id, nouveauNom, nouveauPrenom, nouveauEmail);
			}
		});
		
		btnMAJ.setBounds(10, 130, 120, 35);
		btnMAJ.setText("Mettre à jour");
		
		//zone texte
		txtNom = new Text(shlEditClient, SWT.BORDER);
		txtNom.setBounds(90, 15, 96, 31);
		txtNom.setText(getViewModel().m_Nom);
		
		txtPrenom = new Text(shlEditClient, SWT.BORDER);
		txtPrenom.setBounds(90, 55, 96, 31);
		txtPrenom.setText("" + getViewModel().m_Prenom);
		
		txtEmail = new Text(shlEditClient, SWT.BORDER);
		txtEmail.setBounds(90, 90, 200, 31);
		txtEmail.setText("");
		
		//creation de label et modification de grandeur et texte
		Label lblNom = new Label(shlEditClient, SWT.NONE);
		lblNom.setBounds(20, 15, 55, 35);
		lblNom.setText("Nom");
		
		Label lblPrenom = new Label(shlEditClient, SWT.NONE);
		lblPrenom.setBounds(20, 55, 65, 35);
		lblPrenom.setText("Prenom");
		
		Label lblEmail = new Label(shlEditClient, SWT.NONE);
		lblEmail.setBounds(20, 90, 65, 35);
		lblEmail.setText("Hash");
		
		//creation de bouton
		Button btnRevenirLa = new Button(shlEditClient, SWT.NONE);
		btnRevenirLa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(shlEditClient, ListClientsController.class);
			}
		});
		btnRevenirLa.setBounds(300, 200, 150, 35);
		btnRevenirLa.setText("liste des Clients");

	}
}

