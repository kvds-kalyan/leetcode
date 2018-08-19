public class AddDigitsO1RunTime {

    //https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
