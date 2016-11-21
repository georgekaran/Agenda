package agenda.apresentacao;

import java.util.ArrayList;
import agenda.negocio.AgendaPadrao;
import agenda.negocio.Compromisso;
import pilar.Data;
import pilar.Entrada;
import pilar.menu2.Menu;
import pilar.menu2.MenuItem;
import pilar.menu2.MenuItemAction;

public class TelaMenu
{

    private AgendaPadrao agenda;

    public TelaMenu(AgendaPadrao agenda)
    {
        this.agenda = agenda;
        this.agenda.ler();
    }

    public void exibir()
    {
        Menu m = new Menu();

        m.adicionar(new MenuItem('1', "Cadastrar", new MenuItemAction()
        {
            @Override
            public void executar()
            {
                String dt = Entrada.leiaString("Data");
                String desc = Entrada.leiaString("Descrição");

                Compromisso c = new Compromisso(new Data(dt), desc);
                agenda.adicionar(c);
            }
        }));

        m.adicionar(new MenuItem('2', "Deletar compromisso", new MenuItemAction()
        {
            @Override
            public void executar()
            {
                int p = Entrada.leiaInt("Informe número do compromisso a ser deletado");
                agenda.excluir(p - 1);
            }
        }));

        m.adicionar(new MenuItem('3', "Listar todos os compromissos", new MenuItemAction()
        {
            @Override
            public void executar()
            {
                if (agenda.obterQuantidadeCompromissos() > 0)
                {
                    ArrayList<Compromisso> compromissos = agenda.obterCompromissos();

                    Data dt = compromissos.get(0).getData();
                    System.out.println("***** " + dt.getDataFormatada(1));
                    int i = 0;
                    for (Compromisso compromisso : compromissos)
                    {
                        i++;
                        if (compromisso.getData().equals(dt))
                        {
                            System.out.println(i + ": " + compromisso.getDescrição());
                        } else
                        {
                            System.out.println("");
                            dt = compromisso.getData();
                            System.out.println("***** " + dt.getDataFormatada(1));
                            System.out.println(i + ": " + compromisso.getDescrição());
                        }
                    }
                }
            }
        }));

        m.adicionar(new MenuItem('4', "Listar compromissos entre duas datas", new MenuItemAction()
        {
            @Override
            public void executar()
            {
                String dti = Entrada.leiaString("Data inicial");
                String dtf = Entrada.leiaString("Data final");

                Data dtInicial = new Data(dti);
                Data dtFinal = new Data(dtf);
                System.out.println("Data inicial..: " + dtInicial.getDataFormatada(1));
                System.out.println("Data final....: " + dtFinal.getDataFormatada(1));
                System.out.println("");

                ArrayList<Compromisso> compromissos = agenda.obterCompromissos(dtInicial, dtFinal);
                int i = 0;
                for (Compromisso compromisso : compromissos)
                {
                    i++;
                    System.out.println(i + ": " + compromisso);
                }
            }
        }));

        m.adicionar(new MenuItem('5', "Sair", new MenuItemAction()
        {
            @Override
            public void executar()
            {
                agenda.salvar();
                System.exit(0);
            }
        }));

        m.gerar();
    }

    
}
