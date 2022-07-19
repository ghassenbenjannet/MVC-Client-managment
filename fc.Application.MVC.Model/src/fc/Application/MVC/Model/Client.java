package fc.Application.MVC.Model;

//la classe hérite de la classe commandes
public class Client extends Commandes
{
	public int m_Id;
	public String m_Nom;
	public String m_Prenom;
	public String m_Email ;
	
	//creation du constructeur de client
	public Client(String Produit, int Quantite, int PrixUnitaire, int Discount,
			int id, String Nom, String Prenom, String Email)
	{
		super(Produit,Quantite,PrixUnitaire,Discount);
		m_Id = id;
		m_Nom = Nom;
		m_Prenom = Prenom;
		m_Email = Email ;
	}
	
	
}
