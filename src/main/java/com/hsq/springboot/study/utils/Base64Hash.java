package com.hsq.springboot.study.utils;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Base64Hash {
	/** string to base64 string
	 * @param inputString
	 * @return
	 */
	public static String string2Base64(String inputString) {
		Encoder base64 = Base64.getEncoder();
		return base64.encodeToString(inputString.getBytes(Charset.forName("utf-8")));		
	}

	/** base64 string to string
	 * @param inputString
	 * @return
	 */
	public static String base642String(String inputString){
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decoderBytes = decoder.decode(inputString.getBytes(Charset.forName("utf-8")));
		return new String(decoderBytes);
	}
	
	/**base64 string to byte[]
	 * @param inputString
	 * @return
	 */
	public static byte[] base642Byte(String inputString){
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decoderBytes = decoder.decode(inputString.getBytes(Charset.forName("utf-8")));
		return decoderBytes;
	}	
	
	/**byte[] to base64 byte[]
	 * @param inputbyte
	 * @return
	 */
	public static byte[] byte2Base64(byte[] inputbyte) {
		Encoder base64 = Base64.getEncoder();
		return base64.encode(inputbyte);
	}

	/**base64 byte[] to byte[]
	 * @param inputbyte
	 * @return
	 */
	public static byte[] base642Byte(byte[] inputbyte){
		Base64.Decoder decoder = Base64.getDecoder();
		return decoder.decode(inputbyte);
	}

}
