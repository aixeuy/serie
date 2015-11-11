package tournament;
class team
{
  String name;
  player p=new player();
  player[] member={p,p,p,p,p,p,p,p,p,p,p};
  int score;
  int round;
  int goal;
  int fan;
  int igoal;
    int cupgoal;
    int cupgamegoal;
    int cupid;
    int icontrol;
    int ishoot;
    int isshoot;
  public team()
  {
  }
  public void add(player p,int i)
  {
    member[i]=p;
  }
  public String getinf()
  {
    String s="";
    for(int j=0;j<11;j++)
    {
      s=s+member[j].getinf();
      //s=s+"\n";
    }
    s=s+"score "+score+" goal "+goal+" number of fans "+fan;
    return s;
  }
    public void arrange(){
        for(int i=1;i<4;i++){
            for(int j=i;j<11;j++){
                if(member[i].defence/(member[i].pass+member[i].shoot+0.1)<member[j].defence/(member[j].pass+member[j].shoot+0.1)){
                    player tmp=member[i];
                    member[i]=member[j];
                    member[j]=tmp;
                }
            }
        }
        for(int i=4;i<7;i++){
            for(int j=i;j<11;j++){
                if(member[i].pass/(member[i].shoot+0.1)<member[j].pass/(member[j].shoot+0.1)){
                    player tmp=member[i];
                    member[i]=member[j];
                    member[j]=tmp;
                }
            }
        }
        rearrange();
    }
    public void rearrange(){
        int i=(int)(Math.random()*3)+1;
        int j=(int)(Math.random()*10)+1;
        if(member[i].defence/(member[i].shoot+member[i].pass+0.1)<member[j].defence/(member[j].shoot+member[j].pass+0.1)){
            player tmp=member[i];
            member[i]=member[j];
            member[j]=tmp;
        }

        i=(int)(Math.random()*3)+4;
        j=(int)(Math.random()*10)+1;
        if(member[i].pass/(member[i].shoot+member[i].defence+0.1)<member[j].pass/(member[j].shoot+member[j].defence+0.1)){
            player tmp=member[i];
            member[i]=member[j];
            member[j]=tmp;
        }

        i=(int)(Math.random()*4)+7;
        j=(int)(Math.random()*10)+1;
        if(member[i].shoot/(member[i].pass+member[i].defence+0.1)<member[j].shoot/(member[j].pass+member[j].defence+0.1)){
            player tmp=member[i];
            member[i]=member[j];
            member[j]=tmp;
        }
    }
    public void printFormation(){
        System.out.println(name);
        System.out.println(member[0].name);
        System.out.println(member[1].name+"/"+member[2].name+"/"+member[3].name);
        System.out.println(member[4].name+"/"+member[5].name+"/"+member[6].name);
        System.out.println(member[7].name+"/"+member[8].name+"/"+member[9].name+"/"+member[10].name);
    }
    public player randomp(int pos){//0:b;1:m;2:f
        int i;
        switch (pos){
            case 0:
                i=(int)(Math.random()*13)+1;
                if(i>10){
                    i-=10;
                }
                return member[i];
            case 1:
                i=(int)(Math.random()*13)+1;
                if(i>10){
                    i-=7;
                }
                return member[i];
            case 2:
                i=(int)(Math.random()*14)+1;
                if(i>10){
                    i-=4;
                }
                return member[i];
            default:
                return null;
        }
    }
    public void setZeroBM(){
        icontrol=0;
        ishoot=0;
        isshoot=0;
        for(player p:member){
            p.ipass=0;
            p.ispass=0;
            p.itackle=0;
            p.istackle=0;
            p.ishoot=0;
            p.isshoot=0;
            p.iassist=0;
            p.igoal=0;
        }
    }
}