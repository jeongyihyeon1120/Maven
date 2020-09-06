package abstractClass;

public abstract class Animal {
    public String kind;
     
    public void breath(){
        System.out.println("숨 쉰다.");
    }
    //추상메서드
    public abstract void sound();//구체적인 구현부는 없음!
}
