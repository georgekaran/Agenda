package agenda.negocio;

import agenda.persistencia.AgendaDao;
import agenda.persistencia.AgendaDaoTxt;
import java.util.ArrayList;
import java.util.Collections;
import pilar.Data;
import pilar.Entrada;

public class Agenda implements AgendaPadrao
{
    private ArrayList<Compromisso> compromissos;

    public Agenda()
    {
        this.compromissos = new ArrayList();
    }

    public void adicionar( Compromisso c )
    {
        compromissos.add(c);
        ordenar();
    }
    
    public void adicionar( Data dt, String descrição )
    {
        Compromisso aux = new Compromisso(dt,descrição);
        compromissos.add(aux);
    }
    
    
    
    public void editar( int posição, Compromisso c )
    {
        if (posição < compromissos.size() && posição >= 0)
        {
            compromissos.set(posição, c);
        }
    }
    
    public void excluir( int posição )
    {
        if (posição < compromissos.size() && posição >= 0)
        {
            compromissos.remove(posição);
        }
    }
    
    public void ordenar()
    {
       Collections.sort(compromissos);
    }
    
    public ArrayList<Compromisso> obterCompromissos( Data data )
    {
        ArrayList<Compromisso> temp = new ArrayList();
        for (Compromisso compromisso : compromissos)
        {
            if (compromisso.getData().equals(data))
            {
                temp.add(compromisso);
            }
        }
        return temp;
    }
    
    public ArrayList<Compromisso> obterCompromissos( Data dataInicial, Data dataFinal )
    {
        ArrayList<Compromisso> temp = new ArrayList();
        for (Compromisso compromisso : compromissos)
        {
            if (compromisso.getData().compareTo(dataInicial) >= 0 &&
                compromisso.getData().compareTo(dataFinal) <= 0 )
            {
                temp.add(compromisso);
            }
        }
        return temp;
    }
    
    public ArrayList<Compromisso> obterCompromissos( String descriçãoParcial ) 
    {
        ArrayList<Compromisso> temp = new ArrayList();
        for (Compromisso compromisso : compromissos)
        {
            if (compromisso.getDescrição().indexOf(descriçãoParcial) >= 0)
            {
                temp.add(compromisso);
            }
        }
        return temp;
    }
    
    public ArrayList<Compromisso> obterCompromissos() 
    {
        return compromissos;
    }
    
    public int obterQuantidadeCompromissos()
    {
        return compromissos.size();
    }
    
    public void salvar()
    {
        AgendaDao ad = new AgendaDaoTxt();
        ad.salvar(this);
    }
    
    public void ler()
    {
        AgendaDao ad = new AgendaDaoTxt();
        ad.ler(this);
    }
    
}
    

