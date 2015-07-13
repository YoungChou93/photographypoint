package org.photography.action.point;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;
import org.photography.entity.Point;
import org.photography.entity.User;
import org.photography.service.PointService;
import org.photography.utils.CommonUtils;
import org.photography.utils.ImageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 摄影点模块
 *  
 * 添加摄影点
 * 
 * @author zhouyang
 *
 * 2015-7-13
 * 
 */
public class AddPointAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Point point;

	private File pointPhoto;// 头像图片

	private String pointPhotoContentType;
	private String pointPhotoFileName;
	private String savePath;

	private PointService pointService;

	public String getPointPhotoContentType() {
		return pointPhotoContentType;
	}

	public void setPointPhotoContentType(String pointPhotoContentType) {
		this.pointPhotoContentType = pointPhotoContentType;
	}

	public String getPointPhotoFileName() {
		return pointPhotoFileName;
	}

	public void setPointPhotoFileName(String pointPhotoFileName) {
		this.pointPhotoFileName = pointPhotoFileName;
	}

	public File getPointPhoto() {
		return pointPhoto;
	}

	public void setPointPhoto(File pointPhoto) {
		this.pointPhoto = pointPhoto;
	}

	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	@Override
	public String execute() throws Exception {

		User user = (User) ActionContext.getContext().getSession()
				.get("sessionUser");
		if (user != null && pointPhoto!=null) {   

			String fileName = user.getNickname()
					+ CommonUtils.uuid()
					+ pointPhotoFileName.substring(pointPhotoFileName
							.lastIndexOf("."));

			String largePhotoPath = getSavePath() + "\\" + "largephoto" + "\\"
					+ fileName;

			String smallPhotoPath = getSavePath() + "\\" + "smallphoto" + "\\"
					+ fileName;
			
			FileOutputStream fos = new FileOutputStream(largePhotoPath);
			FileInputStream fis = new FileInputStream(getPointPhoto());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {   //存大图
				fos.write(buffer, 0, len); 
			}
			fos.close();
			fis.close();
			setPointPhotoFileName(fileName);

			ImageUtil imageUtil = new ImageUtil();
			imageUtil.saveImageAsJpg(largePhotoPath, smallPhotoPath, 800, 600);//存小图

			point.setUser(user);
			point.setLargePhotoUrl("/file/pointphoto/largephoto/" + fileName);
			point.setSmallPhotoUrl("/file/pointphoto/smallphoto/" + fileName);
			pointService = new PointService();
			pointService.savePoint(point);

		}
		return SUCCESS;

	}

}
