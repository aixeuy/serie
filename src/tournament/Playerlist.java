package tournament;
class playerlist
{
  player[] p;
  public playerlist()
  {
    p=new player[132];
  }
  public void generatelist(team[] t)
  {
    for(int i=0;i<12;i++)
    {
      for(int j=0;j<11;j++)
      {
        p[11*i+j]=t[i].member[j];
      }
    }
  }
  public void sort(boolean a,boolean b)
//tt:goal   ft:saaist    ff:score
  {
    if(a)//goal
    {
      int min=0; player temp=new player();
      for(int i=0;i<88;i++)
      {
        min=i;
        for (int j=i+1;j<88;j++){
          if(p[j].goal>p[i].goal)
          {
            temp=p[i];
            p[i]=p[j];
            p[j]=temp;
          }
        }
      }
    }
    else if(b)//assist
    {
      int min=0; player temp=new player();
      for(int i=0;i<88;i++)
      {
        min=i;
        for (int j=i+1;j<88;j++){
          if(p[j].assist>p[i].assist)
          {
            temp=p[i];
            p[i]=p[j];
            p[j]=temp;
          }
        }
      }
    }
    else//score
    {
      int min=0; player temp=new player();
      for(int i=0;i<88;i++)
      {
        min=i;
        for (int j=i+1;j<88;j++){
          if(p[j].score>p[i].score)
          {
            temp=p[i];
            p[i]=p[j];
            p[j]=temp;
          }
        }
      }
    }
  }
  //tt:goal   ft:saaist    ff:score
  public String getlist(boolean a,boolean b)
  {
    String s="";
    if(a)//goal
    {
      s=s+"name           goal   team\n";
      for(int i=0;i<10;i++)
      {
        s=s+p[i].name;
        for(int j=0;j<15-p[i].name.length();j++)
        {
          s=s+" ";
        }
        s=s+p[i].goal;
        s=s+"      "+p[i].team+"\n";
      }
      return s;
    }
    else if(b)//assist
    {
      s=s+"name           assist team\n";
      for(int i=0;i<10;i++)
      {
        s=s+p[i].name;
        for(int j=0;j<15-p[i].name.length();j++)
        {
          s=s+" ";
        }
        s=s+p[i].assist;
        s=s+"      "+p[i].team+"\n";
      }
      return s;
    }
    else//score
    {
      s=s+"name           score  team\n";
      for(int i=0;i<10;i++)
      {
        s=s+p[i].name;
        for(int j=0;j<15-p[i].name.length();j++)
        {
          s=s+" ";
        }
        s=s+p[i].score/100.0;
        s=s+"      "+p[i].team+"\n";
      }
      return s;
    }
  }
  public player findplayer(String s)
 {
   for(int i=131;i>-1;i--)
   {
     if(p[i].name.equals(s))
     {
       return p[i];
     }
     else
     {
       continue;
     }
   }
   System.out.println("can't find");
   return null;
 }
  public void set0()
 {
   for(int i=0;i<132;i++)
   {
     p[i].score=0;
     p[i].assist=0;
     p[i].goal=0;
   }
 }
}