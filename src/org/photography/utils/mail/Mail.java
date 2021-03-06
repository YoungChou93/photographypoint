package org.photography.utils.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * 琛ㄧず閭欢绫伙紝浣犻渶瑕佽缃細璐︽埛鍚嶅拰瀵嗙爜銆佹敹浠朵汉銆佹妱閫�(鍙��)銆佹殫閫�(鍙��)銆佷富棰樸�佸唴瀹癸紝浠ュ強闄勪欢(鍙��)
 * 
 * 鍦ㄥ垱寤轰簡Mail瀵硅薄涔嬪悗
 * 鍙互璋冪敤瀹冪殑setSubject()銆乻etContent()锛岃缃富棰樺拰姝ｆ枃
 * 涔熷彲浠ヨ皟鐢╯etFrom()鍜屻��addToAddress()锛岃缃彂浠朵汉锛屽拰娣诲姞鏀朵欢浜恒��
 * 涔熷彲浠ヨ皟鐢╝ddAttch()娣诲姞闄勪欢
 * 鍒涘缓AttachBean锛歯ew AttachBean(new File("..."), "fileName");
 */
public class Mail {
	private String from;//鍙戜欢浜�
	private StringBuilder toAddress = new StringBuilder();//鏀朵欢浜�
	private StringBuilder ccAddress = new StringBuilder();//鎶勯��
	private StringBuilder bccAddress = new StringBuilder();//鏆楅��
	
	private String subject;//涓婚
	private String content;//姝ｆ枃
	
	// 闄勪欢鍒楄〃
	private List<AttachBean> attachList = new ArrayList<AttachBean>();
	
	public Mail() {}
	
	public Mail(String from, String to) {
		this(from, to, null, null);
	}
	
	public Mail(String from, String to, String subject, String content) {
		this.from = from;
		this.toAddress.append(to);
		this.subject = subject;
		this.content = content;
	}
	
	/**
	 * 杩斿洖鍙戜欢浜�
	 * @return
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * 杩斿洖鍙戜欢浜�
	 * @return
	 */
	public String getFrom() {
		return from;
	}
	
	/**
	 * 杩斿洖涓婚
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 璁剧疆涓婚
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 鑾峰彇涓婚鍐呭
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 璁剧疆涓婚鍐呭
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 鑾峰彇鏀朵欢浜�
	 * @return
	 */
	public String getToAddress() {
		return toAddress.toString();
	}

	/**
	 * 鑾峰彇鎶勯��
	 * @return
	 */
	public String getCcAddress() {
		return ccAddress.toString();
	}

	/**
	 * 鑾峰彇鏆楅��
	 * @return
	 */
	public String getBccAddress() {
		return bccAddress.toString();
	}

	/**
	 * 娣诲姞鏀朵欢浜�,鍙互鏄涓敹浠朵汉
	 * @param to
	 */
	public void addToAddress(String to) {
		if(this.toAddress.length() > 0) {
			this.toAddress.append(",");
		}
		this.toAddress.append(to);
	}

	/**
	 * 娣诲姞鎶勯�佷汉锛屽彲浠ユ槸澶氫釜鎶勯�佷汉
	 * @param cc
	 */
	public void addCcAddress(String cc) {
		if(this.ccAddress.length() > 0) {
			this.ccAddress.append(",");
		}
		this.ccAddress.append(cc);
	}

	/**
	 * 娣诲姞鏆楅�佷汉锛屽彲浠ユ槸澶氫釜鏆楅�佷汉
	 * @param bcc
	 */
	public void addBccAddress(String bcc) {
		if(this.bccAddress.length() > 0) {
			this.bccAddress.append(",");
		}
		this.bccAddress.append(bcc);
	}
	
	/**
	 * 娣诲姞闄勪欢锛屽彲浠ユ坊鍔犲涓檮浠�
	 * @param attachBean
	 */
	public void addAttach(AttachBean attachBean) {
		this.attachList.add(attachBean);
	}
	
	/**
	 * 鑾峰彇鎵�鏈夐檮浠�
	 * @return
	 */
	public List<AttachBean> getAttachs() {
		return this.attachList;
	}
}
