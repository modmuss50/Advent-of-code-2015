import java.security.MessageDigest;

public class Day4 {

    public static final String input = "iwrupvqb";

    public static void main(String[] args) {
        int i = 1;
        boolean hasFoundPart1 = false;
        while(true){
            String md = genMd5(input + i);
            if(md.startsWith("00000") && !hasFoundPart1){
                System.out.println("Part 1 :" + md + ":     " + i);
                hasFoundPart1 = true;
            }
            if(md.startsWith("000000")){
                System.out.println("Part 2 :" + md + ":     " + i);
                break;
            }
            i++;
        }
    }

    public static String genMd5(String md5) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] array = messageDigest.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
