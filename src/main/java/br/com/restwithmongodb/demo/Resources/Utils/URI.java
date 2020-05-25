package br.com.restwithmongodb.demo.Resources.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URI {
    public static String decoding(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
