
class Philosoph extends Thread
{
    int nummer;
    Tisch tisch;
    Philosoph (int nummer, Tisch tisch)
    {
        this.nummer = nummer; 
        this.tisch = tisch;
    }
    
    public void run()
    {
        try
        {
            int i = (int)(Math.random()*1000);
            sleep(i);
        }catch(Exception e){}
        
        tisch.stäbchenNehmen(nummer);
        
        try
        {
            sleep((int)(Math.random()*1000));
        }catch(Exception e){}
        
        tisch.stäbchenZurückgeben(nummer);
    }
}
