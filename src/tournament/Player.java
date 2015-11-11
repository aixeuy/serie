package tournament;

class player
{
  String name;
  int shoot;
  int pass;
  int defence;
  int goal;
  int assist;
  int save;
  int score;
  String team;
  int iscore;
    int ipass;
    int ispass;
    int itackle;
    int istackle;
    int ishoot;
    int isshoot;
    int iassist;
    int igoal;

  public player()
  {
  }
  public double getscore()
  {
    return score/10.0;
  }
  public String getinf()
  {
    String s="";
    String t="";
    s=s+name;
    for(int j=0;j<15-name.length();j++)
    {
      s=s+" ";
    }
    s=s+goal;
    for(int j=0;j<6-(t+goal).length();j++)
    {
      s=s+" ";
     }
    s=s+assist;
    for(int j=0;j<6-(t+assist).length();j++)
    {
      s=s+" ";
    }
    s=s+score*0.1;
    s=s+"\n";
    return s;
  }
}