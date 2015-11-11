package tournament;

import java.io.*;
class tournament
{
  public static teamlist tl=new teamlist(1,1);
  public static playerlist pl=new playerlist();
  public static void main(String[] args)
  { 
    readteam();
    readplayer();
    tl.generatera();
    pl.generatelist(tl.ca);

      //tl.changefan();
      /*tl.round=1;
      tl.game=1;
      tl.regroup();
      pl.set0();
      tl.set0();

      writeteam();*/

      /*tl.round=14;
      tl.game=5;*/

    run();
    //if (round==14)
    //{
      //write file to perm(true)
    //}
    //else
    //{
      //write file to temp and inseason
    //rearrange
    writeplayer();
    writeteam();
    //}
  }
  /////////////////////////////////////////////////////////////////////////////////////operator///////////////////////////////////////////////////////
  public static void run()
  {
    System.out.println("1.play next game");
    System.out.println("2.view tournament standing");
    System.out.println("3.view personal standing");
      System.out.println("4.view cup standing");
      System.out.println("5.view second division standing");
    System.out.println("6.view team information");
    System.out.println("7.view personal information");
    System.out.println("8.exit");
    System.out.println("9.next season");
    java.util.Scanner ff=new java.util.Scanner(System.in);
    try{int reply=ff.nextInt();
    String reply2;
      switch(reply)
      {
        case 1: 
        {
          if(tl.round==0)
          {
            System.out.println("season ends");
          }
          else
          {
            team a=tl.chooseteam(tl.round,tl.game,true);
            team b=tl.chooseteam(tl.round,tl.game,false);
              a.arrange();
              b.arrange();
              a.printFormation();
              b.printFormation();
              a.setZeroBM();
              b.setZeroBM();
            tl.playnextgame();
            writegamerecord(a,b);
            writeplayer();
            writeteam();
            run();
            break;
          }
        }
        case 2: 
        {
          //print team rank
          tl.generatera();
          System.out.println(tl.returnrank());
          run();
            break;
        }
        case 3: 
        {
          //print score assist mark
          pl.sort(true,true);
          System.out.println(pl.getlist(true,true));
          pl.sort(false,true);
          System.out.println(pl.getlist(false,true));
          pl.sort(false,false);
          System.out.println(pl.getlist(false,false));
          run();
          break;          
        }
        case 4:{
            for(team t:tl.cu){
                System.out.println(t.name+"    total: "+t.cupgoal+" first round: "+(t.cupgamegoal-1));
            }
            run();
            break;
        }
          case 5:{
              tl.generatera();
              System.out.println(tl.returnSecondRank());
              run();
              break;
          }
        case 6:
        {
          //print team inf
          System.out.println("enter team name");
          java.util.Scanner f=new java.util.Scanner(System.in);
          reply2=f.nextLine();
          System.out.println("player       goal assist score");
          System.out.println(tl.findteam(reply2).getinf());
          run();
          break;
        }
        case 7:
        {
          //print player inf
          System.out.println("enter player name");
          java.util.Scanner f=new java.util.Scanner(System.in);
          reply2=f.nextLine();
          System.out.println("player       goal assist score");
          System.out.print(pl.findplayer(reply2).getinf());
          System.out.println("now in "+pl.findplayer(reply2).team);
          run();
          break;
        }
        case 8:
        {
          //exit
          
          break;
        }
        case 9:
        {
          //new season set 0 write history
          System.out.println("are you sure to end this season");
          System.out.println("0.yes");
          System.out.println("1.no");
          reply=ff.nextInt();
          if(reply==0)
          {
          tl.changefan();
          writehistory();
          tl.round=1;
          tl.game=1;
          tl.year++;
          tl.regroup();
          pl.set0();
          tl.set0();
              writeteam();
              writeplayer();
          }
          run();
          break;
        }
        default:break;
      }
      }catch(Exception ee){ System.out.println(ee);run();}
    //}
  }
  //////////////////////////////////////////////////////////////////////////////////////////read/////////////////////////////////////////////////////////////////////////////
  public static void readteam(){
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("team.txt"));
            String s;
            team t;
            for(int i=0;i<12;i++)
            {
              t=new team();
              s = br.readLine();
              t.name=s;
              s = br.readLine();
              t.score=toint(s);
              s = br.readLine();
              t.round=toint(s);
              s = br.readLine();
              t.goal=toint(s);
              s = br.readLine();
              t.fan=toint(s);
                s = br.readLine();
                t.cupgoal=toint(s);
                s = br.readLine();
                t.cupgamegoal=toint(s);
                s = br.readLine();
                t.cupid=toint(s);
              tl.ca[i]=t;
                //System.out.println(t.name);
              }
            s = br.readLine();
            tl.round=toint(s);
            s = br.readLine();
            tl.game=toint(s);
            s = br.readLine();
            tl.year=toint(s);
            br.close();            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
  public static void readplayer(){
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("player.txt"));
            String s;
            player p;
            for(int i=0;i<12;i++)
            {
              for(int j=0;j<11;j++)
              {
                p=new player();
                s = br.readLine();
                p.name=s;
                s = br.readLine();
                p.shoot=toint(s);
                s = br.readLine();
                p.pass=toint(s);
                s = br.readLine();
                p.defence=toint(s);
                s = br.readLine();
                p.goal=toint(s);
                s = br.readLine();
                p.assist=toint(s);
                s = br.readLine();
                p.save=toint(s);
                s = br.readLine();
                p.score=toint(s);
                s = br.readLine();
                p.team=s;
                tl.ca[i].add(p,j);
                p.team=tl.ca[i].name;
              }
            }

