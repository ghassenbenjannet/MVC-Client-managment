package fc.Application.MVC.Views;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import fc.Application.MVC.Controllers.DemarrageController;
import fc.Application.MVC.Model.Commandes;

public class ListCommandesView extends Dialog {

	protected Object result;
	protected Shell shlListeDesCommandes;
	private Table table;
	
	public RunController m_Infrastructure;
	
	protected Commandes[] getViewModel()
	{
		if (m_Infrastructure != null)
			return (Commandes[])m_Infrastructure.m_ViewModel;
		else
			return new Commandes[0];
	}
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ListCommandesView(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlListeDesCommandes.open();
		shlListeDesCommandes.layout();
		Display display = getParent().getDisplay();
		while (!shlListeDesCommandes.isDisposed()) {
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
		//shlListeDesCommandes = new Shell(SWT.CLOSE | SWT.MIN | SWT.RESIZE);
		//shlListeDesCommandes.setSize(680, 550);
		shlListeDesCommandes = new Shell(SWT.CLOSE | SWT.MIN | SWT.RESIZE);
		shlListeDesCommandes.setSize(730, 580);
		shlListeDesCommandes.setText("Liste des Commandess");
		
		//creation d'un tableau
		table = new Table(shlListeDesCommandes, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(60, 60, 560, 360);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//titre colonne
		TableColumn tcProduit = new TableColumn(table, SWT.NONE);
		tcProduit.setWidth(150);
		tcProduit.setText("Produit");
		
		TableColumn tcQuantite = new TableColumn(table, SWT.NONE);
		tcQuantite.setWidth(100);
		tcQuantite.setText("Quantite");
		
		TableColumn tcPrixUnitaire = new TableColumn(table, SWT.NONE);
		tcPrixUnitaire.setWidth(120);
		tcPrixUnitaire.setText("PrixUnitaire");
		
		TableColumn tcDiscount = new TableColumn(table, SWT.NONE);
		tcDiscount.setWidth(100);
		tcDiscount.setText("Discount");
		
		Commandes[] Commandess = getViewModel();
		//remplissage tableau 
		for (Commandes Commandes : Commandess)
		{
		    TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { ""+Commandes.m_Produit, ""+Commandes.m_Quantite, ""+Commandes.m_PrixUnitaire, ""+Commandes.m_Discount });
		}
		
		//evennement et resultats après avoir cliquer sur le bouton
		//diriger vers le Demarrage View
		Button btnRevenirLa = new Button(shlListeDesCommandes, SWT.NONE);
		btnRevenirLa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(shlListeDesCommandes, DemarrageController.class);
			}
		});
		btnRevenirLa.setBounds(450, 450, 150, 35);
		btnRevenirLa.setText("Revenir");
	}
}
