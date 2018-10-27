<%--  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="0;url=/Treasure/list.jsp">
</head>
<body>

</body>
</html> --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="0;url=/Treasure/K/myfeed.do">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page
	import="com.oreilly.servlet.MultipartRequest,com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.*"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page
	import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>

<%@ page import="p.action.*"%>


<%
	String realFolder = "";

	String saveFolder = "filesave";
	String encType = "utf-8";
	int maxSize = 5 * 1024 * 1024;

	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	out.println("the realpath is : " + realFolder + "<br>");

	try {
		MultipartRequest multi = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding(encType);
		List<FileItem> items = upload.parseRequest(request);
		/* AddRequest addRequest = new AddRequest(); */
		
		Iterator<FileItem> iter = items.iterator();
		/* while(iter.hasNext()){
			FileItem item = iter.next();
			if(item.isFormField()){
				String name = item.getFieldName();
				if(name.equals("show_image")){
					addRequest.setShow_image(realFolder);
				}
			}
		} */

		/* ShowDataBean shb = AddShowService.getInstance().add(addRequest);
		//전송을 담당할 콤포넌트를 생성하고 파일을 전송한다.
		//전송할 파일명을 가지고 있는 객체, 서버상의 절대경로,최대 업로드될 파일크기, 문자코드, 기본 보안 적용
		multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

				 */
		//Form의 파라미터 목록을 가져온다
		Enumeration params = multi.getParameterNames();
		//파라미터를 출력한다
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement(); //전송되는 파라미터이름
			String value = multi.getParameter(name); //전송되는 파라미터값  
			out.println(name + " = " + value + "<br>");
		}

		out.println("-------------------------------------<br>");

		//전송한 파일 정보를 가져와 출력한다
		Enumeration files = multi.getFileNames();

		//파일 정보가 있다면
		while (files.hasMoreElements()) {
			//input 태그의 속성이 file인 태그의 name 속성값 :파라미터이름
			String name = (String) files.nextElement();

			//서버에 저장된 파일 이름
			String filename = multi.getFilesystemName(name);

			//전송전 원래의 파일 이름
			String original = multi.getOriginalFileName(name);

			//전송된 파일의 내용 타입
			String type = multi.getContentType(name);

			//전송된 파일 속성이 file인 태그의 name 속성값을 이용해 파일 객체 생성
			File file = multi.getFile(name);

			out.println("파라메터 이름 : " + name + "<br>");
			out.println("실제 파일 이름 : " + original + "<br>");
			out.println("저장된 파일 이름 : " + filename + "<br>");
			out.println("파일 타입 : " + type + "<br>");

			if (file != null) {
				out.println("크기 : " + file.length());
				out.println("<br>");
			}
		}
	} catch (IOException ioe) {
		System.out.println(ioe);
	} catch (Exception ex) {
		System.out.println(ex);
	}
%>

</head>
<body>
	<%-- <%
	// 1. multipart/form-data 여부 확인
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (isMultipart) {
		// 2. 메모리나 파일로 업로드 데이터를 보관하는 FileItem의 Factory 설정
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 3. 업로드 요청을 처리하는 ServletFileUpload 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		//파일명 한글처리
		upload.setHeaderEncoding("utf-8");
		// 4. 업로드 요청 파싱해서 FileItem 목록 구함
		List<FileItem> items = upload.parseRequest(request);
		//FileItem : 
			
		AddRequest addRequest = new AddRequest();
		Iterator<FileItem> iter = items.iterator();
		
		while (iter.hasNext()) {
			FileItem item = iter.next();
			// 5. FileItem이 폼 입력 항목인지 여부에 따라 알맞은 처리
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString("utf-8");

%>
요청 파라미터: <%= name %>=<%= value %> <br/>
<%
			} else {
				String name = item.getFieldName();
				String fileName = item.getName();
				String contentType = item.getContentType();
				//업로드한 파일 타입
			
				boolean isInMemory = item.isInMemory();
				// 임시메모리에 올라갔는지
				long sizeInBytes = item.getSize();
				//업로드한 파일 사이즈
				
			  	File file = new File("d://item/"+fileName); 
				item.write(file);
				//임시 디렉토리나 메모리에 업로드한 파일을 다른 곳으로 이동
%>
파일 : <%= name %>, <%= fileName %>, <%= sizeInBytes %>,<%= contentType %>
<%= isInMemory ? "메모리저장" : "임시파일저장" %>
 <br/>
<%
			}
		}
	} 
%> 
</body>
</html>--%>