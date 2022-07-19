package fc.Application.MVC.Controllers;

import fc.Application.MVC.Model.Client;
import fc.Application.MVC.ViewModels.MovieViewModel;

public class ListClientsController extends Controller
{
	@Override
	public ActionResult run(Object ... args)
	{
		Client[] movies = m_Model.m_Clients;
		
		MovieViewModel[] movieViewModel = new MovieViewModel[movies.length]; // (movie.m_Id, movie.m_Title, movie.m_Year);

		for (int i=0; i < movies.length; i++)
		{
			Client movie = movies[i];
			movieViewModel[i] = new MovieViewModel(movie.m_Id, movie.m_Nom, movie.m_Prenom);
		}
		
		return View(movieViewModel);
	}
}
