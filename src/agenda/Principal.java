package agenda;



import agenda.apresentacao.TelaMenu;
import agenda.negocio.Agenda;
import agenda.negocio.AgendaPadrao;


public class Principal
{

    public static void main(String[] args)
    {
        Agenda a = new Agenda();
        
        TelaMenu tela = new TelaMenu(a);
        tela.exibir();
        
        System.exit(0);
                
    }
}
