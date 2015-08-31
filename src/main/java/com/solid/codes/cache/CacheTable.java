package com.solid.codes.cache;

import java.util.Enumeration;
import java.util.Hashtable;

public class CacheTable extends Hashtable implements Pingable {

	private long expireTime;
	private Ping cleaner;

	public CacheTable(long expireTime) {
		super();
		this.expireTime = expireTime;
		cleaner = new Ping(this, ((long) (expireTime * 0.75)));
		cleaner.start();
	}

	@Override
	public synchronized Object put(Object key, Object value) {
		return (super.put(key, new TimeWrapper(value)));
	}

	@Override
	public synchronized Object get(Object key) {
		if (super.get(key) != null) {
			return (((TimeWrapper) super.get(key)).getObject());
		}
		return null;

	}

	@Override
	public synchronized void ping() {
		Enumeration e = super.keys();
		while (e.hasMoreElements()) {
			Object key = e.nextElement();
			TimeWrapper tw = (TimeWrapper) super.get(key);
			if ((tw != null) && (tw.getAge() > expireTime)) {
				remove(key);
			}
		}
		System.gc();
	}

}
