package fc.Application.MVC.Controllers;

public class UpdateClientController extends Controller
{
	@Override
	public ActionResult run(Object ... args)
	{
		Integer Num = (Integer)args[0];
		String nom = (String)args[1];
		String prenom = (String)args[2];
		
		m_Model.m_Clients[Num].m_Nom = nom;
		m_Model.m_Clients[Num].m_Prenom = prenom;
		
		return View(Num);
	}
}
