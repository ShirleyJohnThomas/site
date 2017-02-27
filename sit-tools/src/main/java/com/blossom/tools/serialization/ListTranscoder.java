package com.blossom.tools.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Blossom
 * @time 2016年8月25日
 */
public class ListTranscoder<M extends Serializable> extends SerializeTranscoder {

	/**
	 * @author Blossom
	 * @time 2016年8月25日
	 * @param value
	 * @return
	 * @see com.hz.crm.utils.abstracts.SerializeTranscoder#serialize(java.lang.Object)
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public byte[] serialize(Object value) {
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		byte[] results = null;
		try {
			List<M> values = (List<M>)value;
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			for (M m : values) {
				objectOutputStream.writeObject(m);
			}
			objectOutputStream.writeObject(null);
			objectOutputStream.close();
			byteArrayOutputStream.close();
			
			results = byteArrayOutputStream.toByteArray();
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Non-serializable object",e);
		}finally {
			close(objectOutputStream);
			close(byteArrayOutputStream);
		}
		return null;
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
	public List<M> deserialize(byte[] in) {
		
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;
		List<M> resultList = new ArrayList<M>();
		try {
			byteArrayInputStream = new ByteArrayInputStream(in);
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			Object object = null;
			while ((object = objectInputStream.readObject())!=null) {
				resultList.add((M)object);
			}
			
			objectInputStream.close();
			byteArrayInputStream.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Non-deserialize object",e);
		}finally {
			close(objectInputStream);
			close(byteArrayInputStream);
		}
		return resultList;
	}

}
