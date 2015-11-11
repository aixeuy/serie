package tournament;

import java.util.Random;
class Jieshuo
{
  String[] cbd;
  String[] czj;
  String[] czjj;
  String[] czjc;
  String[] cbr;
  String[] bd;
  String[] dmj;
  String[] bp;
  String[] j;
  public Jieshuo()
  {
    cbd=new String[]{" get the ball back"};//"英勇地抢断","将球断下","阻止了对方的进攻","一个飞铲将球断下","夺回球权"};
    czj=new String[]{" win a penalty"};//"在禁区内被放倒","赢得了点球","倒在了禁区内"
      //,"点球!点球!点球!他立功了，他立功了!不要给对方任何的机会。 伟大夏越队的左后卫!他继承了夏越的光荣的传统。法切蒂、卡布里尼、马尔蒂尼在这一刻灵魂附体!他一个人他代表了夏越足球悠久的历史和传统，在这一刻他不是一个人在战斗，他不是一个人! "
      //,"这是个假摔啊，裁判竟然给了点球"};
    czjj=new String[]{" shoot in"};//"把球罚进死角","踢出勺子点球","骗过了门将","射门，球打在门将身上弹进球门","球进啦!比赛结束了!伟大的夏越!伟大的夏越的左后卫!马尔蒂尼今天生日快乐!夏越万岁! "};;
    czjc=new String[]{" save"};//"门将跳起了面条舞，对方果然打飞了","一个鱼跃把球扑出","用意念让球飞出","轻松把球得到"};
    cbr=new String[]{" pass"};//"过顶长传","送出直塞","挑传给队友","底线传中","将球停给队友","将球球交给队友","开出任意球","开出角球","精彩的二过一"};
    bd=new String[]{" defend"};//"舍身堵抢眼","干净地将球断下","大脚解围","头球解围","将球破坏出底线","成功的抢断","一个飞铲把球断下"};
    dmj=new String[]{" shoot"};//"晃过了所有人","杀入禁区，射了","长途奔袭，直接面对门将，打门","飞身垫射","临空抽射","倒钩射门","拉出空当，射门","在禁区外起脚远射","圆月弯刀","踢出电梯球","回头望月","没踢中足球，禁区内一片混乱","传球，结果变成了一次射门","将球吊向球门",
      //"超远距离射门","门前抢点","补射","没人防守，射门","和队友打出精妙配合，射门","生吃对方后卫，射门"};
    bp=new String[]{" save"};//"把球吓飞了","飞身将球扑出","单掌将球托出","双拳将球击出","轻松将球得到","将射门的球员吓傻了","奋不顾身的将球得到"};
    j=new String[]{" goal"};//"将球打进","穿裆将球打进","把球打进死角","进了，这球其实是个乌龙","进球了"};
  }
  public String cbd(String n)
  {
    Random r = new Random();
   return n+cbd[(int)(cbd.length* r.nextDouble())];
  }
  public String czj(String n)
  {
    Random r = new Random();
   return n+czj[(int)(czj.length* r.nextDouble())];
  }
  public String czjj(String n)
  {
    Random r = new Random();
   return n+czjj[(int)(czjj.length* r.nextDouble())];
  }
  public String czjc(String n)
  {
    Random r = new Random();
   return n+czjc[(int)(czjc.length* r.nextDouble())];
  }
  public String cbr(String n)
  {
    Random r = new Random();
   return n+cbr[(int)(cbr.length* r.nextDouble())];
  }
  public String bd(String n)
  {
    Random r = new Random();
   return n+bd[(int)(bd.length* r.nextDouble())];
  }
  public String dmj(String n)
  {
    Random r = new Random();
   return n+dmj[(int)(dmj.length* r.nextDouble())];
  }
  public String bp(String n)
  {
    Random r = new Random();
   return n+bp[(int)(bp.length* r.nextDouble())];
  }
  public String j(String n)
  {
    Random r = new Random();
   return n+j[(int)(j.length* r.nextDouble())];
  }
}