            br.close();            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
  /////////////////////////////////////////////////////////////////////////////////////////write////////////////////////////////////////////////////////////////
  public static void writeplayer()
  {
     try
        {
          BufferedWriter bw = new BufferedWriter(new FileWriter("player.txt"));
          for(int i=0;i<12;i++)
          {
            for(int j=0;j<11;j++)
            {
              bw.write(tl.ca[i].member[j].name);
              bw.newLine();
              bw.write(tostring(tl.ca[i].member[j].shoot));
              bw.newLine();
              bw.write(tostring(tl.ca[i].member[j].pass));
              bw.newLine();
              bw.write(tostring(tl.ca[i].member[j].defence));
              bw.newLine();
              bw.write(tostring(tl.ca[i].member[j].goal));
              bw.newLine();
              bw.write(tostring(tl.ca[i].member[j].assist));
              bw.newLine();
              bw.write(tostring(tl.ca[i].member[j].save));
              bw.newLine();
              bw.write(tostring(tl.ca[i].member[j].score));
              bw.newLine();
              bw.write(tl.ca[i].member[j].team);
              bw.newLine();
            }
          }
          bw.close();
        }
        
        catch(Exception ee){
            System.out.println(ee);
        }
  }
  public static void writeteam()
  {
    try
        {
          BufferedWriter bw = new BufferedWriter(new FileWriter("team.txt"));
           for(int i=0;i<12;i++)
            {
              bw.write(tl.ca[i].name);
              bw.newLine();
              bw.write(tostring(tl.ca[i].score));
              bw.newLine();
              bw.write(tostring(tl.ca[i].round));
              bw.newLine();
              bw.write(tostring(tl.ca[i].goal));
              bw.newLine();
              bw.write(tostring(tl.ca[i].fan));
              bw.newLine();
                bw.write(tostring(tl.ca[i].cupgoal));
                bw.newLine();
                bw.write(tostring(tl.ca[i].cupgamegoal));
                bw.newLine();
                bw.write(tostring(tl.ca[i].cupid));
                bw.newLine();
            }
           bw.write(tostring(tl.round));
           bw.newLine();
           bw.write(tostring(tl.game));
           bw.newLine();
           bw.write(tostring(tl.year));
           bw.newLine();
           bw.close();
        }
        
        catch(Exception ee){
            System.out.println(ee);
        }
  }
  public static void writehistory()
  {
    try
        {
          BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt",true));
          bw.write (tostring(tl.year));
          bw.newLine();
          bw.write ("team      round score goal  fan");
          bw.newLine();
          for(int i=0;i<12;i++)
          {
            String s="";
            s=s+tl.ra[i].name;
            for(int j=0;j<10-tl.ra[i].name.length();j++)
            {
              s=s+" ";
            }
            s=s+tl.ra[i].round;
            for(int j=0;j<6-(""+tl.ra[i].round).length();j++)
            {
              s=s+" ";
            }
            s=s+tl.ra[i].score;
            for(int j=0;j<6-(""+tl.ra[i].score).length();j++)
            {
              s=s+" ";
            }
            s=s+tl.ra[i].goal;
            for(int j=0;j<6-(""+tl.ra[i].goal).length();j++)
            {
              s=s+" ";
            }
            s=s+tl.ra[i].fan;
            bw.write (s);
            bw.newLine();
          }
          pl.sort(true,true);
          bw.write ("name           goal   team");
          bw.newLine();
          for(int i=0;i<10;i++)
          {
            String s="";
            s=s+pl.p[i].name;
            for(int j=0;j<15-pl.p[i].name.length();j++)
            {
              s=s+" ";
            }
            s=s+pl.p[i].goal;
            s=s+"      "+pl.p[i].team;
            bw.write (s);
            bw.newLine();
          }
          pl.sort(false,true);
          bw.write ("name           assist team");
          bw.newLine();
          for(int i=0;i<10;i++)
          {
            String s="";
            s=s+pl.p[i].name;
            for(int j=0;j<15-pl.p[i].name.length();j++)
            {
              s=s+" ";
            }
            s=s+pl.p[i].assist;
            s=s+"      "+pl.p[i].team;
            bw.write (s);
            bw.newLine();
          }
          pl.sort(false,false);
          bw.write ("name           score  team");
          bw.newLine();
          for(int i=0;i<10;i++)
          {
            String s="";
            s=s+pl.p[i].name;
            for(int j=0;j<15-pl.p[i].name.length();j++)
            {
              s=s+" ";
            }
            s=s+pl.p[i].score;
            s=s+"      "+pl.p[i].team;
            bw.write (s);
            bw.newLine();
          }
          bw.write("player       goal assist score");
          bw.newLine();
          for(int i=0;i<8;i++)
          {
            for(int j=0;j<11;j++)
            {
              bw.write(tl.ca[i].member[j].getinf());
              bw.newLine();
            }
            bw.write("score "+tl.ca[i].score+" goal "+tl.ca[i].goal+" number of fans "+tl.ca[i].fan);
            bw.newLine();             
          }
          bw.close();
          tl.transfer();
        }
        
        catch(Exception ee){
            System.out.println(ee);
        }
  }
  public static void writegamerecord(team a,team b)
  {
    try
        {
          BufferedWriter bw = new BufferedWriter(new FileWriter("gamerecord.txt",true));
          bw.write(tostring(tl.year)+ " "+tostring(tl.round)+" "+tostring(tl.game));
          bw.newLine();
          bw.write(a.name+ " "+tostring(a.igoal)+"   "+tostring(b.igoal)+" "+b.name);
          bw.newLine();
          bw.close();
        }
        
        catch(Exception ee){
            System.out.println(ee);
        }
  }
  ////////////////////////////////////////////////////////////////////////write read helper////////////////////////////////////////////////////////
  public static int toint(String s)
  {
    if(s.length()==1)
    {
      return s.charAt(0)-48;
    }
    else
    {
      return (s.charAt(s.length()-1)-48)+10*toint(s.substring(0,s.length()-1));
    }
  }
  public static String tostring(int i)
  {
    return ""+i;
  }
} 

