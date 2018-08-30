package com.yoribogo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoribogo.model.Editor;

@Controller("EditorController")
@RequestMapping("/")
public class EditorController {

	
	@RequestMapping(value="fileUploader", method = RequestMethod.POST)
	@ResponseBody
	//싱글파일 업로더////////////////////////////////
    public String fileUpload(HttpServletRequest request, HttpServletResponse response, Editor editor){
		 String callback = editor.getCallback();
		 String callback_func = editor.getCallback_func();
		 String file_result = "";
		
		 try {
			if(editor.getFiledata() != null && editor.getFiledata().getOriginalFilename() != null && !editor.getFiledata().getOriginalFilename().equals("")) {
	             // 기존 상단 코드를 막고 하단코드를 이용
	            String original_name = editor.getFiledata().getOriginalFilename();
				String ext = original_name.substring(original_name.lastIndexOf(".")+1);
				//파일 기본 경로
				String defaultPath = request.getSession().getServletContext().getRealPath("/");
			    //파일 기본경로-상세경로
				String path = defaultPath + "resources" + File.separator + "editor" + File.separator + "photoUpload" + File.separator;
			   	File file = new File(path);
			   	//디렉토리 존재하지 않을 경우 디렉토리 생성
				
		    		if(!file.exists()) {
		    			file.mkdirs();
		    		}
		    		//서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋다.
		    		String realname = UUID.randomUUID().toString() + "." + ext;
		    		
		    		///////////////// 서버에 파일쓰기 /////////////////
					editor.getFiledata().transferTo(new File(path+realname));
					file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL=/yoribogo/resources/editor/photoUpload/"+realname;
			
			}else {
				 	file_result += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "redirect:" + callback + "?callback_func=" + callback_func + file_result;
}
	/*//다중파일업로드 컨트롤러//////////////////////////////
	public String multiplePhotoUpload(HttpServletRequest request, Editor editor) {
	// 파일정보
	StringBuffer sb = new StringBuffer();
	try {
	// 파일명을 받는다 - 일반 원본파일명
	String oldName = request.getHeader("file-name");
	// 파일 기본경로 _ 상세경로
	String filePath = "C:/Users/sangj/git/Yoribogo/src/main/webapp/resources/photoUpload/";
	String saveName = sb.append(new SimpleDateFormat("yyyyMMddHHmmss")
	            .format(System.currentTimeMillis()))
	            .append(UUID.randomUUID().toString())
	            .append(oldName.substring(oldName.lastIndexOf("."))).toString();
	InputStream is = request.getInp
	utStream();
	OutputStream os = new FileOutputStream(filePath + saveName);
	int numRead;
	byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	while ((numRead = is.read(b, 0, b.length)) != -1) {
	  os.write(b, 0, numRead);
	}
	os.flush();
	os.close();
	// 정보 출력
	sb = new StringBuffer();
	sb.append("&bNewLine=true")
	.append("&sFileName=").append(oldName)
	.append("&sFileURL=").append("http://localhost:8080/yoribogo/resources/photoUpload/")
	.append(saveName);
	} catch (Exception e) {
	e.printStackTrace();
	}
	return sb.toString();
	}*/

}