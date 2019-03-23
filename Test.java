
class Test
{
    int anzahl;
    Philosoph[] philosophen;
    Tisch tisch;
    
    Test (int anzPhilosophen)
    {
        this.anzahl = anzPhilosophen;
        
        tisch = new Tisch(anzahl);
        philosophen = new Philosoph[anzahl];
        
        for(int i = 0; i < anzahl; i++)
        {
            philosophen[i] = new Philosoph(i, tisch);
        }
    }
    
    public void eat()
    {
        for(int i = 0; i < anzahl; i++)
        {
            philosophen[i].start();
        }
    }
}
