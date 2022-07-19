package fc.Application.MVC.Controllers;

import fc.Application.MVC.Model.Commandes;

public class ListCommandesController extends Controller
{
	//contreolleur de la vue de la liste de commandes
	@Override
	public ActionResult run(Object ... args)
	{
		Commandes[] Commandes = m_Model.m_Commandes;
		
		return View(Commandes);
	}
}
