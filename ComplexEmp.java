public class ComplexEmp extends ObjEmp{
    double x,y;

    public ComplexEmp(double x,double y){
        super(3);
        this.x = x;
        this.y = y;
    }

    public ComplexEmp getValue(){
        return this;
    }
    
    public String toString(){
        if (y == 0) return String.valueOf(x);
        return y > 0 ? x+"+"+y+"i" : x+""+y+"i";
    }
}
