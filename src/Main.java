import java.util.Scanner;

class Main {
    static int[] tmp;

    static int Find(int num) {
        if (tmp[num] == num) {
            return num;
        } else {
            return tmp[num] = Find(tmp[num]);
        }
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);

        tmp[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int g = kb.nextInt(); // 게이트 수
        int p = kb.nextInt(); // 비행기 수

        tmp = new int[g + 1];
        for (int i = 0; i <= g; i++) {
            tmp[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < p; i++) {
            int num = kb.nextInt();
            int fn = Find(num);

            if (fn != 0) {
                Union(fn, fn - 1);
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);

    }

}
