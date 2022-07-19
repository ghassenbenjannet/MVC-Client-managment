package fc.Application.MVC.Model;

public class Commandes
{
	public String m_Produit;
	public int m_Quantite;
	public int m_PrixUnitaire;
	public int m_Discount ;
	
	//creation du constructeur de commandes
	public Commandes(String Produit, int Quantite, int PrixUnitaire, int Discount)
	{
		m_Produit = Produit;
		m_Quantite = Quantite;
		m_PrixUnitaire = PrixUnitaire;
		m_Discount = Discount ;
	}
}
