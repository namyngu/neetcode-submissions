class Solution {

    // Encode string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        
        for (String str : strs) {
            int len = str.length();
            sb.append(len + "#");
            sb.append(str);
        }

        return sb.toString();
    }

    // Decode string
    public List<String> decode(String str) {
        List<String> strList = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            // check start of new string
            // NOTE: The length of a string could be more than 1 digit long.
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt( str.substring(i, j));
            String tmp = str.substring(j + 1, j + 1 + len);
            strList.add(tmp);

            // check if this is last word
            if (j + len >= str.length()) {
                break;
            }

            i = j + 1 + len;
        }

        return strList;
    }
}
