package implementations;

import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        if(this.parentheses == null){
            throw new NullPointerException("cannot pass null values");
        }

        this.parentheses = this.parentheses.trim();
        if(this.parentheses.length()==0){
            throw new IllegalStateException();
        }
        if(this.parentheses.length()%2 !=0){
            return false;
        }

        for (int i = 0; i <this.parentheses.length(); i++) {
            if(this.parentheses.charAt(i)=='{'){
                if( this.parentheses.charAt(this.parentheses.length()-1-i) !='}'){
                    return false;
                }
            }else if(this.parentheses.charAt(i) =='['){
                if( this.parentheses.charAt(this.parentheses.length()-1-i) !=']'){
                    return false;
                }
            }else if(this.parentheses.charAt(i) =='('){
                if( this.parentheses.charAt(this.parentheses.length()-1-i) !=')'){
                    return false;
                }
            }

        }
        return true;
    }
}
