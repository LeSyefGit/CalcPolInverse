public class NumberEmp extends ObjEmp {
    double value;
    public NumberEmp(double val){
        super(1);
        this.value = val;
    }

    public double getValue(){
        return this.value;
    }
    
    public String toString(){
        return String.valueOf(this.value);
    }
}