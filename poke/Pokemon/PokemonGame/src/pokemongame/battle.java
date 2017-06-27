/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemongame;

/**
 *
 * @author $$Goutham...!!$$
 */

import java.util.*;
import java.io.*;
public class battle
{
public static void main(String args[])throws IOException
{
Scanner sc=new Scanner(System.in);
BufferedReader br=new BufferedReader(new
InputStreamReader(System.in));
System.out.println("Welcome to Poke Battle zone\nGet ready to battle");
System.out.println("1. Venasaur\n2. Charizard\n3. Blastoise\n4. Feraligatr\n5. Typhlosion\n6. Mewtwo\n7. Swampert\n8. Blaziken\n9. Sceptile");
System.out.println("\n\nPlayer 1 choose yourPokemon(number)");
int p1=sc.nextInt();
Pokemon P1=null;
switch(p1)
{
case 1: P1=new Venasaur();break;
case 2: P1=new Charizad();break;
case 3: P1=new Blastoise();break;
case 4: P1=new Feraligatr();break;
case 5: P1=new Typhlosion();break;
case 6: P1=new Mewtwo();break;
case 7: P1=new Swampert();break;
case 8: P1=new Blaziken();break;
case 9: P1=new Sceptile();break;
default:System.out.println("Wronginput!");System.exit(0);break;
}
System.out.println("What would you like to name your Pokemon?");
P1.name=br.readLine();
System.out.println("\n\nPlayer 2 choose your Pokemon(number)");
int p2=sc.nextInt();
Pokemon P2=null;
switch(p2)
{
case 1: P2=new Venasaur();break;
case 2: P2=new Charizad();break;
case 3: P2=new Blastoise();break;
case 4: P2=new Feraligatr();break;
case 5: P2=new Typhlosion();break;
case 6: P2=new Mewtwo();break;
case 7: P2=new Swampert();break;
case 8: P2=new Blaziken();break;
case 9: P2=new Sceptile();break;
default:System.out.println("Wrong input!");System.exit(0);break;
}
System.out.println("What would you like to name your Pokemon?");
P2.name=br.readLine();
System.out.println("\nLet the Battle begin");
Pokemon Poke1,Poke2;
if(P1.Spe>P2.Spe)
{
Poke1=P1;
Poke2=P2;
}
else
{
Poke1=P2;
Poke2=P1;
}
System.out.println(Poke1.name+ " starts ");
while(true)
{
System.out.println("\n\n"+Poke1.name+"\nHP:"+Poke1.HP
+"\n");
System.out.println("Moves:");
Poke1.printMoves();
System.out.println("\n\n"+Poke2.name+"\nHP:"+Poke2.HP
+"\n");
System.out.println("Moves:");
Poke2.printMoves();
System.out.println("\n\n"+Poke1.name+", choose a move(number)");
int m1=sc.nextInt();
m1--;
System.out.println("\n\n"+Poke2.name+", choose a move(number)");
int m2=sc.nextInt();
m2--;
Poke1.calculateDamage(Poke2,m1);
if(Poke2.HP<=0)
{
System.out.println(Poke2.name+" is defeated! \n"+Poke1.name +" wins!");
System.out.println("Do you want to battle again?(y/n)");
char c=(br.readLine().toLowerCase()).charAt(0);
if(c=='y')
main(args);
else
{
System.out.println("Thanks for playing");
System.exit(0);
}
}
Poke2.calculateDamage(Poke1,m2);
if(Poke1.HP<=0)
{
System.out.println(Poke1.name+" is defeated!\n"+Poke2.name +" wins!");
System.out.println("Do you want to battle again?(y/n)");
char c=sc.next().toLowerCase().charAt(0);
if(c=='y')
main(args);
else
{
System.out.println("Thanks for playing");
System.exit(0);
}
}
System.out.println("Enter any button to continue");

String f=sc.next();
System.out.print("\f");
}
}
}
 class Pokemon
{
int HP,Def,SpDef,Att,SpAtt,Spe;
String name,type1,type2;
String moves[][];
Pokemon(int h,int a,int d,int sa,int sd, int s, String t1,String t2)
{
moves=new String[4][6];
HP=h;
Def=d;
SpDef=sd;
Att=a;
SpAtt=sa;
Spe=s;
type1=t1;
type2=t2;
}
void printMoves()
{
for(int i=0;i<4;i++)
System.out.println((i+1)+". "+moves[i][0]);
}
void calculateDamage(Pokemon P, int m)
{
System.out.println("\n\n");
double damage=0.0;
double r=Math.random()*100;
if(r>Double.parseDouble(moves[m][2]))
{
System.out.println("Attack missed!");
return;
}
if(moves[m][4].equals("special"))
{
damage=SpAtt*Double.parseDouble(moves[m][1])/P.SpDef;
}
else
{
damage=Att*Double.parseDouble(moves[m][1])/P.Def;
}
double rawDam=damage;
String typem=moves[m][3];
String typep1=P.type1;
String typep2=P.type2;
if(typep1.equals("fire"))
{
if(typem.equals("fire"))
{
damage/=2;
}
else if(typem.equals("water"))
{
damage*=2;
}
else if(typem.equals("grass"))
{
damage/=2;
}
else if(typem.equals("ground"))
{
damage*=2;
}
else if(typem.equals("rock"))
{
damage*=2;
}
else if(typem.equals("ice"))
{
damage/=2;
}
}
else if(typep1.equals("water"))
{
if(typem.equals("fire"))
{
damage/=2;
}
else if(typem.equals("water"))
{
damage/=2;
}
else if(typem.equals("grass"))
{
damage*=2;
}
else if(typem.equals("electric"))
{
damage*=2;
}
else if(typem.equals("ice"))
{
damage/=2;
}
}
else if(typep1.equals("grass"))
{
if(typem.equals("fire"))
{
damage*=2;
}
else if(typem.equals("water"))
{
damage/=2;
}
else if(typem.equals("grass"))
{
damage/=2;
}
else if(typem.equals("ground"))
{
damage/=2;
}
else if(typem.equals("rock"))
{
damage*=2;
}
else if(typem.equals("ice"))
{
damage*=2;
}
else if(typem.equals("flying"))
{
damage*=2;
}
else if(typem.equals("electric"))
{
damage/=2;
}
}
else if(typep1.equals("psychic"))
{
if(typem.equals("psychic"))
{
damage/=2;
}
else if(typem.equals("dark"))
{
damage*=2;
}
else if(typem.equals("fighting"))
{
damage/=2;
}
}
else if(typep1.equals("flying"))
{
if(typem.equals("ice"))
{
damage*=2;
}
else if(typem.equals("electric"))
{
damage*=2;
}
else if(typem.equals("fighting"))
{
damage/=2;
}
else if(typem.equals("rock"))
{
damage*=2;
}
else if(typem.equals("ground"))
{
damage=0;
}
else if(typem.equals("grass"))
{
damage/=2;
}
}
else if(typep1.equals("ground"))
{
if(typem.equals("ice"))
{
damage*=2;
}
else if(typem.equals("electric"))
{
damage=0;
}
else if(typem.equals("water"))
damage*=2;
else if(typem.equals("grass"))
{
damage*=2;
}
}
else if(typep1.equals("poison"))
{
if(typem.equals("ground"))
{
damage*=2;
}
else if(typem.equals("psychic"))
{
damage*=2;
}
else if(typem.equals("grass"))
{
damage/=2;
}
else if(typem.equals("poison"))
{
damage/=2;
}
else if(typem.equals("fighting"))
{
damage/=2;
}
}
if(typep2.equals("null"))
{
P.HP-=(int)(damage);
}
else
{
if(typep2.equals("fire"))
{
if(typem.equals("fire"))
{
damage/=2;
}
else if(typem.equals("water"))
{
damage*=2;
}
else if(typem.equals("grass"))
{
damage/=2;
}
else if(typem.equals("ground"))
{
damage*=2;
}
else if(typem.equals("rock"))
{
damage*=2;
}
else if(typem.equals("ice"))
{
damage/=2;
}
}
else if(typep2.equals("water"))
{
if(typem.equals("fire"))
{
damage/=2;
}
else if(typem.equals("water"))
{
damage/=2;
}
else if(typem.equals("grass"))
{
damage*=2;
}
else if(typem.equals("electric"))
{
damage*=2;
}
else if(typem.equals("ice"))
{
damage/=2;
}
}
else if(typep2.equals("grass"))
{
if(typem.equals("fire"))
{
damage*=2;
}
else if(typem.equals("water"))
{
damage/=2;
}
else if(typem.equals("grass"))
{
damage/=2;
}
else if(typem.equals("ground"))
{
damage/=2;
}
else if(typem.equals("rock"))
{
damage*=2;
}
else if(typem.equals("ice"))
{
damage*=2;
}
else if(typem.equals("flying"))
{
damage*=2;
}
else if(typem.equals("electric"))
{
damage/=2;
}
}
else if(typep2.equals("psychic"))
{
if(typem.equals("psychic"))
{
damage/=2;
}
else if(typem.equals("dark"))
{
damage*=2;
}
else if(typem.equals("fighting"))
{
damage/=2;
}
}
else if(typep2.equals("flying"))
{
if(typem.equals("ice"))
{
damage*=2;
}
else if(typem.equals("electric"))
{
damage*=2;
}
else if(typem.equals("fighting"))
{
damage/=2;
}
else if(typem.equals("rock"))
{
damage*=2;
}
else if(typem.equals("ground"))
{
damage=0;
}
else if(typem.equals("grass"))
{
damage/=2;
}
}
else if(typep2.equals("ground"))
{
if(typem.equals("ice"))
{
damage*=2;
}
else if(typem.equals("electric"))
{
damage=0;
}
else if(typem.equals("water"))
{
damage*=2;
}
else if(typem.equals("grass"))
{
damage*=2;
}
}
else if(typep2.equals("poison"))
{
if(typem.equals("ground"))
{
damage*=2;
}
else if(typem.equals("psychic"))
{
damage*=2;
}
else if(typem.equals("grass"))
{
damage/=2;
}
else if(typem.equals("poison"))
{
damage/=2;
}
else if(typem.equals("fighting"))
{
damage/=2;
}
}
P.HP-=(int)(damage);
}
if(damage==0)
System.out.println(moves[m][0] +" has no effect on"+P.name);
else if(damage>rawDam)
{
System.out.println(moves[m][0] +" is Super Effective on"+P.name);
}
else if(damage<rawDam)
{
System.out.println(moves[m][0] +" is Not Very Effectiveon "+P.name);
}
}
}
class Charizad extends Pokemon
{
Charizad()
{
super(360,293,280,348,295,328,"fire","flying");
moves[0][0]= "Flamethrower";
moves[0][1]= "90";
moves[0][2]= "95";
moves[0][3]= "fire";
moves[0][4]= "special";
moves[1][0]= "Earthquake";
moves[1][1]= "100";
moves[1][2]= "100";
moves[1][3]= "ground";
moves[1][4]= "physical";
moves[2][0]= "Air Slash";
moves[2][1]= "85";
moves[2][2]= "80";
moves[2][3]= "flying";
moves[2][4]= "special";
moves[3][0]= "Rock Slide";
moves[3][1]= "80";
moves[3][2]= "85";
moves[3][3]= "rock";
moves[3][4]= "physical";
}
}
class Blastoise extends Pokemon
{
Blastoise()
{
super(362,291,328,295,339,280,"water","null");
moves[0][0]= "Surf";
moves[0][1]= "95";
moves[0][2]= "90";
moves[0][3]= "water";
moves[0][4]= "special";
moves[1][0]= "Skull Bash";
moves[1][1]= "80";
moves[1][2]= "90";
moves[1][3]= "normal";
moves[1][4]= "physical";
moves[2][0]= "Ice Beam";
moves[2][1]= "95";
moves[2][2]= "95";
moves[2][3]= "ice";
moves[2][4]= "special";
moves[3][0]= "Earthquake";
moves[3][1]= "100";
moves[3][2]= "100";
moves[3][3]= "ground";
moves[3][4]= "physical";
}
}
class Venasaur extends Pokemon
{
Venasaur()
{
super(364,289,291,328,328,284,"grass","poison");
moves[0][0]= "Solar Beam";
moves[0][1]= "120";
moves[0][2]= "75";
moves[0][3]= "grass";
moves[0][4]= "special";
moves[1][0]= "Sludge Bomb";
moves[1][1]= "90";
moves[1][2]= "95";
moves[1][3]= "poison";
moves[1][4]= "special";
moves[2][0]="Wood Hammer";
moves[2][1]= "85";
moves[2][2]= "90";
moves[2][3]= "grass";
moves[2][4]= "physical";
moves[3][0]= "Bulldoze";
moves[3][1]= "60";
moves[3][2]= "100";
moves[3][3]= "ground";
moves[3][4]= "physical";
}
}
class Feraligatr extends Pokemon
{
Feraligatr()
{
super(374,339,328,282,291,280,"water","null");
moves[0][0]= "Hydro Pump";
moves[0][1]= "120";
moves[0][2]= "75";
moves[0][3]= "water";
moves[0][4]= "special";
moves[1][0]= "Superpower";
moves[1][1]= "120";
moves[1][2]= "80";
moves[1][3]= "fighting";
moves[1][4]= "physical";
moves[2][0]= "Ice Fang";
moves[2][1]= "65";
moves[2][2]= "90";
moves[2][3]= "ice";
moves[2][4]= "physical";
moves[3][0]= "Crunch";
moves[3][1]= "80";
moves[3][2]= "100";
moves[3][3]= "dark";
moves[3][4]= "physical";
}
}
class Typhlosion extends Pokemon
{
Typhlosion()
{
super(360,293,280,348,295,328,"fire","null");
moves[0][0]= "Fire Blast";
moves[0][1]= "5000";
moves[0][2]= "75";
moves[0][3]= "fire";
moves[0][4]= "special";
moves[1][0]= "Body Slam";
moves[1][1]= "80";
moves[1][2]= "100";
moves[1][3]= "normal";
moves[1][4]= "physical";
moves[2][0]= "Brick Break";
moves[2][1]= "75";
moves[2][2]= "100";
moves[2][3]= "fighting";
moves[2][4]= "physical";
moves[3][0]= "Fire Punch";
moves[3][1]= "75";
moves[3][2]= "100";
moves[3][3]= "fire";
moves[3][4]= "physical";
}
}
class Mewtwo extends Pokemon
{
Mewtwo()
{
super(4166,350,306,447,306,394,"psychic","null");
moves[0][0]= "Psychstrike";
moves[0][1]= "100";
moves[0][2]= "100";
moves[0][3]= "psychic";
moves[0][4]= "special";
moves[1][0]= "Aura Sphere";
moves[1][1]= "100";
moves[1][2]= "100";
moves[1][3]= "fighting";
moves[1][4]= "special";
moves[2][0]= "Thunderbolt";
moves[2][1]= "95";
moves[2][2]= "100";
moves[2][3]= "electric";
moves[2][4]= "special";
moves[3][0]= "Ice Beam";
moves[3][1]= "95";
moves[3][2]= "95";
moves[3][3]= "ice";
moves[3][4]= "special";
}
}
class Swampert extends Pokemon
{
Swampert()
{
super(404,350,306,295,306,240,"water","ground");
moves[0][0]= "Muddy Water";
moves[0][1]= "90";
moves[0][2]= "90";
moves[0][3]= "water";
moves[0][4]= "special";
moves[1][0]= "Hammer Arm";
moves[1][1]= "100";
moves[1][2]= "85";
moves[1][3]= "figthing";
moves[1][4]= "physical";
moves[2][0]= "Blizzard";
moves[2][1]= "120";
moves[2][2]= "75";
moves[2][3]= "ice";
moves[2][4]= "special";
moves[3][0]= "Earthquake";
moves[3][1]= "100";
moves[3][2]= "100";
moves[3][3]= "ground";
moves[3][4]= "physical";
}
}
class Blaziken extends Pokemon
{
Blaziken()
{
super(364,372,262,350,262,284,"fire","fighting");
moves[0][0]= "Brave Bird";
moves[0][1]= "100";
moves[0][2]= "90";
moves[0][3]= "flying";
moves[0][4]= "physical";
moves[1][0]= "Flare Blitz";
moves[1][1]= "120";
moves[1][2]= "75";
moves[1][3]= "fire";
moves[1][4]= "physical";
moves[2][0]= "Solar Beam";
moves[2][1]= "120";
moves[2][2]= "75";
moves[2][3]= "grass";
moves[2][4]= "special";
moves[3][0]= "Sky Uppercut";
moves[3][1]= "90";
moves[3][2]= "85";
moves[3][3]= "fighting";
moves[3][4]= "physical";
}
}
class Sceptile extends Pokemon
{
Sceptile()
{
super(344,295,251,339,295,372,"grass","null");
moves[0][0]= "Faint Attack";
moves[0][1]= "60";
moves[0][2]= "100";
moves[0][3]= "dark";
moves[0][4]= "special";
moves[1][0]= "Leaf Blade";
moves[1][1]= "85";
moves[1][2]= "100";
moves[1][3]= "grass";
moves[1][4]= "physical";
moves[2][0]= "Psychic";
moves[2][1]= "90";
moves[2][2]= "90";
moves[2][3]= "psychic";
moves[2][4]= "special";
moves[3][0]= "Aerial Ace";
moves[3][1]= "65";
moves[3][2]= "100";
moves[3][3]= "flying";
moves[3][4]= "physical";
}
}
