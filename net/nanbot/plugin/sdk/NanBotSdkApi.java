package net.nanbot.plugin.sdk;
import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.*;


class NanBotSdkApi {
	private String token = "";
	public final int INT_TEST = 1;
	
    public interface CLibrary extends Library {
        // DLL�ļ�Ĭ��·��Ϊ��Ŀ��Ŀ¼����DLL�ļ��������Ŀ�⣬��ʹ�þ���·�������˴���(Platform.isWindows()?"msvcrt":"c")ָ���ض�̬��msvcrt.dll��
        CLibrary INSTANCE = (CLibrary) Native.load(("ntapi.dll" ), CLibrary.class);

        // ������Ҫ���õ�DLL�еķ���,�����Ƕ������(�˴�ʾ�����ñ��ض�̬��msvcrt.dll�е�printf()����)
        String nt_callFuction(String format);
    }
	
	public void SetAuthCode(String tk) {
		this.token = tk;
	}

	/**
	 * ��Ϣת�壬�����Ϣ���������з��������������`[` `]` `{` `}`�ַ��Ļ���Ҫ����ת��
	 * @param msg ��ת���ı�
	 * @return
	 */
	public String msgFormat(String msg) {
		msg = msg.replace("&","&#38;");
		msg = msg.replace("[","&#91;");
		msg = msg.replace( "]","&#93;");
		msg = msg.replace("{","&#123;");
		msg = msg.replace("}","&#125;");
		return msg;
	}

	/**
	 * ��ת���˵���Ϣ��ԭ
	 * @param msg
	 * @return
	 */
	public String msgDeformat(String msg) {
		msg = msg.replace("&#91;", "[");
		msg = msg.replace("&#93;", "]");
		msg = msg.replace("&#123;", "{");
		msg = msg.replace("&#125;", "}");
		msg = msg.replace("&#38;", "&");
		return msg;
	}

