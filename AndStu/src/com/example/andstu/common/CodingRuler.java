/**
 * �ļ�������ѡ������ CodingRuler.java
 * 
 * �汾��Ϣ����ѡ�����磺@version 1.0.0
 * 
 * ��Ȩ��������Դ����һ�㶼��Ҫ��ӣ����磺Copyright (C) 2010-2013 SINA Corporation.
 */
package com.example.andstu.common;
/**
 * ��Ĵ��������������
 * 
 * <p>
 * <b>NOTE�����²���Ϊһ����Ҫ�ı���淶������淶��ο� ORACLE �ٷ��ĵ���</b><br>
 * ��ַ��http://www.oracle.com/technetwork/java/codeconventions-150003.pdf<br>
 * ���⣬��ʹ�� UTF-8 ��ʽ���鿴���룬��������������롣<br>
 * <b>����ע��Ӧ��ʹ�����Ļ���Ӣ�ģ����Լ��о��������ݹ�˾����Ŀ��Ҫ��������Ƽ�ʹ��Ӣ�ġ�</b><br>
 * </p>
 * <h3>1. �������</h3>
 * <ul>
 * <li>1.1. Java �����в���������ھ��棬�޷������ľ���Ҫ�� @SuppressWarnings��
 * <li>1.2. ȥ�����õİ��������������ȣ����ٽ�ʬ���롣
 * <li>1.3. ʹ�� Lint �������鿴����������ʹ���
 * <li>1.4. ʹ�� Ctrl+Shift+F ����ʽ�����룬Ȼ���ٽ��е�����
 * <li>1.5. ʹ�� Ctrl+Shift+O ����ʽ�� Import ����
 * </ul>
 * 
 * <h3>2. ��������</h3> <h3>2.1. ����ԭ��</h3>
 * <ul>
 * <li>2.1.1. ������������������Ҫ���壬�ϸ��ֹʹ�� name1, name2 ��������
 * <li>2.1.2. ��������̫�����ʵ�ʹ�ü�д����д������ò�Ҫ���� 25 ����ĸ��
 * <li>2.1.3. ��������Сд��ĸ��ʼ���Ժ�ÿ����������ĸ��д��
 * <li>2.1.4. ����ʹ�����ƻ��߽��ڴ�Сд������������֡�
 * <li>2.1.5. ����ʹ�����֣������� 2 ���� to���� 4 ���� for �ȣ��� go2Clean��
 * </ul>
 * 
 * <h3>2.2. �ࡢ�ӿ�</h3>
 * <ul>
 * <li>2.2.1. ���е�������ĸ����д��ʹ����ȷ�з�Ӧ���ࡢ�ӿں��塢���ܵȵĴʡ�һ��������ʡ�
 * <li>2.2.2. �ӿڴ� I ǰ׺����able, ible, er�Ⱥ�׺����ISeriable��
 * </ul>
 * 
 * <h3>2.3. �ֶΡ�����</h3>
 * <ul>
 * <li>2.3.1. ��Ա������ m ��ͷ����̬������ s ��ͷ���� mUserName, sInstance��
 * <li>2.3.2. ����ȫ����д���ڴ����֮ǰ���»������ӣ��� MAX_NUMBER��
 * <li>2.3.3. �����н�ֹʹ��Ӳ���룬��һЩ���ֻ��ַ�������ɳ�������
 * <li>2.3.4. ���ڷ������õĺ�����Ϊ�˱��ּ����ԣ�ͨ����� @Deprecated���� {@link #doSomething()}
 * </ul>
 * 
 * <h3>3. ע��</h3> ��ο� {@link #SampleCode} ���ע�͡�
 * <ul>
 * <li>3.1. ����ע�ͣ��μ� {@link #ACTION_MAIN}
 * <li>3.2. ����ע�ͣ��μ� {@link #mObject0}
 * <li>3.3. ����ע�ͣ��μ� {@link #doSomething(int, float, String)}
 * </ul>
 * 
 * <h3>4. Class �ڲ�˳����߼�</h3>
 * <ul>
 * <li>4.1. ÿ�� class ��Ӧ�ð���һ�����߼��ṹ�����л���Ա�������������ڲ���ȣ� �Ӷ��ﵽ���õĿɶ��ԡ�
 * <li>4.2. ��������˵��Ҫ������ public, �� protected, ��� private, �������Ų�
 * ҲӦ����һ���߼����Ⱥ�˳�����ص��ᡣ
 * <li>4.3. ����˳��ɹ��ο��� ����TAG��һ��Ϊ private����ѡ��<br>
 * ���� public ����<br>
 * ���� private �������ڲ���<br>
 * ���� private ����<br>
 * ���� public ����<br>
 * ���� protected ����<br>
 * ���� private ����<br>
 * </ul>
 * 
 * <h3>5. ���ʽ�����</h3> <h3>5.1. ����ԭ�򣺲��ý����ͷ������д����</h3> <h3>5.2. ϸ��</h3>
 * <ul>
 * <li>5.2.1. ������ʾʽ���μ� {@link #conditionFun(boolean)}
 * <li>5.2.2. switch ��䣬�μ� {@link #switchFun(int)}
 * <li>5.2.3. ѭ����䣬�μ� {@link #circulationFun(boolean)}
 * <li>5.2.4. �������쳣���μ� {@link #exceptionFun()}
 * <li>5.2.5. ����μ� {@link #otherFun()}
 * <li>5.2.6. ��ע���μ� {@link #doSomething(int, float, String)}
 * </ul>
 * 
 * @author ������
 * @since 2013-XX-XX
 */
