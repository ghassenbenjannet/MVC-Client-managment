package fc.Application.MVC.Views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import fc.Application.MVC.Controllers.EditClientController;
import fc.Application.MVC.Controllers.ListClientsController;
import fc.Application.MVC.Model.Client;
import fc.Application.MVC.Controllers.ListCommandesController;

public class DemarrageView extends Dialog {

	protected Object result;
	protected Shell shlDemarrage;
	private Table table;

	protected Client[] getViewModel()
	{
		if (m_Infrastructure != null)
			return (Client[])m_Infrastructure.m_ViewModel;
		else
			return new Client[0];
	}
	
	
	
	
	public RunController m_Infrastructure;
	

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DemarrageView(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDemarrage.open();
		shlDemarrage.layout();
		Display display = getParent().getDisplay();
		while (!shlDemarrage.isDisposed()) {
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
		shlDemarrage = new Shell(SWT.CLOSE | SWT.MIN | SWT.RESIZE);
		shlDemarrage.setSize(730, 580);
		shlDemarrage.setText("Détail du Client");
		
		//creation d'une etiquette
		Label lblClients = new Label(shlDemarrage, SWT.NONE);
		lblClients.setBounds(20, 30, 65, 35);
		lblClients.setText("Clients : ");
		
		//creation d'une liste déroulante
		Combo combo = new Combo(shlDemarrage, SWT.BORDER | SWT.READ_ONLY);
		Client[] Clients = getViewModel();
		for (Client Client : Clients)
		{		
			combo.add(""+Client.m_Nom);
		}
		combo.setBounds(20, 65, 65, 35);
		combo.setSize(460,41);
		int a = combo.getSelectionIndex();
		
		//lorsqu'on selectionne une variable de la liste
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(a);
			}
		});
		
		//creation du tableau
		table = new Table(shlDemarrage, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(25, 130, 650, 300);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//remplissage d'une colonne
		TableColumn tcId = new TableColumn(table, SWT.NONE);
		tcId.setWidth(130);
		tcId.setText("Column 1");
		
		TableColumn tcNom = new TableColumn(table, SWT.NONE);
		tcNom.setWidth(130);
		tcNom.setText("Column 2");
		
		//afficher les commandes du clients dans le tableau
		if (a!=-1) {
		TableItem item = new TableItem(table, SWT.NONE);
	    item.setText(new String[] { ""+Clients[a].m_Produit});
		};
		 
		//creation d'un boutton
		Button btnRevenirLa = new Button(shlDemarrage, SWT.NONE);
		btnRevenirLa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(shlDemarrage, ListCommandesController.class);
			}
		});
		//grandeur setbounds(x,y,largeur,hauteur)
		btnRevenirLa.setBounds(440, 460, 240, 35);
		btnRevenirLa.setText("Voir detail Commande");

		//evennement en cliquant sur le bouton
		Button btnEditer = new Button(shlDemarrage, SWT.NONE);
		btnEditer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(shlDemarrage, EditClientController.class);
			}
		});
		
		btnEditer.setBounds(580, 65, 100, 35);
		btnEditer.setText("Editer");
		
		
	}
}