	/**
	 * ������_���أ���ֱ�ӻ������Ϣ��ʹ�ã���Ϣ���ͳ�ȥ��Ϊָ������������
	 * @param obj Ŀ�����QQ
	 * @return
	 */
	public String code_AT(String obj) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("mod","at");
		j.put("val",obj);
		String par = new JSONObject(j).toString();
		return "[nt:" + par + "]";
	}


	/**
	 * ������_ͼƬ����ֱ�ӻ������Ϣ��ʹ�ã���Ϣ���ͳ�ȥ��Ϊָ������������
	 * @param picData ͼƬ���ݣ������� ͼƬ��ַ / ��������·�� / �ѻ�����data\image�е��ļ� / ͼƬBase64(���Ƽ�)
	 * @param width ͼƬ���
	 * @param height ͼƬ�߶�
	 * @param type ͼƬ���ͣ�jpg / png / bmp / gif ��ͼƬ���ͺ�׺��;����Ҫ�ӡ�.��
	 * @param show �Ƿ�����ͼ
	 * @param showType ��ͼ���ͣ�Ŀǰ��֪���� 40001 �� 40002
	 * @param flash �Ƿ������շ�ʽ���ͣ���������ͼͬʱΪtrue
	 * @return
	 */
	public String code_pic(String picData, int width, int height, String type, Boolean show, int showType, boolean flash) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("mod","pic");
		j.put("val",picData);
		j.put("Width",width);
		j.put("Height",height);
		j.put("Pictype",type);
		j.put("Show",show);
		j.put("ShowType",showType);
		String par = new JSONObject(j).toString();
		return "[nt:" + par + "]";
	}

	/**
	 * ������_ͼƬ����ֱ�ӻ������Ϣ��ʹ�ã���Ϣ���ͳ�ȥ��Ϊָ������������
	 * @param picData ͼƬ���ݣ������� ͼƬ��ַ / ��������·�� / �ѻ�����data\image�е��ļ� / ͼƬBase64(���Ƽ�)
	 * @param width ͼƬ���
	 * @param height ͼƬ�߶�
	 * @param type ͼƬ���ͣ�jpg / png / bmp / gif ��ͼƬ���ͺ�׺��;����Ҫ�ӡ�.��
	 * @return
	 */
	public String code_pic(String picData, int width, int height, String type) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("mod","pic");
		j.put("val",picData);
		j.put("Width",width);
		j.put("Height",height);
		j.put("Pictype",type);
		j.put("Show",false);
		j.put("ShowType",0);
		String par = new JSONObject(j).toString();
		return "[nt:" + par + "]";
	}
	
	
	/**
	 * ������_ͼƬ����ֱ�ӻ������Ϣ��ʹ�ã���Ϣ���ͳ�ȥ��Ϊָ������������
	 * @param picData ͼƬ���ݣ������� ͼƬ��ַ / ��������·�� / �ѻ�����data\image�е��ļ� / ͼƬBase64(���Ƽ�)
	 * @param width ͼƬ���
	 * @param height ͼƬ�߶�
	 * @return
	 */
	public String code_pic(String picData, int width, int height) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("mod","pic");
		j.put("val",picData);
		j.put("Width",width);
		j.put("Height",height);
		j.put("Pictype","");
		j.put("Show",false);
		j.put("ShowType",0);
		String par = new JSONObject(j).toString();
		return "[nt:" + par + "]";
	}
	/**
	 * ������_ͼƬ����ֱ�ӻ������Ϣ��ʹ�ã���Ϣ���ͳ�ȥ��Ϊָ������������
	 * @param picData ͼƬ���ݣ������� ͼƬ��ַ / ��������·�� / �ѻ�����data\image�е��ļ� / ͼƬBase64(���Ƽ�)
	 * @return
	 */
	public String code_pic(String picData) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("mod","pic");
		j.put("val",picData);
		j.put("Width",0);
		j.put("Height",0);
		j.put("Pictype","");
		j.put("Show",false);
		j.put("ShowType",0);
		String par = new JSONObject(j).toString();
		return "[nt:" + par + "]";
	}
	
	/**
	 * ������_���飬��ֱ�ӻ������Ϣ��ʹ�ã���Ϣ���ͳ�ȥ��Ϊָ������������
	 * @param faceid ����ID
	* @return
	 */
	public String code_face(String faceid) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("mod","face");
		j.put("val",faceid);
		String par = new JSONObject(j).toString();
		return "[nt:" + par + "]";
	}
	
	/**
	 * ������_���ţ���ֱ�ӻ������Ϣ��ʹ�ã���Ϣ���ͳ�ȥ��Ϊָ�����������ݣ����� emoji ���� Utf8 ʮ�����ƣ����Է���һЩ�������޷���ʾ�������ַ�
	 * @param hex UTF-8
	 * @return
	 */
	public String code_emoji(String hex) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("mod","face");
		j.put("val",hex);
		String par = new JSONObject(j).toString();
		return "[nt:" + par + "]";
	}
	
	/**
	 * [������Ϣ] ��ȡ�����˺����б�
	 * @return Json��ʽ�����˺����б�
	 * @throws JSONException 
	 */
	public JSONObject GetFriendList() throws JSONException{
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetFriendList");
		return new JSONObject(this.callFunction(j));
	}
	
	/**
	 * [������Ϣ] ��ȡ������Ⱥ�б�
	 * @return Json��ʽȺ�б�
	 * @throws JSONException 
	 */
	public JSONObject GetGroupList() throws JSONException{
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetGroupList");
		return new JSONObject(this.callFunction(j));
	}
	
	/**
	 * [��Ϣ����] ���� ��ͨ/xml/json ��Ϣ��ĳ������
	 * @param toQQ ����QQ
	 * @param msgType ��Ϣ��ʽ��1Ϊ��ͨ�ı� 2ΪXML 3ΪJson
	 * @param content ��Ϣ����
	 */
	public void sendFriendMsg(long toQQ, int msgType, String content) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SendMsg");
		j.put("type",1);
		j.put("msgType",msgType);
		j.put("target",toQQ);
		j.put("content",content);
		this.callFunction(j);
	}

	/**
	 * [��Ϣ����] ���� ��ͨ/xml/json ��Ϣ��ĳ��Ⱥ
	 * @param toGroup Ŀ��Ⱥ��
	 * @param msgtype ��Ϣ��ʽ 1Ϊ��ͨ�ı� 2ΪXML 3ΪJson
	 * @param Content ��Ϣ����/XML����/Json����
	 */
	public void sendGroupMsg(long toGroup,int msgtype,String Content){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SendMsg");
		j.put("type",2);
		j.put("msgType",msgtype);
		j.put("target",toGroup);
		j.put("content",Content);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ��ȡĳ��Ⱥ��Ա����ϸ��Ϣ
	 * @param group
	 * @param qq
	 * @return Ⱥ��Ա��Ϣ��� Json
	 * @throws JSONException
	 */
	public JSONObject GetGroupMemberInfo(long group, long qq) throws JSONException{
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetGroupMemberInfo");
		j.put("group",group);
		j.put("qq",qq);

		return new JSONObject(this.callFunction(j));
	}
	
	/**
	 * [������Ϣ] ��ȡȺ��ϸ��Ϣ
	 * @param group
	 * @return
	 * @throws JSONException
	 */
	public JSONObject GetGroupInfo(long group) throws JSONException{
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetGroupInfo");
		j.put("group",group);
		return new JSONObject(this.callFunction(j));
	}
	
	/**
	 * [Ⱥ����] ����ĳ��
	 * @param group
	 * @param qq
	 * @param time ��λΪ�룬��0Ϊ���
	 */
	public void ShutUp(long group, long qq, int time) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","ShutUp");
		j.put("group",group);
		j.put("qq",qq);
		j.put("time",time);

		this.callFunction(j);
	}
	
	
	/**
	 * [Ⱥ����] ����ĳ��Ⱥ��Ϣ
	 * @param group
	 * @param msgId ��ϢID
	 * @param msgNo ��Ϣ���
	 */
	public void DrawGroupMsg(long group, int msgId, int msgNo) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","DrawGroupMsg");
		j.put("group",group);
		j.put("msgId",msgId);
		j.put("msgNo",msgNo);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ��ȫȺ���Ի���
	 * @param group
	 * @param isShutUp �Ƿ����
	 */
	public void ShutUpGroup(long group, Boolean isShutUp) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","ShutUpGroup");
		j.put("group", group);
		j.put("isShutUp",isShutUp);

		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ����ÿ���ӷ���Ƶ������
	 * @param group
	 * @param num �������� Ŀǰ��Ѷ��ѡ��ֻ��5��10������ֵ����Ը�
	 */
	public void SetMsgSpeed(long group, int num) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetMsgSpeed");
		j.put("group", group);
		j.put("num",num);
		this.callFunction(j);
	}
	
	
	/**
	 * [Ⱥ����] ���������쿪��
	 * @param group
	 * @param isOpen �Ƿ���
	 */
	public void SetAnonymousSwitch(long group, Boolean isOpen) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetAnonymousSwitch");
		j.put("group", group);
		j.put("switch",isOpen);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ��̹��˵����
	 * @param group
	 * @param isOpen �Ƿ���
	 */
	public void SetHonestSwitch(long group, Boolean isOpen) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetHonestSwitch");
		j.put("group", group);
		j.put("switch",isOpen);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ��Ⱥ��ԱȺ��Ƭ
	 * @param group
	 * @param qq
	 * @param card
	 */
	public void SetGroupCard(long group, long qq, String card) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetGroupCard");
		j.put("group", group);
		j.put("qq",qq);
		j.put("card", card);
		this.callFunction(j);
	}

	/**
	 * [Ⱥ����] ��Ⱥ�ĵ�����
	 * @param group Ŀ��Ⱥ��
	 * @param name Ⱥ������
	 */
	public void SetGroupName(long group, String name) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetGroupName");
		j.put("group", group);
		j.put("name", name);
		this.callFunction(j);
	}
	
	/**
	 * [������Ϣ] ��ȡ�������˺�
	 * @return �ѵ�¼�Ļ�����QQ
	 */
	public String GetRobotQQ() {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetRobotQQ");
		return this.callFunction(j);
	}
	
	/**
	 * [������Ϣ] ��ȡ�������ǳ�
	 * @return �ѵ�¼�Ļ������ǳ�
	 */
	public String GetRobotName() {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetRobotName");
		return this.callFunction(j);
	}
	
	/**
	 * [��ܲ���] ����д��һ����־
	 * @param msg ����
	 */
	public void OutPut(String msg) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","OutPut");
		j.put("val", msg);
		this.callFunction(j);
	}
	
	/**
	 * [������Ϣ] ��ȡ������skey
	 * @return �ѵ�¼�Ļ�����skey
	 */
	public String GetSkey() {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetSkey");
		return this.callFunction(j);
	}
	
	/**
	 * [������Ϣ] ��ȡ������P_skey
	 * @return �ѵ�¼�Ļ�����P_skey
	 * @throws JSONException 
	 */
	public JSONObject GetP_skey() throws JSONException {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetP_skey");
		return new JSONObject(this.callFunction(j));
	}
	
	/**
	 * [��ܲ���] �ڿ�� WebUI �ײ���ʾһ����ʾ
	 * @param msg
	 */
	public void ShowTips(String msg) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","ShowTips");
		j.put("val", msg);
		this.callFunction(j);
	}
	
	/**
	 * [��ܲ���] �ڿ�� WebUI ��ʾһ����Ϣ��ʾ����Ҫ�û����ȷ�Ϲر�
	 * @param msg
	 */
	public void ShowAlert(String msg) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","ShowAlert");
		j.put("val", msg);
		this.callFunction(j);
	}
	
	/**
	 * [��֤��Ϣ����] ����Ⱥ�¼���Ŀǰ֧��ĳ�������Ⱥ��ĳ����������Ⱥ����
	 * @param type 1ͬ�⣬2�ܾ�
	 * @param group Ⱥ��
	 * @param qq ��Ⱥ��QQ��
	 * @param seq ���¼��������ݶ���
	 */
	public void GroupEventProcessing(int type, long group, long qq, long seq) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GroupEventProcessing");
		j.put("code", type);
		j.put("group", group);
		j.put("qq", qq);
		j.put("seq", seq);
		this.callFunction(j);
	}

	/**
	 * [��֤��Ϣ����] ��������¼��������������
	 * @param type ����ʽ 1ͬ�� 2�ܾ�
	 * @param qq
	 * @param msgId
	 * @param seq
	 */
	public void FriendEventProcessing(int type, long qq, long msgId, long seq) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","FriendEventProcessing");
		j.put("code", type);
		j.put("qq", qq);
		j.put("msgNo", msgId);
		j.put("seq", seq);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ����(���)���Ѽ���ĳ��Ⱥ��
	 * @param group
	 * @param qq
	 */
	public void InviteFriendInGroup(long group, long[] qq) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","InviteFriendInGroup");
		j.put("group", group);
		j.put("qq", qq);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ��Ⱥ��Աר��ͷ��
	 * @param group
	 * @param qq
	 * @param name
	 */
	public void SetMemberTitle(long group, long qq, String name) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetMemberTitle");
		j.put("group", group);
		j.put("qq", qq);
		j.put("name", name);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] �˳����ɢĳȺ
	 * @param group
	 */
	public void ExitGroup(long group) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","ExitGroup");
		j.put("group", group);
		this.callFunction(j);
	}
	
	
	/**
	 * [Ⱥ����] ��Ⱥ��Ա�Ƴ�
	 * @param group
	 * @param qq
	 * @param noEnter �Ƿ�ܾ��ٴ�����
	 */
	public void KickMember(long group, long qq, Boolean noEnter) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","KickMember");
		j.put("group", group);
		j.put("qq", qq);
		j.put("noEnter", noEnter);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ��ȡȺ��Ա�б�
	 * @param group
	 * @return Ⱥ��Ա�б�Json
	 * @throws JSONException
	 */
	public JSONObject GetGroupMemberList(long group) throws JSONException{
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetGroupMemberList");
		j.put("group",group);
		return new JSONObject(this.callFunction(j));
	}
	
	/**
	 * [��Ϣ����] ����һ��������Ϣ��ָ������ע�⣺���������� amr ��ʽ���� amr ��ʽ�޷����ͣ�������ת��
	 * @param type �������ͣ�1Ϊ���ѣ�2ΪȺ
	 * @param target Ŀ��
	 * @param content ������ ������ַ / ��������·�� / �ѻ�����data\image�е��ļ� / ͼƬBase64(���Ƽ�)
	 * @param time ��������ʱ�䣬��λΪ��
	 */
	public void SendVoice(int type, long target, String content, int time) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SendVoice");
		j.put("type", type);
		j.put("target", target);
		j.put("content", content);
		j.put("time", time);
		this.callFunction(j);
	}
	
	/**
	 * [�����˲���] ��ĳ�˵���
	 * @param qq ����Ŀ��
	 * @param num ��������
	 */
	public void Favorite(long qq, int num) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","Favorite");
		j.put("qq", qq);
		j.put("num", num);
		this.callFunction(j);
	}
	
	/**
	 * [Ⱥ����] ����Ⱥ��Ϣ���ѷ�ʽ
	 * @param group
	 * @param type 1���ղ����ѣ�2�ս�Ⱥ���֣�3����Ⱥ��Ϣ��4���յ�������
	 */
	public void SetGroupNotifyType(long group, int type) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetGroupNotifyType");
		j.put("group", group);
		j.put("type", type);
		this.callFunction(j);
	}
	
	/**
	 * [SendTempMsg][��Ϣ����] ����Ⱥ��ʱ��Ϣ
	 * @param group
	 * @param qq
	 * @param content
	 * @param type
	 */
	public void SendTempMsg(long group, long qq, String content, int type) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SendTempMsg");
		j.put("group", group);
		j.put("qq", qq);
		j.put("content", content);
		j.put("type", type);
		this.callFunction(j);
	}
	
	/**
	 * [��ܲ���] ��ȡ������ƺ��ڲ��汾��
	 * @return 
	 */
	public String GetFrameVer() {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetFrameVer");
		return this.callFunction(j);
	}
	
	/**
	 * [��ܲ���] ��ȡ�����˵�������Ϣ����������ʱ�����շ����ʣ��շ�����
	 * @return 
	 */
	public String GetRobotStatus() {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetRobotStatus");
		return this.callFunction(j);
	}
	
	
	/**
	 * [�����˲���] ���û�����ǩ��
	 * @param content
	 */
	public void SetSign(String content) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetSign");
		j.put("content", content);
		this.callFunction(j);
	}
	
	/**
	 * [�����˲���] ���û������ǳ�
	 * @param content
	 */
	public void SetNick(String content) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetNick");
		j.put("content", content);
		this.callFunction(j);
	}
	
	/**
	 * [�����˲���] ���û�����ͷ��
	 * @param content ������ ͼƬ��ַ / ��������·�� / �ѻ�����data\image�е��ļ� / ͼƬBase64(���Ƽ�)
	 */
	public void SetAvatar(String content) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetAvatar");
		j.put("content", content);
		this.callFunction(j);
	}
	
	/**
	 * [�����˲���] ���û����˷���
	 * @param content ������ ͼƬ��ַ / ��������·�� / �ѻ�����data\image�е��ļ� / ͼƬBase64(���Ƽ�)
	 */
	public void SetCover(String content) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetCover");
		j.put("content", content);
		this.callFunction(j);
	}
	
	/**
	 * [�����˲���] ���û����˵ĳ�������
	 * @param year
	 * @param month
	 * @param day
	 */
	public void SetBirthday(short year, byte month, byte day) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetBirthday");
		j.put("year", year);
		j.put("month", month);
		j.put("day", day);
		this.callFunction(j);
	}
	
	/**
	 * [�����˲���] ���û����˵��Ա�
	 * @param sex 1�� 2Ů
	 */
	public void SetSex(int sex) {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetSex");
		j.put("sex", sex);
		this.callFunction(j);
	}

	/**
	 * [�����˲���] ���ú��ѱ�ע
	 * @param qq �˺�
	 * @param name ��ע����
	 */
	public void SetFriendName(long qq, String name){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetSex");
		j.put("qq", qq);
		j.put("name", name);
		this.callFunction(j);
	}

	/**
	 * [�����˲���] ��ȦȦ������һ����һ��
	 * @param qq Ŀ��QQ
	 * @param CircleId ȦȦID������ͨ��ȡ���Ͽ���ȡ
	 */
	public void LikeIt(long qq, long CircleId){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","LikeIt");
		j.put("qq", qq);
		j.put("id", CircleId);
		this.callFunction(j);
	}

	/**
	 * [�����˲���] �������Ͽ��еĸ��Ա�ǩ������һ����һ��
	 * @param qq Ŀ�����
	 * @param LabelId ��ǩID
	 */
	public void LikeLable(long qq, long LabelId){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","LikeLable");
		j.put("qq", qq);
		j.put("id", LabelId);
		this.callFunction(j);
	}

	/**
	 * [�����˲���] ����һ����Ⱥ��
	 * @param name Ⱥ������
	 * @return ��Ⱥ����
	 */
	public long CreateGroup(String name){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","CreateGroup");
		j.put("gn", name);

		return Long.parseLong(this.callFunction(j)) ;
	}

	/**
	 * [������Ϣ] ��ȡ���Ͽ���Ϣ
	 * @param qq Ŀ��QQ
	 * @return ���Ͽ�Json����
	 * @throws JSONException
	 */
	public JSONObject GetSummaryCard(long qq) throws JSONException{
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetSummaryCard");
		j.put("qq", qq);
		return new JSONObject(this.callFunction(j));
	}

	/**
	 * ���ÿ�ܵ�CURL�������ҳPost
	 * @param url �����ַ
	 * @param type �������ͣ�0 GET��1 �ı���POST��2 �ֽڼ���POST��Ĭ��Ϊ0
	 * @param postString ����Ϊ1ʱ������
	 * @param postBytes ����Ϊ2ʱ������
	 * @param cookies
	 * @param userAgent
	 * @param header
	 * @return
	 * @throws JSONException
	 */
	public JSONObject HttpCurl(String url, int type,String postString, byte[] postBytes,String cookies,String userAgent,String[] header) throws JSONException{
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","GetSummaryCard");
		j.put("url", url);
		j.put("type", type);
		j.put("posttext", postString);
		j.put("posthex", bytesToHexString(postBytes));
		j.put("cookies", cookies);
		j.put("useragent", userAgent);
		j.put("header", header);
		return new JSONObject(this.callFunction(j));
	}

	/**
	 * [Ⱥ����] ���û���ȡ������ԱȨ��
	 * @param group
	 * @param qq
	 * @param status true���ã�falseȡ��
	 */
	public void SetAdminStatus(long group, long qq, boolean status){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","SetAdminStatus");
		j.put("group", group);
		j.put("qq", qq);
		j.put("status", status);
		this.callFunction(j);
	}

	/**
	 * [Ⱥ����] ��ĳ�������û�����
	 * @param group Ⱥ��
	 * @param uid ����UID
	 * @param nick ��������
	 * @param time ����ʱ������λΪ��
	 */
	public void ShutUpAnonymous(long group, String uid, String nick,long time){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","ShutUpAnonymous");
		j.put("group", group);
		j.put("id", uid);
		j.put("nick", nick);
		j.put("time", time);
		this.callFunction(j);
	}

	/**
	 * [��Ϣ����] ���û���ȡ��ĳ����ϢΪ����
	 * @param group
	 * @param msgId
	 * @param msgNo
	 * @param status
	 */
	public void setMessageEssence(long group,int msgId,int msgNo,boolean status){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","setEssence");
		j.put("group", group);
		j.put("msgId", msgId);
		j.put("msgNo", msgNo);
		j.put("status", status);
		this.callFunction(j);
	}

	/**
	 * [Ⱥ����] �������߹ر�ĳ��Ⱥ�������ַ�����Ҫ����ԱȨ��
	 * @param group
	 * @param status
	 */
	public void setGroupLuckyCharStatus(long group, boolean status){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","setLuckyChar");
		j.put("group", group);
		j.put("status", status);
		this.callFunction(j);
	}

	/**
	 * [Ⱥ����] ��Ⱥ����˫��ĳ��ͷ���׳���һ��
	 * @param group
	 * @param qq
	 */
	public void touchTwice(long group, long qq){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","touchTwice");
		j.put("group", group);
		j.put("qq", qq);
		this.callFunction(j);
	}

	/**
	 * [Ǯ������] ����һ����ͨ�����Ⱥ�Ļ��ߺ��ѻ���Ⱥ��ʱ������Json����ʾ���뿴Դ�붨λ�����API��
	 * @param toObj ���Ŀ���Ǻ��Ѿ��Ǻ���Q�ţ���Ⱥ����Ⱥ��
	 * @param num �������
	 * @param money "1.23" ��ʾ1��Ǯ��ë����
	 * @param title
	 * @param type 1���� 2Ⱥ  3Ⱥ��ʱ�Ự
	 * @param group �����������ΪȺ��ʱ�Ự(3)��Ч�ұ��봫�ݣ�����ʱ�������0
	 * @return
	 * @throws JSONException
	 */
	public JSONObject sendSimpleRedPacket(long toObj, short num, String money,String title, int type, long group) throws JSONException {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","sendSimplePacket");
		j.put("obj", toObj);
		j.put("num", num);
		j.put("money", money);
		j.put("brief", title);
		j.put("type", type);
		j.put("group", group);
		return new JSONObject(this.callFunction(j));
		//{"retcode":"0","retmsg":"success","bargainor_id":"1000026901","callback_url":"https%3A%2F%2Fmqq.tenpay.com%2Fv2%2Fhybrid%2Fwww%2Fmobile_qq%2Fpayment%2Fpay_result.shtml%3F_wv%3D1027%26channel%3D2","pay_flag":"1","pay_time":"2021-01-28 18:18:31","real_fee":"1","sp_billno":"1010000269015021012xxxxxxxxxxxxx","sp_data":"attach%3DCgQKABABElEQ8YnZCBoMU0FP5Li2S2lyaXRvIJeVlyYqBOaziS4wATgBQABIAVAAWg4xODIuMTMxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx%26bank_billno%3D%26bank_type%3DCFT%26bargainor_id%3D1000026901%26charset%3D2%26fee_type%3D1%26pay_result%3D0%26purchase_alias%3D400988517%26sign%3DCF04B547759E925CF1BD4771xxxxxxxx%26sp_billno%3D101000026901502xxxxxxxxxxxxxxxxxxx%26time_end%3D20210128181831%26total_fee%3D1%26transaction_id%3D100002690121012800047xxxxxxxxxxxxxxxxxxx%26ver%3D2.0","transaction_id":"100002690121012800047311615xxxxxxxxxxxxxxxxxxx","send_flag":"0"}
	}

	/**
	 * [Ǯ������] ����һ�������������ѻ���Ⱥ�ģ�����Json����
	 * @param toObj  ���Ŀ���Ǻ��Ѿ��Ǻ���Q�ţ���Ⱥ����Ⱥ��
	 * @param num �������
	 * @param money "1.23" ��ʾ1��Ǯ��ë����
	 * @param title
	 * @param type 1���� 2Ⱥ
	 * @return
	 * @throws JSONException
	 */
	public JSONObject sendCommandRedPacket(long toObj, short num, String money,String title, int type) throws JSONException {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","sendCommandPacket");
		j.put("obj", toObj);
		j.put("num", num);
		j.put("money", money);
		j.put("brief", title);
		j.put("type", type);
		return new JSONObject(this.callFunction(j));
	}

	/**
	 * [Ǯ������] ����һ��ר������Ⱥ�ģ�����Json����
	 * @param group Ŀ��Ⱥ
	 * @param qq ר��QQ
	 * @param money ���
	 * @param title
	 * @return
	 * @throws JSONException
	 */
	public JSONObject sendExclusiveRedPacket(long group, long qq, String money, String title) throws JSONException {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","sendExclusivePacket");
		j.put("group", group);
		j.put("obj", qq);
		j.put("num", 1);
		j.put("money", money);
		j.put("brief", title);
		return new JSONObject(this.callFunction(j));
	}


	/**
	 * [Ǯ������] ��ĳ�����ѽ���ת�ˣ�����Json����
	 * @param qq
	 * @param money "1.23" ��ʾ1��Ǯ��ë����
	 * @param title
	 * @return
	 * @throws JSONException
	 */
	public JSONObject sendTransferAccounts(long qq, String money, String title) throws JSONException {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","TransferAccounts");
		j.put("obj", qq);
		j.put("money", money);
		j.put("brief", title);
		return new JSONObject(this.callFunction(j));
	}

	/**
	 * [Ǯ������] ����һ��ƴ���������Ⱥ�ģ�����Json����
	 * @param group
	 * @param num
	 * @param money "1.23" ��ʾ1��Ǯ��ë����
	 * @param title
	 * @return
	 * @throws JSONException
	 */
	public JSONObject sendFightLuckRedPacket(long group, int num, String money, String title) throws JSONException {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","sendFightLuckPacket");
		j.put("group", group);
		j.put("num", num);
		j.put("money", money);
		j.put("brief", title);
		return new JSONObject(this.callFunction(j));
	}

	/**
	 * [Ǯ������] ����һ�����������Ⱥ�Ļ��ߺ��ѣ����ؽ��Json�ı�
	 * @param obj
	 * @param num
	 * @param money "1.23" ��ʾ1��Ǯ��ë����
	 * @param content
	 * @param type 1���� 2Ⱥ
	 * @return
	 * @throws JSONException
	 */
	public JSONObject sendVoiceRedPacket(long obj, int num, String money, String content, int type) throws JSONException {
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","sendVoicePacket");
		j.put("obj", obj);
		j.put("num", num);
		j.put("money", money);
		j.put("brief", content);
		j.put("type", type);
		return new JSONObject(this.callFunction(j));
	}

	/**
	 * [Ⱥ����] ����Ⱥ��Ա�޸���Ƭʱ��Ĺ�����ʾ
	 * @param group
	 * @param rule
	 */
	public void setGroupCardRule(long group, String rule){
		Map<String, Object> j = new LinkedHashMap<String, Object>();
		j.put("func","setGroupCardRule");
		j.put("group", group);
		j.put("rule", rule);
		this.callFunction(j);
	}




	/**
	 * ���� NanBot ����������������ò����Լ������Լ����ؽ�����μ��Ŀ�������� SDK
	 * @param callinfo ���ò���
	 * @return ����з����򷵻� Json �ַ��������򷵻ؿ�
	 */
	public String callFunction(Map<String, Object> callinfo){
		callinfo.put("tk", this.token);
		return CLibrary.INSTANCE.nt_callFuction(new JSONObject(callinfo).toString());
	}




	private static String string2HexString(String strPart) {
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < strPart.length(); i++) {
			int ch = (int) strPart.charAt(i);
			String strHex = Integer.toHexString(ch);
			hexString.append(strHex);
		}
		return hexString.toString();
	}


	/**
	 * �ֽ�����ת16�����ַ���
	 */
	public static String bytesToHexString(byte[] bArr) {
		if (bArr == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(bArr.length);
		String sTmp;
		for (byte b : bArr) {
			sTmp = Integer.toHexString(0xFF & b);
			if (sTmp.length() < 2)
				sb.append(0);
			sb.append(sTmp);
		}

		return sb.toString();
	}

	/**
	 * hex�ַ���תbyte����
	 *
	 * @param inHex ��ת����Hex�ַ���
	 * @return ת�����byte������
	 */
	public static byte[] hexToByteArray(String inHex) {
		int hexlen = inHex.length();
		byte[] result;
		if (hexlen % 2 == 1) {
			//����
			hexlen++;
			result = new byte[(hexlen / 2)];
			inHex = "0" + inHex;
		} else {
			//ż��
			result = new byte[(hexlen / 2)];
		}
		int j = 0;
		for (int i = 0; i < hexlen; i += 2) {
			result[j] = hexToByte(inHex.substring(i, i + 2));
			j++;
		}
		return result;
	}
	public static byte hexToByte(String inHex) {
		return (byte) Integer.parseInt(inHex, 16);
	}
}
