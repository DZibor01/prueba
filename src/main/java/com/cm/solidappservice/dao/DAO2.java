package com.cm.solidappservice.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DAO2 {
	private static DAO2 singleton = null;

	public static DAO2 getInstance() {
		if (singleton == null) {
			try {
				synchronized (DAO2.class) {
					if (null == singleton) {
						singleton = new DAO2();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	protected SqlSessionFactory getFactory() throws IOException {
		String resource ="com/cm/solidappservice/mapper/config/mybatis-config.xml";
		// if(DiferenciarNodo(1)==2){
		// resource = "com/cm/solidappservice/mapper/config/mybatis-config2.xml";
		// }else{
		// resource = "com/cm/solidappservice/mapper/config/mybatis-config.xml";
		// }

		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	protected SqlSessionFactory getFactoryMySQL() throws IOException {
		String resource = "com/cm/solidappservice/mapper/config/mybatis-configMySQL.xml";
		if(DiferenciarNodo(2)==2){
		 resource = "com/cm/solidappservice/mapper/config/mybatis-configMySQL2.xml";
		}else{
		 resource = "com/cm/solidappservice/mapper/config/mybatis-configMySQL.xml";
		}
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	private int DiferenciarNodo(int numeroBaseDatos) throws IOException {
		int nodoUsar = 0;
		//ruta donde se va ubicar el archivo de texto
		File doc = new File("C:\\Users\\JuanSebastianArenas\\Documents\\ejemplotxt\\ejemplo.txt");
		BufferedReader obj = null;
		obj = new BufferedReader(new FileReader(doc));
		String strng = null;

		switch (numeroBaseDatos) {
			// Oracle
			case 1:

			while ((strng = obj.readLine()) != null) {
				if (strng.contains("nodo1Oracle")) {
					nodoUsar=1;
				}
				if (strng.contains("nodo2Oracle")) {
					nodoUsar=2;
				}
			}
				break;
			// MySql
			case 2:
			while ((strng = obj.readLine()) != null) {
				if (strng.contains("nodo1Mysql")) {
					nodoUsar=1;
				}
				if (strng.contains("nodo2Mysql")) {
					nodoUsar=2;
				}
			}
				break;

			default:
				nodoUsar=1;
		}
		obj.close();
		return nodoUsar;
	}
	// protected Object getObject(String query, Object parameter) throws Exception {
	// Object tokenUnit = null;
	// SqlSession session = getFactory().openSession();
	// try {
	// if (parameter != null) {
	// tokenUnit = session
	// .selectOne(query, parameter);
	// }else{
	// tokenUnit = session
	// .selectOne(query);
	// }
	// } finally {
	// session.close();
	// }
	// return tokenUnit;
	// }

	@SuppressWarnings("unchecked")
	protected <T> T getObject(String query, Object parameter) throws Exception {
		Object tokenUnit = null;
		SqlSession session = getFactory().openSession();
		try {
			if (parameter != null) {
				tokenUnit = session
						.selectOne(query, parameter);
			} else {
				tokenUnit = session
						.selectOne(query);
			}
		} finally {
			session.close();
		}
		return (T) tokenUnit;
	}

	protected void insertObject(String query, Object parameter) throws Exception {
		int registrosAfectados = 0;
		SqlSession session = getFactory().openSession();
		try {
			registrosAfectados = session.insert(query, parameter);
			session.commit();
		} finally {
			session.close();
		}
		if (registrosAfectados == 0) {
			throw new Exception("No se pudo crear el registro.");
		}
	}

	protected void updateObject(String query, Object parameter) throws Exception {
		int registrosAfectados = 0;
		SqlSession session = getFactory().openSession();
		try {
			registrosAfectados = session.update(query, parameter);
			session.commit();
		} finally {
			session.close();
		}
		if (registrosAfectados == 0) {
			throw new Exception("No se pudo actualizar el registro.");
		}
	}

	protected <T> List<T> getList(Class<? extends T> clase, String query, Object parameter) throws Exception {
		List<T> l = null;
		SqlSession session = getFactory().openSession();
		try {
			if (parameter == null) {
				l = session.selectList(query);
			} else {
				l = session.selectList(query, parameter);
			}
		} finally {
			session.close();
		}
		return l;
	}

	protected <T> List<T> getList(String query, Object parameter) throws Exception {
		List<T> l = null;
		SqlSession session = getFactory().openSession();
		try {
			if (parameter == null) {
				l = session.selectList(query);
			} else {
				l = session.selectList(query, parameter);
			}
		} finally {
			session.close();
		}
		return l;
	}

	/*
	 * protected List<com.cm.solidappservice.model.AgenciaMD> getList2(String query,
	 * Object parameter) throws Exception {
	 * List<com.cm.solidappservice.model.AgenciaMD> l = null;
	 * SqlSession session = getFactory().openSession();
	 * try {
	 * if (parameter == null) {
	 * System.err.println( "Antes de hacer la consulta!!!! --> " + query );
	 * l = session.selectList(query);
	 * System.err.println( "Despues de la consulta!!!!" );
	 * }else
	 * {
	 * l = session.selectList(query, parameter);
	 * }
	 * } catch ( Exception e ) {
	 * e.printStackTrace();
	 * } finally {
	 * session.close();
	 * }
	 * return l;
	 * }
	 */
}