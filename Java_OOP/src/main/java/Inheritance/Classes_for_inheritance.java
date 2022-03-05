package Inheritance;

public class Classes_for_inheritance {
    public static class A {

        // Static allocates the class memory on launch of program.
        // TO prevent a class or method being inherited use the final declaration

        int i, j;

        public void showij() {
            System.out.println("i and j : " + i + " & " + j);
        }
    }
    // To inherit use the extends key word. Super class is the one being inherited and the sub class is the new class created

    public static class B extends A {
        int k;

        public void showk() {
            System.out.println("K: " + k);
        }

        public void sum() {
            System.out.println("Sum of i, j, k = " + (i + j + k));
        }
    }
}

// Although a subclass includes all of the members of its superclass, it cannot access those members of the superclass
// that have been declared as private. SLIDE 12 Topic 2a shows this concept well:
    /*

        Class A {
            int i;
            private int j;
            void setij(int x, int y){
                i = x;
                j= y;
            }
        }

        Class B extends A {
            int total;
            void sum(){
                total = i + j -> j can not be accessed as it was declared private therefore can not be inherited
            }
        }

        j in this example is only accessible by other members in class A
     */
