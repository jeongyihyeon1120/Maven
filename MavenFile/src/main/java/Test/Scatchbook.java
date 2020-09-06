package Test;

public class Scatchbook {
	private String name;
    private Drawing[] drawList;     //  �迭�� ũ�⸦ �������� �����ϱⰡ �����. Chap23, 24 ���׸��� �÷����� ���� �������� ũ�⸦ �����ϴ� ���� ���� �ȴ�.
    
    public Scatchbook(String name, int size) {
        this.name = name;
        this.drawList = new Drawing[size];
    }
    
    public void addDrawing(Drawing d){
        for(int index = 0; index < drawList.length; index++){
            if(drawList[index] == null) {
                drawList[index] = d;
                break;
            }
        }
    }
    
    public void draw(){
        for(Drawing d : drawList) {
        	System.out.println(d.draw());

        }
    }

    public static void main(String args[]) {
        Scatchbook scatchbook = new Scatchbook("SWH��ī���� ����ġ��", 2);
        Circle circle = new Circle(5000);
        Line line = new Line(5);
        Rectangle rectangle = new Rectangle();
        
        scatchbook.addDrawing(circle);
        scatchbook.addDrawing(rectangle);
//        scatchbook.addDrawing(line);      //  ������ ����
        scatchbook.draw();
    }
}