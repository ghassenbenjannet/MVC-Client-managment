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

import fc.Application.MVC.ViewModels.MovieViewModel;
import fc.Application.MVC.Controllers.DemarrageController;

public class ListClientsView extends Dialog {

	protected Object result;
	protected Shell shlListeDesFilms;
	private Table table;
	
	public RunController m_Infrastructure;
	
	protected MovieViewModel[] getViewModel()
	{
		if (m_Infrastructure != null)
			return (MovieViewModel[])m_Infrastructure.m_ViewModel;
		else
			return new MovieViewModel[0];
	}
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ListClientsView(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlListeDesFilms.open();
		shlListeDesFilms.layout();
		Display display = getParent().getDisplay();
		while (!shlListeDesFilms.isDisposed()) {
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
		//shlListeDesFilms = new Shell(getParent(), getStyle());
		//shlListeDesFilms.setSize(450, 300);
		shlListeDesFilms = new Shell(SWT.CLOSE | SWT.MIN | SWT.RESIZE);
		shlListeDesFilms.setSize(730, 580);
		shlListeDesFilms.setText("Liste des films");
		
		table = new Table(shlListeDesFilms, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 424, 251);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tcId = new TableColumn(table, SWT.NONE);
		tcId.setWidth(100);
		tcId.setText("Id");
		
		TableColumn tcTitre = new TableColumn(table, SWT.NONE);
		tcTitre.setWidth(100);
		tcTitre.setText("Nom");
		
		TableColumn tcAnnee = new TableColumn(table, SWT.NONE);
		tcAnnee.setWidth(100);
		tcAnnee.setText("Prenom");
		
		MovieViewModel[] movies = getViewModel();
		
		for (MovieViewModel movie : movies)
		{
		    TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { ""+movie.m_Id, movie.m_Nom, ""+movie.m_Prenom });
		}
		
		Button btnRevenirLa = new Button(shlListeDesFilms, SWT.NONE);
		btnRevenirLa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(shlListeDesFilms, DemarrageController.class);
			}
		});
		btnRevenirLa.setBounds(450, 450, 150, 35);
		btnRevenirLa.setText("Revenir");
	}
}
