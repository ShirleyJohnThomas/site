package com.blossom.tools.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * @author Blossom
 * @time 2016年8月25日
 */
public class ObjectTranscoder<M extends Serializable> extends SerializeTranscoder {

	/**
	 * @author Blossom
	 * @time 2016年8月25日
	 * @param value
	 * @return
	 * @see com.hz.crm.utils.abstracts.SerializeTranscoder#serialize(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public byte[] serialize(Object value) {
		if (value == null) {
			throw new NullPointerException("Cant't serialize null");
		}
		byte[] results = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			M m = (M)value;
			objectOutputStream.writeObject(m);
			results = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			throw new IllegalArgumentException("Non-serializable object",e);
		}finally{
			close(objectOutputStream);
			close(byteArrayOutputStream);
		}
		return results;
	}

	/**
	 * @author Blossom
	 * @time 2016年8月25日
	 * @param in
	 * @return
	 * @see com.hz.crm.utils.abstracts.SerializeTranscoder#deserialize(byte[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public M deserialize(byte[] in) {
		
		if (in.length == 0) {
			throw new NullPointerException("Cant't deserialize null");
		}
		
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;
		M resultObject = null;
		try {
			byteArrayInputStream = new ByteArrayInputStream(in);
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			resultObject = (M)objectInputStream.readObject();
		} catch (Exception e) {
			throw new IllegalArgumentException("Non-deserialize object",e);
		}finally {
			close(objectInputStream);
			close(byteArrayInputStream);
		}
		
		return resultObject;
	}

}
