/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.persistencia;

import agenda.negocio.Agenda;

/**
 *
 * @author mouriac
 */
public interface AgendaDao
{
    public void salvar(Agenda agenda);
    public void ler(Agenda agenda);
}
