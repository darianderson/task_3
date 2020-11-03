package com.tsyhanok;

public class Encoder {

    public static String encode(String message) {
        if (message.length() <= 0 || message.length() > 100) {
            return "Message isn't valid";
        }
        StringBuilder sb = new StringBuilder();
        char[] binaryMessage = convertToBinaryCharArray(message);
        String tmpLength;
        for (int i = 0; i < binaryMessage.length - 1; i += tmpLength.length()) {
            sb.append(binaryMessage[i] == '0' ? "00 " : "0 ");
            tmpLength = getFrequency(binaryMessage, i, "0");
            sb.append(tmpLength).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String getFrequency(char[] message, int index, String result) {
        if (index < message.length - 1 && message[index] == message[index + 1]) {
            return getFrequency(message, ++index, result + "0");
        }
        return result;
    }

    private static char[] convertToBinaryCharArray(String message) {
        StringBuilder sb = new StringBuilder().append("0");
        for (int i = 0; i < message.length(); i++) {
            int characterASCII = message.charAt(i);
            sb.append(Integer.toBinaryString(characterASCII));
        }
        return sb.toString().toCharArray();
    }

}