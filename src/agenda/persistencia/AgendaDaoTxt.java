/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.persistencia;

import agenda.negocio.Agenda;
import pilar.Arquivo;
import pilar.Data;

/**
 *
 * @author mouriac
 */
public class AgendaDaoTxt implements AgendaDao
{
    Arquivo arquivo = new Arquivo("base.txt");
    @Override
    public void salvar(Agenda agenda)
    {
        arquivo.abrirEscrita();
        for (int i = 0; i < agenda.obterQuantidadeCompromissos(); i++) 
        {
            arquivo.escreverLinha(String.valueOf(agenda.obterCompromissos().get(i)));
        }

        arquivo.fecharArquivo();
    }

    @Override
    public void ler(Agenda agenda)
    {
        String aux = "";
        String[] vet = new String[5];
        int cont = 0;
        if (arquivo.abrirLeitura())
        {
            
            String linha = arquivo.lerLinha();
            while (linha != null)
            {
                aux = linha;
                agenda.adicionar(new Data(aux.substring(0, 10)), aux.substring(14, aux.length()));
                cont++;
                linha = arquivo.lerLinha();
            }
            arquivo.fecharArquivo();
        }
    }
    
}
