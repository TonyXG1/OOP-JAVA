package fraction;

//Клас "Обикновена дроб"
public class Fraction {
//Свойства: числител и знаменател
private long num,den;

//Частни методи

//НОД на числителя и знаменателя
private long gcd(){
//променливи n и d - абсолютните стойности на числителя и знаменателя
//(методът НЕ ПРОМЕНЯ свойствата, работим с копия от тях) 
 long n=num>=0?num:-num,
      d=den>0?den:-den,
      t;
//Невъзможният резултат 0 подсказва, че поне едно от числата е било 0.
//(По принцип това ще е осигурено преди повикването, но като правим инструменти,
//предпочитаме да са по-всеобхватни.)
 if (n==0||d==0) return 0;
//Оставяме в n не по-малкото от двете.
 if (n<d){
	 t=n;
	 n=d;
	 d=t;
 }
//Алгоритъм на Евклид с деление
 do{
	   t=n%d;
	   if (t==0) return d;
	   n=d;
	   d=t;
 }while(true);
}
//"Нормализиране" на дроб
private void normalize(){
	 //Проверка за знаменател 0
	 if (den==0) return;
	 //Проверка за числител 0
	 if (num==0){
		 den=1;
		 return;
	 }
	 //Знакът да се държи от числителя
	 if (den<0){
		 den=-den;
		 num=-num;
	 }
	 //Опростяване на дробта
	 long d=gcd();
	 num/=d;
	 den/=d;
}

//Публични методи

//"Празен" конструктор (без параметри): да създава дроб със стойност 0 
public Fraction(){
	 num=0;
	 den=1;
}
//Конструктор с един параметър - превръща цяло в "обикновена дроб"
public Fraction (long n){
	 num=n;
	 den=1;
}
//Конструктор с два параметъра - числител и знаменател
public Fraction (long n,long d){
//Запомняне на входните параметри в свойствата
	 num=n;
	 den=d;
//"Нормализиране" на дробта
	 normalize();
}
//Конструктор от реално число
public Fraction(double d){
//С използване на дефинирания конструктор Fraction(long,long)
//this(Long.parseLong(Double.toString(d).replace(".","")),
//     (long)Math.pow(10,Double.toString(d).indexOf('.')<0?0:
//		         Double.toString(d).length()-Double.toString(d).indexOf('.')-1));

//С използване на цикъл
long b = 1;//За степените на 10
while(d!=(long)d){ //Докато има дробна част
 d*=10;
 b*=10;
}
num = (long)d;
den = b;
normalize();
}

//"Гетъри": позволяват на външния потребител да ЧЕТЕ свойствата
public long getNum(){
	 return num;
}
public long getDen(){
	 return den;
}
//"Сетъри": позволяват на външния потребител да ПРОМЕНЯ свойствата
//ВНИМАНИЕ за адекватността на промените!
public void setNum(long n){
	 num=n;
	 normalize();
}
public void setDen(long d){
	 den=d;
	 normalize();
}
//Създаване на низ за визуализация на обект от новия клас
@Override
public String toString(){
	 if (den==0)  return "NaN";
	 if (den==1) return Long.toString(num);//return ""+num;
	 return num+"/"+den;
}
//Действия с обекти от новия клас
//Събиране на дроби
public Fraction add(Fraction f){
	 return new Fraction(this.num*f.den+this.den*f.num,this.den*f.den);
}
//Изваждане на дроби
public Fraction sub(Fraction f){
	 return new Fraction(this.num*f.den-this.den*f.num,this.den*f.den);
}
//Умножение на дроби
public Fraction mul(Fraction f){
	 return new Fraction(this.num*f.num,this.den*f.den);
}
//Деление на дроби (ВНИМАНИЕ при деление на нула!)
public Fraction div(Fraction f){
	 if (f.num==0) return new Fraction(1,0);//Връща NaN
	 return new Fraction(this.num*f.den,this.den*f.num);
}
//Намиране на реципрочна на дадена дроб
public Fraction reciprocal(){
	 //0 и NaN нямат реципрочни
	 if (num==0 || den==0) return new Fraction(1,0); //Връща NaN
	 return new Fraction(den,num);
}
//Повдигане на степен на дроб
public Fraction power(int p){
//Няма нулева степен на 0 и NaN
	 if (p==0 && (num==0 || den==0)) return new Fraction(1,0);
	 //Временна променлива t, равна на текущия обект
	 //"Суматор" r, равен на 1 (ще трупаме произведение)
	 Fraction t=this,r=new Fraction(1);
	 //Ако p е отрицателно, сменяме t с неговото реципрочно
	 // и правим p положително
	 if (p<0) {
		 p=-p;
		 t=t.reciprocal();
	 }
	 //Цикъл за натрупване на произведението в r
	 for (int i=0;i<p;i++) r=r.mul(t);
	 return r;
}
//Сравняване на дроби.
public int compareTo(Fraction f){
/*За сравняване на обекти от един и същ клас най-често използваме 
* публичен метод compareTo(A), който сравнява this с параметъра си 
* A - обект от същия клас - и връща:
* -1, ако редът (this преди A) е "правилен" (според приоритетите ни);
* 1, ако редът (this преди A) НЕ Е "правилен" (според приоритетите ни);
* 0, ако нямаме критерий, по който да предпочетем наредбата 
*  (this преди A) от (this след A).
*Да припомним, че compareTo върху String, например, спазва тази идеология.
*/
//Специални случаи (считаме знаменател 0 за безкрайност)
if (den==0) return 1;
if (f.den==0) return -1;
//Според знаците (в нашата концепция числителят носи знака)
if (this.num<0 && f.num>=0) return -1;//Отрицателните са преди неотрицателните
if (this.num>=0 && f.num<0) return 1;//Неотрицателните са след отрицателните
//Ако и двете са отрицателни, наредбата е обратна на съоветните им положителни
if (this.num<0 && f.num<0) return new Fraction(-f.num,f.den).compareTo(new Fraction(-num,den));
//Стандартен случай на положителни дроби
long r=num*f.den-den*f.num;
if (r<0) return -1;//"Добре наредени" (в случая - в нарастваща големина)
if (r>0) return 1;//"Лошо наредени"
return 0; //Няма различаващ ги критерий
}
}
