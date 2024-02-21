public class RecVarTest {
    int n = 50;

    int giveNum() {
        n = n + 1;
        return n;
    }

    void RecursionTest(int a) {
        if (a == 20) {
            System.out.println("Stopped here");
            return;
        }
        int num = giveNum();
        RecursionTest(a + 1);
        System.out.println("After : " + num);
    }
    public static void main(String[] args) {
        RecVarTest t = new RecVarTest();
        t.RecursionTest(11);
    }
}

// Learned form this 
// Conclusion - Only local Variable will go back to their previous call state
// Global does not go to their previous call state after return