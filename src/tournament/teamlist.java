package tournament;
import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_sv;

import java.io.*;
import java.util.Random; 
class teamlist
{
team[] ca;
team[] ra;
team[] cu;
int round;
int game;
int year;
int[][] cons;

teamlist(int r,int g)
{
  ca=new team[12];
  ra=new team[12];
  cu=new team[8];
  round=r;
  game=g;
  year=0;
  cons();
}
public String returnrank()
{
  String s="";
  String t="";
  s=s+"team      round score goal  fan\n";
  for(int i=0;i<8;i++)
  {
    s=s+ra[i].name;
    for(int j=0;j<10-ra[i].name.length();j++)
    {
      s=s+" ";
    }
    s=s+ra[i].round;
    for(int j=0;j<6-(t+ra[i].round).length();j++)
    {
      s=s+" ";
    }
    s=s+ra[i].score;
    for(int j=0;j<6-(t+ra[i].score).length();j++)
    {
      s=s+" ";
    }
    s=s+ra[i].goal;
    for(int j=0;j<6-(t+ra[i].goal).length();j++)
    {
      s=s+" ";
    }
    s=s+ra[i].fan;
    s=s+"\n";
  }
  return s;
}
    public String returnSecondRank(){
        String s="";
        String t="";
        s=s+"team      round score goal  fan\n";
        for(int i=8;i<12;i++)
        {
            s=s+ra[i].name;
            for(int j=0;j<10-ra[i].name.length();j++)
            {
                s=s+" ";
            }
            s=s+ra[i].round;
            for(int j=0;j<6-(t+ra[i].round).length();j++)
            {
                s=s+" ";
            }
            s=s+ra[i].score;
            for(int j=0;j<6-(t+ra[i].score).length();j++)
            {
                s=s+" ";
            }
            s=s+ra[i].goal;
            for(int j=0;j<6-(t+ra[i].goal).length();j++)
            {
                s=s+" ";
            }
            s=s+ra[i].fan;
            s=s+"\n";
        }
        return s;
    }
public void generatera()
{
  ra[0]=ca[0];
  ra[1]=ca[1];
  ra[2]=ca[2];
  ra[3]=ca[3];
  ra[4]=ca[4];
  ra[5]=ca[5];
  ra[6]=ca[6];
  ra[7]=ca[7];
    for(int i=8;i<12;i++){
        ra[i]=ca[i];
    }
    for(int i=0;i<8;i++){
        cu[ca[i].cupid]=ca[i];
    }
    team temp;
  for(int i=0;i<8;i++)
  {
    for (int j=i+1;j<8;j++){
      if(ra[j].score>ra[i].score||(ra[j].score==ra[i].score&&ra[j].goal>ra[i].goal)||(ra[j].score==ra[i].score&&ra[j].goal==ra[i].goal&&ra[j].fan>ra[i].fan))
      {
        temp=ra[i];
        ra[i]=ra[j];
        ra[j]=temp;
      }
    }
  }

    for(int i=8;i<12;i++)
    {
        for (int j=i+1;j<12;j++){
            if(ra[j].score>ra[i].score||(ra[j].score==ra[i].score&&ra[j].goal>ra[i].goal)||(ra[j].score==ra[i].score&&ra[j].goal==ra[i].goal&&ra[j].fan>ra[i].fan))
            {
                temp=ra[i];
                ra[i]=ra[j];
                ra[j]=temp;
            }
        }
    }

}
public team findteam(String s)
{
  for(int i=0;i<12;i++)
  {
    if(ca[i].name.equals(s))
    {
      return ca[i];
    }
  }
  return null;
}
////////////////////////////////////////////////////////////end season///////////////////////////////////
public void transfer()
{
  try
       {
        BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt",true));
        for(int k=0;k<12;k=k+2)
        {
          player temp=new player();
          Random r = new Random();
          double rvi = 1.0+10* r.nextDouble();
          double rvj = 1.0+10* r.nextDouble();
          int i=(int)rvi;
          int j=(int)rvj;
          ca[k].member[i].team=ca[k+1].name;
          ca[k+1].member[j].team=ca[k].name;
          System.out.println(ca[k].member[i].name+" from "+ca[k].name+" to "+ca[k+1].name);
          System.out.println(ca[k+1].member[j].name+" from "+ca[k+1].name+" to "+ca[k].name);
          bw.write (ca[k].member[i].name+" from "+ca[k].name+" to "+ca[k+1].name);
          bw.newLine();
          bw.write (ca[k+1].member[j].name+" from "+ca[k+1].name+" to "+ca[k].name);
          bw.newLine();
          temp=ca[k].member[i];
          ca[k].member[i]=ca[k+1].member[j];
          ca[k+1].member[j]=temp;
        }
        bw.close();
       }
       
       catch(Exception ee){
           System.out.println(ee);
       }
}
public void changefan()
{
  for(int i=0;i<12;i++)
  {
    ca[i].fan=(ca[i].fan)*2/3+ca[i].goal+ca[i].score+ca[i].cupgoal;
  }
}
public void regroup()
{
  generatera();
    team tmp=ra[7];
    ra[7]=ra[8];
    ra[8]=tmp;

  ca[0]=ra[0];
  ca[1]=ra[1];
  ca[2]=ra[2];
  ca[3]=ra[3];
  ca[4]=ra[4];
  ca[5]=ra[5];
  ca[6]=ra[6];
  ca[7]=ra[7];
    cu[0]=ca[5];
    cu[1]=ca[2];
    cu[2]=ca[6];
    cu[3]=ca[1];
    cu[4]=ca[4];
    cu[5]=ca[3];
    cu[6]=ca[7];
    cu[7]=ca[0];

    cu[0].cupid=0;
    cu[1].cupid=1;
    cu[2].cupid=2;
    cu[3].cupid=3;
    cu[4].cupid=4;
    cu[5].cupid=5;
    cu[6].cupid=6;
    cu[7].cupid=7;
}
public void set0()
{
  for(int i=0;i<12;i++)
  {
    ca[i].score=0;
    ca[i].round=0;
    ca[i].goal=0;
      ca[i].cupgamegoal=1;
      ca[i].cupgoal=0;
  }
}
//########################################################################operator####################################################################################
//################################################################################################################################################################
public void playnextgame() throws IOException {
    if(round<=13&&game==5){
        playnextcupgame();
        return;
    }
    else if(round==14&&game==5){
        return;
    }
  Jieshuo j=new Jieshuo();
  java.util.Scanner ff=new java.util.Scanner(System.in);
  String pause;
  team a=chooseteam(round,game,true);
  team b=chooseteam(round,game,false);
  System.out.println("round "+round+"   game "+game);
  System.out.println(a.name+"   vs   "+b.name);
  for(int i=0;i<11;i++)
  {
    //a.member[i].igoal=0;
    //a.member[i].iassist=0;
    //a.member[i].isave=0;
    a.member[i].iscore=60;
    //b.member[i].igoal=0;
    //b.member[i].iassist=0;
    //b.member[i].isave=0;
    b.member[i].iscore=60;
  }
  a.igoal=0;
  b.igoal=0;
    double hostmod=0.03125;
  for(int i=0;i<18;i++)
  {
    System.out.println((i+1)*5+"minites");
   player pa1=a.randomp(1);
   player pb1=b.randomp(0);
      pause=ff.nextLine();
      player am=a.randomp(1);
      player bm=b.randomp(1);
      am.ipass++;
      bm.ipass++;
      if(randomstr(am.pass,hostmod*a.fan/b.fan)>randomstr(bm.pass,0.0)) {
          a.icontrol++;
          am.ispass++;
          am.iscore++;
          bm.iscore--;
          System.out.println(am.name + " controls ball,now " + a.name);
          pause = ff.nextLine();
          pb1.itackle++;
          if (randomstr(pa1.pass, hostmod * a.fan / b.fan) > randomstr(pb1.defence, 0.0)) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////success pass
              //pa1.iassist++;
              a.icontrol++;
              pa1.iscore += 2;
              pb1.iscore-=2;
              player pa2 = a.randomp(2);
              if (pa1.name.equals(pa2.name)) {/////////////////////////////////////////////////////////////////////////////////////////////////pass to self
                  System.out.println(j.czj(pa1.name));
                  pause = ff.nextLine();
                  a.ishoot++;
                  pa1.ishoot++;
                  a.isshoot++;
                  pa1.isshoot++;
                  b.member[0].itackle++;
                  if (randomstr(pa1.pass, 0.0) > randomstr(b.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                      pa1.iassist++;
                      pa1.assist++;
                      //pa1.igoal++;
                      pa1.igoal++;
                      pa1.goal++;
                      pa1.iscore += 13;
                      b.member[0].iscore-=1;
                      a.goal++;
                      a.igoal++;
                      System.out.println(j.czjj(pa1.name));
                      System.out.println(a.igoal + "  to  " + b.igoal);
                  } else {//////////////////////////////////////////////////////////////////////////no goal
                      pa1.iscore+=5;
                      b.member[0].istackle++;
                      b.member[0].iscore += 10;
                      System.out.println(j.czjc(b.member[0].name));
                  }
              } else {//////////////////////////////////////////////////////////////////////////////////////////////////pass to others
                  pa1.ispass++;
                  pa1.ipass++;
                  player pb2 = b.randomp(0);
                  System.out.println(j.cbr(pa1.name));
                  pause = ff.nextLine();
                  a.ishoot++;
                  pa2.ishoot++;
                  pb2.itackle++;
                  if (randomstr(pa2.shoot, hostmod * a.fan / b.fan) > randomstr(pb2.defence, 0.0)) {///////////////////////////////////////////////////////////////////////after defence
                      System.out.println(j.dmj(pa2.name));
                      pause = ff.nextLine();
                      a.icontrol++;
                      a.isshoot++;
                      pa2.isshoot++;
                      b.member[0].itackle++;
                      pa2.iscore += 5;
                      pb2.iscore-=2;
                      if (randomstr(pa2.shoot, hostmod * a.fan / b.fan) > randomstr(b.member[0].defence, 0.0)) {//////////////////////////////////////////////////goal
                          pa2.iscore += 10;
                          pa2.igoal++;
                          pa2.goal++;
                          pa1.iassist++;
                          pa1.iscore+=5;
                          pa1.assist++;
                          b.member[0].iscore-=3;
                          a.goal++;
                          a.igoal++;
                          System.out.println(j.j(pa2.name));
                          System.out.println(a.igoal + "  to  " + b.igoal);
                      } else {///////////////////////////////////////////////no goal b keeper+score
                          b.member[0].istackle++;
                          b.member[0].iscore += 5;
                          System.out.println(j.bp(b.member[0].name));
                      }
                  } else {///////////////////////////////////////////////////////////////////////////defended b2+score
                      pa2.iscore-=2;
                      b.icontrol++;
                      pb2.istackle++;
                      pb2.iscore += 5;
                      System.out.println(j.bd(pb2.name));
                  }
              }
          } else {///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////unable to pass b1+score
              b.icontrol++;
              pb1.istackle++;
              pb1.iscore += 5;
              pa1.iscore-=1;
              System.out.println(j.cbd(pb1.name));
          }
      }
      else {
          b.icontrol++;
          bm.ispass++;
          bm.iscore++;
          am.iscore--;
          System.out.println(bm.name+" controls the ball,now "+b.name);

          pause = ff.nextLine();
          pb1=b.randomp(1);
          pa1=a.randomp(0);
          pa1.itackle++;
          if (randomstr(pb1.pass, 0.0) > randomstr(pa1.defence, hostmod * a.fan / b.fan)) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////success pass
              //pa1.iassist++;
              b.icontrol++;
              pb1.iscore += 2;
              pa1.iscore-=2;
              player pb2 = b.randomp(2);;
              if (pb1.name.equals(pb2.name)) {/////////////////////////////////////////////////////////////////////////////////////////////////pass to self
                  System.out.println(j.czj(pb1.name));
                  pause = ff.nextLine();
                  b.ishoot++;
                  pb1.ishoot++;
                  b.isshoot++;
                  pb1.isshoot++;
                  a.member[0].itackle++;
                  if (randomstr(pb1.pass, 0.0) > randomstr(a.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                      pb1.iassist++;
                      pb1.assist++;
                      //pa1.igoal++;
                      pb1.igoal++;
                      pb1.goal++;
                      pb1.iscore += 13;
                      a.member[0].iscore--;
                      b.goal++;
                      b.igoal++;
                      System.out.println(j.czjj(pb1.name));
                      System.out.println(a.igoal + "  to  " + b.igoal);
                  } else {//////////////////////////////////////////////////////////////////////////no goal
                      pb1.iscore+=5;
                      a.member[0].istackle++;
                      a.member[0].iscore += 10;
                      System.out.println(j.czjc(a.member[0].name));
                  }
              } else {//////////////////////////////////////////////////////////////////////////////////////////////////pass to others
                  pb1.ipass++;
                  pb1.ispass++;
                  player pa2 = a.randomp(0);
                  System.out.println(j.cbr(pb1.name));
                  pause = ff.nextLine();
                  b.ishoot++;
                  pb2.ishoot++;
                  pa2.itackle++;
                  if (randomstr(pb2.shoot, 0.0) > randomstr(pa2.defence, hostmod * a.fan / b.fan)) {///////////////////////////////////////////////////////////////////////after defence
                      b.icontrol++;
                      System.out.println(j.dmj(pb2.name));
                      pause = ff.nextLine();
                      b.isshoot++;
                      pb2.isshoot++;
                      pb2.iscore+=5;
                      pa2.iscore-=2;
                      a.member[0].itackle++;
                      if (randomstr(pb2.shoot, 0.0) > randomstr(a.member[0].defence, hostmod * a.fan / b.fan)) {//////////////////////////////////////////////////goal
                          pb2.iscore += 10;
                          pb2.igoal++;
                          pb2.goal++;
                          pb1.iassist++;
                          pb1.assist++;
                          pb1.iscore+=5;
                          a.member[0].iscore-=3;
                          b.goal++;
                          b.igoal++;
                          System.out.println(j.j(pb2.name));
                          System.out.println(a.igoal + "  to  " + b.igoal);
                      } else {///////////////////////////////////////////////no goal b keeper+score
                          a.member[0].istackle++;
                          a.member[0].iscore += 5;
                          System.out.println(j.bp(a.member[0].name));
                      }
                  } else {///////////////////////////////////////////////////////////////////////////defended b2+score
                      a.icontrol++;
                      pb2.iscore-=2;
                      pa2.istackle++;
                      pa2.iscore += 5;
                      System.out.println(j.bd(pa2.name));
                  }
              }
          } else {///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////unable to pass b1+score
              a.icontrol++;
              pa1.istackle++;
              pa1.iscore += 5;
              pb1.iscore-=1;
              System.out.println(j.cbd(pa1.name));
          }
      }
   
   
  }
  a.round++;
  b.round++;
  if(a.igoal>b.igoal)
  {
    a.score+=3;
  }
  if(a.igoal<b.igoal)
  {
    b.score+=3;
  }
  if(a.igoal==b.igoal)
  {
    a.score++;
    b.score++;
  }
  System.out.println("the final result is "+a.name+" "+a.igoal+"  "+b.igoal+" "+b.name);
  //calculate score
  for(int i=0;i<11;i++)
  {
    a.member[i].score=(a.member[i].score*((round-1))+a.member[i].iscore*10)/((round));
    b.member[i].score=(b.member[i].score*((round-1))+b.member[i].iscore*10)/((round));
  }
  //team record
    int total=a.icontrol+b.icontrol;
  System.out.println("controll: "+a.name+(a.icontrol*100/total+1)+" : "+b.icontrol*100/total+b.name);
    System.out.println("shoot: "+a.name+a.isshoot+"/"+a.ishoot+" : "+b.isshoot+"/"+b.ishoot+b.name);
    System.out.println("name         tackle  pass shoot assist goal score");
  for(int i=0;i<11;i++)
  {
    System.out.print(a.member[i].name);
      for(int k=a.member[i].name.length();k<15;k++){
          System.out.print(" ");
      }
      System.out.println(a.member[i].istackle+"/"+a.member[i].itackle + "   " + a.member[i].ispass+"/"+a.member[i].ipass
      +"   "+a.member[i].isshoot+"/"+a.member[i].ishoot+"     "+a.member[i].iassist+"     "
              +a.member[i].igoal+"   "+a.member[i].iscore);
  }
  System.out.println("");
  for(int i=0;i<11;i++)
  {
      System.out.print(b.member[i].name);
      for(int k=b.member[i].name.length();k<15;k++){
          System.out.print(" ");
      }
      System.out.println(b.member[i].istackle+"/"+b.member[i].itackle + "   " + b.member[i].ispass+"/"+b.member[i].ipass
              +"   "+b.member[i].isshoot+"/"+b.member[i].ishoot+"     "+b.member[i].iassist+"     "
              +b.member[i].igoal+"   "+b.member[i].iscore);
  }
  shiftround();
}
    public void playnextcupgame() throws IOException {
        Jieshuo j=new Jieshuo();
        java.util.Scanner ff=new java.util.Scanner(System.in);
        String pause;
        team a=chooseteam(round,game,true);
        team b=chooseteam(round,game,false);
        System.out.println("cup game "+round);
        System.out.println(a.name+"   vs   "+b.name);
        System.out.println("agg score : "+(a.cupgamegoal-1)+" : "+(b.cupgamegoal-1));
        for(int i=0;i<11;i++)
        {
            //a.member[i].igoal=0;
            //a.member[i].iassist=0;
            //a.member[i].isave=0;
            a.member[i].iscore=60;
            //b.member[i].igoal=0;
            //b.member[i].iassist=0;
            //b.member[i].isave=0;
            b.member[i].iscore=60;
        }
        a.igoal=0;
        b.igoal=0;
        int ap=0;
        int bp=0;
        double hostmod=0.03125;
        if(round==13){
            hostmod=0;
        }
        for(int i=0;i<18;i++) {
            System.out.println((i + 1) * 5 + "minites");
            player pa1 = a.randomp(1);
            player pb1 = b.randomp(0);
            pause = ff.nextLine();
            player am = a.randomp(1);
            player bm = b.randomp(1);
            if (randomstr(am.pass, hostmod * a.fan / b.fan) > randomstr(bm.pass, 0.0)) {
                am.iscore++;
                bm.iscore--;
                System.out.println(am.name + " controls ball,now " + a.name);
                pause = ff.nextLine();
                if (randomstr(pa1.pass, hostmod * a.fan / b.fan) > randomstr(pb1.defence, 0.0)) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////success pass
                    //pa1.iassist++;
                    pa1.iscore += 5;
                    player pa2 = a.randomp(2);
                    if (pa1.name.equals(pa2.name)) {/////////////////////////////////////////////////////////////////////////////////////////////////pass to self
                        System.out.println(j.czj(pa1.name));
                        pause = ff.nextLine();
                        if (randomstr(pa1.pass, 0.0) > randomstr(b.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                            //pa1.igoal++;
                            pa1.iscore += 10;
                            a.igoal++;
                            a.cupgamegoal++;
                            a.cupgoal++;
                            System.out.println(j.czjj(pa1.name));
                            System.out.println(a.igoal + "  to  " + b.igoal);
                            System.out.println("agg score : " + (a.cupgamegoal - 1) + " : " + (b.cupgamegoal - 1));
                        } else {//////////////////////////////////////////////////////////////////////////no goal
                            b.member[0].iscore += 10;
                            System.out.println(j.czjc(b.member[0].name));
                        }
                    } else {//////////////////////////////////////////////////////////////////////////////////////////////////pass to others
                        player pb2 = b.randomp(0);
                        System.out.println(j.cbr(pa1.name));
                        pause = ff.nextLine();
                        if (randomstr(pa2.shoot, hostmod * a.fan / b.fan) > randomstr(pb2.defence, 0.0)) {///////////////////////////////////////////////////////////////////////after defence
                            System.out.println(j.dmj(pa2.name));
                            pause = ff.nextLine();
                            pa2.iscore += 5;
                            if (randomstr(pa2.shoot, hostmod * a.fan / b.fan) > randomstr(b.member[0].defence, 0.0)) {//////////////////////////////////////////////////goal
                                pa2.iscore += 10;
                                a.igoal++;
                                a.cupgamegoal++;
                                a.cupgoal++;
                                System.out.println(j.j(pa2.name));
                                System.out.println(a.igoal + "  to  " + b.igoal);
                                System.out.println("agg score : " + (a.cupgamegoal - 1) + " : " + (b.cupgamegoal - 1));
                            } else {///////////////////////////////////////////////no goal b keeper+score
                                b.member[0].iscore += 5;
                                System.out.println(j.bp(b.member[0].name));
                            }
                        } else {///////////////////////////////////////////////////////////////////////////defended b2+score
                            pb2.iscore += 5;
                            System.out.println(j.bd(pb2.name));
                        }
                    }
                } else {///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////unable to pass b1+score
                    pb1.iscore += 5;
                    System.out.println(j.cbd(pb1.name));
                }
            }
        else {
                bm.iscore++;
                am.iscore--;
                System.out.println(bm.name + " controls the ball,now " + b.name);

                pause = ff.nextLine();
                pa1=a.randomp(0);
                pb1=b.randomp(1);
                if (randomstr(pb1.pass, 0.0) > randomstr(pa1.defence, hostmod * a.fan / b.fan)) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////success pass
                    //pa1.iassist++;
                    pb1.iscore += 5;
                    player pb2 = b.randomp(2);
                    if (pb1.name.equals(pb2.name)) {/////////////////////////////////////////////////////////////////////////////////////////////////pass to self
                        System.out.println(j.czj(pb1.name));
                        pause = ff.nextLine();
                        if (randomstr(pb1.pass, 0.0) > randomstr(a.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                            pb1.iscore += 10;
                            b.igoal++;
                            b.cupgoal++;
                            b.cupgamegoal++;
                            System.out.println(j.czjj(pb1.name));
                            System.out.println(a.igoal + "  to  " + b.igoal);
                            System.out.println("agg score : " + (a.cupgamegoal - 1) + " : " + (b.cupgamegoal - 1));
                        } else {//////////////////////////////////////////////////////////////////////////no goal
                            a.member[0].iscore += 10;
                            System.out.println(j.czjc(a.member[0].name));
                        }
                    } else {//////////////////////////////////////////////////////////////////////////////////////////////////pass to others
                        player pa2 = a.randomp(0);
                        System.out.println(j.cbr(pb1.name));
                        pause = ff.nextLine();
                        if (randomstr(pb2.shoot, 0.0) > randomstr(pa2.defence, hostmod * a.fan / b.fan)) {///////////////////////////////////////////////////////////////////////after defence
                            System.out.println(j.dmj(pb2.name));
                            pause = ff.nextLine();
                            if (randomstr(pb2.shoot, 0.0) > randomstr(a.member[0].defence, hostmod * a.fan / b.fan)) {//////////////////////////////////////////////////goal
                                pb2.iscore += 5;
                                b.igoal++;
                                b.cupgoal++;
                                b.cupgamegoal++;
                                System.out.println(j.j(pb2.name));
                                System.out.println(a.igoal + "  to  " + b.igoal);
                                System.out.println("agg score : " + (a.cupgamegoal - 1) + " : " + (b.cupgamegoal - 1));
                            } else {///////////////////////////////////////////////no goal b keeper+score
                                a.member[0].iscore += 5;
                                System.out.println(j.bp(a.member[0].name));
                            }
                        } else {///////////////////////////////////////////////////////////////////////////defended b2+score
                            pa2.iscore += 5;
                            System.out.println(j.bd(pa2.name));
                        }
                    }
                } else {///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////unable to pass b1+score
                    pa1.iscore += 5;
                    System.out.println(j.cbd(pa1.name));
                }
            }


        }
        if((round==5||round==6||round==7||round==8||round==11||round==12||round==13)){
            if(a.cupgamegoal==b.cupgamegoal) {
                for (int i = 18; i < 24; i++) {
                    System.out.println((i + 1) * 5 + "minites");
                    player pa1 = a.randomp(1);
                    player pb1 = b.randomp(0);
                    pause = ff.nextLine();
                    player am = a.randomp(1);
                    player bm = b.randomp(1);
                    if (randomstr(am.pass, hostmod * a.fan / b.fan) > randomstr(bm.pass, 0.0)) {
                        am.iscore++;
                        bm.iscore--;
                        System.out.println(am.name + " controls ball,now " + a.name);
                    pause = ff.nextLine();
                    if (randomstr(pa1.pass, hostmod * a.fan / b.fan) > randomstr(pb1.defence, 0.0)) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////success pass
                        //pa1.iassist++;
                        pa1.iscore += 5;
                        player pa2 = a.randomp(2);
                        if (pa1.name.equals(pa2.name)) {/////////////////////////////////////////////////////////////////////////////////////////////////pass to self
                            System.out.println(j.czj(pa1.name));
                            pause = ff.nextLine();
                            if (randomstr(pa1.pass, 0.0) > randomstr(b.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                                pa1.iscore += 10;
                                a.igoal++;
                                a.cupgamegoal++;
                                a.cupgoal++;
                                System.out.println(j.czjj(pa1.name));
                                System.out.println(a.igoal + "  to  " + b.igoal);
                            } else {//////////////////////////////////////////////////////////////////////////no goal
                                b.member[0].iscore += 10;
                                System.out.println(j.czjc(b.member[0].name));
                            }
                        } else {//////////////////////////////////////////////////////////////////////////////////////////////////pass to others
                            player pb2 = b.randomp(0);
                            System.out.println(j.cbr(pa1.name));
                            pause = ff.nextLine();
                            if (randomstr(pa2.shoot, hostmod * a.fan / b.fan) > randomstr(pb2.defence, 0.0)) {///////////////////////////////////////////////////////////////////////after defence
                                System.out.println(j.dmj(pa2.name));
                                pause = ff.nextLine();
                                pa2.iscore += 5;
                                if (randomstr(pa2.shoot, hostmod * a.fan / b.fan) > randomstr(b.member[0].defence, 0.0)) {//////////////////////////////////////////////////goal
                                    pa2.iscore += 10;
                                    a.igoal++;
                                    a.cupgamegoal++;
                                    a.cupgoal++;
                                    System.out.println(j.j(pa2.name));
                                    System.out.println(a.igoal + "  to  " + b.igoal);
                                } else {///////////////////////////////////////////////no goal b keeper+score
                                    b.member[0].iscore += 5;
                                    System.out.println(j.bp(b.member[0].name));
                                }
                            } else {///////////////////////////////////////////////////////////////////////////defended b2+score
                                pb2.iscore += 5;
                                System.out.println(j.bd(pb2.name));
                            }
                        }
                    } else {///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////unable to pass b1+score
                        pb1.iscore += 5;
                        System.out.println(j.cbd(pb1.name));
                    }
                    }
                    else {
                        bm.iscore++;
                        am.iscore--;
                        System.out.println(bm.name + " controls the ball,now " + b.name);

                        pause = ff.nextLine();
                        pa1=a.randomp(0);
                        pb1=b.randomp(1);
                        if (randomstr(pb1.pass, 0.0) > randomstr(pa1.defence, hostmod * a.fan / b.fan)) {/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////success pass
                            //pa1.iassist++;
                            pb1.iscore += 5;
                            player pb2 = b.randomp(2);
                            if (pb1.name.equals(pb2.name)) {/////////////////////////////////////////////////////////////////////////////////////////////////pass to self
                                System.out.println(j.czj(pb1.name));
                                pause = ff.nextLine();
                                if (randomstr(pb1.pass, 0.0) > randomstr(a.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                                    pb1.iscore += 10;
                                    b.igoal++;
                                    b.cupgoal++;
                                    b.cupgamegoal++;
                                    System.out.println(j.czjj(pb1.name));
                                    System.out.println(a.igoal + "  to  " + b.igoal);
                                } else {//////////////////////////////////////////////////////////////////////////no goal
                                    a.member[0].iscore += 10;
                                    System.out.println(j.czjc(a.member[0].name));
                                }
                            } else {//////////////////////////////////////////////////////////////////////////////////////////////////pass to others
                                player pa2 = a.randomp(0);
                                System.out.println(j.cbr(pb1.name));
                                pause = ff.nextLine();
                                if (randomstr(pb2.shoot, 0.0) > randomstr(pa2.defence, hostmod * a.fan / b.fan)) {///////////////////////////////////////////////////////////////////////after defence
                                    System.out.println(j.dmj(pb2.name));
                                    pause = ff.nextLine();
                                    if (randomstr(pb2.shoot, 0.0) > randomstr(a.member[0].defence, hostmod * a.fan / b.fan)) {//////////////////////////////////////////////////goal
                                        pb2.iscore += 5;
                                        b.igoal++;
                                        b.cupgoal++;
                                        b.cupgamegoal++;
                                        System.out.println(j.j(pb2.name));
                                        System.out.println(a.igoal + "  to  " + b.igoal);
                                    } else {///////////////////////////////////////////////no goal b keeper+score
                                        a.member[0].iscore += 5;
                                        System.out.println(j.bp(a.member[0].name));
                                    }
                                } else {///////////////////////////////////////////////////////////////////////////defended b2+score
                                    pa2.iscore += 5;
                                    System.out.println(j.bd(pa2.name));
                                }
                            }
                        } else {///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////unable to pass b1+score
                            pa1.iscore += 5;
                            System.out.println(j.cbd(pa1.name));
                        }
                    }
                }
                if (a.cupgamegoal == b.cupgamegoal) {
                    int i;
                    for (i = 0; i < 5; i++) {
                        System.out.println("round "+(i+1));
                        pause = ff.nextLine();

                        player pa1 = a.member[10 - i];
                        if (randomstr(pa1.shoot, 0.0) > randomstr(b.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                            pa1.iscore += 1;
                            ap++;
                            System.out.println(pa1.name + " shoots in");
                            System.out.println(ap + "  to  " + bp);
                        } else {//////////////////////////////////////////////////////////////////////////no goal
                            b.member[0].iscore += 5;
                            System.out.println(b.member[0].name + " saves");
                            System.out.println(ap + "  to  " + bp);
                        }

                        pause = ff.nextLine();
                        player pb1 = a.member[10 - i];
                        if (randomstr(pb1.shoot, 0.0) > randomstr(a.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                            pb1.iscore += 1;
                            bp++;
                            System.out.println(pb1.name + " shoots in");
                            System.out.println(ap + "  to  " + bp);
                        } else {//////////////////////////////////////////////////////////////////////////no goal
                            a.member[0].iscore += 5;
                            System.out.println(a.member[0].name + " saves");
                            System.out.println(ap + "  to  " + bp);
                        }
                    }
                    while (ap == bp) {
                        System.out.println("round "+(i+1));
                        pause = ff.nextLine();

                        player pa1 = a.member[10 - i];
                        if (randomstr(pa1.shoot, 0.0) > randomstr(b.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                            pa1.iscore += 1;
                            ap++;
                            System.out.println(pa1.name + " shoots in");
                            System.out.println(ap + "  to  " + bp);
                        } else {//////////////////////////////////////////////////////////////////////////no goal
                            b.member[0].iscore += 5;
                            System.out.println(b.member[0].name + " saves");
                            System.out.println(ap + "  to  " + bp);
                        }

                        pause = ff.nextLine();
                        player pb1 = a.member[10 - i];
                        if (randomstr(pb1.shoot, 0.0) > randomstr(a.member[0].defence, -0.5)) {///////////////////////////////////////////////////////////////////////////goal
                            pb1.iscore += 1;
                            bp++;
                            System.out.println(pb1.name + " shoots in");
                            System.out.println(ap + "  to  " + bp);
                        } else {//////////////////////////////////////////////////////////////////////////no goal
                            a.member[0].iscore += 5;
                            System.out.println(a.member[0].name + " saves");
                            System.out.println(ap + "  to  " + bp);
                        }
                        i++;
                        if (i == 10) {
                            i = 0;
                        }
                    }
                }
            }
        }
        System.out.println("the final result is "+a.name+" "+a.igoal+"  "+b.igoal+" "+b.name);
        System.out.println("agg score : "+(a.cupgamegoal-1)+" : "+(b.cupgamegoal-1));
        if((round==5||round==6||round==7||round==8||round==11||round==12||round==13)){
            if(a.cupgamegoal>b.cupgamegoal||ap>bp)
            {
                a.cupgamegoal=1;
                b.cupgamegoal=0;
                System.out.println(a.name+" wins");

                for(int i=0;i<Math.abs(a.cupid-b.cupid);i++){
                    switchcup(cu[i+a.cupid],cu[i+b.cupid]);
                }
            }
            else{
                a.cupgamegoal=0;
                b.cupgamegoal=1;
                System.out.println(b.name+" wins");
            }
        }
        //calculate score
        //team record
        System.out.println("");
        for(int i=0;i<11;i++)
        {
            System.out.println(a.member[i].name+"  "+a.member[i].iscore);
        }
        System.out.println("");
        for(int i=0;i<11;i++)
        {
            System.out.println(b.member[i].name+"  "+b.member[i].iscore);
        }
        shiftround();
    }
    public void switchcup(team a,team b){
        int id=a.cupid;
        a.cupid=b.cupid;
        b.cupid=id;
        cu[a.cupid]=a;
        cu[b.cupid]=b;
    }
public void cons()
{
  cons=new int[23][6];
   cons[1][1]=72; cons[1][2]=18;  cons[1][3]=63;  cons[1][4]=45; cons[1][5]=12;
   cons[2][1]=38; cons[2][2]=16;  cons[2][3]=25;  cons[2][4]=47; cons[2][5]=34;
   cons[3][1]=53; cons[3][2]=64;  cons[3][3]=82;  cons[3][4]=71; cons[3][5]=56;
   cons[4][1]=48; cons[4][2]=15;  cons[4][3]=26;  cons[4][4]=37; cons[4][5]=78;
   cons[5][1]=67; cons[5][2]=23;  cons[5][3]=58;  cons[5][4]=14; cons[5][5]=21;
   cons[6][1]=31; cons[6][2]=42;  cons[6][3]=75;  cons[6][4]=86; cons[6][5]=43;
   cons[7][1]=78; cons[7][2]=56;  cons[7][3]=34;  cons[7][4]=12; cons[7][5]=65;
   cons[8][1]=27; cons[8][2]=81;  cons[8][3]=36;  cons[8][4]=54; cons[8][5]=87;
   cons[9][1]=83; cons[9][2]=61;  cons[9][3]=52;  cons[9][4]=74; cons[9][5]=13;
  cons[10][1]=35;cons[10][2]=46; cons[10][3]=28; cons[10][4]=17; cons[10][5]=57;
  cons[11][1]=84;cons[11][2]=51; cons[11][3]=62; cons[11][4]=73; cons[11][5]=31;
  cons[12][1]=76;cons[12][2]=32; cons[12][3]=85; cons[12][4]=41; cons[12][5]=75;
  cons[13][1]=13;cons[13][2]=24; cons[13][3]=57; cons[13][4]=68; cons[13][5]=51;
  cons[14][1]=87;cons[14][2]=65; cons[14][3]=43; cons[14][4]=21;

    cons[15][1]=12;cons[15][2]=34; cons[15][3]=14; cons[15][4]=23;
    cons[16][1]=42;cons[16][2]=31; cons[16][3]=42; cons[16][4]=31;
    cons[17][1]=23;cons[17][2]=14; cons[17][3]=12; cons[17][4]=34;
    cons[18][1]=24;cons[18][2]=31; cons[18][3]=24; cons[18][4]=31;
    cons[19][1]=43;cons[19][2]=21; cons[19][3]=41; cons[19][4]=32;
    cons[20][1]=41;cons[20][2]=32; cons[20][3]=43; cons[20][4]=21;
    cons[21][1]=21;cons[21][2]=12;
    //cons[22][1]=21;cons[22][2]=12;

}
public team chooseteam(int r,int g,boolean i) {
    if(r>=15&&g>=3){
        if (i) {
            return ca[cons[r][g] / 10 - 1+8];
        }
        return ca[cons[r][g] % 10 - 1+8];
    }
    if (g < 5) {
        if (i) {
            return ca[cons[r][g] / 10 - 1];
        }
        return ca[cons[r][g] % 10 - 1];
    }
    else{
        if (i) {
            return cu[cons[r][g] / 10 - 1];
        }
        return cu[cons[r][g] % 10 - 1];
    }
}
public int randompla()
{
  Random r = new Random();
  int i=1+(int)(11* r.nextDouble());
  if(i>10)
  {
    return randompla();
  }
  return i;
}
public double randomstr(int s,double i)
{
  Random r = new Random();
  return 1.0* r.nextDouble()+i;
}
public void shiftround() throws IOException {
    if(round==13&&game==5){
        BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt",true));
        bw.write ("cup winner: "+cu[0].name);
        bw.newLine();
        bw.close();
    }
    else if(round==14&&game==4){
        generatera();
        for(int i=0;i<8;i++){
            ca[i]=ra[i];
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt",true));
        bw.write ("league winner: "+ra[0].name);
        bw.newLine();
        bw.close();
    }
    else if(round==20&&game==4){
        generatera();
        for(int i=0;i<12;i++){
            ca[i]=ra[i];
        }
        if(ra[0].score-ra[1].score>6) {
            round=0;
            BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt", true));
            bw.write("league winner: " + ra[0].name);
            bw.newLine();
            bw.close();
            return;
        }
    }
    else if(round>=21){
        if(Math.abs(ra[0].score-ra[1].score)>3){
            generatera();
            round=0;
            BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt", true));
            bw.write("league winner: " + ra[0].name);
            bw.newLine();
            bw.close();
            return;
        }
    }
    if(round<=13) {
        if (game < 5) {
            game++;
        } else {
            round++;
            game = 1;
        }
    }
    else if(round<=20){
        if (game < 4) {
            game++;
        } else {
            round++;
            game = 1;
        }
    }
    else{
        if (game < 2) {
            game++;
        } else {
            game = 1;
        }
    }
}
}