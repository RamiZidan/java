package ast.Statment.Variable;

public class equation extends Variable {
    public equation left;
    public equation right;
    public String opeartion ;
    public int value ;
    public equation(equation left , equation right , String operation){
        this.left = left ;
        this.right = right ;
        this.opeartion = operation ;
    }
    public equation(int value ){
        this.value = value ;
    }

    public String getOpeartion() {
        return opeartion;
    }

    public void setOpeartion(String opeartion) {
        this.opeartion = opeartion;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getVarValue() {
        return Integer.toString(value);
    }
    public void setVarValue(int value ) {
        this.value = value ;
    }

}
