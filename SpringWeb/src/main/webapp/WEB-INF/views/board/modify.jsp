<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">수정 페이지</div>
      <div class="card-body">
      
        <form role="form" name="modiForm" id="modiForm" action="modifyForm" method="post">  
                
          <div class="form-group">
            <label>번호</label>
            <input class="form-control" name='index' value="${index }" readonly>
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name='title' value="${vo.title }">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content'>${vo.content }</textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name='writer' value="${vo.writer }">
          </div>         
          
          <input type="hidden" name='num' value="${vo.num }">
          <input type="hidden" name='pageNum' value="${cri.pageNum }">
          <button type="button" class="btn btn-primary" onclick="modifyCheck('modify')">변경</button>
          <button type="button" class="btn btn-secondary" onclick="modifyCheck('delete')">삭제</button>
          <button type="button" class="btn btn-dark" onclick="modifyCheck('list')">목록</button>
          <%-- <button type="button" class="btn btn-secondary" onclick="location.href='contentDelete?num=${vo.num}'">삭제</button>
          <button type="button" class="btn btn-dark" onclick="location.href='list?pageNum=${cri.pageNum}&&count=${cri.count }'">목록</button> --%>
        </form>
      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->        
	
<%@ include file="../include/footer.jsp" %>
	<script type="text/javascript">
			function modifyCheck(e) {
				// $("#아이디")는 HTML의 아이디 속성에 한 번에 접근할 수 있음
				// attr(속성, 변경할 값) 함수는 태그 내부속성을 변경하는 함수
				
				if (e == 'modify') {
					if (document.modiForm.title.value == '') {
						alert("제목을 입력해주세요!");
						return;
					} else if (document.modiForm.content.value == '') {
						alert("내용을 입력해주세요!");
						return;
					} else if (document.modiForm.writer.value == '') {
						alert("작성자를 입력해주세요!");
						return;
					} else if (confirm("게시물을 변경하시겠습니까?")) {
						document.modiForm.submit();
					}
					
				} else if (e == 'delete') {
					if (confirm("진짜 정말로 삭제하시겠습니까?")) {
						<% System.out.println("삭제중========================");%>
						$("#modiForm").attr("action","contentDelete");
						$("#modiForm").submit();
						
					}
				} else if (e == 'list') {
					$("#modiForm").attr("action","list");
					$("#modiForm").submit();
				}	
			}
		</script>
</body>
</html>