package agenda.negocio;

import java.util.ArrayList;
import pilar.Data;

public interface AgendaPadrao
{
    public void adicionar( Compromisso c );
    public void adicionar( Data dt, String descrição );
    public void editar( int posição, Compromisso c );
    public void excluir( int posição );
    public void ordenar();
    public ArrayList<Compromisso> obterCompromissos( Data data );
    public ArrayList<Compromisso> obterCompromissos( Data dataInicial, Data dataFinal );
    public ArrayList<Compromisso> obterCompromissos( String descriçãoParcial );
    public ArrayList<Compromisso> obterCompromissos();
    public int obterQuantidadeCompromissos();
    public void ler();
    public void salvar();
}
