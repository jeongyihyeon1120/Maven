package Test;

public class Line extends Shape{

    protected int startX;

    public Line(){
        startX = 0;
    }

    public Line(int startX) {
        this.startX = startX;
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        return startX;
    }

    public int draw() {
//      System.out.println(title + " : ���� �׸��ϴ�.");      //  ����, �������̽��� �������� �ʾҴ�.
        return 0;
    }
}