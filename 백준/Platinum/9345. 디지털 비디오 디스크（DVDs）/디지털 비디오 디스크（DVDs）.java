import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static int first;
    static int[] mintree;
    static int[] maxtree;
    static int[] minarr;
    static int[] maxarr;
    static int logn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());
            logn = 0;
            for (int j = 1; j < size; j *= 2) {
                logn++;
            }
            minarr = new int[size + 1];
            maxarr = new int[size + 1];
            minarr[size] = Integer.MAX_VALUE;
            maxarr[size] = Integer.MIN_VALUE;
            mintree = new int[(int) Math.pow(2, logn + 1)];
            maxtree = new int[mintree.length];
            Arrays.fill(mintree, size);
            Arrays.fill(maxtree, size);
            first = mintree.length / 2;
            for (int j = 0; j < size; j++) {
                minarr[j] = j;
                maxarr[j] = j;
                mintree[first + j] = j;
                maxtree[first + j] = j;
            }
            mininit(1);
            maxinit(1);
            for (int j = 0; j < line; j++) {
                st = new StringTokenizer(br.readLine());
                int choice = Integer.parseInt(st.nextToken());
                if (choice == 0) {
                    int temp1 = Integer.parseInt(st.nextToken());
                    int answer1 = minarr[temp1];
                    int temp2 = Integer.parseInt(st.nextToken());
                    int answer2 = minarr[temp2];
                    minarr[temp1] = answer2;
                    minarr[temp2] = answer1;
                    maxarr[temp1] = answer2;
                    maxarr[temp2] = answer1;
                    minupdate(first + temp1);
                    minupdate(first + temp2);
                    maxupdate(first + temp1);
                    maxupdate(first + temp2);
                } else {
                    int temp1 = Integer.parseInt(st.nextToken());
                    int temp2 = Integer.parseInt(st.nextToken());
                    int result1 = minarr[minfind(first + temp1, first + temp2)];
                    int result2 = maxarr[maxfind(first + temp1, first + temp2)];
                    if (result1 == temp1 && result2 == temp2) {
                        sb.append("YES\n");
                    } else {
                        sb.append("NO\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }

    static int maxfind(int start, int end) {
        int result = maxtree[start];
        while (end >= start) {
            if (end == start) {
                if (maxarr[result] < maxarr[maxtree[start]]) {
                    result = maxtree[start];
                }
                return result;
            }
            if (start % 2 == 1) {
                if (maxarr[result] < maxarr[maxtree[start]]) {
                    result = maxtree[start];
                }
                start++;
            }
            if (end % 2 == 0) {
                if (maxarr[result] < maxarr[maxtree[end]]) {
                    result = maxtree[end];
                }
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return result;
    }

    static int minfind(int start, int end) {
        int result = mintree[start];
        while (end >= start) {
            if (end == start) {
                if (minarr[result] > minarr[mintree[start]]) {
                    return result = mintree[start];
                }
            }
            if (start % 2 == 1) {
                if (minarr[result] > minarr[mintree[start]]) {
                    result = mintree[start];
                }
                start++;
            }
            if (end % 2 == 0) {
                if (minarr[result] > minarr[mintree[end]]) {
                    result = mintree[end];
                }
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return result;
    }

    static void maxupdate(int index) {
        int temp = index / 2;
        while (temp != 0) {
            if (maxarr[maxtree[temp * 2]] >= maxarr[maxtree[temp * 2 + 1]]) {
                maxtree[temp] = maxtree[temp * 2];
            } else {
                maxtree[temp] = maxtree[temp * 2 + 1];
            }
            temp /= 2;
        }
    }

    static void minupdate(int index) {
        int temp = index / 2;
        while (temp != 0) {
            if (minarr[mintree[temp * 2]] <= minarr[mintree[temp * 2 + 1]]) {
                mintree[temp] = mintree[temp * 2];
            } else {
                mintree[temp] = mintree[temp * 2 + 1];
            }
            temp /= 2;
        }
    }

    static int mininit(int index) {
        if (index >= first / 2) {
            if (minarr[mintree[index * 2]] <= minarr[mintree[index * 2 + 1]]) {
                return mintree[index] = mintree[index * 2];
            } else {
                return mintree[index] = mintree[index * 2 + 1];
            }
        }
        if (minarr[mininit(index * 2)] <= minarr[mininit(index * 2 + 1)]) {
            return mintree[index] = mintree[index * 2];
        } else {
            return mintree[index] = mintree[index * 2 + 1];
        }
    }

    static int maxinit(int index) {
        if (index >= first / 2) {
            if (maxarr[maxtree[index * 2]] >= maxarr[maxtree[index * 2 + 1]]) {
                return maxtree[index] = maxtree[index * 2];
            } else {
                return maxtree[index] = maxtree[index * 2 + 1];
            }
        }
        if (maxarr[maxinit(index * 2)] >= maxarr[maxinit(index * 2 + 1)]) {
            return maxtree[index] = maxtree[index * 2];
        } else {
            return maxtree[index] = maxtree[index * 2 + 1];
        }
    }
}
