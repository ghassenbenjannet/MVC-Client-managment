package fc.Application.MVC.Controllers;

import fc.Application.MVC.Model.Client;

public class DemarrageController extends Controller
{
	//controlleur de la vue de demarrage
	@Override
	public ActionResult run(Object ... args)
	{
		Client[] Clients = m_Model.m_Clients;
		
		return View(Clients);
	}
}
