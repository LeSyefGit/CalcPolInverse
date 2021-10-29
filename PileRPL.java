public class PileRPL {
    private int stackSize;
    private ObjEmp []tab;
    private int indexObj;

    public PileRPL(int stackSize) {
        this.stackSize = stackSize;
        if (stackSize >= 2) { // the stack must have at least 2 boxes
            this.indexObj = -1;
            this.tab = new ObjEmp [stackSize];
        }else{
            System.out.println("The stack must have at least 2 boxes");
        }
    }


    ////////////////   pour les fonctions de la pile 

    public void stack(ObjEmp objEmp) {
        if (indexObj < this.stackSize-1) {
            this.indexObj++;
            this.tab[this.indexObj] = objEmp;
        }else {
            System.out.println("the stack is full");
        }
    }

    public void pop() {
        if (indexObj > 0) {
            this.tab[indexObj] = null;
            this.indexObj--;
        } else {
            System.out.println("the stack is empty must have at least 1 elements");
        }
    }

    public String toString() {
        String output = "";
        for (int j = this.stackSize - 1; j >= 0; j--) {
            if (j > this.indexObj) {
                output += "|" + Integer.toString(j) + "    :    |\n";
            } else {
                output += "|" + Integer.toString(j) + "    : " + (this.tab[j]).toString() + "  |\n";
            }
        }
        return output;
    }

    ///////////              pour les opérations implémentées + , - , * , : 

    public void add() {
        if (indexObj >= 1) {
            
            if (tab[indexObj].type == tab[indexObj-1].type){
                switch(tab[indexObj].type) {
                    case 0:
                        System.out.println("Can't execute this operation");
                        break;
                    case 1:
                        addNumber();
                        break;
                    case 2:
                        addVecteur();
                        break;
                    case 3:
                        addComplex();
                        break;
                    default:
                        System.out.println("I don't know the type of these elements");
                        break;
                }
            } else
                System.out.println("Can't add different types");

        } else {
            System.out.println("the stack must have at least 2 elements to do addition");
        }
    }

    public void sub() {
        if (indexObj >= 1) {
            
            if (tab[indexObj].type == tab[indexObj-1].type){
                switch(tab[indexObj].type) {
                    case 0:
                        System.out.println("Can't execute this operation");
                        break;
                    case 1:
                        subNumber();
                        break;
                    case 2:
                        subVecteur();
                        break;
                    case 3:
                        subComplex();
                        break;
                    default:
                        System.out.println("I don't know the type of these elements");
                        break;
                }
            } else
                System.out.println("Can't substract different types");

        } else {
            System.out.println("the stack must have at least 2 elements to do substraction");
        }
    }

    public void mul(){
        if (indexObj >= 1) {
            
            if (tab[indexObj].type == tab[indexObj-1].type){
                switch(tab[indexObj].type) {
                                                    // to remove case 0
                    case 0:
                        System.out.println("Can't execute this operation");
                        break;
                    case 1:
                        mulNumber();
                        break;
                    case 2:
                        mulVecteur();
                        break;
                    case 3:
                        mulComplex();
                        break;
                    default:
                        System.out.println("I don't know the type of these elements");
                        break;
                }
            } else
                System.out.println("Can't multiply different types");

        } else {
            System.out.println("the stack must have at least 2 elements to do multiplication");
        }
    }

    public void scal(){
        if (indexObj >= 1) {
            
            if (tab[indexObj].type == tab[indexObj-1].type){
                switch(tab[indexObj].type) {
                                                    // to remove case 0
                    case 0:
                        System.out.println("Can't execute this operation");
                        break;
                    case 2:
                        mulVecteur();
                        break;
                    default:
                        System.out.println("Can't execute scalar product of non vectors");
                        break;
                }
            }

        } else {
            System.out.println("the stack must have at least 2 elements to do scalar product");
        }
    }

    public void div(){
        if (indexObj >= 1) {
            
            if (tab[indexObj].type == tab[indexObj-1].type){
                switch(tab[indexObj].type) {
                                                    // to remove case 0
                    case 0:
                        System.out.println("Can't execute this operation");
                        break;
                    case 1:
                        divNumber();
                        break;
                    case 2:
                        System.out.println("Can't execute division of vectors");
                        break;
                    case 3:
                        divComplex();
                        break;
                    default:
                        System.out.println("Can't execute this division");
                        break;
                }
            }

        } else {
            System.out.println("the stack must have at least 2 elements to do scalar product");
        }
    }

    //////////           pour les fonctions Addition
    
    public void addNumber(){
        ((NumberEmp)this.tab[indexObj - 1]).value = ((NumberEmp)this.tab[indexObj]).value +((NumberEmp)this.tab[indexObj - 1]).value;
        this.tab[indexObj] = null;
        indexObj--;
    }

    public void addVecteur(){
        if ( ((VecteurEmp)this.tab[indexObj - 1]).taille == ((VecteurEmp)this.tab[indexObj]).taille ) {
            ((VecteurEmp)this.tab[indexObj - 1]).x = ((VecteurEmp)this.tab[indexObj]).x +((VecteurEmp)this.tab[indexObj - 1]).x;
            ((VecteurEmp)this.tab[indexObj - 1]).y = ((VecteurEmp)this.tab[indexObj]).y +((VecteurEmp)this.tab[indexObj - 1]).y;
            if(((VecteurEmp)this.tab[indexObj]).taille == 3)
                ((VecteurEmp)this.tab[indexObj - 1]).z = ((VecteurEmp)this.tab[indexObj]).z +((VecteurEmp)this.tab[indexObj - 1]).z;
            this.tab[indexObj] = null;
            indexObj--;
        }else{
            System.out.println("Can't add vector of different lengh");
        }
    }

    public void addComplex(){
        ((ComplexEmp)this.tab[indexObj - 1]).x = ((ComplexEmp)this.tab[indexObj]).x +((ComplexEmp)this.tab[indexObj - 1]).x;
        ((ComplexEmp)this.tab[indexObj - 1]).y = ((ComplexEmp)this.tab[indexObj]).y +((ComplexEmp)this.tab[indexObj - 1]).y;
        this.tab[indexObj] = null;
        indexObj--;
    }

    
    //////////           pour les fonctions Soustraction


    public void subNumber(){
        ((NumberEmp)this.tab[indexObj - 1]).value = ((NumberEmp)this.tab[indexObj]).value -((NumberEmp)this.tab[indexObj - 1]).value;
        this.tab[indexObj] = null;
        indexObj--;
    }

    public void subVecteur(){
        if ( ((VecteurEmp)this.tab[indexObj - 1]).taille == ((VecteurEmp)this.tab[indexObj]).taille ) {
            ((VecteurEmp)this.tab[indexObj - 1]).x = ((VecteurEmp)this.tab[indexObj]).x -((VecteurEmp)this.tab[indexObj - 1]).x;
            ((VecteurEmp)this.tab[indexObj - 1]).y = ((VecteurEmp)this.tab[indexObj]).y -((VecteurEmp)this.tab[indexObj - 1]).y;
            if(((VecteurEmp)this.tab[indexObj]).taille == 3)
                ((VecteurEmp)this.tab[indexObj - 1]).z = ((VecteurEmp)this.tab[indexObj]).z -((VecteurEmp)this.tab[indexObj - 1]).z;
            this.tab[indexObj] = null;
            indexObj--;
        }else{
            System.out.println("Can't substract vector of different lengh");
        }
    }

    public void subComplex(){
        ((ComplexEmp)this.tab[indexObj - 1]).x = ((ComplexEmp)this.tab[indexObj]).x -((ComplexEmp)this.tab[indexObj - 1]).x;
        ((ComplexEmp)this.tab[indexObj - 1]).y = ((ComplexEmp)this.tab[indexObj]).y -((ComplexEmp)this.tab[indexObj - 1]).y;
        this.tab[indexObj] = null;
        indexObj--;
    }

    //////////           pour les fonctions Multiplication

    public void mulNumber(){
        ((NumberEmp)this.tab[indexObj - 1]).value = ((NumberEmp)this.tab[indexObj]).value *((NumberEmp)this.tab[indexObj - 1]).value;
        this.tab[indexObj] = null;
        indexObj--;
    }

    public void mulVecteur(){
        if (((VecteurEmp)this.tab[indexObj - 1]).taille == ((VecteurEmp)this.tab[indexObj]).taille ) {
            double x1,x2,y1,y2,z1,z2 = (double) 0;
            x1 = ((VecteurEmp)this.tab[indexObj]).x;
            x2 = ((VecteurEmp)this.tab[indexObj-1]).x;
            y1 = ((VecteurEmp)this.tab[indexObj]).y;
            y2 = ((VecteurEmp)this.tab[indexObj-1]).y;
            if(((VecteurEmp)this.tab[indexObj]).taille == 3){
                z1 = ((VecteurEmp)this.tab[indexObj]).z;
                z2 = ((VecteurEmp)this.tab[indexObj-1]).z;
                
                ((VecteurEmp)this.tab[indexObj - 1]).x = y1*z2 - z1*y2;
                ((VecteurEmp)this.tab[indexObj - 1]).y = z1*x2 - x1*z2;
                ((VecteurEmp)this.tab[indexObj - 1]).z = x1*y2 - y1*x2;
                /// je me suis arreté  à la mul de 2 vect 3*3  et 2*2 // faudra aussi faire le scalaire
            }else{
                // en dimension 2 et produit un vect n'existe pas car donne un vecteur orthogonal qui n'est pas dans cette base
                System.out.println("Can't execute vectorial product in Dim 2");
            }
            this.tab[indexObj] = null;
            indexObj--;
        }else{
            System.out.println("Can't multiply theses elements");
        }
    }

    public void mulComplex(){
        double x1,x2,y1,y2 = (double) 0;
            x1 = ((ComplexEmp)this.tab[indexObj]).x;
            x2 = ((ComplexEmp)this.tab[indexObj-1]).x;
            y1 = ((ComplexEmp)this.tab[indexObj]).y;
            y2 = ((ComplexEmp)this.tab[indexObj-1]).y;
            
        ((ComplexEmp)this.tab[indexObj - 1]).x = (x1*x2 - y1*y2);
        ((ComplexEmp)this.tab[indexObj - 1]).y = (x1*y2 + y1*x2);
        this.tab[indexObj] = null;
        indexObj--;
    }

    //////////           pour les fonctions Multiplication

    public void divNumber(){
        if(((NumberEmp)this.tab[indexObj - 1]).value != 0)
            ((NumberEmp)this.tab[indexObj - 1]).value = ((NumberEmp)this.tab[indexObj]).value /((NumberEmp)this.tab[indexObj - 1]).value;
        else
            System.out.println("Can't execute division by zero");
        this.tab[indexObj] = null;
        indexObj--;
    }

    public void divVecteur(){
        if (((VecteurEmp)this.tab[indexObj - 1]).taille == ((VecteurEmp)this.tab[indexObj]).taille ) {
            double x1,x2,y1,y2,z1,z2 = (double) 0;
            x1 = ((VecteurEmp)this.tab[indexObj]).x;
            x2 = ((VecteurEmp)this.tab[indexObj-1]).x;
            y1 = ((VecteurEmp)this.tab[indexObj]).y;
            y2 = ((VecteurEmp)this.tab[indexObj-1]).y;
            if(((VecteurEmp)this.tab[indexObj]).taille == 3){
                z1 = ((VecteurEmp)this.tab[indexObj]).z;
                z2 = ((VecteurEmp)this.tab[indexObj-1]).z;
                
                ((VecteurEmp)this.tab[indexObj - 1]).x = y1*z2 - z1*y2;
                ((VecteurEmp)this.tab[indexObj - 1]).y = z1*x2 - x1*z2;
                ((VecteurEmp)this.tab[indexObj - 1]).z = x1*y2 - y1*x2;
                /// je me suis arreté  à la mul de 2 vect 3*3  et 2*2 // faudra aussi faire le scalaire
            }else{
                // en dimension 2 et produit un vect n'existe pas car donne un vecteur orthogonal qui n'est pas dans cette base
                System.out.println("Can't execute vectorial product in Dim 2");
            }
            this.tab[indexObj] = null;
            indexObj--;
        }else{
            System.out.println("Can't multiply theses elements");
        }
    }

    public void divComplex(){
        double x1,x2,y1,y2 = (double) 0;
            x1 = ((VecteurEmp)this.tab[indexObj]).x;
            x2 = ((VecteurEmp)this.tab[indexObj-1]).x;
            y1 = ((VecteurEmp)this.tab[indexObj]).y;
            y2 = ((VecteurEmp)this.tab[indexObj-1]).y;

        ((ComplexEmp)this.tab[indexObj - 1]).x = (x1*x2 - y1*y2);
        ((ComplexEmp)this.tab[indexObj - 1]).y = (x1*y2 + y1*x2);
        this.tab[indexObj] = null;
        indexObj--;
    }


    //////////           pour les fonctions pour les produit scalaires de vecteur

    public void scalVecteur(){
        if ( ((VecteurEmp)this.tab[indexObj - 1]).taille == ((VecteurEmp)this.tab[indexObj]).taille ) {
            double x1,x2,y1,y2,z1,z2 = (double) 0;
            x1 = ((VecteurEmp)this.tab[indexObj]).x;
            x2 = ((VecteurEmp)this.tab[indexObj-1]).x;
            y1 = ((VecteurEmp)this.tab[indexObj]).y;
            y2 = ((VecteurEmp)this.tab[indexObj-1]).y;
            if(((VecteurEmp)this.tab[indexObj]).taille == 3){
                z1 = ((VecteurEmp)this.tab[indexObj]).z;
                z2 = ((VecteurEmp)this.tab[indexObj-1]).z;
                (this.tab[indexObj - 1]) = new NumberEmp(x1*x2 + y1*y2 + z1*z2);
            }else{
                (this.tab[indexObj - 1]) = new NumberEmp(x1*x2 + y1*y2);
            }
            this.tab[indexObj] = null;
            indexObj--;
        }else{
            System.out.println("Can't do the scalar product of these elements");
        }
    }

}
