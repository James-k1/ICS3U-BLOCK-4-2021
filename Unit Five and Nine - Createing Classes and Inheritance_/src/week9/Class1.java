package week9;

public class Class1

{

private int val1;

public Class1()

{

val1 = 1;

}

public void init ()

{

Class2 c2 = new Class2();

c2.init(this, val1);

}

public void update(int x)

{

val1 -= x;

}

public int getVal()

{

return val1;

}

}

