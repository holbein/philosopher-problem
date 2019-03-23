class Tisch
{

    boolean[] istInGebrauch;
    int anzahl;
    
    Tisch (int anzahl)
    {
        istInGebrauch = new boolean[anzahl];
        this.anzahl = anzahl;
        for(int i = 0; i < anzahl; i++)
        {
            istInGebrauch[i] = false;
        }
    }
    
    private int linkesGeben(int nr){
        return nr;
    }
    
    private int rechtesGeben(int nr){
        if(nr == anzahl-1){
            return 0;
        }else{
            return nr+1;
        }
    }
    
    synchronized public void stäbchenNehmen(int nr){
        if(istInGebrauch[linkesGeben(nr)] || istInGebrauch[rechtesGeben(nr)]){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        istInGebrauch[linkesGeben(nr)] = true;
        istInGebrauch[rechtesGeben(nr)] = true;
        
        System.out.println("Philosoph Nr."+nr+" fängt an zu essen!"+" "+linkesGeben(nr)+"/"+rechtesGeben(nr));
    }
    
    synchronized public void stäbchenZurückgeben(int nr){
        istInGebrauch[linkesGeben(nr)] = false;
        istInGebrauch[rechtesGeben(nr)] = false;
        
        System.out.println("Philosoph Nr."+nr+" ist fertig mit essen!"+" -"+nr+"/-"+(nr+1));
        
        notify();
    }
}
