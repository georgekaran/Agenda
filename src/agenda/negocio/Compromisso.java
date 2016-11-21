package agenda.negocio;

import pilar.Data;

public class Compromisso implements Comparable<Compromisso>
{
    private Data data;
    private String descrição;

    public Compromisso(Data data, String descrição)
    {
        this.data = data;
        this.descrição = descrição;
    }

    public String getDescrição()
    {
        return descrição;
    }

    public void setDescrição(String descrição)
    {
        this.descrição = descrição;
    }

    public Data getData()
    {
        return data;
    }

    public void setData(Data data)
    {
        if (data != null)
        {
            this.data = data;
        }
    }
   
    public String toString()  
    {
        return this.data.getDataFormatada(1) + " -> " + this.descrição;
    }

    @Override
    public int compareTo(Compromisso outro)
    {
        Data d1 = this.getData();
        Data d2 = outro.getData();
        
        int r = d1.compareTo(d2);
        
        return r;
    }


    
   
}
