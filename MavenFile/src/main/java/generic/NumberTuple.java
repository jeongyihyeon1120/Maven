package generic;

public class NumberTuple<T extends Number> {
    private T key, value;
    
    public NumberTuple(T v1, T v2) {
        this.key = v1;
        this.value = v2;
    }
    
    public T getKey() {
        return key;     
    }
    
    public T getValue() {
        return value;       
    }   
    
    public static void main(String args[]) {
        NumberTuple<Integer> si = new NumberTuple<Integer>(3, 4);
        System.out.println(si.getKey());
        
        NumberTuple<Double> sd = new NumberTuple<Double>(3.0, 4.0);
        System.out.println(sd.getValue());      
    }
}