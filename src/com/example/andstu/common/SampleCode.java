/**
 * 
 */
package com.example.andstu.common;

/**
 * ��Ĵ��������������
 *         
 * @author ������
 * @since 2013-XX-XX
 */
@SuppressWarnings("unused")
public class SampleCode {

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
		// ...implementation
	}

	/**
	 * ������������...
	 */
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
}