@SuppressWarnings("unused")
public class CodingRuler {
	/** ���еĳ���ע�� */
	public static final String ACTION_MAIN = "android.intent.action.MAIN";

	/** ˽�еĳ���ע�ͣ�ͬ���͵ĳ������Էֿ鲢���ն��壩 */
	private static final int MSG_AUTH_NONE = 0;
	private static final int MSG_AUTH_SUCCESS = 1;
	private static final int MSG_AUTH_FAILED = 2;

	/** �����ĳ�Ա����ע�� */
	protected Object mObject0;

	/** ˽�еĳ�Ա���� mObject1 ע�ͣ�ͬ���͵ĳ�Ա�������Էֿ鲢���ն��壩 */
	private Object mObject1;
	/** ˽�еĳ�Ա���� mObject2 ע�� */
	private Object mObject2;
	/** ˽�еĳ�Ա���� mObject3 ע�� */
	private Object mObject3;

	/**
	 * ����ע�Ͷ���һ�еģ��������ַ�ʽ�� ����ñ���
	 */
	private Object mObject4;

	/**
	 * ���з�������...
	 * 
	 * @param param1
	 *            ����1����...
	 * @param param2
	 *            ����2����...
	 * @param paramXX
	 *            ����XX����... ��ע�⣺�뽫���������������룩
	 */
	public void doSomething(int param1, float param2, String paramXX) {
		// ����ע�ͱ�ǩ����ͨ��Eclipse���õ�Task�������
		// TODO ʹ��TODO����Ǵ��룬˵����ʶ���й��ܴ������д
		// FIXME ʹ��FIXME����Ǵ��룬˵����ʶ��������Ҫ����������������
		// ����ģ����ܹ�������Ҫ�޸�
		// XXX ʹ��XXX����Ǵ��룬˵����ʶ��������Ȼʵ���˹��ܣ�����ʵ��
		// �ķ����д���ȶ��ϣ�������ܸĽ�
	}

	/**
	 * ������������...
	 */
	@Deprecated
	protected void doSomething() {
		// ...implementation
	}

	/**
	 * ˽�з�������...
	 * 
	 * @param param1
	 *            ����1����...
	 * @param param2
	 *            ����2����...
	 */
	private void doSomethingInternal(int param1, float param2) {
		// ...implementation
	}

	/**
	 * �������ʽԭ��
	 */
	private void conditionFun() {
		boolean condition1 = true;
		boolean condition2 = false;
		boolean condition3 = false;
		boolean condition4 = false;
		boolean condition5 = false;
		boolean condition6 = false;

		// ԭ�� 1. ���� if �������� {} ��������������ֻ��һ�䣬��ֹʹ�ò���{}�����
		// 2. �ں��ж���������ı��ʽ�У�ʹ��Բ������������������ȼ�����
		// 3. �ж������ܶ�ʱ���뽫������������
		if (condition1) {
			// ...implementation
		}

		if (condition1) {
			// ...implementation
		} else {
			// ...implementation
		}

		if (condition1) /* ��ֹʹ�ò���{}����� */
			condition3 = true;

		if ((condition1 == condition2) || (condition3 == condition4)
				|| (condition5 == condition6)) {

		}
	}

	/**
	 * Switch���ԭ��
	 */
	private void switchFun() {

		// ԭ�� 1. switch ����У�break ����һ�� case ֮�䣬��һ��
		// 2. ���ڲ���Ҫ break ���ģ���ʹ�� /* Falls through */����ע
		// 3. ��Ĭ��д�� default ��䣬����������
		int code = MSG_AUTH_SUCCESS;
		switch (code) {
		case MSG_AUTH_SUCCESS:
			break;

		case MSG_AUTH_FAILED:
			break;

		case MSG_AUTH_NONE:
			/* Falls through */
		default:
			break;
		}
	}

	/**
	 * ѭ�����ʽ��
	 */
	private void circulationFun() {

		// ԭ�� 1. ����ʹ��for each������ԭʼ��for���
		// 2. ѭ���б�������ֹѭ������������䣬������ѭ��
		// 3. ѭ��Ҫ�����ܵĶ�, �ѳ�ѭ�������ݳ�ȡ��������ȥ
		// 4. Ƕ�ײ�����Ӧ����3��, Ҫ��ѭ�������ɶ�

		int array[] = { 1, 2, 3, 4, 5 };
		for (int data : array) {
			// ...implementation
		}

		int length = array.length;
		for (int ix = 0; ix < length; ix++) {
			// ...implementation
		}

		boolean condition = true;
		while (condition) {
			// ...implementation
		}

		do {
			// ...implementation
		} while (condition);
	}

	/**
	 * �쳣����ԭ��
	 */
	private void exceptionFun() {

		// ԭ�� 1. ��׽�쳣��Ϊ�˴�������ͨ�����쳣catch��������쳣��Ϣ��
		// 2. ��Դ�ͷŵĹ��������Էŵ� finally �鲿��ȥ������ر� Cursor �ȡ�
		try {
			// ...implementation
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * ����ԭ��������...����
	 */
	private void otherFun() {
		// TODO
	}
	

}
