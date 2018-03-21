package taskB;

public class potenz {
    public static int potenzLoop(int basis, int potenz){

        int b = basis;
        int p = potenz;
        int ergebnis = b;

        if (potenz == 0) {
            return 1;
        } else {
            for(int i = 0; i<(p-1); i++){
                ergebnis = ergebnis * b;
            }
        }

        return ergebnis;
    }

    public static int potenzRecursive(int basis, int potenz){
        if(potenz == 1)
            return basis;
        if(potenz == 0)
            return 1;
        else {
            return potenzRecursive(basis, potenz - 1) * basis;
        }
    }

    public static int potenzEfficent(int basis, int potenz){
        if(potenz == 1)
            return basis;
        if(potenz == 0)
            return 1;
        else {
            return potenzRecursive(basis,potenz%2) *  potenzRecursive(basis,potenz/2) * potenzRecursive(basis,potenz/2);
        }
    }
}
