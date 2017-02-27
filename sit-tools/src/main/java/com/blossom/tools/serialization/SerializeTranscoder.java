package com.blossom.tools.serialization;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Blossom
 * @time 2016年8月25日
 */
public abstract class SerializeTranscoder {
 
	public abstract byte[] serialize(Object value);
	
	public abstract Object deserialize(byte[] in);
	
	public void close(Closeable closeable){
		if (closeable != null) {
			
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
	}
}
