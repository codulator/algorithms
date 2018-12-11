package algos;

public class Urlify {
    private String transform(char[] arr, int length) {
        int totalSpaces = 0;

        if (arr.length == 0) {
            return "";
        } else if (length == 0) {
            return "";
        }


        for (int i = 0; i < length ;i++) {
            if (arr[i] == ' ') {
                totalSpaces++;
            }
        }

        int newLength = length + 2*totalSpaces;
        char[] newArr = new char[newLength];
        int j = 0;
        for (int k=0; k < length; k++) {
            if (arr[k] == ' ') {
                newArr[j++] = '%';
                newArr[j++] = '2';
                newArr[j++] = '0';
            } else {
                newArr[j++]  = arr[k];
            }
        }
        return String.valueOf(newArr);
    }

    public static void main(String[] args) {
        Urlify url = new Urlify();
        String str = "Mr John Smith    ";
        System.out.println("Transformed String: " + url.transform(str.toCharArray(), 13));
    }
}
