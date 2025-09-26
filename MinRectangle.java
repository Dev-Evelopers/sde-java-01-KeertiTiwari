public class MinRectangle {

    public static void main(String[] args) {
        int h = 8, w = 4;
        int h1 = 6, w1 = 1;
        System.out.println(minFolds(h, w, h1, w1));
    }

    public static int minFolds(int h, int w, int h1, int w1) {
        int ans1 = tryFold(h, w, h1, w1);
        int ans2 = tryFold(w, h, w1, h1);
        return Math.min(ans1, ans2);
    }

    private static int tryFold(int h, int w, int h1, int w1) {
        if (h1 > h || w1 > w) return Integer.MAX_VALUE;
        int folds = foldDim(h, h1) + foldDim(w, w1);
        return folds;
    }

    private static int foldDim(int from, int to) {
        int folds = 0;
        while (from > to) {
            if (from / 2 >= to) from /= 2;
            else from = to;
            folds++;
        }
        return folds;
    }
}


