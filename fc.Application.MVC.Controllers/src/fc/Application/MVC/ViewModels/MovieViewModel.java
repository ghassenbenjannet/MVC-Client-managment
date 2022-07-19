package fc.Application.MVC.ViewModels;

public class MovieViewModel
{
	public int m_Id;
	public String m_Nom;
	public String m_Prenom;
	
	public MovieViewModel(int id, String Nom, String prenom)
	{
		m_Id = id;
		m_Nom = Nom;
		m_Prenom = prenom;
	}
}
