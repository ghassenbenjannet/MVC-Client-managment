package fc.Application.MVC.Model;

public class Model
{
	public Client[] m_Clients;
	public Commandes[] m_Commandes ;
	
	//declaration d'un model
	private static Model s_Model = null;
	public static Model getModel()
	{
		if (s_Model == null)
		{
			Model m =  new Model();
			m.m_Clients = new Client[] {
					new Client("Laptop",1,10,400,0,"Imen","Ben Sassi","BenSassi_Imen@gmail.com"),
					new Client("Tablette",2,1,0,1,"Ghassen","Ben Jannet","Ghassen_BenJannet@gmail.fr"),
			};
			
			m.m_Commandes = new Commandes[] {
					new Commandes("Laptop",500,10,125),
					new Commandes("Tablette",2,1,0),
		};
			
			s_Model = m;
		}
		
    
	
		return s_Model;
	}
}
