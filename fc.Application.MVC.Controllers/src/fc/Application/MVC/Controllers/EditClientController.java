package fc.Application.MVC.Controllers;

import fc.Application.MVC.ViewModels.MovieViewModel;
import fc.Application.MVC.Model.Client;

public class EditClientController extends Controller
{
	@Override
	public ActionResult run(Object ... args)
	{
		Integer clientId = (Integer)args[0];
		
		Client Client = m_Model.m_Clients[clientId];		
		MovieViewModel movieViewModel = new MovieViewModel(Client.m_Id, Client.m_Nom, Client.m_Prenom);
		
		return View(movieViewModel);
	}
}
