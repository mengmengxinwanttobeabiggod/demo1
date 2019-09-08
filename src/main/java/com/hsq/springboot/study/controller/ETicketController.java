package com.hsq.springboot.study.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.hsq.springboot.study.domain.Rs_ValidCode;
import com.hsq.springboot.study.utils.Base64Hash;



@RestController
@RequestMapping("ticket")
public class ETicketController {

	@GetMapping("{code}")
	public Rs_ValidCode qrcode(@PathVariable String code) throws Exception  {
		if (StringUtils.isNotEmpty(code)) {
			BufferedImage image = writeInfoToJpgBuff(code);
			byte[] bytes = convertToByte(image);
			Rs_ValidCode result = new Rs_ValidCode();
			result.setCode(code);
			result.setImage(new String(Base64Hash.byte2Base64(bytes)));
			return result;
		} else {
			throw new Exception();
		}

	}
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  public static BufferedImage writeInfoToJpgBuff(String content){
		    BufferedImage re=null;
		  
		    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		    Map hints = new HashMap();
		    hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		    try {
				BitMatrix bitMatrix = multiFormatWriter.encode(content,
						BarcodeFormat.QR_CODE, 250, 250, hints);
				re=MatrixToImageWriter.toBufferedImage(bitMatrix);
			} catch (Exception e) {
				e.printStackTrace();
			}	 
		    
		  return re;
	  }
	 
	private byte[] convertToByte(BufferedImage image) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		ImageIO.write(image, "png", out);
		return out.toByteArray();
	}
}
