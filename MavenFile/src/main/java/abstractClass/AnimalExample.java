package abstractClass;

public class AnimalExample {
	 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Dog dog = new Dog();
        Cat cat = new Cat();
        System.out.println(1);
        dog.sound();
        cat.sound();
         
        Animal animal = null;
        animal = new Dog(); //자동 타입변환
        animal.sound(); //Dog에 구현된 Sound()메서드 실행
        animal = new Cat(); //자동 타입변환
        animal.sound(); //Cat에 구현된 Sound()메서드 실행
         
        System.out.println(1);
        animalSound(new Dog()); //자동 타입변환 (매개변수도 가능)
        animalSound(new Cat()); //자동 타입변환 (매개변수도 가능)
    }
    //자동 타입변환 : 추상클래스 타입 변수는 추상클래스를 상속받은 실체클래스의 타입으로 자동 타입변환이 된다. 
    private static void animalSound(Animal animal) {
        animal.sound();
    }
}