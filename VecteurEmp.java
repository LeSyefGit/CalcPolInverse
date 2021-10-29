public class VecteurEmp extends ObjEmp{
    double x,y,z;
    int taille;

    public VecteurEmp(double x,double y,double z){
        super(2);
        this.x = x;
        this.y = y;
        this.z = z;
        this.taille = 3;
    }

    public VecteurEmp(double x,double y){
        super(2);
        this.x = x;
        this.y = y;
        this.taille = 2;
    }

    public VecteurEmp getValue(){
        return this;
    }
    
    public String toString(){
        return this.taille == 3 ? "("+x+", "+y+", "+z+")" : "("+x+", "+y+")" ;
    }
}
