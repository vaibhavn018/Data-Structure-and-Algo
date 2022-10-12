public class Pattern {

    static void triangleDown(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col == 0) {
            System.out.println();
            triangleDown(row - 1, row - 1);
            return;
        }
        System.out.print("*");
        triangleDown(row, col - 1);
    }

    static void triangleUp(int row, int col) {
        if(row == 0) {
            return;
        }

        if(col<row) {
            triangleUp(row, col+1);
            System.out.print("*");
        
            return;
        }

        triangleUp(row-1, 0);
        System.out.println();

    }

    public static void main(String[] args) {
        // triangleDown(4, 4);
        triangleUp(4, 0);

    }
}
